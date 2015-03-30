package com.sswf.vote;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private PhotoResponse response[];

	public Response() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the response
	 */
	public PhotoResponse[] getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(PhotoResponse[] response) {
		this.response = response;
	}

}
