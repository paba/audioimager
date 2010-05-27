import java.awt.AWTException;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
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



public class ImagesToVideo {


	public static final String OUTPUT_FILE_FLV = "outputFile.flv";

	private IContainer outContainer;
	private IStream outStream;
	private IStreamCoder outStreamCoder;

	private long timeStamp = 0;
	private Robot robot;
	private Toolkit toolkit;
	private Rectangle screenBounds;

	
	public static void main(String[] args) {
		
	ImagesToVideo videoEncoder = new ImagesToVideo();
	int length = args.length;
	if(length==0)
	{
		System.out.println("Give Arguments in the following format");
		System.out.println("<image1path> <image2path> <image3path> <imageNpath> <duration1-in-ms> <duration2-in-ms> <durationN-in-ms>");
		System.out.println("All the images need to be of size 300 X 300 and of format JPEG");
	}
	int index = 0;
	int noOfimages = length/2;
	int position=0;
		 
	while(index < noOfimages){
		position = noOfimages +index;
		 int duration = Integer.parseInt(args[position]);
		try {
						
			FileInputStream in = new FileInputStream(args[index]);
			System.out.println("Reading image " +args[index]);
			com.sun.image.codec.jpeg.JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
			BufferedImage image;
			
			try {
				image = decoder.decodeAsBufferedImage();
				in.close();
				
				for (int i=0;i<(duration/333);i++)
				{
				videoEncoder.encodeImage(image,duration);
				}
			} catch (ImageFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Fail to read the image.Image format should be JPEG");
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}
	
	index ++;
	}
	System.out.println("outputFile.flv is ready");
	}

	public ImagesToVideo(){
	try{
	robot = new Robot();
	}catch (AWTException e){
	System.out.println(e.getMessage());
	}
	toolkit = Toolkit.getDefaultToolkit();
	setupStreams();
	}

	public void setupStreams(){
	outContainer = IContainer.make();
    int retval = outContainer.open(OUTPUT_FILE_FLV, IContainer.Type.WRITE, null);
	if (retval <0)
	throw new RuntimeException("could not open output file");

	outStream = outContainer.addNewStream(0);
	outStreamCoder = outStream.getStreamCoder();

	ICodec codec = ICodec.guessEncodingCodec(null, null, OUTPUT_FILE_FLV, null, ICodec.Type.CODEC_TYPE_VIDEO);

	outStreamCoder.setNumPicturesInGroupOfPictures(30);
	outStreamCoder.setCodec(codec);

	outStreamCoder.setBitRate(25000);
	outStreamCoder.setBitRateTolerance(9000);

	int width = 300;
	int height = 300;
	
	
	outStreamCoder.setPixelType(IPixelFormat.Type.YUV420P);
	outStreamCoder.setHeight(height);
	outStreamCoder.setWidth(width);
	outStreamCoder.setFlag(IStreamCoder.Flags.FLAG_QSCALE, true);
	outStreamCoder.setGlobalQuality(0);

	IRational frameRate = IRational.make(3,1);
	outStreamCoder.setFrameRate(frameRate);
	outStreamCoder.setTimeBase(IRational.make(frameRate.getDenominator(), frameRate.getNumerator()));
	frameRate = null;

	retval = outStreamCoder.open();
	if (retval <0)
	throw new RuntimeException("could not open input decoder");
	retval = outContainer.writeHeader();
	if (retval <0)
	throw new RuntimeException("could not write file header");
	}

	public void encodeImage(BufferedImage originalImage,long duration){
	ByteArrayOutputStream byteConvert = new ByteArrayOutputStream();
	BufferedImage jpegImage = null;
	try{
	ImageIO.write(originalImage, "jpeg", byteConvert);
	byte[] imageData = byteConvert.toByteArray();
	InputStream imageData2 = new ByteArrayInputStream(imageData);
	jpegImage = ImageIO.read(imageData2);
	} catch(Exception e){
	e.printStackTrace(System.out);
	}
	IPacket packet = IPacket.make();

	IConverter converter = null;
	try{
	converter = ConverterFactory.createConverter(jpegImage, IPixelFormat.Type.YUV420P);
	} catch(UnsupportedOperationException e){
	System.out.println(e.getMessage());
	e.printStackTrace(System.out);
	}

	IVideoPicture outFrame = converter.toPicture(jpegImage, timeStamp);
	timeStamp += 333000;

	outFrame.setQuality(0);
	int retval = outStreamCoder.encodeVideo(packet, outFrame, 0);
	if (retval < 0)
	throw new RuntimeException("could not encode video");
	if (packet.isComplete()){
	retval = outContainer.writePacket(packet);
	if (retval < 0)
	throw new RuntimeException("could not save packet to container");
	}
	}

	public void closeStreams(){
	int retval = outContainer.writeTrailer();
	if (retval < 0)
	throw new RuntimeException("Could not write trailer to output file");
	}

	

	
	
}
