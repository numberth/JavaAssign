/**
 * Project: A00902090Gis
 * File: Persona.java
 * Date: Jun 23, 2015
 * Time: 9:59:34 PM
 */
package a00902090.gis.data;

/**
 * @author Trista Huang, A00902090
 *
 */
public class Persona {
    private int personaId;
    private int id;
    private String gamerTag;
    private String platform;

    // private List<Game> gameName = new ArrayList<>();

    /**
     * 
     */
    public Persona() {
    }

    /**
     * @return the personaId
     */
    public int getPersonaId() {
        return personaId;
    }

    /**
     * @param personaId
     *            the personaId to set
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
     * @return the gamerTag
     */
    public String getGamerTag() {
        return gamerTag;
    }

    /**
     * @param gamerTag
     *            the gamerTag to set
     */
    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
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

    // /**
    // * @return the gameName
    // */
    // public List<Game> getGameName() {
    // return gameName;
    // }
    //
    // /**
    // * @param gameName the gameName to set
    // */
    // public void setGameName(String gameName) {
    // for (int i = 0; i < gameName.length(); i++){
    // String id = this.gameName.get(i).getId();
    // if(!id.equals(gameName)){
    // Game game = new Game();
    // this.gameName.add(game);
    // }else if(id.equals(gameName)){
    // if()
    // }
    // }
    // }

}
