DROP TABLE IF EXISTS leagues;
CREATE TABLE leagues (
    id SERIAL PRIMARY KEY ,
    league_name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS teams;
CREATE TABLE teams (
   id SERIAL PRIMARY KEY ,
   name VARCHAR(255),
   league_id INTEGER NOT NULL REFERENCES leagues(id)
);

DROP TABLE IF EXISTS positions;
CREATE TABLE positions (
  id SERIAL PRIMARY KEY ,
  position VARCHAR(255) NOT NULL
);

DROP TABLE if exists players;
CREATE TABLE players (
 id SERIAL PRIMARY KEY ,
 name VARCHAR(255),
 position_id INTEGER NOT NULL REFERENCES positions(id),
 team_id INTEGER REFERENCES teams(id)
);