/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imager;

import org.w3c.dom.Element;

/**
 * Exception thrown when there is a flickr returns error response
 * 
 * @author Winston Prakash
 */
public class FlickrException extends Exception {
	String errorId;
	String errorMessage;

	public FlickrException(Element error) {
		errorId = error.getAttribute("code");
		errorMessage = error.getAttribute("msg");
	}

	@Override
	public String getMessage() {
		return "Flickr Error: " + errorId + " - " + errorMessage;
	}
}
