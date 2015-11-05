/**
 * Project: A00902090Gis
 * File: PlayerReader.java
 * Date: Jun 21, 2015
 * Time: 3:01:35 PM
 */

package a00902090.gis.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import a00902090.gis.ApplicationException;
import a00902090.gis.data.Player;

/**
 * Read the player input.
 * 
 * @author Trista Huang, A00902090
 *
 */
public class PlayerReader {

    public static final String FIELD_DELIMITER = "\\|";

    private static Logger LOG = Logger.getLogger(PlayerReader.class);

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
     * @return An array of players.
     * @throws ApplicationException
     */
    public static List<Player> read(File file) throws ApplicationException {
        LOG.debug("Reading " + file.getAbsolutePath());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new ApplicationException(e);
        }

        List<Player> players = new ArrayList<>();
        try {
            @SuppressWarnings("unused")
            String ignore = scanner.nextLine();
            while (scanner.hasNext()) {

                String row = scanner.nextLine();
                // LOG.debug(row);
                String[] elements = row.split(FIELD_DELIMITER);
                // if (elements.length != Player.ATTRIBUTE_COUNT) {
                // throw new ApplicationException(String.format("Expected %d but got %d: %s", Player.ATTRIBUTE_COUNT,
                // elements.length, Arrays.toString(elements)));
                // }

                Player player = new Player();
                int index = 0;
                player.setId(Integer.parseInt(elements[index++]));
                player.setFirstName(elements[index++]);
                player.setLastName(elements[index++]);
                String email = elements[index++];
                player.setEmailAddress(email);

                String yyyymmdd = elements[index];
                try {
                    player.setAge(Integer.parseInt(yyyymmdd.substring(0, 4)));
                } catch (NumberFormatException e) {
                    LOG.error("Invalid date element:" + yyyymmdd);
                }

                players.add(player);
                // LOG.debug(player);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return players;
    }

}
