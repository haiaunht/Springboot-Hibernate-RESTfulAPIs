CREATE TABLE events (
  id SERIAL PRIMARY KEY ,
  title VARCHAR(255) NOT NULL ,
  street VARCHAR(355) NOT NULL ,
  city VARCHAR(255) NOT NULL ,
  state VARCHAR(2) NOT NULL ,
  postal_code VARCHAR(255) NOT NULL
);

CREATE TABLE participants (
  id SERIAL PRIMARY KEY ,
  first_name VARCHAR(255) NOT NULL ,
  last_name VARCHAR(255) NOT NULL ,
  email VARCHAR(255) NOT NULL ,
  phone VARCHAR(15) NOT NULL ,
  contact_type VARCHAR(255) NOT NULL,
  event_id INTEGER REFERENCES events(id)
);