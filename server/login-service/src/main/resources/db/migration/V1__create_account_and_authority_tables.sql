CREATE TABLE IF NOT EXISTS authorities
(authority_id varchar PRIMARY KEY UNIQUE NOT NULL,
  authority varchar(50) UNIQUE NOT NULL);


CREATE TABLE IF NOT EXISTS accounts
(account_id varchar PRIMARY KEY UNIQUE NOT NULL,
username varchar(50)  UNIQUE NOT NULL,
password varchar NOT NULL,
email varchar NOT NULL,
expiration_date date NOT NULL,
is_account_non_locked boolean NOT NULL,
credentials_expiration_date date NOT NULL,
is_account_enabled boolean NOT NULL);


CREATE TABLE IF NOT EXISTS accounts_authorities
(account_id varchar NOT NULL,
 authority_id varchar NOT NULL,


 FOREIGN KEY(account_id) REFERENCES accounts(account_id),
 FOREIGN KEY(authority_id) REFERENCES authorities(authority_id));



