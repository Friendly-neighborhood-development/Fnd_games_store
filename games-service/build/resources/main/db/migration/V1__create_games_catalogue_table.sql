CREATE TABLE IF NOT EXISTS games_catalogue
(id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
name varchar(20) UNIQUE NOT NULL,
genre varchar(20) UNIQUE NOT NULL,
releasedate varchar(20) UNIQUE NOT NULL,
developer varchar(20) UNIQUE NOT NULL,
publisher varchar(20) UNIQUE NOT NULL,
platform varchar(20) UNIQUE NOT NULL,
features varchar(20) UNIQUE NOT NULL,
price numeric(40,2) UNIQUE NOT NULL,
discount numeric (40,2) UNIQUE NOT NULL,
description varchar(20) UNIQUE NOT NULL);


