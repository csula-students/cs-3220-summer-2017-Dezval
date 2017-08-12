DROP TABLE IF EXISTS guestbook;

CREATE TABLE guestbook (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    message TEXT,
    created timestamp
);

INSERT INTO guestbook (name, message, created)
    VALUES ('John', 'Hello', '2017-07-28 17:10:00'), ('Joe', 'Hi', now());

DROP TABLE IF EXISTS food;

CREATE TABLE food (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DOUBLE
);

INSERT INTO food(foodName,price,description)
VALUES ('Hamburger', 9.99, 'A hamburger'),
	   ('Fries', 4.99, 'Some fries'),
       ('Coke', 2.99, 'Coca Cola');