package imager;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class CCAttribution {
	ArrayList<AttributionData> attList;
	
	String s ;
	Image image;
	Component component;
	ResizeImage resize ;
	public CCAttribution(ArrayList<AttributionData> attributionList,Component comp)
	{
		this.attList = attributionList;
		this.component = comp;
		resize = new ResizeImage(240,320);
		if(attributionList.get(0).getLicense()==4)
		{
			s="The following images are licensed with CC-BY 2.0 license:";
		}
		else if(attributionList.get(0).getLicense()==2)
		{
			s="The following images are licensed with CC-BY-NC 2.0 license:";
		}
		else if(attributionList.get(0).getLicense()==5)
		{
			s="The following images are licensed with CC-BY-SA 2.0 license:";
		}
		else if(attributionList.get(0).getLicense()==7)
		{
			s= "The following images have no known copyright restrictions";
		}
		
	}

	public Image createAttributionImage()
	{
		
		  System.out.println(s);
		  Font f = new Font("Serif",Font.BOLD,100);
		  
		  MediaTracker mt = new MediaTracker(component);
	      image = Toolkit.getDefaultToolkit().createImage("black.jpg");
	      mt.addImage(image,0);
	      try{mt.waitForID(0);}catch(InterruptedException ie){}

	         
	      int width = image.getWidth(null);
	      int height = image.getHeight(null);
	      BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	      bimg.createGraphics().drawImage(image, 0, 0, component);
	      bimg.getGraphics().setFont(f);
	      bimg.getGraphics().drawString(s,2,10);
	      int y=40;
	      for(int i=0; i < attList.size();i++)
			{
	    	  
	    	  	try {
					s = "-"+URLDecoder.decode(attList.get(i).getTitle(),"UNICODE") ;
					bimg.getGraphics().drawString(s,2,y);
					bimg.getGraphics().drawString("by "+ URLDecoder.decode(attList.get(i).getOwnerName(),"UNICODE"), 4, y+15);
					if(attList.get(i).getUrl() != null)
					{
						bimg.getGraphics().drawString(attList.get(i).getUrl().toString(), 4, y+30);
					}
					
					y = y+50;
					
					
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	      
	    	  bimg.getGraphics().drawString("~~Created by Using AudioImager~~",60,235);  
	      
	      
	      
	     
	      //Image image =Toolkit.getDefaultToolkit().createImage(bimg.getSource());
	      return resize.resize(bimg);
	}
}
