package org.menaphos.io.db;

public final class QueryParameter {

    public static final String NOT_NULL = "NOT NULL";
    public static final String PRIMARY_KEY = "PRIMARY KEY";

    private final String name;
    private final SqlDataType type;
    private String arg ="";

    public QueryParameter(String name, SqlDataType type) {
        this.name = name;
        this.type = type;
    }

    public QueryParameter(String name, SqlDataType type, String arg) {
        this.name = name;
        this.type = type;
        this.arg = arg;
    }

    public String getArg() {
        return arg;
    }

    public String getName() {
        return name;
    }

    public SqlDataType getType() {
        return type;
    }
}
