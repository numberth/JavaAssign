/**
 * Project: A00902090Gis
 * File: GameReader.java
 * Date: Jun 24, 2015
 * Time: 8:16:56 PM
 */
package a00902090.gis.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import a00902090.gis.ApplicationException;
import a00902090.gis.data.Game;

/**
 * @author Trista Huang, A00902090
 *
 */
public class GameReader {

    public static final String FIELD_DELIMITER = "\\|";

    private static Logger LOG = Logger.getLogger(GameReader.class);

    /**
     * private constructor to prevent instantiation
     */
    private GameReader() {
    }

    /**
     * Read the player input data.
     * 
     * @param data
     *            The input data.
     * @return An array of players.
     * @throws ApplicationException
     */
    public static List<Game> read(File file) throws ApplicationException {
        LOG.debug("Reading " + file.getAbsolutePath());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new ApplicationException(e);
        }

        List<Game> games = new ArrayList<>();
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

                Game game = new Game();
                int index = 0;
                game.setId(elements[index++]);
                game.setGameName(elements[index++]);
                game.setProducer(elements[index++]);

                games.add(game);
                // LOG.debug(player);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return games;
    }
}
