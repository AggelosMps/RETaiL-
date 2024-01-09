package com.aueb.dmst.retail;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import org.sqlite.SQLiteException;

//Θα πρέπει να εισάγω την κλάση InsertIntoDB

public class UseDB {
    public static Connection connection = null;

    public static boolean usernameExist(String usernameToCheck) {
        boolean y = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username FROM Manager");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                if (username.equals(usernameToCheck)) {
                    y = true;
                    break;
                } else {
                    y = false;
                }
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            

        } catch (SQLiteException e) {
            //e.printStackTrace();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { 
                connection.close();
            } catch (SQLException e) {

            }
        }
        return y;

    }

    public static boolean authenticateUser(String usernameToCheck, String passwordToCheck) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            boolean truename = false;
            boolean truepassword = false;
            ResultSet resultSet = statement.executeQuery("SELECT username FROM Manager ");
            String username = null;
            while (resultSet.next()) {
               username = resultSet.getString("username");
               if (username.equals(usernameToCheck)) {
                  truename = true;
                  break;
                }
            }
            if (truename = true) {
                PreparedStatement pS = connection.prepareStatement("SELECT password FROM Manager WHERE username = ? ");
                pS.setString(1, username);
                ResultSet resultSet2 = pS.executeQuery();
                String password = resultSet2.getString("password");
                /*while (resultSet2.next()) {
                    String password = resultSet.getString("password");
                    if (password.equals(passwordToCheck)) {
                        truepassword = true;
                        resultSet2.close();
                    }
                }*/
                if (password.equals(passwordToCheck)) {
                    truepassword = true;
                    resultSet2.close();
                }
                
                resultSet2.close();
                pS.close();
                
            }

            resultSet.close();
            statement.close();
            connection.close();

            if (truename && truepassword) {
                return true;
            } else {
                return false;
            }

        } catch(SQLiteException e) {
            
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { 
                connection.close();
            } catch (SQLException e) {
                
            }
        }
        return false;

    }

    public static void syndeshxrhsthprotifora(String username) {
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(username  + "timeslogin.txt"));
        writer.write("0");
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void elegxossyndesis(String username) {
        try {
            File file = new File(username + "timeslogin.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
    
            // Read the existing content
            String line = reader.readLine();
            reader.close();
    
            // Update the content
            if (line != null && line.equals("0")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("1");
                writer.close();
                System.out.println("File content updated successfully.");
            } else {
                System.out.println("File content was not updated. Current content may not be '0'.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkfores(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username + "timeslogin.txt"));
            String firstline = reader.readLine();
            int intValue = Integer.parseInt(firstline);
            reader.close();
            return intValue;
        } catch(IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void createTableDB(String username, String password) {
        try {
            // Connect to the SQLite database (creates the database if it doesn't exist)
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Manager (username VARCHAR(40) PRIMARY KEY, password VARCHAR(40), employee1 VARCHAR(255), employee2 VARCHAR(255), employee3 VARCHAR(255), employee4 VARCHAR(255), employee5 VARCHAR(255), product_name1 VARCHAR(40), pr_now1 INT, pr_yesterday1 INT, pr_db_yesterday1 INT, price1 DOUBLE, pr_cost1 DOUBLE, product_name2 VARCHAR(40), pr_now2 INT, pr_yesterday2 INT, pr_db_yesterday2 INT, price2 DOUBLE, pr_cost2 DOUBLE, product_name3 VARCHAR(40), pr_now3 INT, pr_yesterday3 INT, pr_db_yesterday3 INT, price3 DOUBLE, pr_cost3 DOUBLE, product_name4 VARCHAR(40), pr_now4 INT, pr_yesterday4 INT, pr_db_yesterday4 INT, price4 DOUBLE, pr_cost4 DOUBLE, product_name5 VARCHAR(40), pr_now5 INT, pr_yesterday5 INT, pr_db_yesterday5 INT, price5 DOUBLE, pr_cost5 DOUBLE)");

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Manager (username, password) VALUES (?, ?)");
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            insertStatement.executeUpdate();

            System.out.println("Manager data added successfully!");
            
            insertStatement.close();
            statement.close();
            connection.close();
            // Retrieve and display the saved revenue data
            /*ResultSet resultSet = statement.executeQuery("SELECT * FROM Manager ");
            while (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertIntoDBDouble(String column, double value,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET "+ column +" = ? WHERE username = ?");
            pS.setDouble(1, value);
            pS.setString(2, username);
            int rowsAffected = pS.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No rows were updated.");
            }

            pS.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { 
                connection.close();
            } catch (SQLException e) {
                
            }
        }
    }
    public static void insertIntoDBString(String column, String value,String username) { //Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET "+ column +" = ? WHERE username = ?");
            pS.setString(1, value);
            pS.setString(2, username);
            int rowsAffected = pS.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No rows were updated.");
            }

            pS.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { 
                connection.close();
            } catch (SQLException e) {
                
            }
        }
    }
    public static void insertIntoDBInt(String column, int value, String username) { //Αυτή εδώ θα μπει στην κλάση InsertIntoDB
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET "+ column +" = ? WHERE username = ?");
            pS.setInt(1, value);
            pS.setString(2, username);
            int rowsAffected = pS.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No rows were updated.");
            }

            pS.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { 
                connection.close();
            } catch (SQLException e) {
                
            }
        }
    }
    public static Number selectFromTableNumber(String username, String apantisi) {
    try {
        connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + apantisi + " FROM Manager WHERE username = " + "'" + username + "'");         //Warning may cause error in the Diagrams!!!
        if (resultSet.next()) {
            if (resultSet.getObject(apantisi) instanceof Integer) {
                return resultSet.getInt(apantisi);
            } else if (resultSet.getObject(apantisi) instanceof Double) {
                return resultSet.getDouble(apantisi);
            }
        }

        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
            try { 
                connection.close();
            } catch (SQLException e) {
                
            }
        }
    return 0;
}
public static String selectFromTableString(String username, String apantisi) {
    try {
        connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + apantisi + " FROM Manager WHERE username = " + "'" + username + "'");
        if (resultSet.next()) {
            return resultSet.getString(apantisi);   
        }

        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
            try { 
                connection.close();
            } catch (SQLException e) {
                
            }
        }
    return null;
}
}
