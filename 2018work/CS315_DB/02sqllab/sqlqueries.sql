
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
