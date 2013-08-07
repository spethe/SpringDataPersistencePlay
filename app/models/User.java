package models;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: swanand
 * Date: 23/7/13
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User {
    @Id
    public String username;
    public String password;

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
