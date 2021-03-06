package imager;
/**
 * Represents data related to a given video
 * @author Kumaripaba Athukorala
 *
 */
public class AudioData {

	private int songLength;
	private int songDuration;

	public void setSongLenth(int length) {
		this.songLength = length;
	}

	public void setSongDuration(int duration) {
		this.songDuration = duration;
	}

	public int getSongLength() {
		return songLength;
	}

	public int getSongDuration() {
		return songDuration;
	}
}
