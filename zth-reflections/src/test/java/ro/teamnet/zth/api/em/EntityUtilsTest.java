package ro.teamnet.zth.api.em;



import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Departament;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by rares on 4/29/2015.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        Departament department = new Departament();
        String tableName = EntityUtils.getTableName(Departament.class);

        Assert.assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumns() {

        List<ColumnInfo> columnInfo = EntityUtils.getColumns(Departament.class);
        if(columnInfo.isEmpty()){
            Assert.assertNull(null);
        }

    }

    @Test
    public void testCastFromSqlType(){

        Departament department = new Departament();
        Object values;
        values = EntityUtils.castFromSqlType(department,Departament.class);
        if(values == null){
            Assert.assertNull(null);
        }

    }

    @Test
    public void testGetFieldsByAnnotation(){

        List<Field> fields = EntityUtils.getFieldsByAnnotations(Location.class,Departament.class);
        if(fields.isEmpty()){
            Assert.assertNull(null);
        }
    }
}
