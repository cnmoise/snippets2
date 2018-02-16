<?php
$titre = 'Places Réservées';

include('entete.php');
	
	$requete = ("
		select noSpec, nomS, to_char(dateRep, 'DD-MON-YY HH:MM') dateRep from theatre.LesRepresentations natural join theatre.LesSpectacles
		order by NoSpec, dateRep
	");
	
	// analyse (syntaxique) de la requete et association au curseur
	$curseur = oci_parse ($lien, $requete) ;
    
	// execution de la requete
	$ok = @oci_execute ($curseur) ;
	
	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {
		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
		echo "Erreur requete 1 : <p class=\"erreur\">{$error_message['message']}</p>";
		
	}
	else{
	
		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);
		
		if (!$res) {
		
			// il n'y a aucun résultat
			echo "<p class=\"erreur\"><b>Aucun dossier dans la base de données (requete 1)</b></p>" ;
			
		}
		else{
		
		//affichage de la table
		/*
		Pour chaque dossier, la date d'émission du dossier, et pour chaque billet associé, son numéro et
		sa date d'émission, les épreuves associées, leur numéro, leur nom, et leur date (version avec deux curseurs) 
		*/
		echo "<table><tr><th>Numéro du Spectacle</th><th>Nom du Spectacle</th><th>Date de la Représentation</th><th>Nombre de places réservées</th></tr>\n" ;
		
		do{
			
			$numSpec=oci_result($curseur,1);
			$nomSpec=oci_result($curseur, 2);
			$dateRep=oci_result($curseur,3);
			
			$requete2 = ("
				select sum(noPlace) as nbPlRes from theatre.LesTickets
				where noSpec=".$numSpec."
				group by dateRep, noSpec
			");
			$curseur2 = oci_parse ($lien, $requete2) ;
			$ok2 = @oci_execute ($curseur2) ;
			if (!$ok2) {
				
				// oci_execute a échoué, on affiche l'erreur
				$error_message = oci_error($curseur2);
				echo "Erreur requete 2 : <p class=\"erreur\">{$error_message['message']}</p>";
		
			}else{
				
				oci_fetch_all($curseur2,$toto);
				$taille = oci_num_rows($curseur2);
				oci_execute ($curseur2);
				
				$res2 = oci_fetch ($curseur2);
				
				if (!$res2) 
				{
					// il n'y a aucun résultat
					//echo "<p><b>Aucune réservation dans la base de données pour le spectacle n° ".$numSpec."</b></p>" ;
					echo "<tr><td>$numSpec</td><td>$nomSpec</td><td>$dateRep</td><td>0</td></tr>";
				}
				else
				{
					
					echo "<tr><td>$numSpec</td><td>$nomSpec</td><td>$dateRep</td>";
					$numPlRes=oci_result($curseur2,1);
					echo "<td>$numPlRes</td></tr>\n";
				}
				
			}
			
			oci_free_statement($curseur2);
			
		}while(oci_fetch($curseur));
		
		echo "</table>";
		
		}
	}
	
	// on libère le curseur
	oci_free_statement($curseur);

          
include('pied.php');
?>
