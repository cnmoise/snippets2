
/*
prompt 'Question 1';
--how to ask for input, for testing use:
--where dateDep > '02/11/11';
-- &d REFFERS TO WHATEVER THE USER ENTERED
--I had a good concept, Tug did an input check
-- distinct needed?
--make sure that table names are accurate 
prompt 'taper la date qui tu veux';
accept d;

select distinct numC, vDep, vArr from LesCircuits natural join LesProgrammations
where dateDep > to_date('&d', 'DD/MM/YY');
*/
/*
prompt 'Question 2';
--who has not visited any monuments?

--notice the abreviations
--subquery: first find out who visited which cities (match client number and name)
---then we find out who has visited a monument in that city (match city that monument is in with city thats part of the etape

--We select all the clinets by their name, and use minus to select the clients that have visited a monument(otherwise they wouldn't be in the monuments table)
select nomC from LesReservations
minus
(
	select nomC from LesReservations R 
	join LesEtapes E 
		on (R.numC = E.numC)
	join LesMonuments M 
		on (M.nomV = E.vEtape)
);
*/


prompt 'Question 3';
--gives the client number, number of days, the base price of the circuit (which dont have a reservation right now)
--Sum = the total of days passed in each city (found in LesEtapes)
--R: Apparently you can't have comments in your query
--NOT IN: for rows where there is no numC val associated with the Reservation
--qui ave aucun de reservations maintenant
--

Select numC, prix, SUM(nbJours)
from LesCircuits natural join LesEtapes
where numC NOT IN (select numC from LesReservations)
group by numC, prix;


prompt 'Question 4';
--First fucking try :)
--vEtape == nomV (ville)

select vEtape from LesEtapes 
	natural join LesReservations R
where R.nomC = 'Milou';


prompt 'Question 5';
--join ___ on (differently named columns with corresponding values)
-- only one = needed

select vEtape, nomM from LesEtapes E
	natural join LesReservations R
	join LesMonuments M 
		on M.nomV = E.vEtape
where R.nomC = 'Milou';


prompt 'Question 6';
--group by essential to function, colapses all of the london entries under one name
-- if not we get a single function error
--we colapsed based on vEtape, the name of the city in the stages
--pretty simple, just need to think of where your stuff is coming from

select vEtape as Etape, count(M.nomM) as NombreMonuments from LesEtapes E
	natural join LesReservations R
	join LesMonuments M
		on M.nomV = E.vEtape
where R.nomC = 'Milou'
group by E.vEtape;


--gives the total price for the cities which millou visited, made up of the price of each monument
prompt 'Question 7';
select vEtape, sum(prix) from LesEtapes E
natural join LesReservations R join LesMonuments M on M.nomV = E.vEtape
where R.nomC = 'Milou'
group by E.vEtape;
--literally just switch count for price,

/*

--'&pays' uses a var entered by user --Syntax
-- distinct relates to au moins une pays
prompt 'Question 8';
prompt 'Entrez une pays:'
accept pays;
select distinct nomC from LesReservations R
natural join LesEtapes E join LesVilles v on vEtape = nomV
where pays = '&pays';

*/

/*
prompt 'Question 9';
prompt 'Entrez une nom:'
accept nom;

select vEtape, nomM, pays from LesEtapes E
natural join LesReservations R  natural join LesVilles join LesMonuments M on M.nomV = E.vEtape
where nomC = '&nom'
order by pays;
--join ___ on (differently named columns with corresponding values)
-- only one = needed*/


prompt 'Question 10';

prompt 'Entrez une pays:'
accept pays;
Select numC from LesCircuits
	natural join LesEtapes
	join LesVilles on vEtape = nomV
		where lower(pays) = lower('&pays')
group by numC
	having count(vEtape) =
		(select count(nomV) 
		from LesVilles where
		lower(pays) = lower('&pays'));

--Review
--2 wheres
--having - used to specify a search condition, for a GROUP or aggregate function
--use where before agregetion, use having after it takes place
--behaves like where if no Group by is present
--lower() changes it all to lowercase
--Why does it display a bunch of other stuff
