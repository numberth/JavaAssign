/**
 * Project: A00902090Gis
 * File: PlayerSorters.java
 * Date: Jun 25, 2015
 * Time: 11:13:30 AM
 */
package a00902090.gis.util;

import java.util.Comparator;

import a00902090.gis.data.Score;

/**
 * @author Trista Huang, A00902090
 *
 */
public class PlayerSorters {

    public static class CompareByGame implements Comparator<Score> {
        public int compare(Score score1, Score score2) {
            return score1.getGameName().compareTo(score2.getGameName());
        }
    }

    public static class CompareByGameDesc implements Comparator<Score> {
        public int compare(Score score1, Score score2) {
            return score2.getGameName().compareTo(score1.getGameName());
        }
    }

    public static class CompareByGameCount implements Comparator<Score> {
        public int compare(Score score1, Score score2) {
            int re = 0;
            if (score1.getGamePlayed() < (score2.getGamePlayed())) {
                re = -1;
            } else if (score1.getGamePlayed() > (score2.getGamePlayed())) {
                re = 1;
            } else if (score1.getGamePlayed() == (score2.getGamePlayed())) {
                re = 0;
            }
            return re;
        }
    }

    public static class CompareByGameCountDesc implements Comparator<Score> {
        public int compare(Score score1, Score score2) {
            int re = 0;
            if (score1.getGamePlayed() > (score2.getGamePlayed())) {
                re = -1;
            } else if (score1.getGamePlayed() < (score2.getGamePlayed())) {
                re = 1;
            } else if (score1.getGamePlayed() == (score2.getGamePlayed())) {
                re = 0;
            }
            return re;
        }
    }
}
