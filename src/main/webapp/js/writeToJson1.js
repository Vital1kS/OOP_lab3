let Flower = {
	name: "",
	main_color: "",
	family: "",
	height: 0,
	price: 0
	}
function getData(){
    Flower.name = document.getElementById("name").value;
    Flower.main_color = document.getElementById("main_color").value;
    Flower.family = document.getElementById("family").value;
    Flower.height = document.getElementById("height").value;
    Flower.price = document.getElementById("price").value;
    let flowerJson = JSON.stringify(Flower);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "write",true);
	xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(flowerJson);
};