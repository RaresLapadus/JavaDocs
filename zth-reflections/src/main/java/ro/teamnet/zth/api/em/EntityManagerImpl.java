package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Departament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by rares on 4/30/2015.
 */
public class EntityManagerImpl {
   public <T> T findById(Class<T> entityClass, Long id) throws SQLException, ClassNotFoundException {
       DBManager.getConnection();
       EntityUtils.getTableName(entityClass);
       EntityUtils.getColumns(entityClass);
       for (ColumnInfo columnInfo : EntityUtils.getColumns(entityClass)) {
           ColumnInfo.SetValue(columnInfo.getValue());
       }
   }


}
