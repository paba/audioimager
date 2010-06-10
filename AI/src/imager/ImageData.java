package imager;

import java.awt.Image;

public class ImageData {
	
	private int startTime;
	private int endTime;
	private int index;
	private String path;
	private Image image;
	
	ImageData (int start, int end, int id, String url, Image picture)
	{
		startTime = start;
		endTime = end;
		index = id;
		path = url;
		image = picture;
	}
	
	public int getStartTime()
	{
		return startTime;
	}
	public int getEndTime()
	{
		return endTime;
	}
	public int getIndex()
	{
		return index;
	}
	public String getPath()
	{
		return path;
	}
	public Image getImage()
	{
		return image;
	}
	public void setStartTime(int stime)
	{
		this.startTime = stime;
	}
	public void setEndTime(int endtime)
	{
		this.endTime = endtime;
	}
	
	public void setImage(Image picture)
	{
		this.image = picture;
	}

}
