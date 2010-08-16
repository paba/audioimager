package imager;

import java.awt.Image;
/**
 * Maintains the details about the Image.
 * @author Kumaripaba Athukorala
 *
 */
public class ImageData {

	private int startTime;
	private int endTime;
	private int index;
	private String path;
	private AttributionData attData = null;
	private Image image;
	private Image imageThumb;

	public ImageData(int start, int end, int id, String url, Image picture,
			Image thumbImage, AttributionData attData) {
		startTime = start;
		endTime = end;
		index = id;
		path = url;
		image = picture;
		this.imageThumb = thumbImage;
		this.attData = attData;
	}

	public AttributionData getAttribution() {
		return this.attData;
	}

	public void setAttribution(AttributionData attribution) {
		System.out.println(attribution);
		this.attData = attribution;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getIndex() {
		return index;
	}

	public String getPath() {
		return path;
	}

	public Image getImage() {
		return image;
	}

	public Image getThumbImage() {
		return imageThumb;
	}

	public void setStartTime(int stime) {
		this.startTime = stime;
	}

	public void setEndTime(int endtime) {
		this.endTime = endtime;
	}

	public void setImage(Image picture) {
		this.image = picture;
	}

	public void setIndex(int Id) {
		this.index = Id;
	}

	public void setThumbImage(Image thumbImage) {
		this.imageThumb = thumbImage;
	}
}
