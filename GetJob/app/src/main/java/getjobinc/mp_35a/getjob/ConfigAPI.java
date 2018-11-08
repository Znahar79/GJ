package getjobinc.mp_35a.getjob;

//import javafx.util.Pair;
import java.io.File;

public final class ConfigAPI {
    private static ConfigMaster config;

    // .ini file data
    private final static String configAdress = "src/main/res/config/config.ini";

    private final static String userSettingsSection = "UserSettings";
    private final static String loginKey = "lastLogin";
    private final static String passKey = "lastPass";
    private final static String emailKey = "lastEmail";
    private final static String nameKey = "lastName";
    private final static String surnameKey = "lastSurname";
    private final static String phoneKey = "lastPhone";
    private final static String summaryKey = "lastSummary";
    private final static String tagKey = "lastTag";
    private final static String debugKey = "debugMode";
    private final static String selfTestKey = "selfTestMode";

    /*
    private final static String windowSettingsSection = "WindowSettings";
    private final static String heightKey = "height";
    private final static String widthKey = "width";*/

    // Initialize fields with empty values.
    static {
        config = new ConfigMaster(configAdress);
    }

    /*public static void createConfigFile() {
        File configFile = new File(configAdress);
        if (!configFile.exists()) {
            config.create();

            // Writing 'userSettings' sector
            config.write(userSettingsSection, loginKey, "");
            config.write(userSettingsSection, passKey, "");
            config.write(userSettingsSection, emailKey, "");
            config.write(userSettingsSection, nameKey, "");
            config.write(userSettingsSection, surnameKey, "");
            config.write(userSettingsSection, phoneKey, "");
            config.write(userSettingsSection, summaryKey, "");
            config.write(userSettingsSection, tagKey, "");
            config.write(userSettingsSection, debugKey, "false");
            config.write(userSettingsSection, selfTestKey, "false");

            // Writing 'windowsSettings' sector
            //config.write(windowSettingsSection, heightKey, 600);
            //config.write(windowSettingsSection, widthKey, 800);
        }
    }*/
    /// User settings sector

    // debug field control
    /*
    public static void setDebug(boolean option) {
        config.write(userSettingsSection, debugKey, option);
    }
    public static boolean getDebug() {
        return Boolean.parseBoolean(config.read(userSettingsSection, debugKey));
    }
    // selfTest field control
    public static void setSelfTest(boolean option) {
        config.write(userSettingsSection, selfTestKey, option);
    }

    public static boolean getSelfTest() {
        return Boolean.parseBoolean(config.read(userSettingsSection, selfTestKey));
    }
    // User data fields control
    public static String getLogin() {
        return config.read(userSettingsSection, loginKey);
    }

    public static String getPassword() {
        return config.read(userSettingsSection, passKey);
    }

    public static String getEmail() {
        return config.read(userSettingsSection, emailKey);
    }

    public static String getName() {
        return config.read(userSettingsSection, nameKey);
    }

    public static String getSurname() {
        return config.read(userSettingsSection, surnameKey);
    }

    public static String getPhone() {
        return config.read(userSettingsSection, phoneKey);
    }

    public static String getSummary() {
        return config.read(userSettingsSection, summaryKey);
    }

    public static String getTag() {
        return config.read(userSettingsSection, tagKey);
    }

    public static void setLoginData(String login, String password, String email,
                                    String name, String surname, String phone,
                                    String summary, String tag) {
        config.write(userSettingsSection, loginKey, login);
        config.write(userSettingsSection, passKey, password);
        config.write(userSettingsSection, emailKey, email);
        config.write(userSettingsSection, nameKey, name);
        config.write(userSettingsSection, surnameKey, surname);
        config.write(userSettingsSection, phoneKey, phone);
        config.write(userSettingsSection, summaryKey, summary);
        config.write(userSettingsSection, tagKey, tag);
    }

    public static void unlogin() {
        config.write(userSettingsSection, loginKey, "");
        config.write(userSettingsSection, passKey, "");
    }*/
}
