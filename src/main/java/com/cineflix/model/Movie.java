/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineflix.model;
/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class Movie {
    private final int id;
    private final String name;
    private final String date;
    private final String category;
    
    public Movie(int _id, String _name, String _date, String _category)
    {
        this.id = _id;
        this.name = _name;
        this.date = _date;
        this.category = _category;
    }

    public int getId()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    public String getCategory()
    {
        return this.category;
    }
    
}
