package entities;

public class Users {
    private Integer id;
    private String username;
    private String password;


    public Users (Integer id, String username, String password ){
        this.id = id;
        this.username=username;
        this.password=password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}



