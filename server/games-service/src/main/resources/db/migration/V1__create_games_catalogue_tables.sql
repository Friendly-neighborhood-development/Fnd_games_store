CREATE TABLE IF NOT EXISTS games
(game_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
name varchar(255) UNIQUE NOT NULL,
release_date varchar(50) NOT NULL,
developer varchar(200) NOT NULL,
publisher varchar(200) NOT NULL,
platform varchar(200) NOT NULL,
features varchar(255) NOT NULL,
price numeric(10,2) NOT NULL,
discount numeric(10,2) NOT NULL,
description varchar NOT NULL,
base64Image varchar NOT NULL);


CREATE TABLE IF NOT EXISTS genres
(genre_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
name varchar(255) NOT NULL);


CREATE TABLE IF NOT EXISTS game_genre
(game_id varchar(255),
genre_id varchar(255),


FOREIGN KEY(game_id) REFERENCES games(game_id),
FOREIGN KEY(genre_id) REFERENCES genres(genre_id));
