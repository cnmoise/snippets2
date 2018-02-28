set linesize 500;

prompt 'Q1';
select nomV from LeMenu where nomP='Medaillon langouste';

prompt 'Q2';
select nomP, nomV from LeMenu where dateR='21-OCT-03';

prompt 'Q3';
select nomI from LesRepas
minus
select nomA from LesPreferences;

prompt 'Q3 v2';
select distinct nomA 
from LesPreferences
where nomA not in (select nomI from LesRepas);

prompt 'Q4';
select dateR, nomP, nomV from LesRepas R join LesRepas M using (dateR) natural join LeMenu 
where R.nomI='Jacques' and M.nomI='Thomas';

prompt 'Q4 v2';
select dateR, nomP, nomV from LesRepas natural join LeMenu where nomI='Jacques' 
intersect 
select dateR, nomP, nomV from LesRepas natural join LeMenu where nomI='Thomas';


prompt 'Q5';
select distinct nomI from LesRepas natural join LeMenu M join LesPreferences P on (P.nomP = M.nomP)
where P.nomP = M.nomP;

prompt 'Q6';
select distinct R1.nomI from LesRepas R1 join LesRepas R2 on (R1.nomI = R2.nomI) 
where R1.dateR <> R2.dateR;

prompt 'Q6 v2';
select nomI from
(select count(nomI) as nb, nomI from LesRepas group by nomI)
where nb >=2;

prompt 'Q7';
select distinct R1.nomI from LesRepas R1 join LesRepas R2 on (R1.nomI = R2.nomI) where R1.dateR <> R2.dateR
minus
select distinct R1.nomI from LesRepas R1 join LesRepas R2 on (R1.nomI = R2.nomI) join LesRepas R3 on 
(R2.nomI = R3.nomI) 
where R1.dateR <> R2.dateR and R2.dateR <> R3.dateR and R1.dateR <> R3.dateR;

prompt 'Q7 v2';
select nomI from
(select count(nomI) as nb, nomI from LesRepas group by nomI)
where nb=2;

prompt 'Q8';
select distinct nomI from LesRepas R join LesPreferences P on (R.nomI=P.nomA) natural join LesPlats
where typeP='dessert';

prompt 'Q9';
select distinct nomI from LesRepas natural join (
select dateR from LeMenu M join LesPreferences P on (M.nomP <> P.nomA)
group by dateR);

prompt 'Q10';
select nomI from LesRepas natural join LeMenu where nomP='Foie gras'
minus
select nomA from LesPreferences where nomP <> 'Foie gras';

prompt 'Q11';
select dateR, nomP, nomV, nomI
from LesRepas natural join LeMenu
minus
select r1.dateR, nomP, nomV, r1.nomI
from LesRepas r1 join LesRepas r2 on (r1.dateR < r2.dateR) join LeMenu m on (r1.dateR = m.dateR);

prompt 'Q11 v2';
select distinct dateR,nomI, nomP, nomV from LesRepas natural join LeMenu
where dateR in
(select max(dateR) from LesRepas);

prompt 'Q12';
select nomI
from LesRepas
group by nomI
having count(dateR) = (select count (distinct dateR) from LesRepas);

prompt 'Q12 v2';
select nomI from LesRepas
minus
select nomI from
(select R1.dateR, R2.nomI from LesRepas R1 cross join LesRepas R2 
minus
select dateR, nomI from LesRepas);



