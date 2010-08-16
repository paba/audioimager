package imager;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IPacket;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IRational;
import com.xuggle.xuggler.IStream;
import com.xuggle.xuggler.IStreamCoder;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

/**
 * Encodes a given set of images to a video
 * @author Kumaripaba athukorala
 *
 */
public class ImagesToVideo {

	private String OUTPUT_FILE_FLV;

	private IContainer outContainer;
	private IStream outStream;
	private IStreamCoder outStreamCoder;

	private long timeStamp = 0;
	private Robot robot;
	private Toolkit toolkit;
	private Rectangle screenBounds;

	public void createVideo(ArrayList<ImageData> images, String outputFile) {

		ImagesToVideo videoEncoder = new ImagesToVideo(outputFile);
		this.OUTPUT_FILE_FLV = outputFile;
		System.out.println("output file" + OUTPUT_FILE_FLV);
		/*
		 * int length = args.length; if(length==0) {
		 * System.out.println("Give Arguments in the following format");
		 * System.out.println(
		 * "<image1path> <image2path> <image3path> <imageNpath> <duration1-in-ms> <duration2-in-ms> <durationN-in-ms>"
		 * );System.out.println(
		 * "All the images need to be of the size 320 x 240 and of format JPEG"); }
		 */
		int index = 0;
		int noOfimages = images.size();

		while (index < noOfimages) {

			int duration = 1000 * (images.get(index).getEndTime() - images.get(
					index).getStartTime());

			Image image = images.get(index).getImage();

			BufferedImage bufferedImage = toBufferedImage(image);

			try {
				/*
				 * image = decoder.decodeAsBufferedImage(); in.close();
				 */

				for (int i = 0; i < (duration / 333); i++) {
					videoEncoder.encodeImage(bufferedImage, duration);
				}
			} catch (ImageFormatException e) {

				e.printStackTrace();

			}

			index++;
		}
		System.out.println("Imagers are converted to a video");
	}

	public ImagesToVideo(String outputFile) {

		OUTPUT_FILE_FLV = outputFile;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println(e.getMessage());
		}
		toolkit = Toolkit.getDefaultToolkit();
		setupStreams();

	}

	public void setupStreams() {
		outContainer = IContainer.make();
		int retval = outContainer.open(OUTPUT_FILE_FLV, IContainer.Type.WRITE,
				null);
		if (retval < 0)
			throw new RuntimeException("could not open output file");

		outStream = outContainer.addNewStream(0);
		outStreamCoder = outStream.getStreamCoder();

		ICodec codec = ICodec.guessEncodingCodec(null, null, OUTPUT_FILE_FLV,
				null, ICodec.Type.CODEC_TYPE_VIDEO);

		outStreamCoder.setNumPicturesInGroupOfPictures(30);
		outStreamCoder.setCodec(codec);

		outStreamCoder.setBitRate(25000);
		outStreamCoder.setBitRateTolerance(9000);

		int width = 320;
		int height = 240;

		outStreamCoder.setPixelType(IPixelFormat.Type.YUV420P);
		outStreamCoder.setHeight(height);
		outStreamCoder.setWidth(width);
		outStreamCoder.setFlag(IStreamCoder.Flags.FLAG_QSCALE, true);
		outStreamCoder.setGlobalQuality(0);

		IRational frameRate = IRational.make(3, 1);
		outStreamCoder.setFrameRate(frameRate);
		outStreamCoder.setTimeBase(IRational.make(frameRate.getDenominator(),
				frameRate.getNumerator()));
		frameRate = null;

		retval = outStreamCoder.open();
		if (retval < 0)
			throw new RuntimeException("could not open input decoder");
		retval = outContainer.writeHeader();
		if (retval < 0)
			throw new RuntimeException("could not write file header");
	}

	public void encodeImage(BufferedImage originalImage, long duration) {
		ByteArrayOutputStream byteConvert = new ByteArrayOutputStream();
		BufferedImage jpegImage = null;
		try {
			ImageIO.write(originalImage, "jpeg", byteConvert);
			byte[] imageData = byteConvert.toByteArray();
			InputStream imageData2 = new ByteArrayInputStream(imageData);
			jpegImage = ImageIO.read(imageData2);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		IPacket packet = IPacket.make();

		IConverter converter = null;
		try {
			converter = ConverterFactory.createConverter(jpegImage,
					IPixelFormat.Type.YUV420P);
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}

		IVideoPicture outFrame = converter.toPicture(jpegImage, timeStamp);
		timeStamp += 333000;

		outFrame.setQuality(0);
		int retval = outStreamCoder.encodeVideo(packet, outFrame, 0);
		if (retval < 0)
			throw new RuntimeException("could not encode video");
		if (packet.isComplete()) {
			retval = outContainer.writePacket(packet);
			if (retval < 0)
				throw new RuntimeException("could not save packet to container");
		}
	}

	public void closeStreams() {
		int retval = outContainer.writeTrailer();
		if (retval < 0)
			throw new RuntimeException("Could not write trailer to output file");
	}

	public BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();
		// Determine if the image has transparent pixels; for this method's
		// implementation, see Determining If an Image Has Transparent Pixels
		boolean hasAlpha = false;
		// Create a buffered image with a format that's compatible with the
		// screen
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
			// Determine the type of transparency of the new buffered image
			int transparency = Transparency.OPAQUE;
			if (hasAlpha) {
				transparency = Transparency.BITMASK;
			}
			// Create the buffered image
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image
					.getHeight(null), transparency);
		} catch (HeadlessException e) {
			// The system does not have a screen
		}
		if (bimage == null) {
			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			if (hasAlpha) {
				type = BufferedImage.TYPE_INT_ARGB;
			}
			bimage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), type);
		}
		// Copy image to buffered image
		Graphics g = bimage.createGraphics();
		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bimage;
	}

}
