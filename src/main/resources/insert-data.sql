/*Insert into flats*/
INSERT INTO flats (street, postal_code, city) VALUES ('Glanzstr. 11', '12437', 'Berlin');
INSERT INTO flats (street, postal_code, city) VALUES ('Plönzeile 21', '12459', 'Berlin');
INSERT INTO flats (street, postal_code, city) VALUES ('Leopoldo Alas 19', '22345', 'Oviedo');
INSERT INTO flats (street, postal_code, city) VALUES ('Simon-Dach-Str. 45', '12457', 'Berlin');
INSERT INTO flats (street, postal_code, city) VALUES ('Mühlenstr. 22', '33880', 'Hamburg');
INSERT INTO flats (street, postal_code, city) VALUES ('Nanclares de Oca 40', '28022', 'Madrid');
/*Insert into persons*/
INSERT INTO persons (flat_id, first_name, last_name) VALUES (1, 'Christoph', 'Stach');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (1, 'Adrian', 'Saiz');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (1, 'Belen', 'Garcia');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (2, 'Anna', 'Müller');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (2, 'Carlos', 'Capilla');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (3, 'Laila', 'Westphal');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (3, 'Vladimir', 'Vilenchik');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (3, 'Akhmad', 'Sadullaev');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (4, 'Hendrik', 'Gärtner');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (5, 'Sara', 'del Grosso');
INSERT INTO persons (flat_id, first_name, last_name) VALUES (5, 'Saskia', 'Flasche');
/*Insert into products*/
INSERT INTO products (name, price) VALUES ('Glassreiniger', 0.99);
INSERT INTO products (name, price) VALUES ('Toiletenpapier', 3.99);
INSERT INTO products (name, price) VALUES ('Staubsauger', 20.50);
INSERT INTO products (name, price) VALUES ('Mülltüten', 0.60);
INSERT INTO products (name, price) VALUES ('Backpapier', 1.99);
INSERT INTO products (name, price) VALUES ('Wischmop', 4.15);
INSERT INTO products (name, price) VALUES ('Küchenrolle', 0.89);
INSERT INTO products (name, price) VALUES ('Bier', 5.99);
INSERT INTO products (name, price) VALUES ('Zahnpaste', 0.99);
INSERT INTO products (name, price) VALUES ('Spülmittel', 1.39);
/*Insert into rooms*/
INSERT INTO rooms (flat_id, name) VALUES (1, 'Küche');
INSERT INTO rooms (flat_id, name) VALUES (1, 'Badezimmer');
INSERT INTO rooms (flat_id, name) VALUES (1, 'Wohnzimmer');
INSERT INTO rooms (flat_id, name) VALUES (2, 'Küche');
INSERT INTO rooms (flat_id, name) VALUES (2, 'Badezimmer');
INSERT INTO rooms (flat_id, name) VALUES (2, 'Wohnzimmer');
INSERT INTO rooms (flat_id, name) VALUES (3, 'Küche');
INSERT INTO rooms (flat_id, name) VALUES (3, 'Badezimmer');
INSERT INTO rooms (flat_id, name) VALUES (3, 'Wohnzimmer');
INSERT INTO rooms (flat_id, name) VALUES (4, 'Küche');
INSERT INTO rooms (flat_id, name) VALUES (4, 'Badezimmer');
INSERT INTO rooms (flat_id, name) VALUES (4, 'Wohnzimmer');
INSERT INTO rooms (flat_id, name) VALUES (5, 'Küche');
INSERT INTO rooms (flat_id, name) VALUES (5, 'Badezimmer');
INSERT INTO rooms (flat_id, name) VALUES (5, 'Wohnzimmer');
INSERT INTO rooms (flat_id, name) VALUES (6, 'Küche');
INSERT INTO rooms (flat_id, name) VALUES (6, 'Badezimmer');
INSERT INTO rooms (flat_id, name) VALUES (6, 'Wohnzimmer');
/*Insert into tasks*/

