package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class MDSQLiteDataHelper {
    private static String mdDBPathConnection = "jdbc:sqlite:DataBase//EcuaFauna.sqlite";
    private static Connection mdConn = null;

    protected static synchronized Connection mdOpenConnection() throws Exception {
        try {
            if (mdConn==null) {
                mdConn = DriverManager.getConnection(mdDBPathConnection);
            }
        } catch (Exception e) {
            throw e;
        }
        return mdConn;
    }

    protected static void mdCloseConnection() throws Exception{
        try {
            if (mdConn != null) {
                mdConn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
