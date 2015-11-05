package a00902090.gis.io;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import a00902090.gis.data.Score;

/**
 * Prints a formated Players report.
 * 
 * @author Trista Huang, A00902090
 *
 */
public class ScoreReport {

    public static final String SEPERATOR = "------------------------------------------------------------";
    public static final String HEADER_FORMAT = "%-5s %-20s %-20s %s%n";
    public static final String PLAYER_FORMAT = "%-8s %-20s %-19s  %s%n";
    public static final DateFormat birthDateFormat = new SimpleDateFormat("EEE MMM dd yyyy");

    private static Logger LOG = Logger.getLogger(PlayerReport.class);

    /**
     * private constructor to prevent instantiation
     */
    private ScoreReport() {
        LOG.debug("ScoreReport()");
    }

    /**
     * Print the report.
     * 
     * @param players
     */
    public static void write(List<Score> scores, PrintStream out, boolean total) {
        out.format(HEADER_FORMAT, "Win:Loss", "Game Name", "Gamer Tag", "Platform");
        out.println(SEPERATOR);

        for (Score score : scores) {
            // Date date = player.getBirthDate().getTime();
            out.format(PLAYER_FORMAT, score.getWin() + ":" + score.getLoss(), score.getGameName(), score.getGamerTag(),
                    score.getPlatform());
        }

        if (total) {
            out.println(SEPERATOR);
            out.println("Number Picker\t" + ScoreReader.getTotalNP());
            out.println("Quick Fingers\t" + ScoreReader.getTotalQF());
            out.println("Colour Demon\t" + ScoreReader.getTotalCD());
        }

        out.println(SEPERATOR);
    }
}
