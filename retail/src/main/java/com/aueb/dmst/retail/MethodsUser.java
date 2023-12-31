package com.aueb.dmst.retail;
import java.util.InputMismatchException;
import java.util.Scanner;
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
    public static void epilogesMenu() {
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
        epilogesDiadikasia(answer);   
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
    




    public static void epilogesDiadikasia(int answer) {
        // kalei tis katalhlles methodous gia thn leitourgia pou epeleje o xrhsths
        if (answer==1) {
            //kaleite tis methodous gia to chatgpt
        } else {

        }
    }
    //UseDB.selectFromTableNumber("Agg","product_name1");






    public static void newuser(String username, String password) {
        UseDB.syndeshxrhsthprotifora(username);
        UseDB.createTableDB(username, password);
    } 
        
}
