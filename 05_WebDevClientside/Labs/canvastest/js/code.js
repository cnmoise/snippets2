
//searches html doc for canvas element
var canvas = document.querySelector('canvas');

//set height/width to fullsize screen

canvas.width= window.innerWidth;
canvas.height= window.innerHeight;

//context
var c = canvas.getContext('2d');

//Part 3

var x = Math.random() * innerWidth;
var y = Math.random() * innerHeight;
var dy = 4;
var dx = 4;
var radius = 30;
function animate() {
	
	requestAnimationFrame(animate);
	console.log('test');
	c.clearRect(0, 0, innerWidth, innerHeight);
	
	c.beginPath();
	c.arc(x, y, radius, 0, Math.PI * 2, false);
	c.strokeStyle = 'red';
	c.stroke();
	
	if(x + radius > innerWidth || x - radius < 0){
		
		dx = -dx;
	}
	if(y + radius > innerHeight || y - radius < 0){
		
		dy = -dy;
	}
	
	x+= dx;
	y+= dy;
	
}

animate();
