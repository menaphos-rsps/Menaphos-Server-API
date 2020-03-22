package org.menaphos.io.db;

import org.menaphos.Menaphos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public final class DatabaseAcessManager {

    private static DatabaseAcessManager instance = null;

    public static DatabaseAcessManager getInstance() {
        if (instance == null)
            instance = new DatabaseAcessManager();
        return instance;
    }

    public Connection connect(String db) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + Menaphos.getInstance().getFileSystem().getBaseDirectory() + "/system/db/" + db;
            conn = DriverManager.getConnection(url);
            log.info("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            log.warning(e.getMessage());
        }
        return null;
    }

    public void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + Menaphos.getInstance().getFileSystem().getBaseDirectory() + "/system/db/" + fileName;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                log.info("The driver name is " + meta.getDriverName());
                log.info("A new database has been created.");
            }
        } catch (SQLException e) {
            log.warning(e.getMessage());
        }
    }

    private DatabaseAcessManager() {
        this.log = Logger.getLogger(this.getClass().getSimpleName());
    }

    private final Logger log;
}
