<link rel="stylesheet" href="style.css" />





<?php 



?>






<?php

$siege = unserialize($_COOKIE['cookie']);
unset($_COOKIE['cookie']);
$siege = unserialize($_COOKIE['cookie']);
?>



<?php
if(!isset($_SESSION['resa'])){
	$_SESSION['resa'] = array();
	$_SESSION['resa'][0] = 0;
}

// De plus on test si la BDD a pas changé..
for($i=1;$i <= $_SESSION['resa'][0] ; $i++){
// SI on catch une erreur, on crée des warnings
	if(	$siege[$_SESSION['resa'][$i]['rang']][$_SESSION['resa'][$i]['place']] == 0 ){
		if(!isset($warning)){
			$warning=array();
			$warning[0] = 0;
		}
	$warning[0]++;
	$warning[$warning[0]] = $i;
	}
}
// Si ya eu des warnings, on faite en sorte de régler le pb
if(isset($warning)){
	while($warning[0] != 0){
		$i=$warning[$warning[0]];
		while($i<$_SESSION['resa'][0]){
			$_SESSION['resa'][$i]['rang'] = $_SESSION['resa'][$i+1]['rang'];
			$_SESSION['resa'][$i]['place'] = $_SESSION['resa'][$i+1]['place'];
			$i++;
		}	
	$_SESSION['resa'][0]--;
	unset($_SESSION['rang'][$_SESSION['resa'][0]+1]);
		$warning[0]--;
	}
}
// On met a jour les sieges que le client souhaite reservé
for($i = 1; $i <= $_SESSION['resa'][0] ; $i++){
	$siege[$_SESSION['resa'][$i]['rang']][ $_SESSION['resa'][$i]['place']] = -1;
}


// Si la case cliqué n'est pas en rouge, passe en vert ou en bleu..
if(isset($_GET['rang']) AND isset($_GET['place']) AND $siege[$_GET['rang']][$_GET['place']] != 0){
// SI vert, on stock rang et place dans notre variable resa, et on met la case en bleu
	if($siege[$_GET['rang']][$_GET['place']] == 1){	
		$_SESSION['resa'][0]++;
		$_SESSION['resa'][$_SESSION['resa'][0]] = array();
		$_SESSION['resa'][$_SESSION['resa'][0]]['rang'] = $_GET['rang'];
		$_SESSION['resa'][$_SESSION['resa'][0]]['place'] = $_GET['place'];
		$siege[$_GET['rang']][$_GET['place']] = -1;
		
	} else {
// SINON SI BLEU
		$i=1;
		while( $_SESSION['resa'][$i]['rang']!=$_GET['rang'] OR $_SESSION['resa'][$i]['place']!=$_GET['place']){
			$i++;
		}
		while($i<$_SESSION['resa'][0]){
			$_SESSION['resa'][$i]['rang'] = $_SESSION['resa'][$i+1]['rang'];
			$_SESSION['resa'][$i]['place'] = $_SESSION['resa'][$i+1]['place'];
			$i++;
		}	
		$siege[$_GET['rang']][$_GET['place']] = 1;
		$_SESSION['resa'][0]--;
		unset($_SESSION['rang'][$_SESSION['resa'][0]+1]);
		
	}
}

echo '<div class="zone_salle">';

for($i=1; $i <= $siege[0][0] ; $i++){
	echo '<ul class="salle"> Rang #'.$i;
	for($j=1; $j<=$siege[0][$i]; $j++){
		echo "<li>";
		echo '<a href="testvar.php?rang='.$i.'&amp;place='.$j.'">';
		if($siege[$i][$j]==1){
			echo '<div class="place_libre">';			
		} else if ($siege[$i][$j]==0){
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





for($i=1; $i <= $_SESSION['resa'][0] ; $i++ ){
	echo "<br>".$_SESSION['resa'][$i]['rang'].";".$_SESSION['resa'][$i]['place'];	
}


?>



	
















