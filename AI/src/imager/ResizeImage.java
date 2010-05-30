package imager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import sun.reflect.generics.visitor.Reifier;


public class ResizeImage {
	
	private int newHeight;
	private int newWidth;
	
	ResizeImage(int height, int width)
	{
		this.newHeight = height;
		this.newWidth = width;
	}
	
	public Image resize(String path)
	{
		BufferedImage bufferedImage= null;
		Image i = null ;
		Image resizedImage = null;
		try {

		
		BufferedImage layer = ImageIO.read(new File(path));

		BufferedImage background = ImageIO.read(new File("black.JPG")); 
		
		int iWidth = 1;
		iWidth = layer.getWidth();
		int iHeight = 1; 
		iHeight = layer.getHeight();
		
		int newWidth;
		System.out.println("Width="+iWidth+"Height="+iHeight);
	
		// TODO
		if ((iWidth/4)>(iHeight/3)){
			System.out.println("IFFFF");
			newWidth = 640;
		}
		else{
			newWidth = (iWidth*480)/iHeight;
			
		}
		
		
		resizedImage =  layer.getScaledInstance(newWidth, (newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);
		
		
		Image image = resizedImage;
		bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(image, null, null);
        layer = bufferedImage;
       
		WritableRaster raster = background.getRaster();
		int width = layer.getWidth();
		int height = layer.getHeight();
		int lPixel,red,green,blue = 0;
		int dispWidth = (640-width)/2; 
		int dispHeight = (480-height)/2;	
		System.out.println("Width="+width+"Height="+height);
		
		for(int w=0;w<width;w++)
			for(int h=0;h<height;h++){
				lPixel   = layer.getRGB(w, h);
		        red   = (int)((lPixel&0x00FF0000)>>>16); // Red level
		        green = (int)((lPixel&0x0000FF00)>>>8);  // Green level
		        blue  = (int) (lPixel&0x000000FF);       // Blue level 
				raster.setPixel(w+dispWidth,h+dispHeight,new int[]{red,green,blue,255});        
			} 
		
		i = background.getScaledInstance(background.getWidth(),
								background.getHeight(), Image.SCALE_SMOOTH);

	    
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

		
	}

}
