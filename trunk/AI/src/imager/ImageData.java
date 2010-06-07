package imager;

public class ImageData {
	
	private int startTime;
	private int endTime;
	private int index;
	private String path;
	
	ImageData (int start, int end, int id, String url)
	{
		startTime = start;
		endTime = end;
		index = id;
		path = url;
		
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
	public void setStartTime(int stime)
	{
		this.startTime = stime;
	}
	public void setEndTime(int etime)
	{
		this.endTime = etime;
	}
	

}
