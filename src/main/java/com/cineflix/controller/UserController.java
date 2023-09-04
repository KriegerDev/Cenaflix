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

import com.cineflix.model.User;

/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class UserController
{
    private static Connection DatabaseConnection = null;
    
    private static User currtentUser = null;
    
    private static User make(ResultSet rs) throws SQLException
    {
        int _id = rs.getInt("id");
        String _name = rs.getString("username");
        String _password = rs.getString("password");
        int _permission = rs.getInt("permission");
        
        return new User(_id, _name, _password, _permission);
    }
    
    public static void setDatabaseConnection(Connection con)
    {
        DatabaseConnection = con;
    }
    
    public static User getCurrentUser()
    {
        return currtentUser;
    }
    
    public static void setCurrentUser(User _user)
    {
        currtentUser = _user;
    }
    
    public static List<User> get()
    {
        try
        {
            List<User> userArray = new ArrayList<User>();
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `user`");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                User user = make(rs);
                
                userArray.add(user);
            }
            
            return userArray;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static User get(int index)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `user` WHERE `id` = ?");
            pst.setInt(1, index);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                User user = make(rs);
                return user;
            }
            
            return null;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static User get(String _userName)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `user` WHERE `username` = ?");
            pst.setString(1, _userName);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                User user = make(rs);
                return user;
            }
            
            return null;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static int add(User user)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("INSERT INTO `user` (`username`, `password`, `permission`)"
                    + "VALUES (?, ?, ?)");
            
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setInt(3, user.getPermission());
           
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
            PreparedStatement pst = DatabaseConnection.prepareStatement("DELETE FROM `user` WHERE `id` = ?");
            
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
