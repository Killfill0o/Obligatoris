package oxymat.demo;


public class User {

    private int id;
    private String username;
    private String password;
    private String password1;
    private String password2;
    private String newpass;

    public User(){

    }

    public User(int id, String username, String password){
        this.id = id;
        this. username = username;
        this.password = password;
    }

    // Getters
    public int getId(){
        return id;
    }

    public void setId(int value) {this.id = value;}

       public String getUsername(){
        return username;
    }

    public void setUsername(String value){
        this.username = value;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String value){
        this.password = value;
    }

    public String getPassword1(){
        return password1;
    }

    public void setPassword1(String value){
        this.password1 = value;
    }

    public String getPassword2(){
        return password2;
    }

    public void setPassword2(String value){
        this.password2 = value;
    }

    public String getNewpass(){
        return newpass;
    }

    public void setNewpass(String value){
        this.newpass = value;
    }

}
