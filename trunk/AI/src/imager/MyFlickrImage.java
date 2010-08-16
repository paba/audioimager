package imager;

import java.awt.Image;
import java.net.URL;

/**
 * Maintains the details of the images retrieved from the user's flickr account
 * @author Kumaripaba Athukorala
 *
 */
public class MyFlickrImage {
	URL mediumImageURL;

	Image thumbImage;

	public MyFlickrImage(URL url, Image thumb) {
		this.mediumImageURL = url;

		this.thumbImage = thumb;

	}

	public Image getThumbImage() {
		return thumbImage;
	}

	public URL getMediumImageURL() {
		return this.mediumImageURL;
	}

	/*
	 * public BufferedImage getImage() { return this.image; }
	 */

}
