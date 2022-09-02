CREATE TABLE IF NOT EXISTS accounts
(account_id varchar PRIMARY KEY UNIQUE NOT NULL,
username varchar(50)  UNIQUE NOT NULL,
password varchar NOT NULL,
authority_id varchar(50) NOT NULL,

FOREIGN KEY(authority_id)
REFERENCES authorities(authority_id));


CREATE TABLE IF NOT EXISTS authorities
(authority_id varchar PRIMARY KEY UNIQUE NOT NULL,
authority varchar(50) UNIQUE NOT NULL);


