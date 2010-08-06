package imager;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.aetrion.flickr.photos.Photo;
import com.aetrion.flickr.photos.PhotoList;

public class MyFlickrImageLoadThread extends Thread{
	ArrayList<MyFlickrImage>  myFlickrImageList;
	PhotoList photoList;
	JTable tblMyFlickrImages;
	TableModel tblMyFlickrImagesModel;
	ResizeImage resizeImage;
	JLabel lblWait;
	JLabel lblStatus;
	int position;
	
	public MyFlickrImageLoadThread(ArrayList<MyFlickrImage>  myFlickrImageList,PhotoList photoList,JTable tblMyFlickrImages,TableModel tblMyFlickrImagesModel,JLabel lblWait,JLabel lblStatus,int myFlickrMoreCount)
	{
		this.myFlickrImageList = myFlickrImageList;
		this.photoList = photoList;
		this.tblMyFlickrImages = tblMyFlickrImages;
		resizeImage = new ResizeImage(90,120);
		this.tblMyFlickrImagesModel = tblMyFlickrImagesModel; 
		this.lblWait = lblWait;
		this.lblStatus = lblStatus;
		this.position = myFlickrMoreCount;
	}
	public void run()
	{
	
		//myFlickrImageList.clear();
		for(int i=0;i<photoList.size();i++){
	          //get photo object
	          Photo photo=(Photo)photoList.get(i);
	         //Get medium url photo
	          BufferedImage mediumImage;
			try {
				mediumImage = photo.getMediumImage();
				Image resizedImage = resizeImage.resize(mediumImage);
				
				if(resizedImage !=null)
				{
					MyFlickrImage myFlickrImage = new MyFlickrImage(new URL(photo.getMediumUrl()),resizedImage);
			         myFlickrImageList.add(myFlickrImage);
				}
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	        									          
	       }
		/*int count = myFlickrImageList.size();
		for(int i=0; i < (count/4)*4 ; i++)*/
		int count = myFlickrImageList.size();
		
		
		for(int i=position; i < (count/4)*4 ; i++)
	       {
		
	    	   Image resizedImage = myFlickrImageList.get(i).getThumbImage(); 
	    	   TableCellRenderer flickrCellRenderer = new FlickrImgTableCellRenderer();
	    	   tblMyFlickrImages.getColumnModel().getColumn(i%4).setCellRenderer(flickrCellRenderer);
	    	   tblMyFlickrImagesModel.setValueAt(resizedImage,(int)Math.ceil((double)(i+1)/4), i%4 );
			   tblMyFlickrImages.getColumnModel().getColumn(i%4).setPreferredWidth(120);
			   tblMyFlickrImages.setRowHeight(90);
			   tblMyFlickrImages.repaint();
	       }
		lblWait.setVisible(false);
		lblStatus.setText("");
	}

}
