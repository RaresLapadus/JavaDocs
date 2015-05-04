package ro.teamnet.zth.api.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by rares on 4/29/2015.
 */
public class DBManagerTest {
    @Test
    public void testGetConnection() throws SQLException, ClassNotFoundException {

        Connection conn =  DBManager.getConnection();
        try {

            Assert.assertNotNull(conn);
        }
        catch (Exception e){
            throw e;
        }

    }
    @Test
    public void testCheckConnection() throws SQLException, ClassNotFoundException {
        boolean conn = DBManager.checkConnection();
        Assert.assertTrue("Mesaj", conn);
    }
}
