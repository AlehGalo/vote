/**
 * 
 */
package com.sswf.vote.model;

import java.io.Serializable;

/**
 * @author aleh.bahatyrou
 *
 */
public class PhotoResponse implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	private String uid;

	private String first_name;

	private String last_name;

	private String photo_200;

	private String status;

	/**
	 * 
	 */
	public PhotoResponse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name
	 *            the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the photo_200
	 */
	public String getPhoto_200() {
		return photo_200;
	}

	/**
	 * @param photo_200
	 *            the photo_200 to set
	 */
	public void setPhoto_200(String photo_200) {
		this.photo_200 = photo_200;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
