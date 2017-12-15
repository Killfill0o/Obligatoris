package oxymat.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbc;




    public void create(User user) {

        jdbc.update("INSERT INTO users (id, username, password) VALUES ('"+ user.getId() + "','" + user.getUsername() + "','" +user.getPassword()+"')");
    }


    public User read(int id) {
        SqlRowSet user = jdbc.queryForRowSet("SELECT * FROM users WHERE id = '" + id + "'");
        while(user.next()){
            return new User(user.getInt("id"), user.getString("username"), user.getString("password"));
        }
        return null;
    }

    /*
    public ArrayList<User> readAll() {
        ArrayList<User> userList = new ArrayList<User>();
        SqlRowSet user = jdbc.queryForRowSet("SELECT * FROM users");


        while(user.next()){
            userList.add(new User(user.getInt("id"), user.getString("username"), user.getString("password")));
        }


        return userList;
    }
*/

    public void update(User update) {
        String newp = "null";
        if(update.getPassword().equals(update.getNewpass())) {
            if (update.getPassword1().equals(update.getPassword2())) {
                newp = update.getPassword1();
            } else {
                newp = update.getPassword();
            }
        }
        else{
            newp = update.getPassword();
        }

        jdbc.update("UPDATE users SET " +
                "username  = '" + update.getUsername()    + "'," +
                "password  = '" + newp    + "'," +
                "' WHERE id = '" + update.getId() +"'");
    }


    public void delete(int id) {
        jdbc.update("DELETE FROM users WHERE id ='" + id +"'");
    }

    public User findUserByUsername(String username, String password){
        SqlRowSet user = jdbc.queryForRowSet("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'");
        while(user.next()){
            return new User(user.getInt("id"), user.getString("username"), user.getString("password"));
        }
        return null;
    }
}
