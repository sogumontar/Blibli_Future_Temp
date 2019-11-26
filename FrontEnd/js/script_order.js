$(document).ready(function(){
	var token = localStorage.getItem('Token')
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
            for (var i in users) {
            	if(users[i].id_user==idLog){


               $("#dat").
                append("<div class='ard' id='card'>\
						      <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\
						      <div class='card-body'>\
						        <div class=''>\
						          <center><h5>" + users[i].title + "</h5></center>\
						        </div>\
						        <div class=''>\
						          <center><h6>SKU : " + users[i].categories + "</h6></center>\
						        </div>\
						        <div class=''>\
						          <center><h5>Rp " + users[i].price + ",00</h5></center>\
						        </div>\
						        <div class=''>\
						          <button type='button' name='button' style='float:left' id='but_del'><a href='update_book.html?id="+users[i].id+"&title="+users[i].title+"&pict_product="+users[i].pict_product+"&categories="+users[i].categories+"&publication_year="+users[i].publication_year+"&price="+users[i].price+"&author="+users[i].author+"&publisher="+users[i].publisher+"&isbn="+users[i].isbn+"'>Update</a></button>\
						          <button type='button' name='button'  style='float:right' id='but_update'><a href='detail_book.html?id="+users[i].id+"&title="+users[i].title+"&pict_product="+users[i].pict_product+"&categories="+users[i].categories+"&publication_year="+users[i].publication_year+"&price="+users[i].price+"&author="+users[i].author+"&publisher="+users[i].publisher+"&isbn="+users[i].isbn+"'>Detail</a></button>\
						        </div>\
						      </div>\
						    </div>");
            }
            }
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
