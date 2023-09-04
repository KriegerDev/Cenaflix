/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cineflix.main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.cineflix.database.Database;
import com.cineflix.controller.MovieController;
import com.cineflix.controller.PodcastEpisodeController;
import com.cineflix.controller.UserController;
import com.cineflix.model.PodcastEpisode;
import com.cineflix.model.User;
import com.cineflix.view.Login;
import com.cineflix.view.MainView;

/**
 *
 * @author Lorenzo Walecheski https://github.com/KriegerDev
 */

public class Cineflix {

    public static void main(String[] args) 
    {
        Database db = new Database("localhost", 3306, "cenaflix");
        if(!db.connect("root", "password"))
        {
            System.out.println("Ocorreu um erro ao se conectar com a DB!!");
            return;
        }
        else
        {
            MovieController.setDatabaseConnection(db.con());
            PodcastEpisodeController.setDatabaseConnection(db.con());
            UserController.setDatabaseConnection(db.con());
        }
        
        Login login = new Login();
        login.setVisible(true);
        
        
    }
}


