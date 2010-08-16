package imager;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JSlider;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.xuggle.xuggler.IAudioSamples;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IPacket;
import com.xuggle.xuggler.IStream;
import com.xuggle.xuggler.IStreamCoder;
import com.xuggle.xuggler.ICodec;
/**
 * Retrieves the audio from the given path and decodes it to play
 * @author Kumaripaba Athukorala
 *
 */
public class DecodeAndPlayAudio implements Runnable {

	/**
	 * The audio line we'll output sound to; it'll be the default audio device
	 * on your system if available
	 */
	private static SourceDataLine mLine;

	/**
	 * Takes a media container (file) as the first argument, opens it, opens up
	 * the default audio device on your system, and plays back the audio.
	 * 
	 * @param args
	 *            Must contain one string which represents a filename
	 */
	public int startingPoint;
	public String path;
	int songLength;
	int duration;
	public JSlider slider;
	public float tickSpacing;

	public AudioData getAudioData(String audioPath) {

		// int[] returnvalues = new int[2];
		AudioData data = new AudioData();
		this.path = audioPath;
		IContainer container = IContainer.make();
		if (container.open(path, IContainer.Type.READ, null) < 0)
			throw new IllegalArgumentException("could not open file: " + path);

		int numStreams = container.getNumStreams();
		int audioStreamId = -1;
		IStreamCoder audioCoder = null;
		for (int i = 0; i < numStreams; i++) {
			IStream stream = container.getStream(i);
			IStreamCoder coder = stream.getStreamCoder();

			if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO) {
				audioStreamId = i;
				audioCoder = coder;
				break;
			}
		}
		if (audioStreamId == -1)
			throw new RuntimeException(
					"could not find audio stream in container: " + path);

		if (audioCoder.open() < 0)
			throw new RuntimeException(
					"could not open audio decoder for container: " + path);
		openJavaSound(audioCoder);

		IPacket packet = IPacket.make();

		songLength = 0;
		duration = (int) (container.getDuration() / 1000000);
		data.setSongDuration(duration);

		while (container.readNextPacket(packet) >= 0) {

			if (packet.getStreamIndex() == audioStreamId) {
				songLength++;

				IAudioSamples samples = IAudioSamples.make(1024, audioCoder
						.getChannels());

			} else {
				do {
				} while (false);
			}

		}

		closeJavaSound();

		if (audioCoder != null) {
			audioCoder.close();
			audioCoder = null;
		}
		if (container != null) {
			container.close();
			container = null;
		}

		data.setSongLenth(songLength);
		tickSpacing = (float) songLength / duration;
		return data;
	}

	public void player(String path, int startingPoint) {
		String filename = path;

		// Create a Xuggler container object
		IContainer container = IContainer.make();

		// Open up the container
		if (container.open(filename, IContainer.Type.READ, null) < 0)
			throw new IllegalArgumentException("could not open file: "
					+ filename);

		// query how many streams the call to open found
		int numStreams = container.getNumStreams();

		// and iterate through the streams to find the first audio stream
		int audioStreamId = -1;
		IStreamCoder audioCoder = null;
		for (int i = 0; i < numStreams; i++) {
			// Find the stream object
			IStream stream = container.getStream(i);
			// Get the pre-configured decoder that can decode this stream;
			IStreamCoder coder = stream.getStreamCoder();

			if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO) {
				audioStreamId = i;
				audioCoder = coder;
				break;
			}
		}
		if (audioStreamId == -1)
			throw new RuntimeException(
					"could not find audio stream in container: " + filename);

		/*
		 * Now we have found the audio stream in this file. Let's open up our
		 * decoder so it can do work.
		 */
		if (audioCoder.open() < 0)
			throw new RuntimeException(
					"could not open audio decoder for container: " + filename);

		/*
		 * And once we have that, we ask the Java Sound System to get itself
		 * ready.
		 */
		openJavaSound(audioCoder);

		/*
		 * Now, we start walking through the container looking at each packet.
		 */
		IPacket packet = IPacket.make();

		int songLen = 0;
		while (container.readNextPacket(packet) >= 0) {
			/*
			 * Now we have a packet, let's see if it belongs to our audio stream
			 */

			if (packet.getStreamIndex() == audioStreamId) {
				songLen++;

				/*
				 * We allocate a set of samples with the same number of channels
				 * as the coder tells us is in this buffer.
				 * 
				 * We also pass in a buffer size (1024 in our example), although
				 * Xuggler will probably allocate more space than just the 1024
				 * (it's not important why).
				 */

				IAudioSamples samples = IAudioSamples.make(1024, audioCoder
						.getChannels());

				/*
				 * A packet can actually contain multiple sets of samples (or
				 * frames of samples in audio-decoding speak). So, we may need
				 * to call decode audio multiple times at different offsets in
				 * the packet's data. We capture that here.
				 */
				int offset = 0;

				/*
				 * Keep going until we've processed all data
				 */

				// System.out.println(songLen+"  "+packet.getDuration()+
				// "packet size "+ packet.getSize());
				if (songLen > startingPoint)
					while (offset < packet.getSize()) {

						int bytesDecoded = audioCoder.decodeAudio(samples,
								packet, offset);
						if (bytesDecoded < 0)
							throw new RuntimeException(
									"got error decoding audio in: " + filename);
						offset += bytesDecoded;

						/*
						 * Some decoder will consume data in a packet, but will
						 * not be able to construct a full set of samples yet.
						 * Therefore you should always check if you got a
						 * complete set of samples from the decoder
						 */

						if (samples.isComplete()) {
							playJavaSound(samples);
						}
						// System.out.println("Song Length " +songLen +
						// " tickSpacing" + tickSpacing+ " slider value "
						// +((int) (songLen/tickSpacing)) );
						slider.setValue((int) (songLen / tickSpacing));

						// slider.firePropertyChange("Value",false,true);
					}
			} else {
				/*
				 * This packet isn't part of our audio stream, so we just
				 * silently drop it.
				 */
				do {
				} while (false);
			}

		}
		slider.setValue(0);
		/*
		 * Technically since we're exiting anyway, these will be cleaned up by
		 * the garbage collector... but because we're nice people and want to be
		 * invited places for Christmas, we're going to show how to clean up.
		 */
		closeJavaSound();

		if (audioCoder != null) {
			audioCoder.close();
			audioCoder = null;
		}
		if (container != null) {
			container.close();
			container = null;
		}
	}

	private static void openJavaSound(IStreamCoder aAudioCoder) {
		AudioFormat audioFormat = new AudioFormat(aAudioCoder.getSampleRate(),
				(int) IAudioSamples.findSampleBitDepth(aAudioCoder
						.getSampleFormat()), aAudioCoder.getChannels(), true, /*
																			 * xuggler
																			 * defaults
																			 * to
																			 * signed
																			 * 16
																			 * bit
																			 * samples
																			 */
				false);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class,
				audioFormat);
		try {
			mLine = (SourceDataLine) AudioSystem.getLine(info);
			/**
			 * if that succeeded, try opening the line.
			 */
			mLine.open(audioFormat);
			/**
			 * And if that succeed, start the line.
			 */
			mLine.start();
		} catch (LineUnavailableException e) {
			throw new RuntimeException("could not open audio line");
		}

	}

	private static void playJavaSound(IAudioSamples aSamples) {
		/**
		 * We're just going to dump all the samples into the line.
		 */
		byte[] rawBytes = aSamples.getData()
				.getByteArray(0, aSamples.getSize());
		mLine.write(rawBytes, 0, aSamples.getSize());
	}

	private static void closeJavaSound() {
		if (mLine != null) {
			/*
			 * Wait for the line to finish playing
			 */
			mLine.drain();
			/*
			 * Close the line.
			 */
			mLine.close();
			mLine = null;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		player(path, startingPoint);
	}

}
