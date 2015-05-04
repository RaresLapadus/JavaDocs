package ro.teamnet.zth.api.em;

import java.sql.*;
import java.util.List;

/**
 * Created by rares on 4/30/2015.
 */
public class QueryBuilder {
    Object tableName;
    List<ColumnInfo> queryColumns;
    QueryType queryType;
    List<Condition> conditions;

    public QueryBuilder addCondition(Condition condition){

        conditions.add(condition);

    }
    public QueryBuilder setTableName(Object tableName){

        this.tableName = tableName;

    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns){

        queryColumns.addAll(queryColumns);

    }

    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType = queryType;
    }

    private StringBuilder createSelectQuery(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT");
        boolean isfirst = true;
        for (ColumnInfo queryColumn : queryColumns) {
            if (isfirst == true) {
                stringBuilder.append(" ").append(queryColumn);
                isfirst = false;
            }
            else{
                stringBuilder.append(" ,").append(queryColumn);
            }
        }
        stringBuilder.append("FROM ").append(tableName);
        stringBuilder.append("WHERE");
        for (Condition condition : conditions) {
            stringBuilder.append(condition.getColumnName()).append("=").append(condition.getValue()).append(" AND");
        }
        stringBuilder.append(";");
        return stringBuilder;

    }

    private StringBuilder createDeleteQuery(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM").append(tableName).append("WHERE");
        for (Condition condition : conditions) {
            stringBuilder.append(condition.getColumnName()).append("=").append(condition.getValue()).append(" AND");
        }
            stringBuilder.append(";");
        return stringBuilder;

        }

    private StringBuilder createUpdateQuery(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ").append(tableName).append("SET");

        boolean column = true;
        for (ColumnInfo queryColumn : queryColumns) {
            if (column == true){
                stringBuilder.append(" ").append(queryColumn.getColumnName()).append("=").append(queryColumn.getValue());
            }
            else{
                stringBuilder.append(", ").append(queryColumn.getColumnName()).append("=").append(queryColumn.getValue());
            }
        }
        stringBuilder.append("WHERE");
        for (Condition condition : conditions) {
            stringBuilder.append(condition.getColumnName()).append("=").append(condition.getValue()).append(" AND");
        }
        stringBuilder.append(";");
        return stringBuilder;
    }

    private StringBuilder createInsertQuery(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT ").append("INTO ").append(tableName).append("(");

        boolean column = true;
        for (ColumnInfo queryColumn : queryColumns) {
            if (column == true){
                stringBuilder.append(" ").append(queryColumn.getColumnName());
            }
            else{
                stringBuilder.append(", ").append(queryColumn.getColumnName());
            }
        }
        stringBuilder.append(")").append("VALUES (");
        boolean column1 = true;
        for (ColumnInfo queryColumn : queryColumns) {
            if (column1 == true){
                stringBuilder.append(" ").append("=").append(queryColumn.getValue());
            }
            else{
                stringBuilder.append(", ").append("=").append(queryColumn.getValue());
            }
        }
        stringBuilder.append(");");
        return stringBuilder;

    }

    private String createQuery(){
        if(queryType==QueryType.SELECT){
            createSelectQuery();
        }
        if(queryType==QueryType.DELETE){
            createUpdateQuery();
        }
        if(queryType==QueryType.UPDATE){
            createUpdateQuery();
        }
        if(queryType==QueryType.INSERT){
            createInsertQuery();
        }
    }
}
