package com.pluralsight.beanDemo;

public class User {
    private String username;
    private UserRoles role;

    public User(String username, UserRoles role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public void printRole() {
        System.out.println(this.role);
    }

    public void printPermissions() {
        switch (role) {
            case USER -> System.out.println("You are a user. Don't break the application please.");
            case ADMIN -> System.out.println("You are an admin. Be responsible.");
            case EDITOR -> System.out.println("You are an editor. Be creative.");
        }
    }
}
