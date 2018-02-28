set linesize 500;
ALTER SESSION SET CURRENT_SCHEMA = repas;

--selects the person who has been invited the most often as well as his favorite plate
--
--IN pulls from subquery, sub asks for InvName which has a count equal to the the maximum count
--

prompt 'Q1';
select nomA, nomP from LesPreferences
where nomA in (select nomI from LesRepas group by nomI having count(dateR)
= (select max(count(dateR))from LesRepas group by nomI));

/*
--alt ver doesn't use in, needs to have the last join line to compensate
prompt 'Q1 alt';
select nomI, nomP
from (select nomI from LesRepas
group by nomI
having count(dateR) = (select max(count(dateR))
      		       from LesRepas
		       group by nomI)
) join LesPreferences on (nomI = nomA);*/

--Table acronyms - as = creates a column called num
--give the name of the invited who appreciated the biggest number of plates
--takes join so we can match invited to their aimes and plates from the menu w ones from preferences
--in = selects meal date from subquery(selects 3 things, meal date, nom invited, #of invited)
--I guess max selects the maximum of invited as num

--I have no clue how this querry works

prompt 'Q2';
select dateR, nomI from LesRepas r natural join LeMenu m
JOIN LesPreferences p on (r.nomI = p.nomA and m.nomP = p.nomP)
group by nomI, dateR 
having (dateR, count(nomI)) 
in (select dateR, max(num) from (select dateR, nomI, count(nomI) as num 
from LesRepas r natural join LeMenu m JOIN LesPreferences p on (r.nomI = p.nomA and m.nomP = p.nomP)
group by nomI, dateR)
group by dateR);

/*
(select max(count(nomP))
from LeMenu natural join LesRepas
group by dateR);*/


--creates a joined table, shows the  number of fortunate guests, those who got a served a favorite dish
--matches inv to likes --matches the date the meal was had with the actual meal as well as the preference
prompt 'Q3';
/* select distinct M.dateR, nomI,
from LesRepas R join LesPreferences P on (R.nomI = P.nomA) join leMenu M on (R.dateR=M.dateR and P.nomP = M.nomP);
*/

--alt union creates another query for the case for when there is no lucky person
--subquery matches ppl w their preferences, and plates from the pref to plates served on the menu
--why do we have to take the counts in separate intervals?
select dateR, count(nomI)
from
(
select dateR, nomI, count(P.nomP) nbPA
from LesRepas natural join LeMenu M 
join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
group by dateR, nomI
)
group by dateR
union
(select dateR, 0
from LesRepas
where dateR not in (select dateR
      	    	   from LesRepas natural join LeMenu M 
		   join LesPreferences P on (P.nomA = nomI and P.nomP = M.nomP)
		   group by dateR, nomI
		   ));



prompt 'Q4';
--looks for the ppl who have had a dish of each type at least once
--at least 1 = distinct
--need distinct typeP because there are some multiple plates of a single type
--
--selects a person then counts the maximum number of plates had by that person
---why doesn't a regular count cut it?
--creates the minimum amt to be on the list: select count (distinct typeP) from LesPlats

select distinct nomA
from LesPreferences natural join LesPlats
where (select max(count(nomP)) from LesPreferences group by nomA) >= (select count (distinct typeP) from LesPlats); 

prompt'Q4 alt'
--I guess we can just repeat the same querry wince were technically looking for the same number
--if a person has sampled a count that is equal to the distinct number of plates 
select nomA
from LesPreferences natural join LesPlats
group by nomA
having count(distinct typeP) = (select count(distinct typeP) from LesPlats);

prompt'Q5'
--Base query gives numbers for each date a meal is org
--some ppl are invited more than once!!!!
select dateR, count(nomI) from LesRepas group by dateR;

select  to_char(dateR, 'MON-YYYY'), count(distinct nomI)
from LesRepas
group by to_char(dateR, 'MON-YYYY');

prompt'Q6'
/*
select nomP, nomV, count(nomV) from LeMenu
where((select max(count(nomV)) from LeMenu) = select count(distinct nomV) from LeMenu)
group by nomP, nomV;
--having count(distinct nomV) = ;


select R.nomP, vins.nomV, count(R.dateR) from LeMenu R
join LeMenu vins
on R.nomP = vins.nomV
group by R.nomP, vins.nomV;*/


--wine col and meal col are buddies
-- R1 querry- counts nb of times a specific meal and wine combo has happened
-- gets the most often occuring combo?
--R2 querry- counts the nb of occ of wine
--at the end we match them up
--second group by to satisfy max
-- coppy the same querry, 

--HOW DOES THIS MAKE SENSE, we select the exact same thing twice and then just match the two tables up, what kind of comparison did we do?

select R1.nomP, R1.nomV, R1.nbocc
from
(
select nomP, nomV, count(dateR) as nbocc
from LeMenu
group by nomP, nomV
) R1
join
(
select nomP, max(nbocc) as Mnbocc
	from
	(
	select nomP, nomV, count(dateR) as nbocc
	from LeMenu
	group by nomP, nomV
	)
	group by nomP ) R2 on (R1.nomP = R2.nomP and R1.nbocc = R2.Mnbocc);


prompt 'Q7'
--going down and selecting each nickname

select nomI, nbinv, nbpa, nbtpa
from
(select nomI, count(dateR) nbinv
from LesRepas
group by nomI) 
join 
(select nomA, count(nomP) nbpa, count(distinct typeP) nbtpa
from LesPreferences natural join LesPlats
group by nomA) 
on (nomI = nomA);
--done so we don't repeat aimes and invites

