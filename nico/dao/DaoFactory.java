package nico.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import nico.dao.interf.DaoInterface;
import nico.dao.impl.*;

/**
 * This class manage connection to database instance
 * It retrieve content of 'dao.properties' to get credentials, host infos and driver infos
 * On success, It will return an instance of the connection (DaoFactory type)
 */
public class DaoFactory {
    private static final String FILE_PROPERTIES = "/nico/dao/dao.txt";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USER = "user";
    private static final String PROPERTY_PASSWORD = "pwd";

    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieve credentials and connect to database
     * @return an instance of DaoFactory
     * @throws DaoConfigurationException
     */
    public static DaoFactory getInstance() throws DaoConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String user;
        String pwd;

        // Avoid FileNotFoundException handles
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fileProperties = classLoader.getResourceAsStream(FILE_PROPERTIES);

        if(fileProperties == null) {
            throw new DaoConfigurationException("file properties " + FILE_PROPERTIES + " not found.");
        }

        try {
            properties.load(fileProperties);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            user = properties.getProperty(PROPERTY_USER);
            pwd = properties.getProperty(PROPERTY_PASSWORD);
        } catch(IOException e) {
            throw new DaoConfigurationException("Unable to load properties file " + FILE_PROPERTIES, e);
        }

        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            throw new DaoConfigurationException("Driver not found in classpath", e);
        }

        DaoFactory instance = new DaoFactory(url, user, pwd);
        return instance;
    }

    /**
     * 
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public DaoInterface getLivreDao() {
        return new LivreDaoImplementation(this);
    }
}
