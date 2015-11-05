/**
 * Project: A00902090Gis
 * File: Game.java
 * Date: Jun 24, 2015
 * Time: 5:20:39 PM
 */
package a00902090.gis.data;

/**
 * @author Trista Huang, A00902090
 *
 */
public class Game {
    private String id;
    private String gameName;
    private String producer;
    private int win;
    private int loss;

    /**
     * @return the win
     */
    public int getWin() {
        return win;
    }

    /**
     * @param win
     *            the win to set
     */
    public void setWin(int win) {
        this.win = win;
    }

    /**
     * @return the loss
     */
    public int getLoss() {
        return loss;
    }

    /**
     * @param loss
     *            the loss to set
     */
    public void setLoss(int loss) {
        this.loss = loss;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @param gameName
     *            the gameName to set
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer
     *            the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * 
     */
    public Game() {
    }

}
