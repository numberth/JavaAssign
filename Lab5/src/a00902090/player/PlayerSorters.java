/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090.player;

import java.util.Comparator;

import a00902090.data.Player;

/**
 * @author Fred Fish, A00123456
 *
 */
public class PlayerSorters {

	public static class CompareByBirthdate implements Comparator<Player> {
		public int compare(Player player1, Player player2) {
			return player1.getBirthDate().compareTo(player2.getBirthDate());
		}
	}
}
