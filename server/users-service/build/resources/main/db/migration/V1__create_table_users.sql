CREATE TABLE IF NOT EXISTS users
(id varchar PRIMARY KEY UNIQUE NOT NULL ,
username varchar(255) UNIQUE NOT NULL,
password varchar NOT NULL,
email varchar UNIQUE NOT NULL);