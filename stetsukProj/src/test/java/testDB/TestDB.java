package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDB {
    private static Logger logger = Logger.getLogger("TestDB");
    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_DB", "MySQL");
    }

    @Test
    public void testDB() throws SQLException {
        List<Map<String, String>> testData = dbMySQL.selectTable("SELECT * FROM seleniumTable WHERE login ='test'");
//        logger.info(testData);
//        for (Map<String,String> ourMap:testData){
//            logger.info(ourMap);
//        }
//        dbMySQL.changeTable("INSERT INTO seleniumTable VALUES (99,'serhii','123456')");
        testData = dbMySQL.selectTable("SELECT * FROM seleniumTable WHERE login ='serhii'");

        logger.info(testData);
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

}
