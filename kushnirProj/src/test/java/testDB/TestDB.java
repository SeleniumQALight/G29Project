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
    //создать объект статик
    static Logger logger = Logger.getLogger("TestDB"); //имя переменной с логера
    //чтобы был объект логгер, которому можно давать данные, а он будет выводить в консоль
    static Database dbMySql; // будет хранится коннекшн к БД

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_DB", "MySQL");
    }

    @After
    public void tearDown() throws SQLException, IOException, ClassNotFoundException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<Map<String, String>> testData =
                dbMySql.selectTable("select * from seleniumTable " + "where login='test'");
        logger.info(testData);

        dbMySql.changeTable("INSERT " + "INTO seleniumTable VALUES (74, 'Maksim', 'password')");
        testData=dbMySql.selectTable("select * from seleniumTable " + "where login='Maksim'");

        logger.info(testData);
        logger.info(testData);
    }
}
