CREATE TABLE schools (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL ,
    description TEXT
);

CREATE TABLE spells (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL ,
    level INTEGER NOT NULL ,
    description TEXT,
    school_id INTEGER NOT NULL REFERENCES schools(id)
);