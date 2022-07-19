CREATE TABLE IF NOT EXISTS games_catalogue
(id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
name varchar(20) UNIQUE NOT NULL,
genre varchar(20) NOT NULL,
releasedate varchar(20) NOT NULL,
developer varchar(20) NOT NULL,
publisher varchar(20) NOT NULL,
platform varchar(20) NOT NULL,
features varchar(20) NOT NULL,
price numeric(4,2) NOT NULL,
discount numeric(4,2) NOT NULL,
description varchar(255) NOT NULL);


