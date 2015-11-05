/**
 * Project: A00902090Gis
 * File: ScoreReader.java
 * Date: Jun 24, 2015
 * Time: 8:44:06 PM
 */
package a00902090.gis.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import a00902090.gis.ApplicationException;
import a00902090.gis.Gis;
import a00902090.gis.data.Score;

/**
 * @author Trista Huang, A00902090
 *
 */
public class ScoreReader {

    public static final String FIELD_DELIMITER = "\\|";

    private static Logger LOG = Logger.getLogger(ScoreReader.class);
    private static int[] gamesPlayed = new int[5];
    private static int[] gamesWon = new int[5];
    private static int totalQF;
    private static int totalCD;
    private static int totalNP;
    public static int scoresSize;

    /**
     * private constructor to prevent instantiation
     */
    private ScoreReader() {
    }

    /**
     * Read the score input data.
     * 
     * @param data
     *            The input data.
     * @return An array of players.
     * @throws ApplicationException
     */
    public static List<Score> read(File file) throws ApplicationException {
        LOG.debug("Reading " + file.getAbsolutePath());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new ApplicationException(e);
        }

        List<Score> scores = new ArrayList<>();
        try {
            @SuppressWarnings("unused")
            String ignore = scanner.nextLine();

            while (scanner.hasNext()) {
                String row = scanner.nextLine();
                String[] elements = row.split(FIELD_DELIMITER);
                int i = 0;
                int win = 0;
                int loss = 0;
                Score score = new Score();
                while (i < Gis.getPersonas().size()) {
                    if (Gis.getPersonas().get(i).getPersonaId() == Integer.parseInt(elements[0])) {
                        score.setGamerTag(Gis.getPersonas().get(i).getGamerTag());
                        score.setPlatform(Gis.getPersonas().get(i).getPlatform());
                        score.setPersonaId(Gis.getPersonas().get(i).getPersonaId());
                        score.setId(Gis.getPersonas().get(i).getId());
                    }
                    i++;
                }
                int q = 0;
                while (q < Gis.getGames().size()) {
                    if (Gis.getGames().get(q).getId().equals(elements[1])) {
                        score.setGameName(Gis.getGames().get(q).getGameName());
                    }
                    q++;
                }
                if (elements[2].equals("WIN")) {
                    score.setWin(++win);
                } else if (elements[2].equals("LOSE")) {
                    score.setLoss(++loss);
                }

                scores.add(score);
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
            scoresSize = scores.size();
        }

        for (int p = 0; p < scores.size(); p++) {
            int total;
            if (scores.get(p).getId() == 1) {
                total = scores.get(p).getWin() + scores.get(p).getLoss();
                gamesPlayed[0] += total;
            }
            if (scores.get(p).getId() == 2) {
                total = scores.get(p).getWin() + scores.get(p).getLoss();
                gamesPlayed[1] += total;
            }
            if (scores.get(p).getId() == 3) {
                total = scores.get(p).getWin() + scores.get(p).getLoss();
                gamesPlayed[2] += total;
            }
            if (scores.get(p).getId() == 4) {
                total = scores.get(p).getWin() + scores.get(p).getLoss();
                gamesPlayed[3] += total;
            }
            if (scores.get(p).getId() == 5) {
                total = scores.get(p).getWin() + scores.get(p).getLoss();
                gamesPlayed[4] += total;
            }
        }

        for (int n = 0; n < scores.size(); n++) {
            int total;
            if (scores.get(n).getId() == 1) {
                total = scores.get(n).getWin();
                gamesWon[0] += total;
            }
            if (scores.get(n).getId() == 2) {
                total = scores.get(n).getWin();
                gamesWon[1] += total;
            }
            if (scores.get(n).getId() == 3) {
                total = scores.get(n).getWin();
                gamesWon[2] += total;
            }
            if (scores.get(n).getId() == 4) {
                total = scores.get(n).getWin();
                gamesWon[3] += total;
            }
            if (scores.get(n).getId() == 5) {
                total = scores.get(n).getWin();
                gamesWon[4] += total;
            }
        }

        for (int n = 0; n < scores.size(); n++) {
            String game = scores.get(n).getGameName();
            if (game.equals("Quick Fingers")) {
                totalQF++;
                scores.get(n).setGamePlayed(totalQF);
            } else if (game.equals("Colour Demon")) {
                totalCD++;
                scores.get(n).setGamePlayed(totalCD);
            } else if (game.equals("Number Picker")) {
                totalNP++;
                scores.get(n).setGamePlayed(totalNP);
            }
        }

        List<Score> temp = new ArrayList<>();
        List<Score> temp1 = new ArrayList<>();
        temp1.addAll(scores);

        for (int j = 0; j < scores.size(); j++) {
            int pId = scores.get(j).getPersonaId();
            String game1 = scores.get(j).getGameName();

            for (int k = 0; k < scores.size(); k++) {
                int pId2 = scores.get(k).getPersonaId();
                String game2 = scores.get(k).getGameName();

                if (game1.equals(game2)) {
                    if (pId2 == pId) {
                        scores.get(k).setWin(scores.get(j).getWin() + scores.get(k).getWin());
                        scores.get(k).setLoss(scores.get(j).getLoss() + scores.get(k).getLoss());
                        temp.add(scores.get(k));

                        scores.remove(k);
                        scores.remove(j);
                    }
                }
            }
        }
        scores.addAll(temp);

        return scores;
    }

    /**
     * @return the totalQF
     */
    public static int getTotalQF() {
        return totalQF;
    }

    /**
     * @return the totalCD
     */
    public static int getTotalCD() {
        return totalCD;
    }

    /**
     * @return the totalNP
     */
    public static int getTotalNP() {
        return totalNP;
    }

    public static int getGamesPlayed(int i) {
        int gamesPlay = gamesPlayed[i];
        return gamesPlay;
    }

    public static int getGamesWon(int i) {
        int gamesWin = gamesWon[i];
        return gamesWin;
    }
}
