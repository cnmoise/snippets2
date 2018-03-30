<!DOCTYPE html>
<html>
<head>
	<title>ClaudesList</title>
	<script
  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"
  ></script>

  <!-- all muh jquerry code

	http://127.0.0.1/services/index.html

	need to connect index and php service to server
   -->
  <script>
  	
  	$(document).ready(function(){

      $.get("http://127.0.0.1/services/service.php", function(data, status){
        console.log(data);
        var toDoItems = JSON.parse(data);
        //unwraps the JSON object
        for(var i = 0; i < toDoItems.length; i++){
            var item = "id: " + toDoItems[i].itemId +
                        " " + toDoItems[i].itemDescription +
                        " priority: " + toDoItems[i].itemPriority +
                        " due: " + toDoItems[i].itemDueDate;

            //make item into a list item
            item = "<li>" + item + "</li>";
            $("#myitems").append(item);
            //reffering the the list in the website
        }//for

      //detects click on button and adds data from text boxes

        $("#saveitem").click(function(){
          var description = $("#desc").val();
          var dueDate = $("#duedate").val();
          var priority = $("#priority").val();

          //takes the string data and creates it as a JSON object
          var item = {
            itemDescription : description,
            itemDueDate : dueDate,
            itemPriority : priority
          };

          $.post("http://127.0.0.1/services/service.php", item, function(data){
            console.log(data);
          });//post (Strange goddamn block syntax)
        });//saveitem
      });//$.get
  	});//$(document)

  </script>
</head>
<body>
	<div>
		<h1>TO DO LIST</h1>
		<!-- Displays db itmes -->
		<ol id="myitems">
			
		</ol>
	</div>
	<div>
		<h2>Add New Item</h2>
		<label>Item Desc:</label>
		<input type="text" id="desc"/> <br/>
		<label>Item Due Date:</label>
		<input type="text" id="duedate" placeholder="yyyy-mm-dd" /> <br/>
		<label>Item Priority: </label>
		<input type="text" id="priority"/> <br/>
		<input type="button" id="saveitem" value="Save Item"/>


	</div>
</body>
</html>