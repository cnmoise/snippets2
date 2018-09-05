


CREATE TABLE `customers`.`customers` ( `customer_id` INT NOT NULL ,
	`cust_name` VARCHAR NOT NULL , `city` VARCHAR NOT NULL ,
	`grade` INT NULL DEFAULT NULL , `salesman_id` INT NOT NULL) ENGINE = MyISAM;

INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id)
	VALUES (3002, "Nick Rimando", "New York", 100, 5001);
INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id)
	VALUES (3002, "Graham Zusi", "California", 200, 5002);
INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id)
	VALUES (3001, "Brad Guzan", "London", NULL, 5005);
INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id)
	VALUES (3004, "Fabian Johns", "Paris", 300, 5006);
INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id)
	VALUES (3007, "Brad Davis", "New York", 200, 5001);
INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id)
	VALUES (3009, "Geof Camero", "Berlin", 100, 5003);

--1
SELECT COUNT(cust_name) FROM customers;

--2
--group by collapses entries with duplicate city names
--and makes sure that each city gets displayed
SELECT city, MAX(grade) FROM customers GROUP BY city;

--3
SELECT COUNT(cust_name) FROM customers WHERE grade IS NOT NULL;


CREATE TABLE `customers`.`orders` ( `ord_no` INT NOT NULL , `purch_amt`
	DECIMAL NOT NULL , `ord_date` DATE NOT NULL , `custromer_id`
	INT NOT NULL , `salesman_id` INT NOT NULL ) ENGINE = MyISAM;

DELETE FROM orders
--DELETES ALL ROWS IN TABLE

INSERT INTO `orders`(`ord_no`, `purch_amt`, `ord_date`, `custromer_id`, `salesman_id`)
	VALUES (70001, 150.5, "2012-10-05", 3005 ,5002 );

INSERT INTO `orders`(`ord_no`, `purch_amt`, `ord_date`, `custromer_id`, `salesman_id`)
	VALUES (70009, 270.65, "2012-09-10", 3001 ,5005);

INSERT INTO `orders`(`ord_no`, `purch_amt`, `ord_date`, `custromer_id`, `salesman_id`)
	VALUES (70002, 65.26, "2012-10-05", 3002, 5001);

INSERT INTO `orders`(`ord_no`, `purch_amt`, `ord_date`, `custromer_id`, `salesman_id`)
	VALUES (70004, 110.5, "2012-08-17", 3009, 5003);

INSERT INTO `orders`(`ord_no`, `purch_amt`, `ord_date`, `custromer_id`, `salesman_id`)
	VALUES (70007, 948.5, "2012-09-10", 3005, 5002);

INSERT INTO `orders`(`ord_no`, `purch_amt`, `ord_date`, `custromer_id`, `salesman_id`)
	VALUES (70005, 2400.6, "2012-07-27", 3007, 5001);


--4
SELECT SUM(purch_amt) FROM orders;

--5
SELECT AVG(purch_amt) FROM orders;

--6 Count how many customers each salesman has

SELECT salesman_id, COUNT(DISTINCT customer_id) FROM orders GROUP BY salesman_id;

--7
SELECT MAX(purch_amt) FROM orders;
--8
SELECT MIN(purch_amt) FROM orders;

--9
--ORDER BY is always at the very end
SELECT customer_id, MAX(purch_amt) FROM orders GROUP BY customer_id ORDER BY customer_id;

--10
-- Create SQL code that finds the highest purchase amount ordered by the
-- each customer on a particular date with their ID, order date and highest purchase amount.

SELECT customer_id, ord_date, MAX(purch_amt) FROM orders GROUP BY customer_id, ord_date;

--11
SELECT salesman_id, ord_date, MAX(purch_amt) FROM orders WHERE ord_date = "2012-08-17"
GROUP BY salesman_id;

--12
SELECT customer_id, ord_date, MAX(purch_amt) FROM orders WHERE purch_amt > 2000
GROUP BY customer_id, ord_date;

SELECT customer_id,ord_date,MAX(purch_amt)
FROM orders
GROUP BY customer_id,ord_date
HAVING MAX(purch_amt)>2000.00;

--13
SELECT customer_id, ord_date, MAX(purch_amt) FROM orders
WHERE purch_amt > 2000 and purch_amt < 6000
GROUP BY customer_id, ord_date;

--interesting syntax

SELECT customer_id, ord_date, MAX(purch_amt) FROM orders
GROUP BY customer_id, ord_date
HAVING MAX(purch_amt) BETWEEN 2000 AND 6000;

--14
SELECT customer_id, MAX(purch_amt) FROM orders
WHERE customer_id > 3002 and customer_id < 3007
GROUP BY customer_id

SELECT customer_id, MAX(purch_amt) FROM orders
WHERE customer_id BETWEEN 3002 and 3007
GROUP BY customer_id

--DB name > table name
CREATE TABLE `customers`.`salesman` ( `salesman_id` INT NOT NULL , `name` VARCHAR(32) NOT NULL,
`city` VARCHAR(32) NULL DEFAULT NULL , `commission` DECIMAL(10,2) NOT NULL ) ENGINE = MyISAM;

INSERT INTO `salesman`(`salesman_id`, `name`, `city`, `commission`)
VALUES (5001, "James Hoog", "New York", 0.15);

INSERT INTO `salesman`(`salesman_id`, `name`, `city`, `commission`)
VALUES (5002, "Nail Knite", "Paris", 0.13);

INSERT INTO `salesman`(`salesman_id`, `name`, `city`, `commission`)
VALUES (5005, "Pit Alex", "London", 0.11);

INSERT INTO `salesman`(`salesman_id`, `name`, `city`, `commission`)
VALUES (5006, "Mc Lyon", "Paris", 0.14);

INSERT INTO `salesman`(`salesman_id`, `name`, `city`, `commission`)
VALUES (5003, "Lauson Hen", NULL, 0.12);

INSERT INTO `salesman`(`salesman_id`, `name`, `city`, `commission`)
VALUES (5003, "Paul Adam", "ROME", 0.13);

--16

SELECT COUNT(DISTINCT city) FROM salesman WHERE city IS NOT NULL;


--17
SELECT salesman_id, ord_date, COUNT(*) FROM orders
GROUP BY ord_date, salesman_id;

--JOIN exercises
--1

SELECT ord_no, purch_amt, cust_name, city FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE o.purch_amt BETWEEN 500 AND 2000;

SELECT ord_no, purch_amt, cust_name, city FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE o.purch_amt > 500 AND o.purch_amt < 2000;

SELECT a.ord_no,a.purch_amt,
b.cust_name,b.city
FROM orders a,customer b
WHERE a.customer_id=b.customer_id
AND a.purch_amt BETWEEN 500 AND 2000;

--2
SELECT s.salesman_id, c.customer_id, cust_name as "CUSTOMER", name AS "SALESMAN" FROM customers c
INNER JOIN salesman s ON s.salesman_id = c.salesman_id;

--3
SELECT s.salesman_id, c.customer_id, cust_name as "CUSTOMER", name AS "SALESMAN", commission FROM customers c
INNER JOIN salesman s ON s.salesman_id = c.salesman_id
WHERE commission > 0.12;

--4
-- Create SQL code that finds the list of customers who appointed
-- a salesman for their jobs who does not live in same city where
-- there customer lives, and gets a commission is above 12% .

SELECT c.customer_id, cust_name as "CUSTOMER", c.city AS "CUSTOMER City",
s.salesman_id, name AS "SALESMAN", s.city AS "SALESMAN City", commission FROM customers c
INNER JOIN salesman s ON s.salesman_id = c.salesman_id
WHERE commission > 0.12 AND c.city <> s.city;

--5
-- Create SQL code that makes a list in ascending order
-- for the customer who works either through a salesman or by own.

--SPEAK GOOD ENGLISH AND THEN ILL MAKE YOUR QUERY