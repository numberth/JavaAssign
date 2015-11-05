/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090.player.io;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import a00902090.data.Player;

/**
 * Prints a formated Players report.
 * 
 * @author Trista Huang, A00902090
 *
 */
public class PlayerReport {

    public static final String SEPERATOR = "-------------------------------------------------------------------------------------------------------";
    public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-24s %-24s %-15s%n";
    public static final String PERSONA_FORMAT = "%3d. %06d %-12s %-12s %-24s %-24s %-15s%n";
    public static final DateFormat birthDateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

    /**
     * private constructor to prevent instantiation
     */
    private PlayerReport() {
    }

    /**
     * Print the report.
     * 
     * @param players
     */
    public static void write(List<Player> players) {
        System.out.println("Personas Report");
        System.out.println(SEPERATOR);
        System.out.format(HEADER_FORMAT, "# ", "ID", "First name", "Last name", "Email", "Gamer tag", "Birthdate");
        System.out.println(SEPERATOR);

        int i = 0;
        for (Player player : players) {
            Date date = player.getBirthDate().getTime();
            System.out.format(PERSONA_FORMAT, ++i, player.getId(), player.getFirstName(), player.getLastName(),
                    player.getEmailAddress(), player.getGamerTag(), birthDateFormat.format(date));
        }
    }
}
