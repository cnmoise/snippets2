Please write a SQL query that lists all staff members who work at branches ‘B003’ and ‘B005’.

SELECT * FROM staff
WHERE branchNo = "B003" or branchNo = "B005"

Please write a SQL query that shows how many viewings were held for properties in Glasgow.

SELECT count(*) FROM Viewing v
JOIN propertyforrent p ON v.propertyNo = p.propertyNo
WHERE city = "Glasgow"

Please write a SQL query that gives how many different cities
this real estate company is managing properties in.
(The result should be 3. Aberdeen, London and Glasgow).

SELECT count(DISTINCT city) FROM propertyforrent

Please write a SQL query that returns the number of flats in Glasgow.

SELECT COUNT(propertyType) FROM propertyforrent
WHERE propertyType = "Flat" AND city = "Glasgow";

Please write a SQL query that returns the number of clients looking for a house.

SELECT clientNo FROM client
WHERE prefType = "House";

Assume that this real estate company does business by collecting
the first month’s rent from landlords who want to have their properties rented. 

Please write a SQL query that returns the total income that
this company can expect if it was to rent all properties that
is currently in its database.

SELECT SUM(rent) FROM propertyforrent

Please write a SQL query that returns the least amount of total salary paid for each branch.

SELECT branchNo, MIN(T.total) FROM
(SELECT SUM(salary) as total, branchNo FROM staff GROUP BY branchNo) as T

Please write a SQL query that returns the average rent price
for properties that managed by each branch.

SELECT branchNo, AVG(rent) FROM propertyforrent
GROUP BY branchNo

Please write a SQL query that lists all flats
that has more than 3 but less than 6 rooms and located in London or Glasgow.

SELECT * FROM propertyforrent
WHERE propertyType = "Flat" AND city = "Glasgow" OR city = "London"
HAVING COUNT(rooms) > 3 AND COUNT(rooms) < 6

Please write a SQL query that returns the average rent price
for properties that were viewed by the client ‘CS56’.

SELECT AVG(rent) FROM Viewing v
JOIN propertyforrent p ON v.propertyNo = p.propertyNo
WHERE v.clientNo = "CR56"

Please write a SQL query that returns the number of flats in each city.

SELECT city, count(*) FROM propertyforrent
WHERE propertyType = "Flat"
GROUP BY city

Please write a SQL query that that prints the postcode
of branch offices that manage properties in Glasgow and London.

SELECT b.branchNo, b.postcode FROM branch b
JOIN propertyforrent p ON b.branchNo = p.branchNo
WHERE p.city = "Glasgow" AND p.city = "London"

-- SELECT p.branchNo, p.city FROM propertyforrent p
-- WHERE p.city = "Glasgow" or p.city = "London"

Please write a SQL query that returns staff number,
first and last names of all staff who was born after
October 10th 1950. (Use date format YYYY-MM-DD).

SELECT staffNo, fName, lName, DOB FROM staff
WHERE DOB > "1950-10-10"


-- Please write a SQL query that lists first
-- and last names of landlords who own more than two properties in Glasgow.

SELECT fName, lName FROM (SELECT fName, lName, pfr.ownerNo as tar FROM privateowner po
	JOIN propertyforrent pfr ON po.ownerNo = pfr.ownerNo
	WHERE pfr.city = "Glasgow") as ow
HAVING COUNT(ow.tar) > 2;

Please write a SQL query that returns the highest rent for a flat with 4 rooms.

SELECT MAX(rent) FROM propertyforrent
WHERE propertyType = "Flat"
HAVING COUNT(rooms) = 4

Please write a SQL query that lists all properties that were viewed by client’s
with client numbers ‘CR56’ and ‘CR76’ and received a comment from those clients
(Hint: comment column doesn’t have a null value).

SELECT propertyNo FROM (SELECT comments, propertyNo FROM Viewing v1
WHERE clientNo = "CR56" OR clientNo = "CR76") as com
WHERE com.comments IS NOT NULL

--17
Please write a SQL query that lists all staff members who have
the letter ‘o’ in their last name or first name.

-- don't twist things to your vision
-- SELECT * FROM (SELECT * FROM staff WHERE fName LIKE "%o%") R1
-- JOIN
-- (SELECT * FROM staff WHERE lName LIKE "%o%") R2 ON R1.staffNo = R2.staffNo

SELECT * FROM staff
WHERE fName LIKE "%o%" OR lName LIKE "%o%" 

Please write a SQL query that compiles a list of properties that can be afforded by the client ‘CR76’. The list should include property number, street, city, type, rooms and rent.


--18 nothing to join on
SELECT * FROM propertyforrent pfr
WHERE pfr.rent < (SELECT maxRent FROM client
WHERE clientNo = "CR76")

Please write a SQL query that lists the first and
last names of staff members who showed a property of Joe Keogh.

--19
SELECT s.fName, s.lName FROM Viewing vi
JOIN PropertyForRent pfr ON pfr.propertyNo = vi.propertyNo
JOIN privateowner po ON po.ownerNo = pfr.ownerNo
JOIN Staff s ON s.staffNo = pfr.staffNo
WHERE po.fName = 'Joe' AND po.lName = 'Keogh';


Please write a SQL query that lists first and last names of landlords who own propertie(s)
in London.

SELECT po.fName, po.lName FROM privateowner po
JOIN PropertyForRent pfr ON po.ownerNo = pfr.ownerNo
WHERE pfr.city = "London"