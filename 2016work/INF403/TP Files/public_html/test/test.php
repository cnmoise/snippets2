<?php
include('entete.php');
$requete = ("SELECT nomc
		FROM theatre.LesTickets");
	
	$curseur = oci_parse ($lien, $requete) ;
echo"bla";
	
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

	

		}
		else {

			
			echo "la?";

		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	
include('pied.php');
?>
