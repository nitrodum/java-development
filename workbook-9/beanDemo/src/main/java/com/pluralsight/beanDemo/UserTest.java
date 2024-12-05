package com.pluralsight.beanDemo;

public class UserTest {

    public static void main(String[] args) {
        User u = new User("1", UserRoles.USER);
        User a = new User("2", UserRoles.ADMIN);
        User e = new User("3", UserRoles.EDITOR);

        u.printRole();
        u.printPermissions();
        a.printRole();
        a.printPermissions();
        e.printRole();
        e.printPermissions();
    }
}
