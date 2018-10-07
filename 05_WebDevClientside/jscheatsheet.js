//Author: Claudiu Moise



window.alert("pay attention to me");


function myF(){
	//searches whole document by element id
//most basic building block
//loose variable typing
var elname = document.getElementbyID('jsex');
//edits the HTML of a file
elname.innerHTML = "Hello";
	
}


function myF2(){
	//edit the attribute of an html file in 1 call
var elname2 = document.getElementbyID('jsex2').style.border='35px';
	//.src
	//.display='none';//'block'
	
}

function killpopup() {
    document.getElementById('popup').style.display = 'none';
}