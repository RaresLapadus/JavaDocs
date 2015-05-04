package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rares on 4/28/2015.
 */
public class EntityUtils {

    private EntityUtils() {
        throw new UnsupportedOperationException();
    }


    public static String getTableName(Class entity){
        Table annotation = (Table)entity.getAnnotation(Table.class);
        return annotation.name();
    }

    public static List<ColumnInfo> getColumns(Class entity){
        List<ColumnInfo> columnInfos = new ArrayList<>();
       for(Field f: entity.getDeclaredFields()){
           Column b = f.getAnnotation(Column.class);
           if(b != null){
               ColumnInfo v = new ColumnInfo();
               v.setColumnName(f.getName());
               v.setColumnType(f.getType());
               v.setDbName(b.name());
               v.setIsID(false);
               columnInfos.add(v);
           }
           Id c = f.getAnnotation(Id.class);
           if(c != null){
               ColumnInfo x = new ColumnInfo();
               x.setColumnName(f.getName());
               x.setColumnType(f.getType());
               x.setDbName(c.name());
               x.setIsID(true);
               columnInfos.add(x);

           }
       }
        return columnInfos;
    }
    public static Object castFromSqlType(Object value, Class wantedType){
        if(value instanceof BigDecimal && wantedType == Integer.class){
            return(((BigDecimal) value ).intValue());
        }
        return(value);

    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        List<Field> fields = new ArrayList<>();
        for(Field f: clazz.getDeclaredFields()){
            Annotation annotation1 = f.getAnnotation(annotation);
            if(annotation1 != null){
                fields.add(f);
            }
        }
        return fields;

    }


}
