-- Test des questions du TD
set linesize 500;
--alter session set current_schema=biblio;
-- Q1
prompt 'Q1';
select titre, aned
from LeCatalogue;

-- Q2
prompt 'Q2';
select noAdh, nom, prenom,adresse
from LesAdherents
where anNais > 1960;

-- Q3
prompt 'Q3';
select distinct nom, prenom
from LeCatalogue natural join LeFonds
order by nom;

-- Q4
prompt 'Q4';
select noAdh
from LesAdherents
 	 minus
select noAdh
from LesEmprunts;

-- Q5
prompt 'Q5';
select cote, noAdh from LesEmprunts;

select noAdh
from LesEmprunts
minus
select noAdh
from LesEmprunts
where cote = 8 or cote = 3 or cote = 2;

-- Q6
prompt 'Q6';
select cote, titre, anEd from LeCatalogue natural join LeFonds;

select cote, titre
from LeCatalogue natural join LeFonds
where anEd >= 1980;

-- Q7
prompt 'Q7';
select distinct nom,prenom,noAdh
from LesAdherents
where noAdh in
(select noAdh
from LesEmprunts
where cote in 
(select cote
from LesEmprunts
minus
select cote
from LeFonds natural join LeCatalogue
where nom <> 'Herbert' and prenom <> 'Franck')) order by nom;

-- Q8
prompt 'Q8';
select nom,prenom
from LesAdherents
intersect
select nom,prenom
from LeCatalogue;

-- Q9
prompt 'Q9';
select c1.titre, c2.titre, c1.anEd
from LeCatalogue c1 join LeCatalogue c2 on (c1.anEd = c2.anEd)
where c1.nom <> c2.nom and c1.prenom <> c2.prenom and c1.titre<c2.titre;

