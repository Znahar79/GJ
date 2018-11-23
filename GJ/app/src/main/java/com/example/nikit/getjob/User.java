package com.example.nikit.getjob;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

public class User {

    // Type of user
    public enum UserType {
        Unauthorized,
        Developer,
        SimpleUser,
        SelfTest,
        Moderator
    }
    private static UserType currentSession;
    private ArrayList <Vacancy> userVacancys = new ArrayList<>();
    private String password;
    private String name;
    private String surname;
    private String email;
    private String summary;
    private String phone;
    private String tag;
    private float rating;

    public User() {
        this.name = " ";
        this.surname = " ";
        this.password = " ";
        this.email = " ";
        this.summary = " ";
        this.phone = " ";
        this.tag = " ";
        this.currentSession = UserType.Unauthorized;
        this.rating = 0;
    }
    public User(String name,String surname,
                String password, String email,
                String phone, String tag , UserType status,
                float rating){
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.summary = " ";
        this.phone = phone;
        this.tag = tag;
        this.currentSession = status;
        this.rating = rating;
    }



    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getSummary() {
        return summary;
    }

    public String getPhone() {
        return phone;
    }

    public String getTag() {
        return tag;
    }

    public float getRating() {
        return rating;
    }

    public static void setCurrentSession(UserType currentSession) {
        User.currentSession = currentSession;
    }

    public ArrayList<Vacancy> getUserVacancys() {
        return userVacancys;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    /*private static class UserDB {
        // Constants for work with tablet in DB
        final private static class UserTable {
            final public static String NAME = "users";

            static public class COLS {
                static public final String LOGIN = "login";
                static public final String PASSWORD = "pass";
                static public final String STATUS = "status";
                static public final String USERNAME = "name";
                static public final String SURNAME = "surname";
                static public final String EMAIL =  "email";
                static public final float RATING = 5;
            }
        }

        // Constants for work with file in DB
        private static String DB_PATH = "src/main/resources/cache/userDB/userList.db";
        // Class-abstraction над БД
        private static SQLBase userDB;

        static {
            // Create or open exsisting DB by  path (DP_PATH)
            userDB = new SQLBase(DB_PATH);

            // Initialize DB like tablet, if this did not done earlier
            try {
                Statement dbInitialization = userDB.createStatement();

                //logger.log(Level.INFO, "Attemption to initialize UserDB tables");

                dbInitialization.execute("CREATE TABLE IF NOT EXISTS " + UserTable.NAME + "(" +
                        // Логин уникален (UNIQUE)
                        UserTable.COLS.LOGIN + " UNIQUE, " +
                        UserTable.COLS.PASSWORD + ", " +
                        UserTable.COLS.STATUS + ");");

                dbInitialization.close();
            } catch (SQLException e) {
                //logger.log(Level.SEVERE, "DB initialize error!", e);
                e.printStackTrace();
            }
        }

        // Method for user registration
        public static boolean regUser(String login, String password, UserType status) {
            // Securing from moron
            if (status.equals(UserType.Unauthorized)) {
                return false;
            }

            if (login == null || password == null || login.equals("") || password.equals("")) {
                return false;
            }

            if ((status != UserType.Developer && status != UserType.SelfTest) || currentSession == UserType.Developer) {
                // Creating request with user data  in tablet
                //**
                 //* When trying to add an existing user \ error in the work of the database itself
                // * SQLException is thrown and the function returns false.
                // * If the registration is successful, the function returns true.


                try {
                    Statement userAdding = userDB.createStatement();

                    //logger.log(Level.INFO,"Attempt to create new UserDB record");

                    userAdding.execute("INSERT INTO " + UserTable.NAME + "(" +
                            UserTable.COLS.LOGIN + ", " +
                            UserTable.COLS.PASSWORD + ", " +
                            UserTable.COLS.STATUS + ") " +
                            "VALUES (" +
                            "'" + login + "', " +
                            "'" + password + "', " +
                            "'" + status + "');");

                    userAdding.close();

                    return true;
                } catch (SQLException e) {
                    //logger.log(Level.SEVERE, "User registration error!");
                    e.printStackTrace();

                    return false;
                }
            } else {
                //logger.log(Level.SEVERE, "User hasn't permission to create account with this status!");

                return false;
            }
        }

        public static UserType loginUser(String login, String password) {
            // Защита от шалуна-дебила
            if (login == null || password == null || login.equals("") || password.equals("")) {
                return UserType.Unauthorized;
            }

            // Search record with user data in tablet
            /**
             * When trying to get information of a nonexistent user \ error in the work of the database \ error
             * reading the result (userInfo) is thrown SQLException and the function returns Unathorized.
             * In case of successful finding of information, the function returns the status of the found user.
             */

    /*
    try (Statement userRecieving = userDB.createStatement()) {
        //logger.log(Level.INFO,"Attempt to read UserDB record");

        ResultSet userInfo = userRecieving.executeQuery("SELECT " +
                UserTable.COLS.PASSWORD + ", " +
                UserTable.COLS.STATUS + " " +
                "FROM " + UserTable.NAME + " " +
                "WHERE " + UserTable.COLS.LOGIN + " = '" + login + "';");

        if (userInfo.next()) {
            String realPass = userInfo.getString(
                    userInfo.findColumn(
                            UserTable.COLS.PASSWORD));
            if (realPass.equals(password)) {
                UserType status = UserType.valueOf(
                        userInfo.getString(
                                userInfo.findColumn(
                                        UserTable.COLS.STATUS)));

                return status;
            } else {
               // logger.log(Level.INFO, "Incorrect login data. Can't process it");

                return UserType.Unauthorized;
            }
        } else {
            //logger.log(Level.INFO, "User not found");

            return UserType.Unauthorized;
        }
    } catch (SQLException e) {
        //logger.log(Level.SEVERE, "Wrong SQL request", e);
        e.printStackTrace();

        return UserType.Unauthorized;
    }
    return UserType.SimpleUser;
}
}*/
    static {
        currentSession = UserType.Unauthorized;
    }
    public static boolean logIn(String login, String password) {
        //currentSession =  UserDB.loginUser(login, password);

        if (currentSession != UserType.Unauthorized) {
            //ConfigAPI.setLoginData(login, password);

            //logger.log(Level.INFO, "User succefully logged in");

            return true;
        } else {
            return false;
        }
    }
    /*
    public static boolean sessionByLastLogin() {
       // logger.log(Level.INFO, "Logging by saved data...");

        // Reading saved login and password
        String login = ConfigAPI.getLogin();
        String password = ConfigAPI.getPassword();

        // Trying to get access using them
        if (login != null && password != null) {
            return logIn(login, password);
        } else {
            return false;
        }
    }*/
    /*
    public static boolean createNewUser(String login, String password, String email,
                                        String name, String surname, String phone,
                                        String summary, String tag, UserType status) {
        //logger.log(Level.INFO, "Creating a new user...");
        // Проверка успешности регистрации
            if (UserDB.regUser(login, password, status, email, name,
                    surname, phone, summary, tag)) {
                currentSession = status;

                return currentSession != UserType.Unauthorized;
            } else {
                return false;
            }
    }
    public static UserType getStatus() {
        return currentSession;
    }*/
}