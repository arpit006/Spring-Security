package org.app.auth.authentication_authorization;

public class ApplicationUser {

    public String username;
    public String password;


    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ApplicationUser(ApplicationUser user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public ApplicationUser() {
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
