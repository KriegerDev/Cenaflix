/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cineflix.model;

/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */
public class User {
    private final int id;
    private final String username;
    private final String password;
    private final int permission;
    
    public User(int _id, String _username, String _password, int _permission)
    {
        this.id = _id;
        this.username = _username;
        this.password = _password;
        this.permission = _permission;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public int getPermission()
    {
        return this.permission;
    }
    
    public String getPermissionStr()
    {
        switch(this.permission)
        {
            case 1:
            {
                return "Administrador";
            }
            
            case 2:
            {
                return "Operador";
            }
            
            case 3:
            {
                return "Usuario";
            }
            
            default:
            {
                return "Usuario";
            }
        }
    }
}
