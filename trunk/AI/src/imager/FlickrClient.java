package imager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * A simple Flickr client that fetches data using Flickr REST API
 * @author Winston Prakash
 */
public class FlickrClient {

    private static FlickrClient instance;
    public static final String METHOD_RECENT_PHOTOS = "flickr.photos.getRecent";
     public static final String METHOD_SEARCH_PHOTOS = "flickr.photos.search";

    // To get the required Flickr API key visit
    // http://www.flickr.com/services/api/misc.api_keys.html
    private final String flickrApiKey;
    private DocumentBuilder xmlParser = null;

    private FlickrClient(String apiKey) {
        flickrApiKey = apiKey;
        DocumentBuilderFactory dcb = DocumentBuilderFactory.newInstance();
        try {
            this.xmlParser = dcb.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Create an instance using the given API key
     * @param apiKey
     * @return FlickrClient
     */
    public synchronized static FlickrClient createInstance(String apiKey) {
        instance = new FlickrClient(apiKey);
        return instance;
    }
    
    /**
     * returns the eacrlier created instance for internal use by the library
     * @return
     */
    synchronized static FlickrClient getInstance() {
        return instance;
    }

    /**
     * Get the Flickr Photos based on a particular tag
     * @param tagName - name of the tag
     * @param page - page number 
     * @return list of Flickr photos
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public FlickrPhotoList getPhotosByTag(String tagName, int page,int noOfPhotos,boolean nonCommercial,boolean shareAlike) 
            throws MalformedURLException, SAXException, IOException, FlickrException {
        Map<String, String> flickrApiParams = new HashMap<String, String>();
        flickrApiParams.put("tags", tagName);
        flickrApiParams.put("per_page",String.valueOf(noOfPhotos) );
        flickrApiParams.put("page", String.valueOf(page));
        //flickrApiParams.put("license","2,4,7");
        if(nonCommercial)
        {
        	flickrApiParams.put("license","2,4,7");
        }
        else if (shareAlike)
        {
        	flickrApiParams.put("license", "5,4,7");
        }	
        else
        {
        	flickrApiParams.put("license","4,7");
        }
        flickrApiParams.put("sort", "relevance");
      
        //flickrApiParams.put("username", "pabaatukorala");
        //flickrApiParams.put("privacy_filter", "1");
       
        
        Document flickrData = getFlickrData(METHOD_SEARCH_PHOTOS, flickrApiParams);
        return new FlickrPhotoList(flickrData);
    }

    /**
     * Get the recent public photos
     * @param page - page number 
     * @return list of Flickr photos
     * @throws java.net.MalformedURLException
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     */
    public FlickrPhotoList getRecentPublicPhotos(int page) 
            throws MalformedURLException, IOException, SAXException, FlickrException {
        Map<String, String> flickrApiParams = new HashMap<String, String>();
        flickrApiParams.put("per_page", "10");
        flickrApiParams.put("page", String.valueOf(page));
        Document flickrData = getFlickrData(METHOD_RECENT_PHOTOS, flickrApiParams);
        return new FlickrPhotoList(flickrData);
    }

    /**
     * Construct the Flickr REST URL
     * @param method - Flickr API method
     * @param params - parameters for the Flickr REST method 
     * @return constructed URL 
     * @throws java.net.MalformedURLException
     */
    private URL constructFlickrRequestUrl(String method, Map<String, String> params) throws MalformedURLException {
        String flickrServiceEndPoint = "http://www.flickr.com/services/rest/";
        String flickrRequestMethod = flickrServiceEndPoint + "?method=" + method;
        String flickrRequestParams = "&api_key=" + flickrApiKey;
        for (String paramKey : params.keySet()) {
            flickrRequestParams += "&" + paramKey + "=" + params.get(paramKey);
        }
        return new URL(flickrRequestMethod + flickrRequestParams);
    }

    /**
     * Send Flickr Request and returns parsed Flickr Response
     * @param method - Flickr API method
     * @param params - Flickr API Method parameters
     * @return W3C document after parsing the Flickr Response
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    protected synchronized Document getFlickrData(String method, Map<String, String> params)
            throws MalformedURLException, SAXException, IOException, FlickrException {
        URL flickrRequestUrl = null;
        flickrRequestUrl = constructFlickrRequestUrl(method, params);
        //System.out.println(flickrRequestUrl);
        Document document = xmlParser.parse(flickrRequestUrl.toString());
        NodeList errors = document.getDocumentElement().getElementsByTagName("err");
        if (errors != null && errors.getLength() > 0) {
            throw new FlickrException((Element)errors.item(0));
        }
        return document;
    }

    protected void printXml(Document doc) 
            throws TransformerConfigurationException, TransformerException {
        // Prepare the DOM document for writing
        Source source = new DOMSource(doc);
        Result result = new StreamResult(System.out);
        // Write the DOM document
        Transformer xformer = TransformerFactory.newInstance().newTransformer();
        xformer.transform(source, result);
    }

    /**
     * @param args the command line arguments
     */
    
    
}
