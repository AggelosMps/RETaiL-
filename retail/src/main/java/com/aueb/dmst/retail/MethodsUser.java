package com.aueb.dmst.retail;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;
public class MethodsUser {
    public static Scanner scanner = new Scanner(System.in);
    public static int count_employee=1;
    public static int count_name=1;
    public static int count_pr_now=1;
    public static int count_pr_yesterday=1;
    public static int count_pr_db_yesterday=1;
    public static int count_price=1;
    public static int count_pr_cost=1;
    public static String nameUser() {
        System.out.println("Δώσε το όνομα σου");
        String user = scanner.nextLine();
        return user;
    }
    public static String passwordUser() {
        System.out.println("Δώσε τον κωδικό σου");
        String userpa = scanner.nextLine();
        return userpa;
    }
    public static int menu() {
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        return answer;
    }
    public static void epilogesMenu(String username) {
        boolean flag = true;
        int answer = 0;
        while (flag) {    
            System.out.println("Σε ποιόν τομέα θέλετε να σας εξυπηρετήσουμε;");
            System.out.println("1. Αποθέματα (Σας προτείνει το προιόν που πρέπει να αγοράσετε για να μεγιστοποιήσετε το κέρδος σας, βάση των πωλήσεων που έχετε κάνει τις προηγούμενες 3 μέρες.)");
            System.out.println("2. Τιμολόγηση (Σας προτείνει την καλύτερη τιμή για να μεγιστοποιήσετε το κέρδος σας, βάση των πωλήσεων που έχετε κάνει τις προηγούμενες 3 μέρες.)");
            System.out.println("3. Πρόγραμμα προσωπικού (Ωρολόγιο πρόγραμμα προσωπικού.)");
            System.out.println("4. Οικονομικές καταστάσεις (Έσοδα, Έξοδα, Κέρδη επιχείρησης, έχοντας την επιλογή και για διαγραμματική αναπαράσταση.)");
            try {
                answer = scanner.nextInt();
                if (answer >= 0 && answer <=4) {
                    flag = false;
                } else {
                    System.out.println("Παρακαλούμε επιλέξτε ένα απο τα ακόλουθα.");
                }    
            } catch (InputMismatchException e) {
                System.out.println("Παρακαλούμε επιλέξτε ένα απο τα ακόλουθα.");
            }
        }
        epilogesDiadikasia(answer,username);   
    }
    public static void insertdata(String username) {
        insertEmployee_data(username);
        insertEmployee_data(username);
        insertEmployee_data(username);
        insertEmployee_data(username);
        insertEmployee_data(username);
        //
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
        //
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);         //Μπορούμε να την σπάσουμε σε 5 μεθόδους
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
        //
        
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
        //
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
        //
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
    }
    public static void insertEmployee_data(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Καταχωρήστε στοιχεία για τον εργαζόμενο "+count_employee+" στην μορφή: Όνομα, Μέρα που μπορεί να εργαστεί, Ώρα έναρξης, Ώρα λήξης βάρδιας, (Επαναλάβετε για όσες μέρες μπορεί)");           
            try {
                String employee = scanner.nextLine();
                UseDB.insertIntoDBString("employee"+count_employee++, employee, username);
                y = false;
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertProduct_Name(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Καταχωρήστε όνομα για προιόν"+count_name);         
            try {
                if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
                }  
                String product_name = scanner.nextLine();
                UseDB.insertIntoDBString("product_name"+count_name++, product_name, username);
                y = false;
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertProduct_Now(String username) {
        boolean y = true;       
        while (y) {
            System.out.println("Καταχωρήστε σημερινή ποσότητα για προιόν"+count_pr_now);           
            int pr_now = scanner.nextInt();
            if (pr_now > 0) {
                y = false;
                UseDB.insertIntoDBInt("pr_now"+count_pr_now++, pr_now, username);
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertProduct_Yesterday(String username) {
        boolean y = true;       
        while (y) {
            System.out.println("Καταχωρήστε χθεσινή ποσότητα για προιόν"+count_pr_yesterday);
            if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
            }          
            int pr_yesterday = scanner.nextInt();
            if (pr_yesterday > 0) {
                y = false;
                UseDB.insertIntoDBInt("pr_yesterday"+count_pr_yesterday++, pr_yesterday, username);
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertProduct_Db_Yesterday(String username) {
        boolean y = true;       
        while (y) {
            System.out.println("Καταχωρήστε προχθεσινή ποσότητα για προιόν"+count_pr_db_yesterday);
            if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
            }           
            int pr_db_yesterday = scanner.nextInt();
            if (pr_db_yesterday > 0) {
                y = false;
                UseDB.insertIntoDBInt("pr_db_yesterday"+count_pr_db_yesterday++, pr_db_yesterday, username);
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertPrice(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Ποιά είναι η τιμή για προιόν"+count_price);
            if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
            }            
            double price = scanner.nextInt();
            if (price > 0) {
                y = false;
                UseDB.insertIntoDBDouble("price"+count_price++, price, username);
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertProduct_Cost(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Ποιό είναι το κόστος για προιόν"+count_pr_cost);
            if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
            }          
            double pr_cost = scanner.nextInt();
            if (pr_cost > 0) {
                y = false;
                UseDB.insertIntoDBDouble("pr_cost"+count_pr_cost++, pr_cost, username);
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    




    public static void epilogesDiadikasia(int answer,String username) {
        // kalei tis katalhlles methodous gia thn leitourgia pou epeleje o xrhsths
        if (answer==1) {
            String apothema1 = UseDB.selectFromTableString(username, "product_name1") + "," + 
            UseDB.selectFromTableNumber(username, "pr_now1") + "," + UseDB.selectFromTableNumber(username, "pr_yesterday1") + "," + 
            UseDB.selectFromTableNumber(username, "pr_db_yesterday1");
            String apothema2 = UseDB.selectFromTableString(username, "product_name2") + "," + 
            UseDB.selectFromTableNumber(username, "pr_now2") + "," + UseDB.selectFromTableNumber(username, "pr_yesterday2") + "," + 
            UseDB.selectFromTableNumber(username, "pr_db_yesterday2");
            String apothema3 = UseDB.selectFromTableString(username, "product_name3") +
            "," + UseDB.selectFromTableNumber(username, "pr_now3") + "," + UseDB.selectFromTableNumber(username, "pr_yesterday3") +
            "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday3");
            String apothema4 = UseDB.selectFromTableString(username, "product_name4") +
            "," + UseDB.selectFromTableNumber(username, "pr_now4") + "," + UseDB.selectFromTableNumber(username, "pr_yesterday4") + 
            "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday4"); 
            String apothema5 = UseDB.selectFromTableString(username, "product_name5") + 
            "," + UseDB.selectFromTableNumber(username, "pr_now5") + "," + UseDB.selectFromTableNumber(username, "pr_yesterday5") + 
            "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday5");
            
            System.out.println(ApiRequest.getApothema(apothema1));
            System.out.println(ApiRequest.getApothema(apothema2));
            System.out.println(ApiRequest.getApothema(apothema3));
            System.out.println(ApiRequest.getApothema(apothema4));
            System.out.println(ApiRequest.getApothema(apothema5));

        } else if (answer == 2) {
            String price1 = UseDB.selectFromTableString(username, "product_name1") + "," + UseDB.selectFromTableNumber(username, "price1") +
            "," + UseDB.selectFromTableNumber(username, "pr_cost1") + "," + UseDB.selectFromTableNumber(username, "pr_now1") + "," +
            UseDB.selectFromTableNumber(username, "pr_yesterday1") + "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday1");
            String price2 = UseDB.selectFromTableString(username, "product_name2") + "," + UseDB.selectFromTableNumber(username, "price2") +
            "," + UseDB.selectFromTableNumber(username, "pr_cost2") + "," + UseDB.selectFromTableNumber(username, "pr_now2") + "," +
            UseDB.selectFromTableNumber(username, "pr_yesterday2") + "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday2");
            String price3 = UseDB.selectFromTableString(username, "product_name3") + "," + UseDB.selectFromTableNumber(username, "price3") +
            "," + UseDB.selectFromTableNumber(username, "pr_cost3") + "," + UseDB.selectFromTableNumber(username, "pr_now3") + "," +
            UseDB.selectFromTableNumber(username, "pr_yesterday3") + "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday3");
            String price4 = UseDB.selectFromTableString(username, "product_name4") + "," + UseDB.selectFromTableNumber(username, "price4") +
            "," + UseDB.selectFromTableNumber(username, "pr_cost4") + "," + UseDB.selectFromTableNumber(username, "pr_now4") + "," +
            UseDB.selectFromTableNumber(username, "pr_yesterday4") + "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday4");
            String price5 = UseDB.selectFromTableString(username, "product_name5") + "," + UseDB.selectFromTableNumber(username, "price5") +
            "," + UseDB.selectFromTableNumber(username, "pr_cost5") + "," + UseDB.selectFromTableNumber(username, "pr_now5") + "," +
            UseDB.selectFromTableNumber(username, "pr_yesterday5") + "," + UseDB.selectFromTableNumber(username, "pr_db_yesterday5");
            
            System.out.println(ApiRequest.getPrice(price1));
            System.out.println(ApiRequest.getPrice(price2));
            System.out.println(ApiRequest.getPrice(price3));
            System.out.println(ApiRequest.getPrice(price4));
            System.out.println(ApiRequest.getPrice(price5));
            
        } else if (answer == 3) {
            String programma = UseDB.selectFromTableString(username, "employee1") + "," + UseDB.selectFromTableString(username, "employee2") +
            "," + UseDB.selectFromTableString(username, "employee3") + "," + UseDB.selectFromTableString(username, "employee4") + "," + 
            UseDB.selectFromTableString(username, "employee5");
            System.out.println(ApiRequest.getSchedule(programma));
        } else if (answer == 4) {
            int aDifference;
            double revenues_yesterday1;
            double revenues_today1;
            double revenues_yesterday2;
            double revenues_today2;
            double revenues_yesterday3;
            double revenues_today3;
            double revenues_yesterday4;
            double revenues_today4;
            double revenues_yesterday5;
            double revenues_today5;
            //product1
            if ((UseDB.selectFromTableNumber(username, "pr_yesterday1").intValue()) < (UseDB.selectFromTableNumber(username, "pr_db_yesterday1")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_db_yesterday1").intValue()) - (UseDB.selectFromTableNumber(username, "pr_yesterday1").intValue());
                revenues_yesterday1 = aDifference * (UseDB.selectFromTableNumber(username, "price1").doubleValue());
            } else {
                revenues_yesterday1 = 0;
            }
            if ((UseDB.selectFromTableNumber(username, "pr_now1").intValue()) < (UseDB.selectFromTableNumber(username, "pr_yesterday1")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_yesterday1").intValue()) - (UseDB.selectFromTableNumber(username, "pr_now1").intValue());
                revenues_today1 = aDifference * (UseDB.selectFromTableNumber(username, "price1").doubleValue());
            } else {
                revenues_today1 = 0;
            }
            double total_revenues1 = revenues_today1 + revenues_yesterday1;
            //product2
            if ((UseDB.selectFromTableNumber(username, "pr_yesterday2").intValue()) < (UseDB.selectFromTableNumber(username, "pr_db_yesterday2")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_db_yesterday2").intValue()) - (UseDB.selectFromTableNumber(username, "pr_yesterday2").intValue());
                revenues_yesterday2 = aDifference * (UseDB.selectFromTableNumber(username, "price2").doubleValue());
            } else {
                revenues_yesterday2 = 0;
            }
            if ((UseDB.selectFromTableNumber(username, "pr_now2").intValue()) < (UseDB.selectFromTableNumber(username, "pr_yesterday2")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_yesterday2").intValue()) - (UseDB.selectFromTableNumber(username, "pr_now2").intValue());
                revenues_today2 = aDifference * (UseDB.selectFromTableNumber(username, "price2").doubleValue());
            } else {
                revenues_today2 = 0;
            }
            double total_revenues2 = revenues_today2 + revenues_yesterday2;
            //product3
            if ((UseDB.selectFromTableNumber(username, "pr_yesterday3").intValue()) < (UseDB.selectFromTableNumber(username, "pr_db_yesterday3")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_db_yesterday3").intValue()) - (UseDB.selectFromTableNumber(username, "pr_yesterday3").intValue());
                revenues_yesterday3 = aDifference * (UseDB.selectFromTableNumber(username, "price3").doubleValue());
            } else {
                revenues_yesterday3 = 0;
            }
            if ((UseDB.selectFromTableNumber(username, "pr_now3").intValue()) < (UseDB.selectFromTableNumber(username, "pr_yesterday3")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_yesterday3").intValue()) - (UseDB.selectFromTableNumber(username, "pr_now3").intValue());
                revenues_today3 = aDifference * (UseDB.selectFromTableNumber(username, "price3").doubleValue());
            } else {
                revenues_today3 = 0;
            }
            double total_revenues3 = revenues_today3 + revenues_yesterday3;
            //product 4
            if ((UseDB.selectFromTableNumber(username, "pr_yesterday4").intValue()) < (UseDB.selectFromTableNumber(username, "pr_db_yesterday4")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_db_yesterday4").intValue()) - (UseDB.selectFromTableNumber(username, "pr_yesterday4").intValue());
                revenues_yesterday4 = aDifference * (UseDB.selectFromTableNumber(username, "price4").doubleValue());
            } else {
                revenues_yesterday4 = 0;
            }
            if ((UseDB.selectFromTableNumber(username, "pr_now4").intValue()) < (UseDB.selectFromTableNumber(username, "pr_yesterday4")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_yesterday4").intValue()) - (UseDB.selectFromTableNumber(username, "pr_now4").intValue());
                revenues_today4 = aDifference * (UseDB.selectFromTableNumber(username, "price4").doubleValue());
            } else {
                revenues_today4 = 0;
            }
            double total_revenues4 = revenues_today4 + revenues_yesterday4;
            //product5
            if ((UseDB.selectFromTableNumber(username, "pr_yesterday5").intValue()) < (UseDB.selectFromTableNumber(username, "pr_db_yesterday5")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_db_yesterday5").intValue()) - (UseDB.selectFromTableNumber(username, "pr_yesterday5").intValue());
                revenues_yesterday5 = aDifference * (UseDB.selectFromTableNumber(username, "price5").doubleValue());
            } else {
                revenues_yesterday5 = 0;
            }
            if ((UseDB.selectFromTableNumber(username, "pr_now5").intValue()) < (UseDB.selectFromTableNumber(username, "pr_yesterday5")).intValue()) {
                aDifference = (UseDB.selectFromTableNumber(username, "pr_yesterday5").intValue()) - (UseDB.selectFromTableNumber(username, "pr_now5").intValue());
                revenues_today5 = aDifference * (UseDB.selectFromTableNumber(username, "price5").doubleValue());
            } else {
                revenues_today5 = 0;
            }
            double total_revenues5 = revenues_today5 + revenues_yesterday5;
            double total_Revenues = total_revenues1 + total_revenues2 + total_revenues3 + total_revenues4 + total_revenues5;
            System.out.println("Έσοδα για προϊόν 1: " + total_revenues1);
            System.out.println("Έσοδα για προϊόν 2: " + total_revenues2);
            System.out.println("Έσοδα για προϊόν 3: " + total_revenues3);
            System.out.println("Έσοδα για προϊόν 4: " + total_revenues4);
            System.out.println("Έσοδα για προϊόν 5: " + total_revenues5);
            System.out.println("Συνολικά έσοδα προϊόντων: " + total_Revenues);
            
            
        }

    }

    public static void newuser(String username, String password) {
        UseDB.syndeshxrhsthprotifora(username);
        UseDB.createTableDB(username, password);
    } 
        
}
