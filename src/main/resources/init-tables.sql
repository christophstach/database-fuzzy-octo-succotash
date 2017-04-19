DROP TABLE IF EXISTS persons_are_responsible_for_rooms;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS flats;

--DROP TABLE IF EXISTS expenses;
DROP TABLE IF EXISTS products;


CREATE TABLE flats (
  flat_id     SERIAL NOT NULL PRIMARY KEY,
  street      VARCHAR(255),
  postal_code VARCHAR(20),
  city        VARCHAR(255)
);

CREATE TABLE persons (
  person_id  SERIAL NOT NULL PRIMARY KEY,
  flat_id    INTEGER REFERENCES flats,
  first_name VARCHAR(255),
  last_name  VARCHAR(255)
);

CREATE TABLE rooms (
  room_id   SERIAL NOT NULL PRIMARY KEY,
  flat_id   INTEGER REFERENCES flats,
  name      VARCHAR(255)
);

/**
 * Beziehung
 */
CREATE TABLE persons_are_responsible_for_rooms (
  room_id    INTEGER REFERENCES rooms,
  person_id  INTEGER REFERENCES persons,
  start_date TIMESTAMP NOT NULL,
  end_date   TIMESTAMP NOT NULL,
  PRIMARY KEY (room_id, person_id, start_date, end_date)
);

CREATE TABLE tasks (
  task_id SERIAL NOT NULL PRIMARY KEY,
  room_id INTEGER REFERENCES rooms,
  name    VARCHAR(255),
  points  INTEGER
);


CREATE TABLE products (
  product_id SERIAL       NOT NULL PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  price      FLOAT        NOT NULL
);