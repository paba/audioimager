package imager;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MoreImageSearchThread extends Thread {

	int selectedColumn;
	String searchTag;
	int moreCount;
	//TableModel tblFlickrImagesModel;
	//JTable tblFlickrImages;
	ArrayList<TagImageContainer> tagImageContainerList;
	//ArrayList<String> ownerNames;
	ArrayList<AttributionData> attDataArray;
	JLabel lblWait;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton btnMore;
	boolean nonCommercialLicense;
	boolean shareAlikeLicense;
	public MoreImageSearchThread(int selectedColumn, int moreCount,String searchTag,JButton btn1,JButton btn2,JButton btn3,ArrayList<TagImageContainer> tagImageContainerList, JLabel lblWait,JButton btnMore,boolean nonCommercial,boolean shareAlike)
	{
		this.selectedColumn = selectedColumn;
		this.moreCount = moreCount;
		this.searchTag = searchTag;
		//this.tblFlickrImagesModel = tblFlickrImagesModel;
		//this.tblFlickrImages = tblFlickrImages;
		this.tagImageContainerList = tagImageContainerList;
		this.lblWait = lblWait;
		this.btnMore = btnMore;
		this.nonCommercialLicense = nonCommercial;
		this.shareAlikeLicense = shareAlike;
		
		this.button1 = btn1;
		this.button2 = btn2;
		this.button3 = btn3;
		
	}
	
	
	public synchronized ArrayList<URL> flickrURLs(String searchTag,int numberOfPhotos,String size,int pageNumber) throws SAXException, IOException, FlickrException, ParserConfigurationException
    {
		ArrayList<URL> URLs = new ArrayList<URL>();
		//ownerNames = new ArrayList<String>();
		attDataArray = new ArrayList<AttributionData>();
		 
    	try {
    		
    		FlickrClient flickrClient = FlickrClient.createInstance("199d038ad88f6c6c377a4ab2341fb60f");
            FlickrPhotoList photoList = flickrClient.getPhotosByTag(searchTag,pageNumber,numberOfPhotos,nonCommercialLicense,shareAlikeLicense);
           
            	
            	 for (int i = 0; i < photoList.getCount(); i++) {
                 	
                     FlickrPhoto photo = photoList.getPhoto(i);
                     String imageURL = photo.getImageUrl(size);
                     if(imageURL != null)
                     {
                    	 URLs.add(new URL(imageURL));
                    	 //System.out.println(imageURL);
                    	 
                    	
	                     System.out.println("Photo Id :" + photo.getPhotoId());
	                     DocumentBuilderFactory dcb = DocumentBuilderFactory.newInstance();
	                     DocumentBuilder xmlParser = dcb.newDocumentBuilder(); 
	                     System.out.println("URL = http://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=199d038ad88f6c6c377a4ab2341fb60f&photo_id="+photo.getPhotoId());
	                     Document document = xmlParser.parse("http://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=199d038ad88f6c6c377a4ab2341fb60f&photo_id="+photo.getPhotoId());
	                    
	                     NodeList ownerInfo = document.getDocumentElement().getElementsByTagName("owner");
	                     String ownerName = new String(ownerInfo.item(0).getAttributes().getNamedItem("username").getTextContent().getBytes("UTF8"),"UTF8");
	                     ownerName = URLEncoder.encode(ownerName,"UTF-8");
	                    	 
	                     String title = new String(document.getDocumentElement().getElementsByTagName("title").item(0).getTextContent().getBytes("UTF8"),"UTF8");
	                     title = URLEncoder.encode(title,"UTF-8");
	                     System.out.println("Title ="+title);
	                     
	                     NodeList photoInfo = document.getDocumentElement().getElementsByTagName("photo");
	                     int licenseInt =Integer.parseInt(photoInfo.item(0).getAttributes().getNamedItem("license").getTextContent());
	                     System.out.println("License = "+licenseInt);
	                     
	                     AttributionData attData = new AttributionData(licenseInt,title,ownerName,new URL(imageURL));
	                     attDataArray.add(attData);
                     
                     }
                    
                                		
                    
                 }
            
         
            
        } catch (MalformedURLException ex) {
        	 ex.printStackTrace();
        }
        
        return URLs;
        
       
    }
	
	public synchronized void  run() {
		
		
		lblWait.setVisible(true);
		try {
			ArrayList<URL> urls = flickrURLs(this.searchTag,3,FlickrPhoto.MEDIUM,this.moreCount);
			
			URL url;
			//String ownerName;
			AttributionData attributionData;
			//tblFlickrImagesModel = new FlickrImageTableModel();
			//tblFlickrImages.setModel(tblFlickrImagesModel);
			ResizeImage resizeImage = new ResizeImage(90,120);
			
			
			try {
			
				//for(int i=0; i < (urls.size()/4)*4 ; i++)
					for(int i=0; i < urls.size() ; i++)	
				{
					url = urls.get(i);
					//ownerName = ownerNames.get(i);
					attributionData = attDataArray.get(i);
					Image image = resizeImage.resize(url);
					if(image !=null)
					{
						
						synchronized (tagImageContainerList) 
						{
							
							
							tagImageContainerList.get(selectedColumn).addThumbnailImage(image);
				
							if(tagImageContainerList.get(selectedColumn).getOriginalImageURLs() == null)
							{
								ArrayList<URL> newURLs = new ArrayList<URL>();
								tagImageContainerList.get(selectedColumn).setOriginalImageUrls(newURLs);
								tagImageContainerList.get(selectedColumn).originalImageUrls.add(url);
								
								ArrayList<AttributionData> newAttributionData = new ArrayList<AttributionData>();
								tagImageContainerList.get(selectedColumn).setAttributionData(newAttributionData);
								tagImageContainerList.get(selectedColumn).getAttributionData().add(attributionData);
							}
							else if(tagImageContainerList.get(selectedColumn).getOriginalImageURLs().size() != 1 || i!=0)
							{
								tagImageContainerList.get(selectedColumn).originalImageUrls.add(url);
								tagImageContainerList.get(selectedColumn).attData.add(attributionData);
							}
							else
							{
								tagImageContainerList.get(selectedColumn).originalImageUrls.remove(0);
								tagImageContainerList.get(selectedColumn).originalImageUrls.add(0,url);
								tagImageContainerList.get(selectedColumn).attData.remove(0);
								tagImageContainerList.get(selectedColumn).attData.add(0,attributionData);
							}
						}
					}
				}
			synchronized (tagImageContainerList) 
				{
					if(tagImageContainerList.get(selectedColumn).originalImageUrls != null)
					{
						int count = tagImageContainerList.get(selectedColumn).getThumbnaiImages().size();
							
						//synchronized (tblFlickrImages) 
							
							//for(int i=0; i < (count/4)*4 ; i++)
							for(int i=0; i < 3 ; i++)
							{
								Image thumbImage = tagImageContainerList.get(selectedColumn).getThumbnaiImages().get(i);
								{
									/*TableCellRenderer flickrCellRenderer = new FlickrImgTableCellRenderer();
								
									tblFlickrImages.getColumnModel().getColumn(i%4).setCellRenderer(flickrCellRenderer);
									tblFlickrImagesModel.setValueAt(thumbImage,(int)Math.ceil((double)(i+1)/4), i%4 );
									tblFlickrImages.getColumnModel().getColumn(i%4).setPreferredWidth(120);
									tblFlickrImages.setRowHeight(90);*/
									
									/*if(i==0)
									{
										
										ImageIcon icon = new ImageIcon(thumbImage);
										button1.setIcon(icon);
										
									}
									else if (i==1)
									{
										button2.setIcon(new ImageIcon(thumbImage));
										button2.repaint();
									}
									else if(i==2)
									{
										button3.setIcon(new ImageIcon(thumbImage));
										button3.repaint();
									}*/
								}
							}
							//tblFlickrImages.repaint();
						
					}
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	lblWait.setVisible(false);
	btnMore.setVisible(true);
	}
	
	
	
	//

}
