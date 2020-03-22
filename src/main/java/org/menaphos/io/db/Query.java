package org.menaphos.io.db;

public final class Query {

    private final String sql;

    private Query(QueryBuilder queryBuilder) {
        this.sql = queryBuilder.queryBuilder.toString();
    }

    public String getSql() {
        return sql;
    }

    public static class QueryBuilder {

        private final StringBuilder queryBuilder;

        public QueryBuilder() {
            this.queryBuilder = new StringBuilder();
        }

        public QueryBuilder addQuery(String text) {
            queryBuilder.append(text).append(" ");
            return this;
        }

        public QueryBuilder addParameter(QueryParameter parameter) {
            queryBuilder.append("\n")
                    .append(parameter.getName())
                    .append(" ")
                    .append(parameter.getType())
                    .append(" ")
                    .append(parameter.getArg())
                    . append("");
            return this;
        }

        public Query build() {
            return new Query(this);
        }

    }
}
