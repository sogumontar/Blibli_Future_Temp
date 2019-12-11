$(document).ready(function(){

	var token = localStorage.getItem("Token")
	var val = new URL(location.href).searchParams.get('val')
	var kate="";
	if(val=="buku_pelajaran"){
		kate="Buku Pelajaran";
	}else if(val==="buku_anak_anak"){
		kate="Buku Anak anak";
	}else if(val==="buku_novel"){
		kate="Buku Novel";
	}else if(val==="buku_fashion"){
		kate="Buku Fashion";
	}else if(val==="buku_kesehatan"){
		kate="Buku Kesehatan";
	}else if(val==="buku_ensiklopedia"){
		kate="Buku Ensiklopedia";
	}
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
		var gbr="5.png";
		var jsonVar = {
        kategori: "Buku Anak anak"
      };
		$.ajax({
          type:"GET",
          headers:{
          		"Content-Type": "application/json",
			    		"Authorization": "Bearer "+token
          },
          url:"http://localhost:9081/product/kategori/"+kate,
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#dat").
                append("<div class='col-lg-4 col-md-6 mb-5'>\
                    <div id='h'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='./product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'><b>"+users[i].title+"</b></p>\
											</div>\
											<div class=''>\
												<div class='col-md-12'>\
                          <div class='row'>\
                            <div class='col-md-6'>\
                              <p id='harga'><b>Rp "+users[i].price+"</b></p>\
                            </div>\
                            <div class='col-md-6'>\
                              <p></p>\
                            </div>\
                          </div>\
                        </div>\
											</div>\
											<div id='bawah'><hr>\
												<a href='detail_book.html?id="+users[i].sku_product+"' style='text-decoration:none'><button type='button' class='btn btn-outline-primary btn-block'>Detail</button></a>\
											</div>\
                    </div>\
                </div>\
									");
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
