

package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {

    Properties prop;

    public LocatorReader(String filePath) {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocator(String key) {
        return prop.getProperty(key);
    }
}