/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Lorenzo Walecheski https://github.com/KriegerDev
 * Created: 22 de ago. de 2023
 */

CREATE TABLE `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(24),
    `password` VARCHAR(24),
    `permission` INT NOT NULL
);