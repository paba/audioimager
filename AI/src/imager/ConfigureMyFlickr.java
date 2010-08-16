package imager;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.REST;
import com.aetrion.flickr.RequestContext;
import com.aetrion.flickr.auth.Auth;
import com.aetrion.flickr.auth.AuthInterface;
import com.aetrion.flickr.auth.Permission;
import com.aetrion.flickr.photos.PhotoList;
import com.aetrion.flickr.photos.PhotosInterface;
import com.aetrion.flickr.photos.SearchParameters;
import com.aetrion.flickr.photosets.Photoset;
import com.aetrion.flickr.photosets.PhotosetsInterface;

/**
 * Connects to the user's flickr account
 * @author Kumaripaba Athukorala
 *
 */
public class ConfigureMyFlickr {

	Flickr f;
	RequestContext requestContext;
	String frob = "";
	String token = "";
	Auth auth = null;
	AuthInterface authInterface = null;

	public ConfigureMyFlickr() throws ParserConfigurationException,
			IOException, SAXException, FlickrException, URISyntaxException {

		// Authenticate the user account
		f = new Flickr("199d038ad88f6c6c377a4ab2341fb60f", "4583b2386d3d6439",
				new REST());
		Flickr.debugStream = false;
		requestContext = RequestContext.getRequestContext();
		authInterface = f.getAuthInterface();

		// Obtaining the first frob
		frob = authInterface.getFrob();

		// Build the Authenticate URL
		java.net.URL url = authInterface.buildAuthenticationUrl(
				Permission.READ, frob);

		// Redirect the user to the URL

		Desktop desktop = Desktop.getDesktop();
		desktop.browse(url.toURI());

	}

	public PhotoList btnConfigureFlickrActionPerformed(ActionEvent evt)
			throws IOException, SAXException {

		try {
			auth = authInterface.getToken(frob);

			if (auth != null) {
				PhotoList photoList = new PhotoList();
				System.out.println("auth = " + auth);

				requestContext = RequestContext.getRequestContext();
				requestContext.setAuth(auth);
				f.setAuth(auth);

				PhotosInterface photosInterface = f.getPhotosInterface();
				PhotosetsInterface photoSetsInterface = f
						.getPhotosetsInterface();

				Collection sets = photoSetsInterface.getList(
						auth.getUser().getId()).getPhotosets();
				int length = sets.size();
				Iterator iter = sets.iterator();

				for (int i = 0; i < length; i++) {
					Photoset set = (Photoset) iter.next();
					photoList.addAll(photoSetsInterface.getPhotos(set.getId(),
							null, f.PRIVACY_LEVEL_PRIVATE, set.getPhotoCount(),
							1));
					photoList.addAll(photoSetsInterface.getPhotos(set.getId(),
							null, f.PRIVACY_LEVEL_FRIENDS_FAMILY, set
									.getPhotoCount(), 1));
					photoList.addAll(photoSetsInterface.getPhotos(set.getId(),
							null, f.PRIVACY_LEVEL_FAMILY, set.getPhotoCount(),
							1));
					photoList.addAll(photoSetsInterface.getPhotos(set.getId(),
							null, f.PRIVACY_LEVEL_FRIENDS, set.getPhotoCount(),
							1));
					photoList.addAll(photoSetsInterface.getPhotos(set.getId(),
							null, f.PRIVACY_LEVEL_PUBLIC, set.getPhotoCount(),
							1));
				}

				SearchParameters searchParams = new SearchParameters();
				searchParams.setSort(SearchParameters.INTERESTINGNESS_DESC);
				searchParams.setUserId(auth.getUser().getId());

				photoList.addAll(photosInterface.getNotInSet(500, 1));

				return photoList;
			} else {

				return null;
			}

		} catch (FlickrException e) {
			e.printStackTrace();
			return null;

		}

	}

}
