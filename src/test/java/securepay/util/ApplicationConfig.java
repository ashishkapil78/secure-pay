package securepay.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class ApplicationConfig {

    private static final File CONFIG_FILE = FileUtils.getFile("./application.conf");

    public static String getUrl() {
        return ConfigFactory.parseFile(CONFIG_FILE).getConfig("app").getString("url");
    }

    public static String getBrowserConfig(String key) {
        try {
            Config config = ConfigFactory.parseFile(CONFIG_FILE).getConfig("app.browserConfig");
            return config.getString(key);
        }
        catch (Exception e) {
            throw new UnsupportedOperationException("Unable to get config value for " + key);
        }
    }
}
