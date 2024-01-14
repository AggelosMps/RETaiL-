package com.aueb.dmst.retail;

/**
 * Η κλάση Options παρέχει μεθόδους που αντιπροσωπεύουν διάφορες επιλογές
 * σχετικά με την αυθεντικοποίηση και την εγγραφή χρήστη στο σύστημα.
 */

public class Options {

    // Η μέθοδος choice1() εκτέλει τη λειτουργία για Log in
    public static void choice1() {
        String username = MethodsUser.nameUser();
        String password = MethodsUser.passwordUser();
        if (UseDB.authenticateUser(username, password)) {
            System.out.println("Login successful!");
            if (UseDB.checkfores(username) == 0) {
                UseDB.elegxossyndesis(username);
                MethodsUser.insertdata(username);
            }
            MethodsUser.epilogesMenu(username);
        } else {
            System.out.println("Login failed.Incorrect username or password.");
        }
    }

    // Η μέθοδος choice2() εκτέλει τη λειτουργία για Register
    public static void choice2() {
        String username = MethodsUser.nameUser();
        if (UseDB.usernameExist(username)) {
            System.out.println("Username already taken. Please choose another.");
        } else {
            String password = MethodsUser.passwordUser();
            System.out.println("Registration successful! You can now log in.");
            MethodsUser.newuser(username, password);
        }
    }

    // Η μέθοδος choice3() εκτέλει τη λειτουργία για Exit
    public static void choice3() {
        System.out.println("Exit the program.");
    }
}
