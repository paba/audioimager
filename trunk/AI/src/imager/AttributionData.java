package imager;

import java.net.URL;

public class AttributionData {
	
	int license;
	String title;
	String ownerName;
	URL url;
	
	public AttributionData(int license,String title,String ownerName,URL url)
	{
		this.license = license;
		this.title = title;
		this.ownerName = ownerName;
		this.url = url;
	}
	
	public void setLicense(int license)
	{
		this.license = license;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}
	
	public void setURL(URL url)
	{
		this.url = url;
	}
	
	public int getLicense()
	{
		return this.license;
	}

	public String getTitle()
	{
		return this.title;
	}
	
	public String getOwnerName()
	{
		return this.ownerName;
	}
	
	public URL getUrl()
	{
		return this.url;
	}
}
