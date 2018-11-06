package getjobinc.mp_35a.getjob;

//import javafx.util.Pair;
import java.io.File;

public final class ConfiAPI {
    private static ConfigMaster config;

    // .ini file data
    private final static String configAdress = "src/main/resources/config/config.ini";

    private final static String userSettingsSection = "UserSettings";
    private final static String loginKey = "lastLogin";
    private final static String passKey = "lastPass";
    private final static String debugKey = "debugMode";
    private final static String selfTestKey = "selfTestMode";

    private final static String windowSettingsSection = "WindowSettings";
    private final static String heightKey = "height";
    private final static String widthKey = "width";
}
