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

import com.cineflix.model.PodcastEpisode;

/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class PodcastEpisodeController 
{
    private static Connection DatabaseConnection = null;
    
    private static PodcastEpisode make(ResultSet rs) throws SQLException
    {
        int _id = rs.getInt("id");
        String _productor = rs.getString("production");
        String _name = rs.getString("name");
        int _number = rs.getInt("number");
        int _duration = rs.getInt("duration");
        String _URL = rs.getString("URL");
        
        return new PodcastEpisode(_id, _name, _number, _duration, _productor, _URL);
    }
    
    public static void setDatabaseConnection(Connection con)
    {
        DatabaseConnection = con;
    }
    
    public static List<PodcastEpisode> get()
    {
        try
        {
            List<PodcastEpisode> podcast_episodeArray = new ArrayList<PodcastEpisode>();
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `podcast_episode`");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                PodcastEpisode podcast_episode = make(rs);
                
                podcast_episodeArray.add(podcast_episode);
            }
            
            return podcast_episodeArray;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static PodcastEpisode get(int index)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `podcast_episode` WHERE `id` = ?");
            pst.setInt(1, index);
            ResultSet rs = pst.executeQuery();
            
            rs.next();
            
            PodcastEpisode podcast_episode = make(rs);
            
            return podcast_episode;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static List<PodcastEpisode> get(String _podcast_episodeName)
    {
        try
        {
            List<PodcastEpisode> podcast_episodeArray = new ArrayList<PodcastEpisode>();
            
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `podcast_episode` WHERE `name` = ?");
            pst.setString(1, _podcast_episodeName);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                PodcastEpisode podcast_episode = make(rs);
                
                podcast_episodeArray.add(podcast_episode);
            }
            
            return podcast_episodeArray;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static List<PodcastEpisode> getByProductor(String _productor)
    {
        try
        {
            List<PodcastEpisode> podcast_episodeArray = new ArrayList<PodcastEpisode>();
            
            PreparedStatement pst = DatabaseConnection.prepareStatement("SELECT * FROM `podcast_episode` WHERE `production` LIKE ?");
            pst.setString(1, "%"+_productor+"%");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                PodcastEpisode podcast_episode = make(rs);
                
                podcast_episodeArray.add(podcast_episode);
            }
            
            return podcast_episodeArray;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static int add(PodcastEpisode podcast_episode)
    {
        try
        {
            PreparedStatement pst = DatabaseConnection.prepareStatement("INSERT INTO `podcast_episode`"
                    + " (`name`, `number`, `duration`, `URL`, `production`)"
                    + "VALUES (?, ?, ?, ?, ?)");
            
            pst.setString(1, podcast_episode.getName());
            pst.setInt(2, podcast_episode.getNumber());
            pst.setInt(3, podcast_episode.getDuration());
            pst.setString(4, podcast_episode.getURL());
            pst.setString(5, podcast_episode.getProductor());
           
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
            PreparedStatement pst = DatabaseConnection.prepareStatement("DELETE FROM `podcast_episode` WHERE `id` = ?");
            
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
