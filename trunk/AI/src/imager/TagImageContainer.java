package imager;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

public class TagImageContainer {
	
	int tagId;
	ArrayList<Image> thumbnailImages ;
	ArrayList<Image> originalImages;
	ArrayList<URL> originalImageUrls;
	ArrayList<AttributionData> attData;

	
	public TagImageContainer(int id,ArrayList<URL> originalUrls, ArrayList<AttributionData> attData)
	{
		this.tagId = id;
		originalImageUrls = originalUrls;
		
		
		thumbnailImages= new ArrayList<Image>();
		originalImages = new ArrayList<Image>();
		
		if(attData == null)
		{
			attData = new ArrayList<AttributionData>();
		}
		else
		{
			this.attData = attData;
		}
		
	}
	
	

	public ArrayList<AttributionData> getAttributionData()
	{
		return this.attData;
	}
	
	public void setAttributionData(ArrayList<AttributionData> attributionData)
	{
		this.attData = attributionData;
	}
	public void setOriginalImageUrls(ArrayList<URL> originalURLs)
	{
		this.originalImageUrls = originalURLs;
	}
	
	public void addThumbnailImage(Image thumbnailImage)
	{
		this.thumbnailImages.add(thumbnailImage);
	}
	
	public void addOriginalImageURL(URL originalURL)
	{
		this.originalImageUrls.add(originalURL);
	}
	
	public void addOriginalImage(Image originalImage)
	{
		this.originalImages.add(originalImage);
	}
	public ArrayList<Image> getThumbnaiImages()
	{
		return thumbnailImages;
	}
	
	public ArrayList<URL> getOriginalImageURLs()
	{
		return originalImageUrls;
	}
	
	public ArrayList<Image> getOriginalImages()
	{
		return originalImages;
	}

}
