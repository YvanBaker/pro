package com.yvan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Jdbc工具类
 *
 * @author Yvans
 */
public class JdbcUtil {
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        InputStream is = JdbcUtil.class.getResourceAsStream("../../../application.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection对象
     *
     * @return Connection
     */
    public static Connection getConn() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
