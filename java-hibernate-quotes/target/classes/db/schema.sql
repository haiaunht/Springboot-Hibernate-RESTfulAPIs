CREATE TABLE quotes (
  id SERIAL PRIMARY KEY,
  quote TEXT,
  author VARCHAR(255),
  subject VARCHAR(255)
);

CREATE SEQUENCE quotes_id_seq;

CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);
CREATE SEQUENCE authors_id_seq;