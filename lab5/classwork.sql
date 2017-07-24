CREATE DATABASE IF NOT EXISTS RESTAURANT;
USE RESTAURANT;
SET SQL_SAFE_UPDATES = 0;
#Create restaurant food item table
DROP TABLE IF EXISTS food;
CREATE TABLE food (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	foodName char(32) NOT NULL,
    price double NOT NULL,
    description char(160)
);
#Create restaurant order statuses table
DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customerName char(32) NOT NULL,
    dateTimeCreated datetime NOT NULL
);

DROP TABLE IF EXISTS orderedFoods;
CREATE TABLE OrderedFoods (
	orderID int,
	foodID int,
    Quantity int
);
#Create restaurant cart table
DROP TABLE IF EXISTS cart;
CREATE TABLE cart(
	id int NOT NULL,
    customerName char(32) NOT NULL,
	foodID int NOT NULL,
    amount int NOT NULL
);
#Insert default food items into food items table
INSERT INTO food(foodName,price,description) 
VALUES ('Hamburger', 9.99, 'A hamburger'),
	   ('Fries', 4.99, 'Some fries'),
       ('Coke', 2.99, 'Coca Cola');
#Insert default order statuses into order statuses table
INSERT INTO orders(customerName, dateTimeCreated) 
VALUES ('Eric', current_timestamp()), ('John', current_timestamp())
, ('Jane', current_timestamp()), ('Alice', current_timestamp());

INSERT INTO orderedFoods(orderID, foodID, Quantity)
VALUES (1,1,1), (1,2,2), (2,2,2), (2,3,1), (3,3,1), (4,2,1), (4,3,2);

INSERT INTO cart(id, customerName, foodID, amount)
VALUES (1,'Anonymous',1,2), (1,'Anonymous',2,1), (1,'Anonymous',2,1),(2,'Mike',1,1),(2,'Mike',2,1),(3,'Bob',3,1);
#Update food item name from "Hamburger" to "Salad"
UPDATE food SET foodName='Salad' WHERE foodName='Hamburger';
#Update customer name from "Jane" to "Doe"
UPDATE orders SET customerName='Doe' WHERE customerName='Jane';
#Find out which food item has the most orders
SELECT foodName, Quantity FROM food f INNER JOIN orderedFoods o ON f.id = o.foodID GROUP BY o.foodID ORDER BY SUM(o.Quantity) DESC LIMIT 1;
#Find out which food item in least shopping carts
SELECT foodName, Quantity FROM food f INNER JOIN orderedFoods o ON f.id = o.foodID GROUP BY o.foodID ORDER BY SUM(o.Quantity) ASC LIMIT 1;
#Find out all restaurant food items using SELECT query
SELECT * FROM food;
#Find out all restaurant order statuses using SELECT query
#There is no table with the order statuses..? is there? is it orders?
SELECT * FROM orders;
#Find out the order statuses that is created today
SELECT * FROM orders WHERE DATE(dateTimeCreated) = CURDATE();
#DELETE restaurant food items table
DROP TABLE IF EXISTS food;
#Delete restaurant order statuses table
DROP TABLE IF EXISTS orders;
#Delete restaurant cart table
DROP TABLE IF EXISTS cart;

