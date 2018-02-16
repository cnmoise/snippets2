<link rel="stylesheet" href="style.css" />


<?php 
$zone = array();
$zone['nb_zone']=2;
$zone['nom_zone'] = array();
$zone['nom_zone']['1'] = "Poullailer";
$zone['nom_zone']['2'] = "FBI";
?>


<?php
session_start();
//unset($_COOKIE['reservation']);
// A refaire avec requete SQL
$s=$zone['nom_zone']['2'];

$siege[$s][0][0]=6;
$siege[$s][0][1]=15;
$siege[$s][0][2]=12;
$siege[$s][0][3]=22;
$siege[$s][0][4]=11;
$siege[$s][0][5]=17;
$siege[$s][0][6]=5;

for($i=1; $i <= $siege[$s][0][0] ; $i++){
	for($j=1; $j<=$siege[$s][0][$i]; $j++){
		$siege[$s][$i][$j]=1;		
	}
}

$s=$zone['nom_zone']['1'];

$siege[$s][0][0]=6;
$siege[$s][0][1]=15;
$siege[$s][0][2]=12;
$siege[$s][0][3]=22;
$siege[$s][0][4]=11;
$siege[$s][0][5]=17;
$siege[$s][0][6]=5;
for($i=1; $i <= $siege[$s][0][0] ; $i++){
	for($j=1; $j<=$siege[$s][0][$i]; $j++){
		$siege[$s][$i][$j]=1;		
	}
}


?>

<?php

// On récupère les reservations dans le cookie, que s'il est déjà crée
if(isset($_COOKIE['reservation'])){
	$resa = unserialize($_COOKIE['reservation']);
}

if(!isset($resa)){
	echo "ca merde ! ";
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
	if(isset($resa['$nom_zone'])){
		// Tant qu'il y a eu des résas
		for($i = $resa[$nom_zone][0] ; $i > 0 ; $i-- ){
			if($siege[$nom_zone][$resa[$zone['nom_zone'][$nom_]]['rang']][$resa[$zone['nom_zone'][$no_zone]]['place']] == 0){
					if(!isset($warning)){
						$warning=array();
						$warning[0] = 0;
					}
						$warning[0]++;
						$warning[$warning[0]] = array();
						$warning[$warning[0]]['zone'] = [$zone['nom_zone'][$no_zone]];
						$warning[$warning[0]]['place'] = $resa[$zone['nom_zone'][$no_zone]]['place'];
						$warning[$warning[0]]['rang'] = $resa[$zone['nom_zone'][$no_zone]]['rang'];
			}
		}
	}
}

// Si on a eu des warnings : 

if(isset($warning)){
	while($warning[0] != 0){
		$zone_warning = $warning[$warning[0]]['zone'];
		$no_warning=1;
		while($resa[$zone_warning]['rang']!= warning[0][$zone_warning]['rang'] AND $resa[$zone_warning]['rang']!= warning[0][$zone_warning]['rang']){
			$no_warning++;		
		}
		while($no_warning < $resa[$zone_warning][0]){
			$resa[$zone_waning][$no_warning]['rang'] = $resa[$zone_waning][$no_warning+1]['rang'] ;
			$resa[$zone_waning][$no_warning]['place'] = $resa[$zone_waning][$no_warning+1]['place'] ;
			$no_warning++;
		}
			unset($resa[$zone_waning][$i+1]);
//			echo '<p><br>Votre réservation en zone '.$zone_warning.' rang '.warning[0][$zone_warning]["rang"].' et place '.warning[0][$zone_warning]["rang"].' a était reservé par quelqu un dautre.. </p>';
			$warning[0]--;
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
			break;
		default:

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

setcookie('reservation',serialize($resa), time()+3600, "/");
$_COOKIE['reservation'] = $resa;
?> 

<?php


for($k=1; $k <= $zone['nb_zone'] ; $k++){
	echo "<br> <br>";
	$nom_zone = $zone['nom_zone'][$k] ;
	echo $zone['nom_zone'][$k];
	echo '<div class="zone_salle">';

	for($i=1; $i <= $siege[$nom_zone][0][0] ; $i++){
		echo '<ul class="salle"> Rang #'.$i;
		for($j=1; $j<=$siege[$nom_zone][0][$i]; $j++){
			echo "<li>";
			echo '<a href="var2.php?rang='.$i.'&amp;place='.$j.'&amp;zone='.$nom_zone.'">';
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















