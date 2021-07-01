DROP TABLE IF EXISTS parties;

CREATE TABLE parties (
  id SERIAL PRIMARY KEY ,
  party_name VARCHAR(255) NOT NULL ,
  description TEXT NOT NULL,
  location VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS friends;
CREATE TABLE friends (
    id SERIAL PRIMARY KEY ,
    first_name VARCHAR(255) NOT NULL ,
    last_name VARCHAR(255) NOT NULL,
    party_id INTEGER REFERENCES parties(id)
);