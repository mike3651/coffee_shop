/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author ubuntu
 */
public class Person {

    String userName;
    String password;
    String authentication;

    public Person() {

    }

    public Person(String theUserName, String thePassword, String theAuthentication) {
        this.userName = theUserName;
        this.password = thePassword;
        this.authentication = theAuthentication;
    }

    public String getUserName() {
        return userName;
    }

    public void setAuthentication(String theAuthentication) {
        this.authentication = theAuthentication;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setUserName(String theUserName) {
        this.userName = theUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String thePassword) {
        this.password = thePassword;
    }
}
