package getjobinc.mp_35a.getjob;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
//Check Git
public class User {
    private static UserType currentSession;
    private String password;
    private String login;
    private String name;
    private String surname;
    public User(String name,String surname,String login,String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
    // Type of user
    public enum UserType {
        Unauthorized,
        SimpleUser,
        Developer,
        SelfTest
    }
    private static class UserDB {
        // Constants for work with tablet in DB
        final private static class UserTable {
            final public static String NAME = "users";

            static public class COLS {
                static public final String LOGIN = "login";
                static public final String PASSWORD = "pass";
                static public final String STATUS = "status";
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
                /**
                 * When trying to add an existing user \ error in the work of the database itself
                 * SQLException is thrown and the function returns false.
                 * If the registration is successful, the function returns true.
                 **/
                // TODO Обработка исключения для индивидуальной обработки сценариев, описанных выше
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
            // TODO Обработка исключения для индивидуальной обработки сценариев, описанных выше
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
            }*/
            return UserType.SimpleUser;
        }
    }
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

        // Trying to get acces using them
        if (login != null && password != null) {
            return logIn(login, password);
        } else {
            return false;
        }
    }*/
    public static boolean createNewUser(String login, String password, UserType status) {
        //logger.log(Level.INFO, "Creating a new user...");
        // Проверка успешности регистрации
            if (UserDB.regUser(login, password, status)) {
                currentSession = status;

                return currentSession != UserType.Unauthorized;
            } else {
                return false;
            }
    }
    public static UserType getStatus() {
        return currentSession;
    }
}