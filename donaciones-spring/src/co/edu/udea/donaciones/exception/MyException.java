package co.edu.udea.donaciones.exception;

import org.apache.log4j.Logger;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	Logger log= Logger.getLogger(this.getClass());
}
