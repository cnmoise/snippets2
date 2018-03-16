
//searches html doc for canvas element
var canvas = document.querySelector('canvas');

//set height/width to fullsize screen

canvas.width= window.innerWidth;
canvas.height= window.innerHeight;

//context
var c = canvas.getContext('2d');

c.fillStyle = 'rgba(255, 0, 0, .5)';
c.fillRect(100, 100, 100, 100);
//x, y, width, height
c.fillStyle = 'rgba(0, 0, 255, .5)';
c.fillRect(300, 200, 100, 100);
c.fillStyle = 'rgba(0, 255, 0, .5)';
c.fillRect(100, 500, 100, 100);

console.log(canvas);

//line

c.beginPath();
c.moveTo(50, 300);
c.lineTo(300, 100);
c.lineTo(400, 300);
//style > think CSS, color
c.strokeStyle = "#999911";
c.stroke();

//arc/circle

c.beginPath();
c.arc(500, 500, 30, 0, Math.PI * 2, false);
c.strokeStyle = 'blue';
c.stroke();


for(var i = 0; i < 1; i++){
	//NICE TECH
	var x = Math.random() * window.innerWidth;
	var y = Math.random() * window.innerHeight;
	c.beginPath();
	c.arc(x, y, 30, 0, Math.PI * 2, false);
	c.strokeStyle = 'blue';
	c.stroke();
}