/**
 * Project: A00902090Lab5
 * File: Validator.java
 * Date: Mar 15, 2015
 * Time: 12:22:23 PM
 */

package a00902090;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import a00902090.data.Player;
import a00902090.player.PlayerSorters;
import a00902090.player.io.PlayerReader;
import a00902090.player.io.PlayerReport;

/**
 * 
 * Create a commandline program which reads persona data from txt file, creates Persona objects, adds them to a
 * collection, and prints
 * a simple Persona report sorted by birthdate
 * 
 * 
 * @author Trista Huang, A00902090
 *
 */
public class Lab5 {

    public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private static final Logger LOG = Logger.getLogger(Lab5.class);
    private String playerData;
    private static List<String> dataInput = new ArrayList<>();
    private List<Player> players;
    private static String fileName = "players.txt";

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        File output = new File("players_report.txt");
        FileOutputStream fileOut = new FileOutputStream(output);
        PrintStream stdout = System.out;
        PrintStream out = new PrintStream(fileOut);
        System.setOut(out);

        System.out.println(dateFormat.format(new Date()) + "\n");

        new Lab5(getData()).run();

        System.out.println("\n" + dateFormat.format(new Date()));

        // Lab5 output is in "player_report.txt", not printed on console.
        System.setOut(stdout);
        System.out.println("Refer to " + output + " for output.");
    }

    /**
     * Reads player info from txt file.
     * 
     * @return String of data for PlayerReader to process
     */
    public static String getData() {
        BufferedInputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(fileName));
        } catch (Exception e) {
            LOG.error(e.getMessage());
            System.exit(-1);
        }

        Scanner scan = new Scanner(input);
        String text = scan.next();
        dataInput.add(text);

        while (scan.hasNext()) {
            text = scan.next();
            dataInput.add(text);
        }
        scan.close();

        String data = dataInput.get(0);
        for (int i = 1; i < dataInput.size(); i++) {
            data += "|" + dataInput.get(i);
        }
        return data;
    }

    /**
     * Lab5 constructor. Initialized the personas collection.
     */
    public Lab5(String playerData) {
        this.playerData = playerData;
    }

    /**
     * Populate the personas and print them out.
     */
    private void run() {
        try {
            loadPlayers();

            // sort the players by birthdate
            Collections.sort(players, new PlayerSorters.CompareByBirthdate());

            displayPlayers();
        } catch (ApplicationException e) {
            LOG.error(e.getMessage());
        }
    }

    private void loadPlayers() throws ApplicationException {
        players = PlayerReader.read(playerData);
    }

    private void displayPlayers() {
        PlayerReport.write(players);
    }

}
