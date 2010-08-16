package imager;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * A Simple Thread which searches for images in Flickr 
 * @author Kumaripaba Athukorala
 *
 */
public class ImageSearchThread extends Thread {

	ArrayList<TagData> tagArray;
	ArrayList<TagImageContainer> tagImageContainerList;
	ArrayList<ImageData> imageArray;
	JTable tblImage;

	float spacing;
	int i;

	String ownerName = "";
	AttributionData attData = null;
	boolean nonCommercialLicense;
	boolean shareAlikeLicense;
	JButton btn1, btn2, btn3, btnMore;
	JLabel lblWait;

	public ImageSearchThread(int i, float spacing, ArrayList<TagData> tagArray,
			ArrayList<TagImageContainer> tagImageContainerList,
			ArrayList<ImageData> imageArray, JTable tblImage,
			boolean nonCommercial, boolean shareAlike, JButton button1,
			JButton button2, JButton button3, JButton buttonMore,
			JLabel labelWait) {
		this.i = i;
		this.spacing = spacing;
		this.tagArray = tagArray;
		this.tagImageContainerList = tagImageContainerList;
		this.imageArray = imageArray;
		this.tblImage = tblImage;
		this.nonCommercialLicense = nonCommercial;
		this.shareAlikeLicense = shareAlike;
		this.btn1 = button1;
		this.btn2 = button2;
		this.btn3 = button3;
		this.btnMore = buttonMore;
		this.lblWait = labelWait;

	}

	public ArrayList<URL> flickrURLs(String searchTag, int numberOfPhotos,
			String size, int pageNumber) throws SAXException, IOException,
			FlickrException, ParserConfigurationException {
		ArrayList<URL> URLs = new ArrayList<URL>();

		try {

			FlickrClient flickrClient = FlickrClient
					.createInstance("199d038ad88f6c6c377a4ab2341fb60f");
			FlickrPhotoList photoList = flickrClient.getPhotosByTag(searchTag,
					pageNumber, numberOfPhotos, nonCommercialLicense,
					shareAlikeLicense);

			for (int count = 0; count < photoList.getCount(); count++) {

				FlickrPhoto photo = photoList.getPhoto(count);
				String imageURL = photo.getImageUrl(size);

				String photoId = photo.getPhotoId();
				DocumentBuilderFactory dcb = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder xmlParser = dcb.newDocumentBuilder();
				System.out
						.println("URL = http://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=199d038ad88f6c6c377a4ab2341fb60f&photo_id="
								+ photo.getPhotoId());
				// Document document =
				// xmlParser.parse("http://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=17a010f8ef5566563b5666925b42ebe3&photo_id="+photo.getPhotoId());
				Document document = xmlParser
						.parse("http://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=199d038ad88f6c6c377a4ab2341fb60f&photo_id="
								+ photo.getPhotoId());

				NodeList photoInfo = document.getDocumentElement()
						.getElementsByTagName("photo");
				NodeList ownerInfo = ((Element) photoInfo.item(0))
						.getElementsByTagName("owner");
				ownerName = ownerInfo.item(0).getAttributes().getNamedItem(
						"username").getTextContent();
				ownerName = URLEncoder.encode(ownerName, "UTF-8");
				String nsid = ownerInfo.item(0).getAttributes().getNamedItem(
						"nsid").getTextContent();

				System.out.println("owner name =" + ownerName);

				String title = ((Element) photoInfo.item(0))
						.getElementsByTagName("title").item(0).getTextContent();
				title = URLEncoder.encode(title, "UTF-8");
				System.out.println("Title =" + title);

				int licenseInt = Integer.parseInt(photoInfo.item(0)
						.getAttributes().getNamedItem("license")
						.getTextContent());
				System.out.println("License = " + licenseInt);

				if (imageURL != null) {
					URLs.add(new URL(imageURL));
					attData = new AttributionData(licenseInt, title, ownerName,
							new URL("http://www.flickr.com/photos/" + nsid
									+ "/" + photoId));
					// System.out.println(imageURL);
				}

			}

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}

		return URLs;

	}

	public void run() {

		ResizeImage imageResize = new ResizeImage(240, 320, "CENTER");
		ResizeImage resizeToThumb = new ResizeImage(90, 120, "LEFT");

		TagData t = tagArray.get(i);
		String tagWord = t.getTag().replace(" ", ",");
		try {

			ArrayList<URL> urlOriginal = flickrURLs(tagWord, 1,
					FlickrPhoto.MEDIUM, 1);

			Image image;
			Image thumbImage;
			String urlPath;
			TagImageContainer tagContainer;

			// ArrayList<String> ownerNames = new ArrayList<String>();
			ArrayList<AttributionData> attDataArray = new ArrayList<AttributionData>();
			int count = 2;
			if (urlOriginal.size() > 0) {
				URL url = urlOriginal.get(0);

				image = imageResize.resize(url);
				thumbImage = resizeToThumb.resize(url);
				while (image == null && (count < 7)) {
					urlOriginal = flickrURLs(tagWord, 1, FlickrPhoto.MEDIUM,
							count);
					url = urlOriginal.get(0);
					image = imageResize.resize(url);
					thumbImage = resizeToThumb.resize(url);
					count++;
				}
				if (image != null) {

					while (tagImageContainerList.size() < i) {
						this.sleep(50);
					}
					// ownerNames.add(ownerName);
					attDataArray.add(this.attData);
					tagContainer = new TagImageContainer(i, urlOriginal,
							attDataArray);
					tagContainer.addOriginalImage(image);

					tagImageContainerList.add(i, tagContainer);
					urlPath = urlOriginal.get(0).toString();
				} else {
					image = imageResize.resize("noPhoto.jpg");
					thumbImage = resizeToThumb.resize("noPhoto.jpg");
					urlPath = "noPhoto.jpg";
					while (tagImageContainerList.size() < i) {
						this.sleep(50);
					}

					tagContainer = new TagImageContainer(i, urlOriginal,
							attDataArray);
					tagImageContainerList.add(i, tagContainer);
				}

			} else {
				image = imageResize.resize("noPhoto.jpg");
				thumbImage = resizeToThumb.resize("noPhoto.jpg");
				urlPath = "noPhoto.jpg";
				while (tagImageContainerList.size() < i) {
					this.sleep(50);
				}

				tagContainer = new TagImageContainer(i, urlOriginal,
						attDataArray);
				tagImageContainerList.add(i, tagContainer);

			}

			ImageData imgData = new ImageData(t.getStartTime(), t.getEndTime(),
					i, urlPath, image, thumbImage, this.attData);

			while (imageArray.size() < i) {
				this.sleep(50);
			}
			imageArray.add(i, imgData);

			int timegap = t.getEndTime() - t.getStartTime();

			if (timegap < 2) {
				timegap = 2;
			}
			int cellWidth = Math.round(spacing * timegap);
			System.out.println("start time" + t.getStartTime() + "endtime"
					+ t.getEndTime() + "cell width=" + cellWidth);
			System.out.println("column count before"
					+ tblImage.getColumnCount());
			if (tblImage.getModel() != null)
				while (tblImage.getColumnCount() < i) {
					this.sleep(50);
				}
			synchronized (tblImage) {

				System.out.println("column count after"
						+ tblImage.getColumnCount());
				tblImage.getColumnModel().addColumn(
						new TableColumn(i, cellWidth));
				TableCellRenderer mycellrenderer = new MyTableCellRenderer();
				tblImage.getColumnModel().getColumn(i).setCellRenderer(
						mycellrenderer);
				tblImage.setValueAt(imgData, 0, i);
				tblImage.getColumnModel().getColumn(i).setResizable(true);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		Thread moreSearchThread = new MoreImageSearchThread(i, 1, tagWord,
				btn1, btn2, btn3, tagImageContainerList, lblWait, btnMore,
				nonCommercialLicense, shareAlikeLicense);
		moreSearchThread.start();

	}

}
