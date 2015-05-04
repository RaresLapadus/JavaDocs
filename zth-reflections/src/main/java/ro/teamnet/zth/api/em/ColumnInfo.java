package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;

/**
 * Created by rares on 4/28/2015.
 */
public class ColumnInfo {

    private String columnName;
    private Class columnType;
    private String dbName;
    private boolean isID;
    private Object value;

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public boolean isID() {
        return isID;
    }

    public void setIsID(boolean isID) {
        this.isID = isID;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
