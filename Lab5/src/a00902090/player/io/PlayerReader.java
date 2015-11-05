/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090.player.io;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import a00902090.ApplicationException;
import a00902090.data.Player;
import a00902090.util.Validator;

/**
 * Read the player input.
 * 
 * @author Trista Huang, A00902090
 *
 */
public class PlayerReader {

    public static final String RECORD_DELIMITER = ":";
    public static final String FIELD_DELIMITER = "\\|";
    private static final Logger LOG = Logger.getLogger(PlayerReader.class);

    /**
     * private constructor to prevent instantiation
     */
    private PlayerReader() {
    }

    /**
     * Read the player input data.
     * 
     * @param data
     *            The input data.
     * @return A list of players.
     * @throws ApplicationException
     */
    public static List<Player> read(String data) throws ApplicationException {
        String[] rows = data.split(FIELD_DELIMITER);
        List<Player> players = new ArrayList<>();
        
        int index = 0;
        for (int i = 0; i < rows.length / 6; i++) {
            if ((rows.length % Player.ATTRIBUTE_COUNT) != 0) {
                throw new ApplicationException(String.format("Expected %d but got %d Attributes",
                        Player.ATTRIBUTE_COUNT, (rows.length % 6)));
            }

            Player player = new Player();

            player.setId(Integer.parseInt(rows[index++]));
            player.setFirstName(rows[index++]);
            player.setLastName(rows[index++]);
            String email = rows[index++];
            if (!Validator.validateEmail(email)) {
                throw new ApplicationException(String.format("Invalid email: %s", email));
            }
            player.setEmailAddress(email);
            player.setGamerTag(rows[index++]);
            String yyyymmdd = rows[index++];

            try {
                player.setBirthDate(Integer.parseInt(yyyymmdd.substring(0, 4)),
                        Integer.parseInt(yyyymmdd.substring(4, 6)) - 1, Integer.parseInt(yyyymmdd.substring(6, 8)));
            } catch (NumberFormatException e) {
                LOG.error("Invalid date element:" + yyyymmdd);
            }

            players.add(player);
        }

        return players;
    }

}
