CREATE TABLE IF NOT EXISTS orders
(order_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
order_date date NOT NULL,
is_order_processed boolean NOT NULL);


CREATE TABLE IF NOT EXISTS games
(game_id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
name varchar(255) UNIQUE NOT NULL,
release_date varchar(50) NOT NULL,
price numeric(10,2) NOT NULL,
discount numeric(10,2) NOT NULL,
description varchar NOT NULL,
base64Image varchar NOT NULL);


CREATE TABLE IF NOT EXISTS order_game
(order_id varchar(255),
game_id varchar(255),

FOREIGN KEY(order_id) REFERENCES orders(order_id),
FOREIGN KEY(game_id) REFERENCES games(game_id));