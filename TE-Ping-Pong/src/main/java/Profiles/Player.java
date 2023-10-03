package Profiles;

public class Player {

    private String firstName;
    private String lastName;
    private String nickname;
    private String description;


    //constructor
    public Player(String firstName, String lastName, String nickname, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.description = description;
    }
    //getters and setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


}
