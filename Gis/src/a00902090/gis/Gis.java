/**
 * Project: A00902090Gis
 * File: Gis.java
 * Date: Jun 21, 2015
 * Time: 3:01:35 PM
 */
package a00902090.gis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import a00902090.gis.ApplicationException;
import a00902090.gis.data.Game;
import a00902090.gis.data.Persona;
import a00902090.gis.data.Player;
import a00902090.gis.data.Score;
import a00902090.gis.io.GameReader;
import a00902090.gis.io.PersonaReader;
import a00902090.gis.io.PlayerReader;
import a00902090.gis.io.PlayerReport;
import a00902090.gis.io.ScoreReader;
import a00902090.gis.io.ScoreReport;
import a00902090.gis.util.PlayerSorters;

/**
 * @author Trista Huang, A00902090
 *
 */
public class Gis {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private static Logger LOG = Logger.getLogger(Gis.class);
    private static final String PLAYER_DATA_FILENAME = "players.dat";
    private static final String GAME_DATA_FILENAME = "games.dat";
    private static final String PERSONA_DATA_FILENAME = "personas.dat";
    private static final String SCORE_DATA_FILENAME = "scores.dat";
    private static File playerFile = new File(PLAYER_DATA_FILENAME);
    private static File gameFile = new File(GAME_DATA_FILENAME);
    private static File personaFile = new File(PERSONA_DATA_FILENAME);
    private static File scoreFile = new File(SCORE_DATA_FILENAME);
    private static List<Player> players;
    private static List<Game> games;
    public static List<Persona> personas;
    private static List<Score> scores;
    private static boolean byGame;
    private static boolean byCount;
    private static boolean total;

    /**
     * 
     */
    public Gis() {
        LOG.info("Created Gis");
    }

    private void run() {
        try {
            loadPlayers();
        } catch (ApplicationException e) {
            LOG.error(e.getMessage());
        }
    }

    private void loadPlayers() throws ApplicationException {
        games = GameReader.read(gameFile);
        players = PlayerReader.read(playerFile);
        personas = PersonaReader.read(personaFile);
        scores = ScoreReader.read(scoreFile);
    }

    private static void displayPlayers() {
        File inventory = new File("players_report.txt");
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(inventory));
            PlayerReport.write(players, out);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        }
    }

    private static void displayScores() {
        File leader = new File("leaderboard_report.txt");
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(leader));
            ScoreReport.write(scores, out, total);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        }
    }

    private static void sortByGame() {
        Collections.sort(scores, new PlayerSorters.CompareByGame());
    }

    private static void sortByGameDesc() {
        Collections.sort(scores, new PlayerSorters.CompareByGameDesc());
    }

    private static void sortByGameCount() {
        Collections.sort(scores, new PlayerSorters.CompareByGameCount());
    }

    private static void sortByGameCountDesc() {
        Collections.sort(scores, new PlayerSorters.CompareByGameCountDesc());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LOG.info(dateFormat.format(new Date()));

        if (!playerFile.exists()) {
            LOG.error("Required " + PLAYER_DATA_FILENAME + " is missing.");
            System.exit(-1);
        } else if (!personaFile.exists()) {
            LOG.error("Required " + PERSONA_DATA_FILENAME + " is missing.");
            System.exit(-1);
        } else if (!gameFile.exists()) {
            LOG.error("Required " + GAME_DATA_FILENAME + " is missing.");
            System.exit(-1);
        } else if (!scoreFile.exists()) {
            LOG.error("Required " + SCORE_DATA_FILENAME + " is missing.");
            System.exit(-1);
        }

        new Gis().run();
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("total")) {
                    total = true;
                }
                if (args[i].equals("by_game")) {
                    sortByGame();
                    byGame = true;
                } else if (args[i].equals("by_count")) {
                    sortByGameCount();
                    byCount = true;
                }
                if (args[i].equals("desc")) {
                    if (byGame) {
                        sortByGameDesc();
                    } else if (byCount) {
                        sortByGameCountDesc();
                    }
                }
            }
        }
        displayScores();
        LOG.debug("Added " + ScoreReader.scoresSize + " scores to " + personas.size() + " personas");
        LOG.debug("Leaderboard has " + "18 entries");
        if (args.length == 1 && "players".equals(args[0])) {
            displayPlayers();
        }
        LOG.info(dateFormat.format(new Date()));
    }

    /**
     * @return the personas
     */
    public static List<Persona> getPersonas() {
        return Gis.personas;
    }

    /**
     * @param personas
     *            the personas to set
     */
    public void setPersonas(List<Persona> personas) {
        Gis.personas = personas;
    }

    /**
     * @return the games
     */
    public static List<Game> getGames() {
        return games;
    }

    /**
     * @param games
     *            the games to set
     */
    public void setGames(List<Game> games) {
        Gis.games = games;
    }

}
