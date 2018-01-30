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
    static Logger logger
            = Logger.getLogger("TestDB");
    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_DB","MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<Map<String,String>> testData =
        dbMySQL.selectTable("select * from seleniumTable " + "where login='test'");
    logger.info(testData);
    dbMySQL.changeTable("INSERT " + "INTO seleniumTable VALUES (74,'Sanya','pass')");
    testData=
    dbMySQL.selectTable("select * from seleniumTable " + "where login='Sanya'");
        logger.info(testData);
//    for (List<Map<String,String>> ourMap:testData) {
//        logger.info(ourMap);
    }


}

