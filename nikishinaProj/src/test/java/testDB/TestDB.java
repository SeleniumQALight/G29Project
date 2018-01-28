package testDB;

import com.sun.javafx.collections.MappingChange;
import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class TestDB {
    static Logger logger = Logger.getLogger("testDB");
    static Database dbMySQL;

    @Before
    public void setUp () throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_DB","MySQL");
    }

    @After
    public void tearDown () throws SQLException {
        dbMySQL.quit();
    }
    @Test
    public void testDB () throws SQLException {
        List<Map<String,String>> testData = dbMySQL.selectTable("select * from seleniumTable where login='test'");  //sozdali peremennuju, v kotoruiu poluchim dannye po rezultatam selecta
        logger.info(testData);
//       for (List<Map<String,String>> ourMap: testData) {
//           logger.info (ourMap);
//        }
        dbMySQL.changeTable("INSERT into seleniumTable VALUES (74, 'Lidiia','pass')");
        testData = dbMySQL.selectTable("select * from seleniumTable where login='Lidiia'");
        logger.info(testData);
    }

}
