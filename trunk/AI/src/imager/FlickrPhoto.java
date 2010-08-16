package imager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Represent a Flickr Photo obtained via Flickr REST API
 * 
 * @author Winston Prakash
 */
public class FlickrPhoto {

	public static final String SQUARE = "Square";
	public static final String THUMBNAIL = "Thumbnail";
	public static final String SMALL = "Small";
	public static final String LARGE = "Large";
	public static final String ORIGINAL = "Original";
	public static final String MEDIUM = "Medium";

	private static final String METHOD_PHOTO_SIZES = "flickr.photos.getSizes";
	private String farmId;
	private String photoId;
	private String secretId;
	private String serverId;
	private String photoTitle;
	private String owner;
	private Map<String, Element> imageSizeMap;

	public FlickrPhoto(Element photo) {
		farmId = photo.getAttribute("farm");
		serverId = photo.getAttribute("server");
		photoId = photo.getAttribute("id");
		secretId = photo.getAttribute("secret");
		photoTitle = photo.getAttribute("title");
		owner = photo.getAttribute("owner");
	}

	/**
	 * Get the Static URL corresponding to the photo defined as
	 * http://farm{farm-id}.static.flickr.com/{server-id}/{id}_{secretId}.jpg
	 * See - http://www.flickr.com/services/api/misc.urls.html for details
	 */
	public String getPhotoId() {
		return photoId;
	}

	public String getOwner() {
		return owner;

	}

	public String getStaticUrl() {
		return "http://farm" + farmId + ".static.flickr.com/" + serverId + "/"
				+ photoId + "_" + secretId + ".jpg";

	}

	/**
	 * Return the image URL of the Original Image
	 * 
	 * @return URL string of original image
	 * @throws java.net.MalformedURLException
	 * @throws java.io.IOException
	 * @throws org.xml.sax.SAXException
	 */
	public String getImageUrl() throws MalformedURLException, IOException,
			SAXException, FlickrException {
		return getImageUrl(ORIGINAL);
	}

	/**
	 * Get Image URL corresponding to a particular photo size
	 * 
	 * @param size
	 *            - required size
	 * @return URL of the photo size
	 * @throws java.net.MalformedURLException
	 * @throws java.io.IOException
	 * @throws org.xml.sax.SAXException
	 */
	public synchronized String getImageUrl(String size)
			throws MalformedURLException, IOException, SAXException,
			FlickrException {
		if (imageSizeMap == null) {
			imageSizeMap = new HashMap<String, Element>();
			getSizes();
		}
		Element photoSizeInfo = imageSizeMap.get(size);
		if (photoSizeInfo != null) {
			return photoSizeInfo.getAttribute("source");
		}
		return null;
	}

	/**
	 * Get title of the phot
	 * 
	 * @return phot title
	 */
	public String getTitle() {
		return photoTitle;
	}

	/**
	 * Get the list of sizes corresponding to the phot
	 * 
	 * @throws java.net.MalformedURLException
	 * @throws org.xml.sax.SAXException
	 * @throws java.io.IOException
	 */
	private void getSizes() throws MalformedURLException, SAXException,
			IOException, FlickrException {
		FlickrClient flickrClient = FlickrClient.getInstance();
		Map<String, String> flickrApiParams = new HashMap<String, String>();
		flickrApiParams.put("photo_id", photoId);
		Document flickrData = flickrClient.getFlickrData(METHOD_PHOTO_SIZES,
				flickrApiParams);

		// Get the list of tags "sizes" corresponding to each Flickr photo
		NodeList sizes = flickrData.getDocumentElement().getElementsByTagName(
				"sizes");
		if (sizes != null && sizes.getLength() > 0) {
			// Get the list of tags "sizes" corresponding to each Flickr photo
			NodeList sizeList = ((Element) sizes.item(0))
					.getElementsByTagName("size");
			if (sizeList != null && sizeList.getLength() > 0) {
				for (int i = 0; i < sizeList.getLength(); i++) {
					Element photoSizeInfo = (Element) sizeList.item(i);
					imageSizeMap.put(photoSizeInfo.getAttribute("label"),
							photoSizeInfo);
					// System.out.println(photoSizeInfo.getAttribute("label"));
				}
			}
		}
	}
}
