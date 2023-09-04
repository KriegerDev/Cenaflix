/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineflix.model;

/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class PodcastEpisode {
    private final int id;
    private final String name;
    private final int number;
    private final int duration;
    private final String URL;
    private final String productor;
    
    public PodcastEpisode(int _id, String _name, int _number, int _duration, String _productor, String _URL)
    {
        this.id = _id;
        this.name = _name;
        this.number = _number;
        this.duration = _duration;
        this.URL = _URL;
        
        this.productor = _productor;
    }
    
    
    public int getId()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getNumber()
    {
        return this.number;
    }
    
    public int getDuration()
    {
        return this.duration;
    }
    
    public String getURL()
    {
        return this.URL;
    }
    
    public String getProductor()
    {
        return this.productor;
    }
}
