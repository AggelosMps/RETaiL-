package com.aueb.dmst.retail;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//Θα πρέπει να καλέσω την κλάση InsertIntoDB

/**
 * Η κλάση MethodsUser παρέχει μεθόδους για τις λειτουργίες Αποθεμάτων, Τιμολόγησης, Διαχείρισης Προσωπικού, Υπολογισμό Εσόδων και Διαχείριση Δεδομένων.
 * Για την εξυπηρέτηση των παραπάνω λειτουργιών υπάρχει επικοινωνία με τη βάση δεδομένων.
 * Επίσης, παρέχει μεθόδους για την ανάκτηση απαντήσεων από το ChatGPT μέσω του API.
 */

public class MethodsUser {
    public static Scanner scanner = new Scanner(System.in);
    public static int count_employee=1;
    public static int count_name=1;
    public static int count_pr_now=1;
    public static int count_pr_yesterday=1;
    public static int count_pr_db_yesterday=1;
    public static int count_price=1;
    public static int count_pr_cost=1;
    public static double total_Revenues;
    public static double total_revenues1;
    public static double total_revenues2;
    public static double total_revenues3;
    public static double total_revenues4;
    public static double total_revenues5;
    public static String username_local;
    public static int Chartsflag=0;
    public static boolean flag = true;
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
        try {
        int answer = scanner.nextInt();
        scanner.nextLine();
        
        return answer;
        } catch (InputMismatchException e) {
            System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            scanner.nextLine();
            return -1;
        } 
    }
    public static void epilogesMenu(String username) {
        flag = true;
        int answer = 0;
        username_local = username;
        while (flag) {    
            System.out.println("Σε ποιόν τομέα θέλετε να σας εξυπηρετήσουμε;");
            System.out.println("1. Αποθέματα (Σας προτείνει το προϊόν που πρέπει να αγοράσετε για να μεγιστοποιήσετε το κέρδος σας, βάση των πωλήσεων που έχετε κάνει τις προηγούμενες 3 μέρες.)");
            System.out.println("2. Τιμολόγηση (Σας προτείνει την καλύτερη τιμή για να μεγιστοποιήσετε το κέρδος σας, βάση των πωλήσεων που έχετε κάνει τις προηγούμενες 3 μέρες.)");
            System.out.println("3. Πρόγραμμα προσωπικού (Ωρολόγιο πρόγραμμα προσωπικού.)");
            System.out.println("4. Οικονομικές καταστάσεις (Έσοδα για κάθε ένα από τα προϊόντα και συνολικά έσοδα επιχείρησης.)");
            System.out.println("5. Αλλαγή δεδομένων");
            System.out.println("6. Αποσύνδεση");
            System.out.println("7. Έξοδος");
            try {
                answer = scanner.nextInt();
                
                if (answer >= 0 && answer <=7) {
                    
                    epilogesDiadikasia(answer,username);
                } else {
                    System.out.println("Παρακαλούμε επιλέξτε ένα απο τα ακόλουθα.");
                }    
            } catch (InputMismatchException e) {
                System.out.println("Παρακαλούμε επιλέξτε ένα απο τα ακόλουθα.");
                scanner.nextLine();
            }
        } 
    }
    
    public static void insertdataEmployee(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertEmployee_data(username);
        insertEmployee_data(username);
        insertEmployee_data(username);
        insertEmployee_data(username);
        insertEmployee_data(username);
    }

    public static void insertdataProduct1(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
    }

    public static void insertdataProduct2(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);        
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
    }

    public static void insertdataProduct3(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
    }

    public static void insertdataProduct4(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
    }

    public static void insertdataProduct5(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertProduct_Name(username);
        insertProduct_Now(username);
        insertProduct_Yesterday(username);
        insertProduct_Db_Yesterday(username);
        insertPrice(username);
        insertProduct_Cost(username);
    }

    public static void insertdata(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        insertdataEmployee(username);
        insertdataProduct1(username);
        insertdataProduct2(username);
        insertdataProduct3(username);
        insertdataProduct4(username);
        insertdataProduct5(username);
    }

    public static void insertEmployee_data(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;
        while (y) {
            System.out.println("Καταχωρήστε στοιχεία για τον εργαζόμενο "+count_employee+" στην μορφή: Όνομα, Μέρα που μπορεί να εργαστεί, Ώρα έναρξης, Ώρα λήξης βάρδιας, (Επαναλάβετε για όσες μέρες μπορεί)");           
            try {
                String employee = scanner.nextLine();
                
                UseDB.insertIntoDBString("employee"+count_employee++, employee, username);
                if (count_employee>5) {
                    count_employee = 1;
                }
                y = false;
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }
        }
    }
    public static void insertProduct_Name(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;
        while (y) {
            System.out.println("Καταχωρήστε όνομα για προϊόν"+count_name);
            try {
                String product_name = scanner.nextLine();
                UseDB.insertIntoDBString("product_name"+count_name++, product_name, username);
                if (count_name>5) {
                    count_name = 1;
                }
                y = false;
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertProduct_Now(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;

        while (y) {
            System.out.println("Καταχωρήστε σημερινή ποσότητα για προϊόν"+count_pr_now);
            try {
                int pr_now = scanner.nextInt();
                if (pr_now > 0) {
                    y = false;
                    UseDB.insertIntoDBInt("pr_now"+count_pr_now++, pr_now, username);
                    if (count_pr_now>5) {
                        count_pr_now = 1;
                    }
                } else {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                }
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }
        }
    }
    public static void insertProduct_Yesterday(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;       
        while (y) {
            try {
                System.out.println("Καταχωρήστε χθεσινή ποσότητα για προϊόν"+count_pr_yesterday);
                /*if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
                }*/          
                int pr_yesterday = scanner.nextInt();
                if (pr_yesterday > 0) {
                    y = false;
                    UseDB.insertIntoDBInt("pr_yesterday"+count_pr_yesterday++, pr_yesterday, username);
                    if (count_pr_yesterday>5) {
                        count_pr_yesterday = 1;
                    }
                } else {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                }
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }    
        }
    }
    public static void insertProduct_Db_Yesterday(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;       
        while (y) {
            try {
                System.out.println("Καταχωρήστε προχθεσινή ποσότητα για προϊόν"+count_pr_db_yesterday);
                /*if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
                }*/           
                int pr_db_yesterday = scanner.nextInt();
                if (pr_db_yesterday > 0) {
                    y = false;
                    UseDB.insertIntoDBInt("pr_db_yesterday"+count_pr_db_yesterday++, pr_db_yesterday, username);
                    if (count_pr_db_yesterday>5) {
                        count_pr_db_yesterday = 1;
                    }
                } else {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                }
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }
        }
    }
    public static void insertPrice(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;
        while (y) {
            try {
                System.out.println("Ποιά είναι η τιμή για προϊόν"+count_price);
                /*if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
                }*/
                double price = scanner.nextDouble();
                if (price > 0) {
                    y = false;
                    UseDB.insertIntoDBDouble("price"+count_price++, price, username);
                    if (count_price>5) {
                        count_price = 1;
                    }
                } else {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                }
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }
        }
    }
    public static void insertProduct_Cost(String username) {//Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        boolean y = true;
        while (y) {
            try {
                System.out.println("Ποιό είναι το κόστος για προϊόν"+count_pr_cost);
                /*if (scanner.hasNext()) {
                    scanner.nextLine();// clear the input buffer
                }*/
                double pr_cost = scanner.nextDouble();

                scanner.nextLine(); //auto to next line to bazoume epeidh xalage to input sta onomata twn proiontwn 2-5

                if (pr_cost > 0) {
                    y = false;
                    UseDB.insertIntoDBDouble("pr_cost"+count_pr_cost++, pr_cost, username);
                    if (count_pr_cost>5) {
                        count_pr_cost = 1;
                    }
                } else {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                }
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }
        }     
    }

    public static void answersChatGPT(String answer, String username) {
        String filename = username + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));
            writer.write(answer);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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
            answersChatGPT(ApiRequest.getApothema(apothema1), username);
            System.out.println(ApiRequest.getApothema(apothema2));
            answersChatGPT(ApiRequest.getApothema(apothema2), username);
            System.out.println(ApiRequest.getApothema(apothema3));
            answersChatGPT(ApiRequest.getApothema(apothema3), username);
            System.out.println(ApiRequest.getApothema(apothema4));
            answersChatGPT(ApiRequest.getApothema(apothema4), username);
            System.out.println(ApiRequest.getApothema(apothema5));
            answersChatGPT(ApiRequest.getApothema(apothema5), username);

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
            answersChatGPT(ApiRequest.getPrice(price1), username);
            System.out.println(ApiRequest.getPrice(price2));
            answersChatGPT(ApiRequest.getPrice(price2), username);
            System.out.println(ApiRequest.getPrice(price3));
            answersChatGPT(ApiRequest.getPrice(price3), username);
            System.out.println(ApiRequest.getPrice(price4));
            answersChatGPT(ApiRequest.getPrice(price4), username);
            System.out.println(ApiRequest.getPrice(price5));
            answersChatGPT(ApiRequest.getPrice(price5), username);
            
        } else if (answer == 3) {
            String programma = UseDB.selectFromTableString(username, "employee1") + "," + UseDB.selectFromTableString(username, "employee2") +
            "," + UseDB.selectFromTableString(username, "employee3") + "," + UseDB.selectFromTableString(username, "employee4") + "," + 
            UseDB.selectFromTableString(username, "employee5");
            System.out.println(ApiRequest.getSchedule(programma));
            answersChatGPT(programma, username);
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
            // Υπολογισμός εσόδων του πρώτου προϊόντος αυτές τις 3 μέρες
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
            total_revenues1 = revenues_today1 + revenues_yesterday1;
            answersChatGPT(Double.toString(total_revenues1), username);
            // Υπολογισμός εσόδων του δεύτερου προϊόντος αυτές τις 3 μέρες
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
            total_revenues2 = revenues_today2 + revenues_yesterday2;
            answersChatGPT(Double.toString(revenues_today2), username);
            // Υπολογισμός εσόδων του τρίτου προϊόντος αυτές τις 3 μέρες
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
            total_revenues3 = revenues_today3 + revenues_yesterday3;
            answersChatGPT(Double.toString(revenues_today3), username);
            // Υπολογισμός εσόδων του τέταρτου προϊόντος αυτές τις 3 μέρες
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
            total_revenues4 = revenues_today4 + revenues_yesterday4;
            answersChatGPT(Double.toString(revenues_today4), username);
            // Υπολογισμός εσόδων του πέμπτου προϊόντος αυτές τις 3 μέρες
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
            total_revenues5 = revenues_today5 + revenues_yesterday5;
            answersChatGPT(Double.toString(revenues_today5), username);
            total_Revenues = total_revenues1 + total_revenues2 + total_revenues3 + total_revenues4 + total_revenues5;
            answersChatGPT(Double.toString(total_Revenues), username);
            System.out.println("Έσοδα για προϊόν 1: " + total_revenues1);
            System.out.println("Έσοδα για προϊόν 2: " + total_revenues2);
            System.out.println("Έσοδα για προϊόν 3: " + total_revenues3);
            System.out.println("Έσοδα για προϊόν 4: " + total_revenues4);
            System.out.println("Έσοδα για προϊόν 5: " + total_revenues5);
            System.out.println("Συνολικά έσοδα προϊόντων: " + total_Revenues);
            Chartsflag=1; // Με την εκχώρηση της τιμής 1 στο Chartsflag ενεργοποιείται η δυνατότητα για εκτέλεση των Charts
            
        } else if(answer==5) {
            flag= true;
            boolean flag3=false;
            boolean flag4=false;
            while(!flag3) {
                try {   
                    System.out.println("Για να αλλάξετε στοιχεία από το πρόγραμμα προσωπικού πατήστε (1)");
		            System.out.println("Για να αλλάξετε στοιχεία από τα προϊόντα πατήστε (2).");
                    int ans=scanner.nextInt();
                    if (ans==1) {
                        System.out.println("Τα στοιχεία ποιανού εργαζομένου θα θέλατε να αλλάξετε. (1), (2), (3), (4), (5)");
                        int emp=scanner.nextInt();
                        if(emp>=1 && emp<=5) {
                            flag3=true;
                            changeOfEmployeeData(emp);
                        }
                    } else if(ans==2){
                        System.out.println("Ποιό προϊόν θα θέλατε να αλλάξετε (1), (2), (3), (4), (5)");
                        int pr=scanner.nextInt();
                        if (pr>=1 && pr<=5) {
                            flag3=true;
                            while(!flag4) {
                                try {   
                                    System.out.println("Ποιό στοιχείο από το προϊόν"+ pr +" θα θέλατε να αλλάξετε; 1: όνομα προιόντος, 2: σημερινή ποσότητα, 3: χθεσινή ποσότητα, 4: προχθεσινή ποσότητα, 5: τιμή προιόνοτς, 6: κόστος προιόντος");
                                    int col=scanner.nextInt();
                                    if (col>=1 && col<=6) {
                                        flag4=true;
                                        changeOfData(pr,col);
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                                    scanner.nextLine();
                                }    
                            }  
                        }
                    }       
                } catch(InputMismatchException e) {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
                }       
            }
        } else if (answer==6) {
            flag=false;
        } else if (answer==7) {
            boolean flag2 = false;
            Scanner inp = new Scanner(System.in);
            String bob = null;
            while(!flag2) {
                System.out.println("Πριν αποσυνδεθείτε θα θέλατε να δείτε την διαγραμματική αναπαράσταση των αποτελεσμάτων σας; Πατήστε (N) για ΝΑΙ/ (O) για Όχι. (Μόνο λατινικούς χαρακτήρες)");
                bob = inp.nextLine();        
                if (bob.equals("N")) {
                    flag2=true;
                    Charts.main(null);
		    inp.close();
                    System.exit(1);
                } else if (bob.equals("O")) {
		    System.out.println("Έξοδος...");
		    inp.close();
                    System.exit(1);
                } else {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                }   
            }
            System.exit(1);
        }

    }

    public static void newuser(String username, String password) {
        UseDB.syndeshxrhsthprotifora(username);
        UseDB.createTableDB(username, password);
    } 
    public static int getChartflag(){return Chartsflag;}
    private static void changeOfData(int pr, int col) { // Μέθοδος αλλαγής δεδομένων προϊόντων
        boolean flag5= false;
        while(!flag5) {
            System.out.println("Εισάγετε δεδομένο");
            /*if(scanner.hasNext()) {
                scanner.nextLine();
            }*/
            if (col==1) {
                try {
                    if(scanner.hasNext()) {
                        scanner.nextLine();
                    }
                    String val=scanner.nextLine();
                    flag5= true;
                    UseDB.insertIntoDBString("product_name"+pr, val, username_local);
                } catch (InputMismatchException e) {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
                }                              
            } else if (col==2 ) {
                /*if (scanner.hasNext()) {
                    scanner.nextLine();
                }*/
                try {
                    int val=scanner.nextInt();
                    if (val < 0) {
                        System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    } else {
                        flag5= true;
                        UseDB.insertIntoDBInt("pr_now"+pr, val, username_local);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
                }
            } else if (col==3) {
                try {
                    int val=scanner.nextInt();
                    if (val < 0) {
                        System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    } else {
                    flag5= true;
                    UseDB.insertIntoDBInt("pr_yesterday"+pr, val, username_local);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
                }
            } else if(col==4) {
		        try {
			        int val = scanner.nextInt();
                    if (val < 0) {
                        System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    } else {
			        flag5 = true;
			        UseDB.insertIntoDBInt("pr_db_yesterday" + pr, val, username_local);
                    }
		        } catch (InputMismatchException e) {
			        System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
		        }
            }else if(col==5) {
                try {
                    double val=scanner.nextDouble();
                    if (val < 0) {
                        System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    } else {
                        flag5= true;
                        UseDB.insertIntoDBDouble("price"+pr, val, username_local);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
                }
            } else if(col==6) {
                try {
                    double val=scanner.nextDouble();
                    if (val < 0) {
                        System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    } else {
                    flag5= true;
                    UseDB.insertIntoDBDouble("pr_cost"+pr, val, username_local);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                    scanner.nextLine();
                }
            }
        }
    }
    private static void changeOfEmployeeData(int emp) { // Μέθοδος αλλαγής δεδομένων προσωπικού
        boolean flag6= false;
        while(!flag6) {
            System.out.println("Εισάγετε δεδομένο");
            if(scanner.hasNext()) {
                scanner.nextLine();
            }
            try{
                String val=scanner.nextLine();
                flag6=true;
                UseDB.insertIntoDBString("employee"+emp, val, username_local);
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
                scanner.nextLine();
            }
        }
    }
}       

