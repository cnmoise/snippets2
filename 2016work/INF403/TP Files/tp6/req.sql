set linesize 500;
set pagesize 200;
alter session set current_schema = camions;

prompt'Q1';
select NoP, noTr
from LesContrats;

prompt'Q2';
Select NoP, count(noTR), immat, marque
from LesContrats natural join LesCamions
group by NoP, immat, marque;

prompt'Q3';
select NoP, count(noC) from LesSecretaires
group by NoP;

prompt'Q4';
select NoP, count(noC), nom, prenom from LesSecretaires
natural join  LesPersonnes
group by NoP, nom, prenom;

prompt'Q5';
Select NoP, count(noC), nom, prenom, salaire, count(immat) from LesChauffeurs
natural join LesPersonnes
natural join LesContrats
natural join LesCamions
group by NoP, nom, prenom, salaire; 


prompt'Q6';
--reflechir
select noP, nbK
from (select noP, sum(nbK) as kmTotal
	from LesDistances natural join LesContrats
	group by noP)
	natural join LesChauffeurs
where nbK <> kmTotal;

prompt'Q7';
--reflechir, another way to have done this?
--is the natural join with the drivers necessary?
/*
select noP, nom, prenom from LesContrats 
	natural join LesChauffeurs
	group by noP, nom, prenom
	having = 

Select noP, nom, prenom from LesContrats
	natural join LesChauffeurs
	natural join LesCamions
	join LesContrats on  = nomV
		where lower(pays) = lower('&pays')
group by numC
	having count(vEtape) =
		(select count(nomV) 
		from LesVilles where
		lower(pays) = lower('&pays'));
*/

--with creates a subrequest r1 and r2
with r1 as (
	select noP, count(distinct immat) as tot
	from lesContrats
	group by noP),
r2 as (
	select count(immat) as tot2
	from lesCamions
	)
select noP, nom, prenom from LesChauffeurs
	natural join r1
	natural join r2
	natural join lesPersonnes
where tot = tot2;

prompt'Q8';
-- , at the end needed for syntax
-- you can natural join queries? or do these act more like table views?

--r1 gives the total nb of contrats belonging to client 4
--r2 gives the nb effectue (done)
--the 'count(noTR) as'(nicknames it as 'nbeff' adds up the count based on all the following attributes being the same
--Syntax error --j'ai de flemme
with r1 as (
	select count(noTr) as nbc
	from lesContrats
	where noC = 4
		group by noC
	),
r2 as (
	select count(noTr) as nbeff, noP, nom, prenom
	from lesChauffeurs natural join lesPersonnes natural join lesContrats
		where noC = 4
		group by noP, nom, prenom
	)
select noP, nom, prenom
	from r1 natural join r2
	where nbc = nbeff;
/*
select noP, nom, prenom
	from (
		select count(noTr) as nbc
		from lesContrats
		where noC = 4
			group by noC
		)
	natural join 
		(
		select count(noTr) as nbeff, noP, nom, prenom
		from lesChauffeurs natural join lesPersonnes natural join lesContrats
			where noC = 4
			group by noP, nom, prenom
		)
	where nbc = nbeff;
*/

prompt'Q9';
--reflechir -Oliv alt way
Select distinct C1.immat, C1.notr, C2.notr
from LesContrats C1 join LesContrats C2 on (C1.immat = C2.immat and
	C1.notr < C2.notr and C2.dateDep <= c1.dateArr and C1.dateDep <= C2.dateArr);

prompt'Q10';
--Reflechir
--select noP, immat, sum(nbK) as totK
	--from lesChauffeurs natural join lesContrats
with r1 as
	(
	select noP, immat, sum(nbk) as nbkim
	from lesContrats natural join lesChauffeurs
		group by nop, immat
	)
select nop, immat, max(nbkim) 
	from r1
	where nbkim in (select max(nbkim) from r1 group by noP)
	group by nop, immat;

prompt'Q11';
--

