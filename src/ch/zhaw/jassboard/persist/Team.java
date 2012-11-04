package ch.zhaw;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class Team {
    private Integer teamID;
    private String teamName;


    public Team(Integer id, String Name) {
        this.teamID = id;
        this.teamName = Name;
    }

    public void createPlayer() {

    }

    public void savePlayer() {

    }

    public String getName() {
        return teamName;
    }

    public Integer getId() {
        return teamID;
    }

}
