CREATE TABLE IF NOT EXISTS genres
(genre_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
genre_name varchar(255) NOT NULL);

CREATE TABLE IF NOT EXISTS publishers
(publisher_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
publisher_name varchar(255) NOT NULL);

CREATE TABLE IF NOT EXISTS developers
(developer_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
developer_name varchar(255) NOT NULL);

CREATE TABLE IF NOT EXISTS platforms
(platform_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
platform_name varchar(255) NOT NULL);



CREATE TABLE IF NOT EXISTS games
(game_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
name varchar(255) UNIQUE NOT NULL,
release_date varchar(50) NOT NULL,
developer_id varchar(255) NOT NULL,
publisher_id varchar(255) NOT NULL,
features varchar(255) NOT NULL,
price numeric(10,2) NOT NULL,
discount numeric(10,2) NOT NULL,
description varchar NOT NULL,
base64Image varchar NOT NULL,

FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id),
FOREIGN KEY(developer_id) REFERENCES developers(developer_id)

);




CREATE TABLE IF NOT EXISTS game_genre
(game_id varchar(255),
genre_id varchar(255),

FOREIGN KEY(game_id) REFERENCES games(game_id),
FOREIGN KEY(genre_id) REFERENCES genres(genre_id));


CREATE TABLE IF NOT EXISTS game_platform
(game_id varchar(255),
platform_id varchar(255),

FOREIGN KEY(game_id) REFERENCES games(game_id),
FOREIGN KEY(platform_id) REFERENCES platforms(platform_id));
