package a00902090.gis.io;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import a00902090.gis.data.Player;

/**
 * Prints a formated Players report.
 * 
 * @author Trista Huang, A00902090
 *
 */
public class PlayerReport {

    public static final String SEPERATOR = "--------------------------------------------------------------------------------------------------";
    public static final String HEADER_FORMAT = "%s %-2s %-20s %-25s %-5s %-24s %-10s%n";
    public static final String PLAYER_FORMAT = "%9s %-20s %-25s %-22s %-16s %s%n";
    public static final DateFormat birthDateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

    private static Logger LOG = Logger.getLogger(PlayerReport.class);

    /**
     * private constructor to prevent instantiation
     */
    private PlayerReport() {
        LOG.debug("PlayerReport()");
    }

    /**
     * Print the report.
     * 
     * @param players
     */
    public static void write(List<Player> players, PrintStream out) {
        out.format(HEADER_FORMAT, "Player", "ID", "Full name", "Email", "Age", "Total games played", "Total wins");
        out.println(SEPERATOR);

        int i = 0;
        int j = 0;
        for (Player player : players) {
            // Date date = player.getBirthDate().getTime();
            out.format(PLAYER_FORMAT, player.getId(), player.getFirstName() + " " + player.getLastName(),
                    player.getEmailAddress(), player.getAge(), ScoreReader.getGamesPlayed(i++),
                    ScoreReader.getGamesWon(j++));
        }

        out.println(SEPERATOR);
    }
}
