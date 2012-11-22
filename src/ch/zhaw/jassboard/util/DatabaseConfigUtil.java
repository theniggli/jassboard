package ch.zhaw.jassboard.util;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/13/12
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    public static void main(String[] args) throws Exception {
        writeConfigFile("ormlite_config.txt");
    }
}
