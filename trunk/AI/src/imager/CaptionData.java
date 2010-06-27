package imager;

public class CaptionData {
	
	int captionStartTime;
	int captionEndTime;
	String caption;
	
	public CaptionData(int startTime, int endTime, String cap)
	{
		this.captionStartTime = startTime;
		this.captionEndTime = endTime;
		this.caption = cap;
	}

	public int getStartTime()
	{
		return this.captionStartTime;
	}
	
	public int getEndTime()
	{
		return this.captionEndTime;
	}
	
	public String getCaption()
	{
		return this.caption;
	}
	
	public void setStartTime(int startTime)
	{
		this.captionStartTime = startTime;
	}
	
	public void setEndTime(int endTime)
	{
		this.captionEndTime = endTime;
	}
	
	public void setCaption(String cap)
	{
		this.caption = cap;
	}
}
