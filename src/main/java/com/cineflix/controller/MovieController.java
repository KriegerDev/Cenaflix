/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineflix.controller;

import com.cineflix.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.cineflix.model.Movie;

/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class MovieController 
{
    private static Connection DatabaseConnection = null;
    
    private static Movie make(ResultSet rs) throws SQLException
    {
        int _id = rs.getInt("id");
        String _name = rs.getString("name");
        String _date = String.format("%s", rs.getDate("date"));
        String _category = rs.getString("category");
        
        return new Movie(_id, _name, _date, _category);
    }
    
    public static void setDatabaseConnection(Connection con)
    {
        DatabaseConnection = con;
    }
    
    public static List<Movie> get()
    {
        try
        {
            List<Movie> movieArray = new ArrayList<Movie>();
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `movie`");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Movie movie = make(rs);
                
                movieArray.add(movie);
            }
            
            return movieArray;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static Movie get(int index)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `movie` WHERE `id` = ?");
            pst.setInt(1, index);
            ResultSet rs = pst.executeQuery();
            
            rs.next();
            
            Movie movie = make(rs);
            
            return movie;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static List<Movie> get(String _movieName)
    {
        try
        {
            List<Movie> movieArray = new ArrayList<Movie>();
            
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `movie` WHERE `name` = ?");
            pst.setString(1, _movieName);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Movie movie = make(rs);
                
                movieArray.add(movie);
            }
            
            return movieArray;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static List<Movie> getByCategory(String _scategory)
    {
        try
        {
            List<Movie> movieArray = new ArrayList<Movie>();
            
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `movie` WHERE `category` = ?");
            pst.setString(1, _scategory);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Movie movie = make(rs);
                movieArray.add(movie);
            }
            
            return movieArray;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static int add(Movie movie)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("INSERT INTO `movie` (`name`, `date`, `category`)"
                    + "VALUES (?, ?, ?)");
            
            pst.setString(1, movie.getName());
            
            String sqlDate = Database.toSQLDate(movie.getDate(), "dd/MM/yyyy");
            
            pst.setString(2, sqlDate);
            pst.setString(3, movie.getCategory());
           
            return pst.executeUpdate();        
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return 0; 
        }
    }
    
    public static int delete(int _index)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("DELETE FROM `movie` WHERE `id` = ?");
            
            pst.setInt(1, _index);
            
            return pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return 0; 
        }
    }
    
}
