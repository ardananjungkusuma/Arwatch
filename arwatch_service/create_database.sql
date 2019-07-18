DROP DATABASE IF EXISTS arwatch_service;

CREATE DATABASE arwatch_service;

USE arwatch_service;

CREATE TABLE watch
(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price VARCHAR(50),
    imgUrl VARCHAR(255),
    desc VARCHAR(255)

);