package testDB;

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

    static Logger logger = Logger.getLogger("TestDB");

    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_DB", "MySQL") ;
    }

    @Test
    public void testDB() throws SQLException {

        List<Map<String, String>> testData =

          dbMySQL.selectTable("SELECT * FROM seleniumTable where login = 'test'");

        System.out.println(testData);

        //logger.info(testData);
//        for (List<Map<String, String>> ourMap:
//             testData) {
//            logger.info(ourMap);
//        }

        dbMySQL.changeTable("INSERT INTO seleniumTable VALUES (77, 'Grey', 'testPass')");

        testData =  dbMySQL.selectTable("SELECT * FROM seleniumTable where login = 'Student'");
        System.out.println(testData);


    }

    @After
    public void shutDown() throws SQLException {
        dbMySQL.quit();
    }
}
