package org.menaphos.io.db.impl;

import org.menaphos.io.db.DataAcessObjectBase;
import org.menaphos.io.db.DatabaseAcessManager;
import org.menaphos.io.db.Query;
import org.menaphos.io.db.QueryParameter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class DatabaseServiceProvider {

    private final String url;
    private final Logger log = Logger.getLogger(DatabaseServiceProvider.class.getSimpleName());

    public DatabaseServiceProvider(String url) {
        this.url=url;
    }

    public void executeStatement(String sql) {
        try (Connection conn = DatabaseAcessManager.getInstance().connect(url);
             Statement stmt = Objects.requireNonNull(conn).createStatement()) {
            log.info("RUNNING: " + sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String table,String params,QueryParameter...parameters) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";
        final Query.QueryBuilder qb = new Query.QueryBuilder().addQuery("INSERT INTO")
                .addQuery(table)
                .addQuery("(")
                .addQuery(params)
                .addQuery(")")
                .addQuery("VALUES");

        Arrays.stream(parameters).forEach(qb::addParameter);

        qb.addQuery(")");
        this.executeStatement(qb.build().getSql());

    }

    public void createTable(String name, QueryParameter...parameters) {
        final Query.QueryBuilder qb = new Query.QueryBuilder().addQuery("CREATE TABLE IF NOT EXISTS")
                .addQuery(name)
                .addQuery("(");

        Arrays.stream(parameters).forEach(qb::addParameter);

        qb.addQuery(")");
        this.executeStatement(qb.build().getSql());
    }

    public String getUrl() {
        return url;
    }
}
