package imager;

/**
 * Defines the details of a tag.
 * @author Kumaripaba Athukorala
 *
 */

public class TagData {

	int startTime;
	int endTime;
	int tagId;
	String tag;

	public TagData(int id, int sTime, int eTime, String tagValue) {
		this.tagId = id;
		this.startTime = sTime;
		this.endTime = eTime;
		this.tag = tagValue;

	}

	public void setStartTime(int sTime) {
		this.startTime = sTime;
	}

	public void setEndTime(int eTime) {
		this.endTime = eTime;
	}

	public void setTag(String tagWord) {
		this.tag = tagWord;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public String getTag() {
		return tag;
	}

}
