
<?php
// Lorsqu'une personne clic sur le bouton reinitiliser, on se redirige vers cette même page
// et une variable est passé en "GET", on execute en fonction de quel action est à faire.
include('entete_hureauo.php');
if(isset($_GET['action'])){
		include('action.php');
		
	}
// Nos variable session nospec et date nous servirons plus tard lors du paiement
// de plus ca permet a ce qu'une personne, lors d'un retour arriere puisse rester sur le même spectacle.
if(isset($_GET['date'])){
	$_SESSION['date'] = $_GET['date'];
if(isset($_GET['nospec'])){
	$_SESSION['nospec'] = $_GET['nospec'];
}
}

?>

<?php

echo '<p><a href="reserver.php?action=reset_cookie"><input type="button" value="Réinitialiser les sieges/cookies"></input></a></p>';
echo '<p><a href="recherche.php"><input type="button" value="Retour recherche"></input></a></p>';
echo '<p><a href="payer.php"><input type="button" value="Passer au paiement"></input></a></p>';
// On recupere les noms des zones affin de creer la variable zone
//$zone['nb_zone'] renvoi le nombre de zone
//$zopne['nom_zone'][n] renvoie le nom de la zone n 


$requete = ("SELECT nomc
		FROM LesZones");

	$curseur = oci_parse ($lien, $requete) ;

	
		$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
	
	
	}
	else {

		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);

		if (!$res) {
			echo "Erreur, la requete n'as pas aboutie";

		}
		else {
			$min_rang=array();
			$zone = array();
			$zone['nb_zone']=0;
			
			do{
			$var=oci_result($curseur,1);
			$zone['nb_zone']++;
			$zone['nom_zone'][$zone['nb_zone']] = $var ;
			
			
				
		
			} while(oci_fetch($curseur));	
		}
	}

	// on libère le curseur
	oci_free_statement($curseur);

	

?>






<?php

// On recupere ici les variables neccesaire a la creation de la variable siege.
// ELle permet un affichage visuel

// $siege["nom_de_la_zone"][0] renvoie le nombre de rang dans la zone
//$siege["nom_de_la_zone"][n][0] renvoie le nombre de place dans le rang n dans cette zone
// $siege["nom_de_la_zone"][n][m] renvoie la valeur du siege en rang n, place m, zone nom de la zone

// Ici, nous avons définis 0 = La place est occupé (en cas d'erreur du serveur, elle seront tout occupé)
// 1 la place est reservable
// -1 vous êtes en train de reserve la place.

// Il est tout a fait possible de rajouter d'autre variable tel que : quelqu'un d'autre reserve la place
// Ou même encore : ceci sont des places cotes a cotes comme vous le souhaitiez

$requete = ("select max(noplace), min, norang, nozone from lessieges natural join (select min(norang) as min, nozone from lessieges group by nozone) group by nozone, norang, min");

	$curseur = oci_parse ($lien, $requete) ;

		$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
	
	
	}
	else {

		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);

		if (!$res) {
			echo "Erreur, la requete n'as pas aboutie";

		}
		

		else {
			
			$siege = array();
			for($i = 1; $i <= $zone['nb_zone']; $i++){
				$nom_zone=$zone['nom_zone'][$i];
				$siege[$nom_zone] = array();
				$siege[$nom_zone][0] = array();			
				$siege[$nom_zone][0][0] = 0;
				
				}
			
		do{
		$nb_place=oci_result($curseur,1);
		$min=oci_result($curseur,2);
		$no_rang=oci_result($curseur,3);
		$no_rang_aff=$no_rang-$min+1;
		$no_zone=oci_result($curseur,4);	
		$nom_zone=$zone['nom_zone'][$no_zone];
		$siege[$nom_zone][0][0]++;
		$siege[$nom_zone][0][$no_rang_aff] = $nb_place;
		$max_rang[$nom_zone] = $min;
		
						
		
		} while(oci_fetch($curseur));	








			for($i = 1; $i <= $zone['nb_zone']; $i++){
				$nom_zone = $zone['nom_zone'][$i];
				for($j=1; $j <= $siege[$nom_zone][0][0] ; $j++){
					$siege[$nom_zone][$j] = array();
					
					
					for($k = 0; $k <= $siege[$nom_zone][0][$j]; $k++){
						$siege[$nom_zone][$j][$k] = 1;
					
					}			
					
				}

			}
			
			
			
			
			
		}
	}

	// on libère le curseur
	oci_free_statement($curseur);


echo "<br></br>";
$date_spec = $_SESSION['date'];
$nospec= $_SESSION['nospec'];

// On recupere ici les tickets, soit les places déjà reservé pour ce spectacle
// On viendra alors modifier la variable siege à 0;

$requete =  ( "SELECT noplace, norang, nozone
from lestickets natural join lessieges where ( nospec = $nospec )  AND  ( to_char((to_date(daterep, 'DD/MM/YYYY HH24:MI:SS')), 'DD-MON-YY' ) =  '$date_spec' ) ");


$curseur = oci_parse ($lien, $requete) ;

	
		$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {


		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
	
	}
	else {

		// oci_execute a réussi, on fetch sur le premier résultat		
		while(oci_fetch($curseur)) {
			$noplace=oci_result($curseur,1);
			$norang=oci_result($curseur,2);
			$nozone=oci_result($curseur,3);
			$nomzone=$zone['nom_zone'][$nozone];
			$norang = ($norang - $max_rang[$nomzone]+1);
			
			
			$siege[$nomzone][$norang][$noplace] = 0;
			
				
		
			} 	
			
	

		
	}
	

	// on libère le curseur
	oci_free_statement($curseur);







?>




<?php

// On récupère les reservations dans le cookie, que s'il est déjà crée
if(isset($_COOKIE['reservation'])){
	$resa = unserialize($_COOKIE['reservation']);
}

// S'il n'y avais pas de reservations en cours par l'utilisateur (cookie resevration), on cree la variable
// Ici resa est construite de telle maniere
// $resa["nom_de_la_zone"][0] = le nombre de reservation pour cette zone
// $resa["nom_de_la_zone"][n]["place"] est le numéro de place de la n reservation de la zone
// $resa["nom_de_la_zone"][n]["rang"] est le numéro du rang de la n reservation de la zone

if(!isset($resa)){
	echo "Faite votre choix ! ";
	$resa = array();
	for($nb_zone = 1; $nb_zone <= $zone['nb_zone'] ; $nb_zone++){
		$nom_zone = $zone['nom_zone'][$nb_zone];
		$resa[$nom_zone] = array();
		$resa[$nom_zone][0]=0;
		
		
	}
}
// Si la variable résa n'est pas créer, on la cré..
// On regarde si y'a des warnings !
// Pour chaque zone
// Un warning est le faite qu'entre différentes actualisations de la page
// La place a était reservé
// On affiche alors une alerte est la case passe en rouge..
// Même si la fonctionnalité d'Insert des tickets on peux tester les warnings en :
// Reservant un place n rang m de la zone z et set la variable :
// $siege[z][n][m] =0;
// On vois bien que l'erreur s'affiche


for($no_zone = 1; $no_zone <= $zone['nb_zone'] ; $no_zone++ ){
	$nom_zone = $zone['nom_zone'][$no_zone];
	// Si la variable resa existe
	// On verifie que pour chaque reservtion, le siege est libre
	
	if(isset($resa[$nom_zone][0])){
		// Tant qu'il y a eu des résas
		
		for($i = $resa[$nom_zone][0] ; $i >= 1 ; $i-- ){
			if($siege[$nom_zone][$resa[$nom_zone][$i]['rang']][$resa[$nom_zone][$i]['place']] == 0){
					if(!isset($warning)){
						$warning=array();
						$warning[0] = 0;
					}
						$warning[0]++;
						$warning[$warning[0]] = array();
						$warning[$warning[0]]['zone'] = $nom_zone;
						$warning[$warning[0]]['place'] = $resa[$nom_zone][$i]['rang'];
						$warning[$warning[0]]['rang'] = $resa[$nom_zone][$i]['place'];
			}
		}
	}
}

// Si on a eu des warnings on les traites (passage en rouge, suppresion de la resevration dans les cookies) 

if(isset($warning)){
	while($warning[0] != 0){
		$zone_warning = $warning[$warning[0]]['zone'];
		
		$no_warning=$warning[0];
		$i=1;
		
		
		
		
		
		while($resa[$zone_warning][$i]['rang']!= $warning[$no_warning]['rang'] AND $resa[$zone_warning][$i]['place']!= $warning[$no_warning]['rang']){
			$i++;
		}
		
		while($i < $resa[$zone_warning][0]){
			$resa[$zone_warning][$i]['rang'] = $resa[$zone_warning][$i+1]['rang'] ;
			$resa[$zone_warning][$i]['place'] = $resa[$zone_warning][$i+1]['place'] ;
			$i++;
		}
			unset($resa[$zone_warning][$i+1]);
			$resa[$zone_warning][0]--;
			$siege[$zone_warning][$resa[$zone_warning][$i]['rang']][$resa[$zone_warning][$i]['place']] = 0;
		echo "<p> Place ";
			echo $warning[$no_warning]['place'];
			echo " et rang : ";
			echo $warning[$no_warning]['rang'];
			echo " a était reservé par quelqu un d'autre.. </p>";
			$warning[0]--;
	}	
}
?>

<?php 
// On met a jour les sieges que le client souhaite reservé
// Pour chaque zone

for($no_zone = 1; $no_zone <= $zone['nb_zone'] ; $no_zone++ ){
	
	$nom_zone = $zone['nom_zone'][$no_zone];
	
	for ($no_resa = 1; $no_resa <= $resa[$nom_zone][0] ; $no_resa++){
		$siege[$nom_zone][$resa[$nom_zone][$no_resa]['rang']][$resa[$nom_zone][$no_resa]['place']] = -1;		
	}
}



?> 


<?php
//SI le client a précédement cliqué sur une des places, ces coordonés sont envoyé par URL et traité ici

if(isset($_GET['rang']) AND isset($_GET['place']) AND isset($_GET['zone'])   ){
	
	switch($siege[$_GET['zone']][$_GET['rang']][$_GET['place']]){
		case 1:
		// Si vert, on passe au bleu 
		// Et on ajoute la variable dans $resa
			$resa[$_GET['zone']][0]++;
			$nom_zone = $_GET['zone'];
			$no_resa = $resa[$nom_zone][0];
			$resa[$nom_zone][$no_resa] = array();
			$resa[$nom_zone][$no_resa]['rang']=$_GET['rang'];
			$resa[$nom_zone][$no_resa]['place']=$_GET['place'];
			$siege[$nom_zone][$_GET['rang']][$_GET['place']] = -1;			
			break;
		// Si bleu passe au vert
		// et on supprimé la varible dans $resa
		case -1:
			$i=1;
			$nom_zone = $_GET['zone'];
			$no_resa = $resa[$nom_zone][0];	
			
			
			while($i<=$resa[$nom_zone][0]){
				
				
				if($resa[$nom_zone][$i]['rang'] == $_GET['rang'] AND $resa[$nom_zone][$i]['place'] == $_GET['place']){
					$compteur=$i;
				}
				$i++;
			}
		
			$siege[$nom_zone][$resa[$nom_zone][$compteur]['rang']][$resa[$nom_zone][$compteur]['place']] = 1;
			
			while( $compteur < $resa[$nom_zone][0]  ){
				$resa[$nom_zone][$compteur]['place']=  $resa[$nom_zone][$compteur+1]['place'];
				$resa[$nom_zone][$compteur]['rang']=  $resa[$nom_zone][$compteur+1]['rang'];
				$compteur++;
				
			}
			$resa[$nom_zone][0]--;
			break;		
		default:
		
			
	}

}
// En envoie notre variable resa au cookie resa, nous n'y toucherons désormais plus dans ce chargement de page
setcookie('reservation',serialize($resa), time()+300, "/");

?>


<?php
// Comme tout nos sieges dans la variable résa on la bonne valeur, on les affices !

for($k=1; $k <= $zone['nb_zone'] ; $k++){
	echo " ";
	$nom_zone = $zone['nom_zone'][$k] ;
	echo $zone['nom_zone'][$k];
	echo '<div class="zone_salle">';

	for($i=1; $i <= $siege[$nom_zone][0][0] ; $i++){
		echo '<ul class="salle"> Rang #'.$i;
		for($j=1; $j<=$siege[$nom_zone][0][$i]; $j++){
			echo "<li>";
			echo '<a href="reserver.php?rang='.$i.'&amp;place='.$j.'&amp;zone='.$nom_zone.'">';
			if($siege[$nom_zone][$i][$j]==1){
				echo '<div class="place_libre">';			
			} else if ($siege[$nom_zone][$i][$j]==0){
				echo '<div class="place_occupe">';			
			} else {
				echo '<div class="place_en_resa">';
			}

				echo "$j"; 
			echo "</div>";
			echo "</a>";
			
			echo "</li>";		
		}
		echo "</ul>";
	}
	
	echo "</div>";
	



}



?>

<?php

include('pied.php');

?>
