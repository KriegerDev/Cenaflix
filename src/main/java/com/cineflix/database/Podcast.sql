/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Lorenzo Walecheski https://github.com/KriegerDev
 * Created: 22 de ago. de 2023
 */

CREATE TABLE `podcast_episode` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `production` VARCHAR(100),
    `name` VARCHAR(100),
    `number` INT NOT NULL,
    `duration` INT NOT NULL,
    `URL` VARCHAR(100) NOT NULL
);