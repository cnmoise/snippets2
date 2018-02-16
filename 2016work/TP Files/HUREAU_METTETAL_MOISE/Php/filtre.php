<?php 

	session_start();
	$// On recupere tout les variables si jamais elles étaient présente en cookies
	if(isset($_COOKIE['reservation'])){
	$filtre = unserialize($_COOKIE['filtre']);
	}
	
	if(!isset($filtre)){
		$filtre = array();
	}	
	
	// Recupere la date : avant	
	
	if (isset($_POST['day_after']) and !empty($_POST['day_after'])  ){
		$filtre['day_after']=$_POST['day_after'];

	} 
		if(!isset($filtre['day_after'])){
			$filtre['day_after']=date("Y-m-d");
		}
	
	
	// Recupere la date : jusqu'a	
	
	if (isset($_POST['day_before']) and !empty($_POST['day_before'])  ){
		$filtre['day_before']=$_POST['day_before'];
	} else {
		if(!isset($_SESSION['day_before'])){
			$filtre['day_before']="2099-12-31";
		}
	}

	// Recupere l'heure : avant

	if (isset($_POST['hour_after']) and !empty($_POST['hour_after'])  ){
		$filtre['hour_after']=$_POST['hour_after'];
	} else {
		if(!isset($_SESSION['hour_after'])){
			$filtre['hour_after']="08:00";
		}
	}
	
// Recupere la date : jusqu'a	


	if (isset($_POST['hour_before']) and !empty($_POST['hour_before'])  ){
		$filtre['hour_before']=$_POST['hour_before'];
	} else {
		if(!isset($filtre['hour_before'])){
			$filtre['hour_before']="23:59";
		}
	}

// Recupere le nombre de places 

	if (isset($_POST['nb_places']) and !empty($_POST['nb_places'])  ){
		$filtre['nb_places']=$_POST['nb_places'];
	} else {
		if(!isset($filtre['nb_places'])){
			$filtre['nb_places']=1;
		}
	}
// Recupere le boolean cote a cote
	if (isset($_POST['cac']) and !empty($_POST['cac'])  ){
		$filtre['cac']=$_POST['cac'];

	} else {
			$filtre['cac']=false;
			echo $filtre['cac'];
		
	}
// On sauvegarde le cookie, il pourra servir plustard
setcookie('filtre',serialize($filtre), time()+300, "/");
// Si sur firefox, on affichera le format de la date
 $firefox    = strpos($_SERVER["HTTP_USER_AGENT"], 'Firefox') ? true : false; ?>
<html>
	<p>
<!-- Le formulaire a envoyer a recherche.php afin qu'il puisse efectuer les recherches de spectacles -->
		<form method="post" action="recherche.php">
				<label for="day_after">A partir du </label>
			<input type="date" name="day_after" value="<?php if(!isset($filtre['day_after'])){
					echo date("Y-m-d"); 
				} else {
					echo $filtre['day_after'];
				}
				echo '"></input>';
				?> 
				<label for="day-before">Jusqu'au </label>
			<input type="date" name="day_before" value="<?php if(isset($filtre['day_before'])){
					echo $filtre['day_before'];
				}
				echo '"></input>';
				?> 
				<?php 
				
					if($firefox){
						echo "<p> Format de date : AAAA-MM-JJ</p>";	
					}						
				?>
			
				<label for="hour_after">De </label>
			<input type="time" name="hour_after" value="<?php if(!isset($filtre['hour_after'])){
					echo "08:00"; 
				} else {
					echo $filtre['hour_after'];
				}
				echo '"></input>';
				?> h
			
				<label for="hour_before">a </label>
			 <input type="time" name="hour_before" value="<?php if(!isset($filtre['hour_before'])){
					echo "23:59"; 
				} else {
					echo $filtre['hour_before'];
				}
				echo '"></input>';
				?> h
				<?php 
					if($firefox){
						echo "<p> Format de l'heure : HH:MM </p>";
					}						
				?>
			
				<label for="nbplaces"><br></br>Nombre de places </label>
			<input type="number" name="nb_places" min="1" value="<?php if(!isset($filtre['nb_places'])){
					echo "1"; 
				} else {
					echo $filtre['nb_places'];
				}
				echo '"></input>';
				?> h
			
				 <input type="checkbox" name="cac" value="true"
					<?php if(isset($filtre['cac']) AND  $filtre['cac']==true ){
						echo 'checked="on"';
					}
					echo '></input>';
	
					?>
				 
				  Places cote à cotes<br></br>
			
			<input type="submit"></input>
			<a href="recherche.php?action=reset_filtre"><input type="button" class="button" value="Réinitialiser"></input></a>
		</form>
	</p>
</html>
