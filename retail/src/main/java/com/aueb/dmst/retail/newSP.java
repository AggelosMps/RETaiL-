package com.aueb.dmst.retail;

import java.util.InputMismatchException;

public class newSP {
    public static void main(String[] args) {
        boolean successful_login=false;
        while (!successful_login) {

            int choice = MethodsUser.menu();
            if (choice == 1) {
                Options.choice1();
            } else if (choice == 2) { 
                Options.choice2();
            } else if (choice == 3) {
                successful_login = true;
                Options.choice3();
                break;
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }

        }
    }
}
