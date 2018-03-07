-- Using DreamHome DB
-- 1- Produce a List of fName, lName and address of owners who own a property in glasgow.


SELECT fName, lName, address FROM  privateowner ow
JOIN propertyforrent rent ON rent.ownerNo = ow.ownerNo
WHERE city = "Glasgow";


-- 2- Produce a list of total rooms for properties for rent by each city.

SELECT city, SUM(rooms) FROM propertyforrent GROUP BY city;

-- 3- Produce a list fName, lName of the highest earning staff of each branch.

SELECT fName, lName, MAX(salary) FROM staff GROUP BY branchNo;

-- 4- Get the number of Flats in Glasgow.

SELECT COUNT(propertyType) FROM propertyforrent
WHERE propertyType = "Flat" AND city = "Glasgow";

-- 5- Produce a list of properties that are handled by a staff that works at branch B003.

--Handy way of avoiding messy joins, make a subquery

--things getting hard? ask if you can break things into subqueries

SELECT * FROM propertyforrent
WHERE staffNo IN (SELECT branchNo FROM staff WHERE branchNo = "B003")

-- 6- Find the branch that pays the highest total salary.

--Created a subQ instead of doing a join

SELECT branchNo, Max(salarytot) FROM
(SELECT branchNo, Sum(salary) as salarytot FROM staff GROUP BY branchNo) as TS

--
SELECT MAX(ts.Total), ts.branchNo
FROM
(SELECT SUM(salary) as Total, s.branchNo
FROM staff s JOIN branch b ON s.branchNo = b.branchNo
GROUP BY b.branchNo) AS ts

-- 7- Fetch the list of all properties that Mike Ritchie is interested in.

SELECT * FROM propertyforrent
WHERE propertyType = "House" and rent < 750

--LMAO and heres the non-hardcoded version

SELECT propertyNo, street, city, propertyType, rent
FROM PropertyForRent pfr, Client c
WHERE pfr.rent < c.maxRent AND pfr.propertyType = c.prefType AND c.fName = 'Mike' AND c.lName =
'Ritchie';

-- 8- Produce a list of number of staff for branches in each city.

SELECT city, COUNT(*) FROM staff s
JOIN branch b on s.branchNo = b.branchNo 
GROUP BY city;

-- 9- What is the number of female staff members who work at a branch in London?

SELECT city, COUNT(sex) FROM staff s
JOIN branch b on s.branchNo = b.branchNo
WHERE city = "London" and sex = "F"
GROUP BY city;

-- 10- Find the number of staff that showed a property to Aline Stewart.

--Design your query as if the user was typing the term into a searchbox
SELECT COUNT(staffNo) FROM (SELECT clientNo, v.propertyNo, staffNo FROM viewing v
JOIN PropertyForRent pfr ON pfr.propertyNo = v.propertyNo 
WHERE clientNo = "CR56") AS ASV

SELECT COUNT(staffNo)
FROM Viewing v INNER JOIN Client c ON v.clientNo = c.clientNo
INNER JOIN PropertyForRent pfr ON pfr.propertyNo = v.propertyNo
WHERE c.fName = 'Aline' AND c.lName = 'Stewart';


-- 11- Find the names of staff who showed a property to Aline Stewart

--Sometimes Subqueries can make things more confusing and its just better to use Joins
SELECT s.fName, s.lName, s.staffNo FROM
(SELECT clientNo, v.propertyNo, pfr.staffNo, s.fName, s.lName FROM viewing v
JOIN PropertyForRent pfr ON pfr.propertyNo = v.propertyNo 
JOIN staff s ON pfr.staffNo = s.staffNo
WHERE clientNo = "CR56") AS ASV

SELECT s.fName, s.lName FROM Viewing v
INNER JOIN Client c ON v.clientNo = c.clientNo
INNER JOIN PropertyForRent pfr ON pfr.propertyNo = v.propertyNo
INNER JOIN Staff s ON s.staffNo = pfr.staffNo
WHERE c.fName = 'Aline' AND c.lName = 'Stewart';

