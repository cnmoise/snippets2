<?php
include('entete.php');


// On recupere le maximum du numéro de dossier et de serie 
// Afin qu'il puisse matcher lors de l'instert.
$prix = array();
$requete = ("SELECT max(noserie), max(nodossier)
		FROM Lestickets");

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
			
			
			
			$noserie=oci_result($curseur,1) +1;
			$nodossier=oci_result($curseur,2) +1;
			
			
			
			
				
		
		}
	}

	// on libère le curseur
	oci_free_statement($curseur);

// On recupere notre cookie cookie qui contient les places qui ont était payés
	$ticket = unserialize($_COOKIE['ticket']);

	for($i=1; $i <= $ticket[0] ; $i++){
			echo "<p> Inssérez dans les tables ";
			echo "No Dossier : ";
			echo $nodossier;
			echo " No serie : ";
			echo $noserie;
			echo " Place ";			
			echo $ticket[$i]['place'];
			echo " Rang ";
			echo  $ticket[$i]['rang'];
			echo  " Zone ";
			echo $ticket[$i]['nom_zone'];
			echo " Representation le ";
			echo $_SESSION['date'];
			echo " Numéro de specatcle ";
			echo $_SESSION['nospec'];
			echo "</p>";
			$noserie++;
	
	}
			





include('pied.php')
?>