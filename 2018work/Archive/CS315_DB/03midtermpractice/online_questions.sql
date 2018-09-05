--1) https://www.pgexercises.com/questions/joins/simplejoin.html

SELECT starttime FROM cd.members m
JOIN cd.bookings b on m.memid = b.memid
WHERE m.firstname = "David" AND m.surname = "Farrell"


SELECT bks.starttime 
	from 
		cd.bookings bks
		inner join cd.members mems
			on mems.memid = bks.memid
	where 
		mems.firstname='David' 
		and mems.surname='Farrell'; 

-- 2) https://www.pgexercises.com/questions/joins/self.html
SELECT DISTINCT m1.firstname, m1.surname FROM cd.members m1
INNER JOIN cd.members m2 on m1.memid = m2.recommendedby
ORDER BY m1.surname, m1.firstname

--
select distinct recs.firstname as firstname, recs.surname as surname
	from 
		cd.members mems
		inner join cd.members recs
			on recs.memid = mems.recommendedby
order by surname, firstname;         

-- 3) https://www.pgexercises.com/questions/joins/self2.html
SELECT m1.firstname AS recfname, m1.surname AS recsname FROM cd.members m1
INNER JOIN cd.members m2 on m1.memid = m2.recommendedby
ORDER BY m1.surname, m1.firstname

SELECT m2.firstname AS memfname, m2.surname AS memsname
WHERE m2.memid = m1.recommendedby
--

select mems.firstname as memfname, mems.surname as memsname,
recs.firstname as recfname, recs.surname as recsname
	from 
		cd.members mems
		left outer join cd.members recs
			on recs.memid = mems.recommendedby
order by memsname, memfname;     

-- 4) https://www.pgexercises.com/questions/joins/threejoin.html

-- || ' ' || concatenates string and places a space between
-- (0,1) probably reffers to the DB's ID's for the tennis courts

SELECT distinct m.firstname || ' ' || m.surname as member, f.facid, name as facility
FROM cd.facilities f
	JOIN cd.bookings b on f.facid = b.facid
	JOIN cd.members m on m.memid = b.memid
WHERE b.facid in (0,1)
order by member; 

---
select distinct mems.firstname || ' ' || mems.surname as member, facs.name as facility
	from 
		cd.members mems
		inner join cd.bookings bks
			on mems.memid = bks.memid
		inner join cd.facilities facs
			on bks.facid = facs.facid
	where
		bks.facid in (0,1)
order by member

-- 5) https://www.pgexercises.com/questions/joins/sub.html

select mems.firstname as memfname, mems.surname as memsname,
recs.firstname as recfname, recs.surname as recsname
	from 
		cd.members mems
		left outer join cd.members recs
			on recs.memid = mems.recommendedby
order by memsname, memfname;     

--Interesting Tech:
--Query as a selection field

select distinct mems.firstname || ' ' ||  mems.surname as member,
	(select recs.firstname || ' ' || recs.surname as recommender 
		from cd.members recs 
		where recs.memid = mems.recommendedby
	)
	from 
		cd.members mems
order by member;     