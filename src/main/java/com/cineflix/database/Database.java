/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineflix.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class Database {
    private Connection connection;
    private String hostname;
    private int port;
    private String username;
    private String password;
    private String DBName;
    private String URL;
    
    private boolean isConnected;
    
    private String makeURL()
    {
        return String.format("jdbc:mysql://%s:%d/%s", this.hostname, this.port, this.DBName);
    }
    
    public Database(String _hostname, int _port, String _dbname)
    {
        this.hostname = _hostname;
        this.port = _port;
        this.DBName = _dbname;
        this.URL = this.makeURL();
    }
    
    public static String toSQLDate(String _date, String _format)
    {
        SimpleDateFormat entryFormat = new SimpleDateFormat(_format);
        
        try
        {
            Date date = entryFormat.parse(_date);
            SimpleDateFormat SQLFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sqlDate = SQLFormat.format(date);
            
            return sqlDate;    
        }
        catch(ParseException e)
        {  
            System.out.println(e);
            return null;  
        }
    }
    
    public Boolean connect(String _username, String _password)
    {
        if(this.isConnected)
        {
            return true;
        }
        
        this.username = _username;
        this.password = _password;
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.URL, this.username, this.password);
            this.isConnected = true;
            return true;
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
    
    public Connection con()
    {
        if(!this.isConnected)
        {
            return null;
        }
        return this.connection;
    }
}
