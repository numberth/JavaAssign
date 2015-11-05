/**
 * Project: A00902090Gis
 * File: Score.java
 * Date: Jun 25, 2015
 * Time: 1:28:51 AM
 */
package a00902090.gis.data;

/**
 * @author Trista Huang, A00902090
 *
 */
public class Score {
    private String gamerTag;
    private String gameName;
    private int win;
    private int loss;
    private String platform;
    private int personaId;
    private int id;
    private int gamePlayed;

    /**
     * @return the gamePlayed
     */
    public int getGamePlayed() {
        return gamePlayed;
    }

    /**
     * @param gamePlayed
     *            the gamePlayed to set
     */
    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    /**
     * @return the personaID
     */
    public int getPersonaId() {
        return personaId;
    }

    /**
     * @param personaID
     *            the personaID to set
     */
    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the personaId
     */
    public String getGamerTag() {
        return gamerTag;
    }

    /**
     * @param personaId
     *            the personaId to set
     */
    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    /**
     * @return the gameId
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @param gameId
     *            the gameId to set
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

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
     * 
     */
    public Score() {
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform
     *            the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
