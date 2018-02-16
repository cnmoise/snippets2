<?php 
// Recupere la date "de :"
	session_start();
	if(isset($_GET['action'])){
		include('action.php');
	}
	
	if(!isset($_SESSION['filtre'])){
		$_SESSION['filtre'] = array();
	}	
	
	
	
	if (isset($_POST['day_after']) and !empty($_POST['day_after'])  ){
		$_SESSION['filtre']['day_after']=$_POST['day_after'];

	} else {
		if(!isset($_SESSION['filtre']['day-after'])){
			$_SESSION['filtre']['day_after']=date("Y-m-d");
		}
	}
	
// Recupere la date : jusqu'a	


	if (isset($_POST['day_before']) and !empty($_POST['day_before'])  ){
	$_SESSION['filtre']['day_before']=$_POST['day_before'];
	} else {
		if(!isset($_SESSION['filtre']['day_before'])){
			$_SESSION['day_before']="2099-12-31";
		}
	}

// Recupere l'heure

	if (isset($_POST['hour_after']) and !empty($_POST['hour_after'])  ){
		$_SESSION['filtre']['hour_after']=$_POST['hour_after'];
	} else {
		if(!isset($_SESSION['hour_after'])){
			$_SESSION['filtre']['hour_after']="08:00";
		}
	}
	
// Recupere la date : jusqu'a	


	if (isset($_POST['hour_before']) and !empty($_POST['hour_before'])  ){
		$_SESSION['filtre']['hour_before']=$_POST['hour_before'];
	} else {
		if(!isset($_SESSION['filtre']['hour_before'])){
			$_SESSION['filtre']['hour_before']="23:59";
		}
	}

// Recupere le nombre de places 

	if (isset($_POST['nb_places']) and !empty($_POST['nb_places'])  ){
		$_SESSION['filtre']['nb_places']=$_POST['nb_places'];
	} else {
		if(!isset($_SESSION['filtre']['nb_places'])){
			$_SESSION['filtre']['nb_places']=1;
		}
	}

	if (isset($_POST['cac']) and !empty($_POST['cac'])  ){
		$_SESSION['filtre']['cac']=$_POST['cac'];

	} else {
			$_SESSION['filtre']['cac']=false;
			echo $_SESSION['filtre']['cac'];
		
	}

?>

<?php  $firefox    = strpos($_SERVER["HTTP_USER_AGENT"], 'Firefox') ? true : false; ?>
<html>
	<p>
		<form method="post" action="filtre.php">
				<label for="day_after">A partir du </label>
			<input type="date" name="day_after" value="<?php if(!isset($_SESSION['filtre']['day_after'])){
					echo date("Y-m-d"); 
				} else {
					echo $_SESSION['filtre']['day_after'];
				}
				echo '">';
				?> 
				<label for="day-before">Jusqu'au </label>
			<input type="date" name="day_before" value="<?php if(isset($_SESSION['filtre']['day_before'])){
					echo $_SESSION['filtre']['day_before'];
				}
				echo '">';
				?> 
				<?php 
				
					if($firefox){
						echo "<p> Format de date : AAAA-MM-JJ</p>";	
					}						
				?>
			
				<label for="hour_after">De </label>
			<input type="time" name="hour_after" value="<?php if(!isset($_SESSION['filtre']['hour_after'])){
					echo "08:00"; 
				} else {
					echo $_SESSION['filtre']['hour_after'];
				}
				echo '">';
				?> h
			
				<label for="hour_before">a </label>
			 <input type="time" name="hour_before" value="<?php if(!isset($_SESSION['filtre']['hour_before'])){
					echo "23:59"; 
				} else {
					echo $_SESSION['filtre']['hour_before'];
				}
				echo '">';
				?> h
				<?php 
					if($firefox){
						echo "<p> Format de l'heure : HH:MM </p>";
					}						
				?>
			
				<label for="nbplaces"><br>Nombre de places </label>
			<input type="number" name="nb_places" min="1" value="<?php if(!isset($_SESSION['filtre']['nb_places'])){
					echo "1"; 
				} else {
					echo $_SESSION['filtre']['nb_places'];
				}
				echo '">';
				?> h
			
				 <input type="checkbox" name="cac" value="true"
					<?php if(isset($_SESSION['filtre']['cac']) AND  $_SESSION['filtre']['cac']==true ){
						echo 'checked="on"';
					}
					echo '>';
	
					?>
				 
				  Places cote à cotes<br>
			
			<input type="submit">
			<a href="filtre.php?action=reset_filtre"><input type="button" class="button" value="Réinitialiser"></a>
		</form>
	</p>
</html>
