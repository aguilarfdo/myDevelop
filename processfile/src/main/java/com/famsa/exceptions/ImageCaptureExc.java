package com.famsa.exceptions;

public class ImageCaptureExc extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1595911007473390537L;

	public ImageCaptureExc() {
		super();
	}
	
	public ImageCaptureExc(String message) {
		super(message);
	}
	
	public ImageCaptureExc(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ImageCaptureExc(Throwable cause) {
		super(cause);
	}
	
}