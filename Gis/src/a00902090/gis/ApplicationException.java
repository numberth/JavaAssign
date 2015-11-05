/**
 * Project: A00902090Gis
 * File: Game.java
 * Date: Jun 24, 2015
 * Time: 5:20:39 PM
 */

package a00902090.gis;

/**
 * @author Trista Huang, A00902090
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
