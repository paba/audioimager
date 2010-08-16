package imager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Represents the List of photos fetched via Flickr API
 * 
 * @author Winston Prakash
 */
public class FlickrPhotoList {

	private NodeList photoList;
	private int photoCount = 0;

	public FlickrPhotoList(Document document) {
		// Get the tag "photos" - container element for the list of photos

		NodeList photos = document.getDocumentElement().getElementsByTagName(
				"photos");
		if (photos != null && photos.getLength() > 0) {
			// Get the list of tags "photo" corresponding to each Flickr photo
			photoList = ((Element) photos.item(0))
					.getElementsByTagName("photo");
			if (photoList != null && photoList.getLength() > 0) {
				photoCount = photoList.getLength();
			}
		}
	}

	/**
	 * Get the number of photos in this list
	 * 
	 * @return
	 */
	public int getCount() {
		return photoCount;
	}

	/**
	 * Get the photo corresponding to an index from the list
	 * 
	 * @param index
	 * @return
	 */
	public FlickrPhoto getPhoto(int index) {
		return new FlickrPhoto((Element) photoList.item(index));
	}
}
