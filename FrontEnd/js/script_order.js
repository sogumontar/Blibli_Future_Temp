	var arr=[];
$(document).ready(function(){

	var token = localStorage.getItem('Token');
	var idLog = localStorage.getItem('idLogin')
	if(token){
		console.log("testing");
	}else{
		console.log("binatang");
	}
	hideNavbar();
	assignDataProduct();

	$('#listBook').click(function(){
		location.href = "detail.html";
	});



	function hideNavbar(){
		var prevScrollpos = window.pageYOffset;
		window.onscroll = function() {
		var currentScrollPos = window.pageYOffset;
		  if (prevScrollpos > currentScrollPos) {
		    document.getElementById("navbar").style.top = "0";
		  } else {
		    document.getElementById("navbar").style.top = "-50px";
		  }
		  prevScrollpos = currentScrollPos;
		}
	}
	function assignDataProduct(){
		
		// console.log(token)
		var gbr="5.png";
		$.ajax({
          type:"GET",
          headers: {
			        "Content-Type": "application/json",
			        "Authorization": "Bearer "+token
			    },
          url:"http://localhost:9080/cart/",
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            var sum=0;
            for (var i in users) {
            	if(users[i].id_user==idLog){
            		sum+=users[i].price;
            		arr.push(users[i].title);


               $("#dat").
                append("<div class='row' id='card'>\
                			<div class='col-md-2'>\
						      <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\
						    </div>\
						    <div class='col-md-3'>\
						    	<br>\
						       <center><p'>" + users[i].title + "<p5></center>\
						    </div>\
						    <div class='col-md-3'>\
						    	<br>\
						        <center><p>" + users[i].categories + "</p></center>\
						    </div>\
						    <div class='col-md-3'>\
						    	<br>\
						        <center><p>Rp " + users[i].price + ",00</p></center>\
						    </div>\
						    <div class='col-md-1'>\
						          <a class='btn' onclick='hapus("+users[i].id+")' href=''><img width='30' src='pict/icons8-close-window-64.png'></a>\
						    </div>\
						</div><hr><br>\
						");
            }
            }addOrder(arr);
            $("#dd").append("<div class='row'>\
								<div class='col-md-8'>\
							 	</div>\
							 	<div class='col-md-4'>\
								<b>Harga Total</b> : "+sum+"\
								</div>\
							 </div>\
							 ");
          },
          error: function(data) {
          	$("#dat").
          	append("<br><br><br><div class='container-fluid' id='notLogged'>\
          			<center><p>You are not logged in yet <a href='login.html'>Login</a></p></center>\
          		</div>")
            console.log(data);
            }
        });
	}

});
function hapus(idss){
	var token=localStorage.getItem("Token")
  var id=localStorage.getItem("idLogin")
	console.log(idss);
	console.log(token);
		$.ajax({
          type:"DELETE",
          url:"http://localhost:9080/cart/delete/"+idss,
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },	
          success: function(data) {
          	alert("Delete Success");
          	tt();
          },
          error: function(data){
          	alert("error");
          }
	});
}
function tt(){
	alert("Delete Success")
}

function addOrder(arr){

	var token = localStorage.getItem('Token');
	var idLog = localStorage.getItem('idLogin')
	for(var i in arr){
		console.log(arr[i])
		$.ajax({
          type:"POST",
          url:"http://localhost:9080/cart/add",
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },	
          success: function(data) {
          	alert("Success");
          	tt();
          },
          error: function(data){
          	alert("error");
          }
	});
}
}