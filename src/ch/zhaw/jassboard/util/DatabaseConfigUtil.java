package ch.zhaw.jassboard.util;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * Utilityclass
 * This class is needed to receate the ormlite_config.txt which is used to access the database
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    public static void main(String[] args) throws Exception {
        writeConfigFile("ormlite_config.txt");
    }
}
