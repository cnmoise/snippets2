With R as (
select  nozone, noplace, norang from lessieges
minus 
(
select nozone, noplace, norang from lestickets natural join lessieges
where nospec = 2 AND to_char(daterep, 'DD-MON-YY') = '07-MAR-17'
)
) 
select distinct r3.noplace - r1.noplace as place_cac , R1.noplace as noplace,  R1.norang as rang, R1.nozone as zone  from  R R1 
join R R2 on (R1.norang = R2.norang AND R2.nozone = R1.nozone)
join R R3 on (R1.norang = R3.norang AND R3.nozone = R1.nozone ) 
where (r3.noplace - R1.noplace > 11) AND (R1.noplace < R3.noplace) AND ((R1.noplace = R2.noplace+1) OR (R1.noplace+1 = R2.noplace) OR (R1.noplace = R3.noplace+1) OR (R1.noplace+1 = R3.noplace) OR (R2.noplace = R3.noplace+1) OR  (R2.noplace+1 = R3.noplace))
order by place_cac, R1.norang;

-- La requete dans le with selectionne toutes les places existantes, sauf celle déjà reservé


