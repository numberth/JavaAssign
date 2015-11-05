/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090.data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Trista Huang, A00902090
 *
 */
public class Player {

	public static final int ATTRIBUTE_COUNT = 6;
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String gamerTag;
	private GregorianCalendar birthDate;

	/**
	 * Default Constructor
	 */
	public Player() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the gamerTag
	 */
	public String getGamerTag() {
		return gamerTag;
	}

	/**
	 * @param gamerTag the gamerTag to set
	 */
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

	/**
	 * @return the birthDate
	 */
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	@Deprecated
	public void setBirthDate(Date date) {
		//this.birthDate = new GregorianCalendar(date);
	}

	/**
	 * Set the birthdate
	 * 
	 * @param year the year, includes the century, ex. 1967
	 * @param month the month - must be 0-based
	 * @param day the day of the month - 1-based
	 */
	public void setBirthDate(int year, int month, int day) {
		birthDate = new GregorianCalendar();
		birthDate.set(Calendar.YEAR, year);
		birthDate.set(Calendar.MONTH, month);
		birthDate.set(Calendar.DAY_OF_MONTH, day);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", gamerTag=" + gamerTag + ", birthDate=" + birthDate + "]";
	}

}
