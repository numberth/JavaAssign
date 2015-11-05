/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090;

/**
 * @author Fred Fish, A00123456
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {


	/**
	 * Default constructor
	 */
	public ApplicationException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
