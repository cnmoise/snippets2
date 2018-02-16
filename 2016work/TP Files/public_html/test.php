
<?php
include('entete.php');
?>

<?php
$requete = ("SELECT nomc
		FROM theatre.LesZones");

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
				$siege[$zone['nom_zone'][$i]] = array();
				$siege[$zone['nom_zone'][$i]][0] = array();			
				$siege[$zone['nom_zone'][$i]][0][0] = 0;
				
				
				}
			
			
			
			
			
			
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

// Si on a eu des warnings : 

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
	
			echo $warning[$no_warning]['place'];
			echo " et place : ";
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


if(isset($_GET['rang']) AND isset($_GET['place']) AND isset($_GET['zone'])   ){
	
	switch($siege[$_GET['zone']][$_GET['rang']][$_GET['place']]){
		case 1:
		// Si vert, on passe au bleu 
			$resa[$_GET['zone']][0]++;
			$nom_zone = $_GET['zone'];
			$no_resa = $resa[$nom_zone][0];
			$resa[$nom_zone][$no_resa] = array();
			$resa[$nom_zone][$no_resa]['rang']=$_GET['rang'];
			$resa[$nom_zone][$no_resa]['place']=$_GET['place'];
			$siege[$nom_zone][$_GET['rang']][$_GET['place']] = -1;			
			break;
		// Si bleu passe au vert
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
setcookie('reservation',serialize($resa), time()+300, "/");

?>


<?php


for($k=1; $k <= $zone['nb_zone'] ; $k++){
	echo " ";
	$nom_zone = $zone['nom_zone'][$k] ;
	echo $zone['nom_zone'][$k];
	echo '<div class="zone_salle">';

	for($i=1; $i <= $siege[$nom_zone][0][0] ; $i++){
		echo '<ul class="salle"> Rang #'.$i;
		for($j=1; $j<=$siege[$nom_zone][0][$i]; $j++){
			echo "<li>";
			echo '<a href="test.php?rang='.$i.'&amp;place='.$j.'&amp;zone='.$nom_zone.'">';
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
	for($i=1; $i <= $resa[$nom_zone][0] ; $i++ ){
	echo "".$resa[$nom_zone][$i]['rang'].";".$resa[$nom_zone][$i]['place'];
echo " $i";	
}



}
?>

<?php

include('pied.php');

?>
















