/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090.util;

import java.util.regex.Pattern;

/**
 * Validate data.
 * 
 * @author Trista Huang, A00902090
 *
 */
public class Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	private Validator() {
	}

	/**
	 * Validate an email string.
	 * 
	 * @param email the email string.
	 * @return true if the email address is valid, false otherwise.
	 */
	public static boolean validateEmail(final String email) {		
        return pattern.matcher(email).matches();
	}

}
