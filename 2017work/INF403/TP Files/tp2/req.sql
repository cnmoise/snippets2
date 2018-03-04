ALTER SESSION SET CURRENT_SCHEMA = repas;
-- uses this schema name as the schema qualifier when the qualifier is omitted. 

prompt 'Question 1';

Select nomV from leMenu where nomP = 'Foie gras';

prompt 'Question 2';

Select nomP, nomV from leMenu where dateR = '21-OCT-03';

--3

Select nomI from LesRepas
minus
Select nomA from LesPreferences;
--nomA are people from a different db- one which lists 
--if they are not in nom I it means they haven't been invited

--3 Alt
--don't prematurely interrupt your query
Select distinct nomA from LesPreferences
where nomA not in (select nomI from LesRepas);

--4

--because they are in the same table but different rows, we must select the rows indiv.
--we create a table for Thomas and one for Jacques
--then we see what those tables have in common, namely the dates they both were invited
Select dateR, nomP, nomV from LesRepas R join LesRepas M using (dateR)
natural join leMenu
where R.nomI='Thomas' AND M.nomI='Jacques';

--4 Alt

--same story as above
Select dateR, nomP, nomV from LesRepas natural join leMenu where nomI='Thomas' 
intersect
Select dateR, nomP, nomV from LesRepas natural join leMenu where nomI='Jacques';


--5
Select distinct nomA from LeMenu natural join LesPreferences;

--why does the above work better?
prompt 'Q5';
select distinct nomI from LesRepas natural join LeMenu M join LesPreferences P on (P.nomP = M.nomP)
where P.nomP = M.nomP;

--6
--where the dates aren't the same (means that they've been twice at least
--Join on the same patron R1 &R2 - better exp
--Whereas above Tomas and Jacques shared the same dates, the 2 dates share the same person
--that is why we self reference here
--this shared attribute is what we join on
select distinct R1.nomI from LesRepas R1 join LesRepas R2 on (R1.nomI = R2.nomI)
where R1.dateR <> R2.dateR;

--6 alt
--count is an aggregation funct, therefore we need to group by (
Select nomI from 
(select count(nomI) as nb, nomI from LesRepas group by nomI)
where nb >= 2;

--7 -- very brute force - there has to be a better version of this that doesn't use aggregate functions
select distinct R1.nomI from LesRepas R1 join LesRepas R2 on (R1.nomI = R2.nomI)
where R1.dateR <> R2.dateR;
minus
select distinct R1.nomI from LesRepas R1 join LesRepas R2 on (R1.nomI = R2.nomI)
join LesRepas R3 on (R2.nomI = R3.nomI)
where R1.dateR <> R2.dateR and R2.dateR <> R3.dateR and R1.dateR <> R3.dateR;
--basically we exclude the one that has 3 different dates, doesn't really handle more


--7 alt
--count is an aggregation funct, therefore we need to group by (
Select nomI from 
(select count(nomI) as nb, nomI from LesRepas group by nomI)
where nb == 2;
*/
--8
--distinct because ppl have been invited multiple times
--of our invited people, we look at who liked what

Select distinct nomI from LesRepas R
join LesPreferences P on (R.nomI=P.nomA)
natural join LesPlats
where typeP = 'dessert';

--9 -- RE
--natural join from what
--() creates a table T, which we then use the natural join on
--the () query does most of the legwork - creating a table that lists the plates served
--and where there was a mismatch between plate and pref
--however we have no identities of whose pref and plate did not match 
--the join simply combines that with the identities of the people
--selects the people who have not had a favorite dish
--
Select distinct nomI from LesRepas natural join 
(select dateR from LeMenu M join LesPreferences P on (M.nomP <> P.nomA));

--10
--first find the ppl who ate foie fras, invitations are in Repas, food in LeMenu
--then we look at people who had a preference different from foiegras
--results in giving us the ppl who ate foie gras even though it wasnt a fav
select nomI from LesRepas natural join LeMenu where nomP = 'Foie gras'
minus
select nomA from LesPreferences where nomP <> 'Foie gras';

--11 -- RE
--give the menu of people invited most recently
--why do we need a minus here?
--how exactly does this bring us the most recent entries?
--assigns a date to each order, using date as the joining point
select dateR, nomI, nomV, nom P
from LeMenu M natural join LesRepas
minus
select r1.dateR, nomP, nomV, r1.nomI
from LesRepas r1 join LesRepas r2 on (r1.dateR < r2.dateR)
join LeMenu m on (r1.dateR = m.dateR);

--12
--count distinct dateR bc multip meals a day
--select the person who has a date count equal to the total number that have ever been
select nomI from LesRepas
group by nomI
having count(dateR) = (select count (distinct dateR) from LesRepas);

--12 alt - no aggregates
--how the fuck does this cross join give us any kind of solution?
select nomI from LesRepas
minus
select nomI from (select R1.dateR, R2.nomI from LesRepas R1 cross join LesRepas R2)
minus
select dateR, nomI from LesRepas);
