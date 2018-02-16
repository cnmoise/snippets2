set linesize 500;
alter session set current_schema=moisecl;
-- describe
alter session  set nls_date_format="DD/MM/YYYY HH24:MI:SS";

drop table LesTickets;
drop table LesDossiers;
drop table LesRepresentations;
drop table LesSpectacles;
drop table LesSieges;
drop table LesZones;
drop table LesCategories;

create table LesCategories (nomC varchar2(20) constraint c_pk primary key, prix number(8,2) not null,
	constraint c_ck1 check(prix > 0),
	constraint c_ck2 check(nomC in ('orchestre','1er balcon', '2nd balcon', 'poulailler'))
	);

create table LesZones(noZone number(2) constraint z_pk primary key, nomC varchar(30) not null,
	constraint z_fk foreign key (nomC) references LesCategories(nomC)
	);
	
create table LesSieges (noPlace number(4), noRang number(4), noZone number(2),
	constraint s_pk primary key (noPlace,noRang),
	constraint s_fk foreign key (noZone) references LesZones(noZone)
	);

create table LesSpectacles(noSpec number(4) constraint sp_pk primary key, nomS varchar(30) not null, duree number(4));

create table LesRepresentations(dateRep date constraint r_pk primary key, noSpec number(4) not null,
	constraint r_fk foreign key (noSpec) references LesSpectacles(noSpec)
	);

create table LesDossiers(noDossier number(5) constraint d_pk primary key, montant number(6,2) not null,
	constraint d_ck check(montant > 0)
	);
	
create table LesTickets(noSerie number(4) constraint t_pk1 primary key, noSpec number(4), dateRep date, noPlace number(4), noRang number(4), dateEmission date not null, noDossier number(4),
	constraint t_pk2 unique (noSpec, dateRep, noPlace, noRang),
	constraint t_fk1 foreign key (noPlace,noRang) references LesSieges(noPlace,noRang),
	constraint t_fk2 foreign key (noDossier) references LesDossiers(noDossier),
	constraint t_fk3 foreign key (noSpec) references LesSpectacles(noSpec), 
	constraint t_fk4 foreign key (dateRep) references LesRepresentations(dateRep),
	constraint t_ck2 check(dateEmission < dateRep),
	constraint t_ck3 check(noDossier > 0),
	constraint t_ck1 check(noSpec > 0),
	constraint t_ck4 check(noPlace > 0),
	constraint t_ck5 check(noRang > 0)
	);
	
insert into LesCategories select * from theatre.LesCategories;
insert into LesZones select * from theatre.LesZones;
insert into LesSieges select * from theatre.LesSieges;
insert into LesSpectacles select * from theatre.LesSpectacles;
insert into LesRepresentations select dateRep, noSpec from theatre.LesRepresentations;
insert into LesDossiers (noDossier, montant) select noDossier, sum(prix) as montant from theatre.LesTickets natural join theatre.LesSieges natural join theatre.LesZones natural join theatre.LesCategories group by noDossier;
insert into LesTickets select * from theatre.LesTickets;


