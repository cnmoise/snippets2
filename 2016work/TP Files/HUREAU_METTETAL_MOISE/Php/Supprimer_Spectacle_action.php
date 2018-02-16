<?php

	// récupération des variables
	$numSpec = $_POST['noSpec'];

	$previous_page = "Supprimer_Spectacle.php";
	include('entete_v2.php');
	
	// construction des requêtes
	$requete = "DELETE FROM LesSpectacles WHERE noSpec=".$numSpec." ";

	// analyse de la requete 1 et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

	// association des variables
	//oci_bind_by_name ($curseur1,':o', $numSpec);
	//oci_bind_by_name($curseur1, ':d', $dateRep)

	// execution de la requete
	$ok = @oci_execute ($curseur, OCI_NO_AUTO_COMMIT) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		echo LeMessage ("majRejetee")."<br /><br />";
		$e = oci_error($curseur);
		if ($e['code'] == 1) {
			echo LeMessage ("spectacleconnu") ;
		}
		else {
			echo LeMessageOracle ($e['code'], $e['message']) ;
		}

		// terminaison de la transaction : annulation
		oci_rollback ($lien) ;

	}
	else {

			echo LeMessage ("majOK") ;
			// terminaison de la transaction : validation
			oci_commit ($lien) ;

	}

	// on libère le curseur
	oci_free_statement($curseur);

	include('pied.php');

?>
