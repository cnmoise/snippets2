
--SQL code must be run on the WAMP server
--we've downloaded the DB and we're running our queries on that

-- example of using membership

SELECT branchNo
FROM branch
WHERE city IN ('London', 'Aberdeen', 'Glasgow')

SELECT * FROM staff WHERE sex = 'M'

--Pattern Matching
--REGEX
-- % = represents any sequence of characters
-- only cares about the first 2 letters being SG
SELECT * FROM staff WHERE staffNo LIKE 'SG%'
-- 3 random chars and must end in a 1
SELECT * FROM staff WHERE staffNo LIKE '___1'

--finds all properties w no staff member assigned to watch it
SELECT * FROM propertyforrent where staffNo IS NULL

--aranges rents in ascending order
SELECT * FROM propertyforrent where staffNo IS NOT NULL
ORDER BY rent, propertyType


----SUB QUERIES 3/3/2018 ----

--Outer/Inner Queries

--Find staff member who earns above the avg salary
SELECT * FROM staff
	WHERE salary > (SELECT AVG(salary) from staff)

--find highest paid employeed

SELECT * FROM staff
	WHERE salary = (SELECT MAX(salary) from staff)

SELECT * FROM staff WHERE branchNo IN
	(SELECT branchNo FROM branch WHERE city = 'London' or city = 'Glasgow')

SELECT propertyNo FROM propertyforrent
	WHERE staffNo IN
		(SELECT staffNo FROM staff WHERE position = 'assistant')

--find branch w highest salary expense
--Can select an agregate!!!
-- as makes a view
-- multiple, attributes

SELECT MAX(TS.Total), branchNo FROM
	(SELECT SUM(salary) FROM staff GROUP BY branchNo) as TS

--INNER JOINS
--needs data from more than 1 table, needs joins
--c. dictates we're pulling the value from the CLIENT table
--refferencing common key & using it to join tables

--HOW TO DO IT W/O using JOIN

SELECT c.clientNo, c.fName, c.lName, v.propertyNo, v.comment
FROM Viewing v, Client c
WHERE c.clientNo = v.clientNo

--with JOIN ON
--ON == the common property
SELECT c.clientNo, c.fName, c.lName, v.propertyNo, v.comment
FROM Client c INNER JOIN Viewing v ON c.clientNo = v.clientNo
ORDER BY c.clientNo, c.fName, v.propertyNo;

--OUTER JOINS
--includes NULL values

SELECT b.branchNo, b.city, propertyNo, p.city
FROM branch b LEFT JOIN propertyforrent p ON b.city = p.city;

--INSRT, UPDATE, DELETE
--Add crap to databases

INSERT INTO movietable (id, name, genre, rating)
	VALUES (0, "SPOODERMAN", "History", 9)

--can omit
--might need to go into wAMP and change db properties
INSERT INTO movietable VALUES (0, "SPOODERMAN", "History", 9)



UPDATE movietable SET rating = 6 WHERE name LIKE "SPOO%"

DELETE * FROM 'movietable' WHERE rating < 6