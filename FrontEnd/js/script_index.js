$(document).ready(function(){

	var c = new URL(location.href).searchParams.get('token')

	console.log(c);

	hideNavbar();
	assignDataProduct();

	$('#listBook').click(function(){
		location.href = "detail_book.html?token="+c;
	});


	//for navbar
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
		$.ajax({
          type:"GET",
					headers: {
			        "Content-Type": "application/json",
			        "Authorization": "Bearer "+c
			    },
          url:"http://localhost:9080/product/getAll",
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-3 col-md-6 mb-4'>\
                    <div class='card h-100'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'>.....</p>\
											</div>\
											<div class='card-footer'>\
												<button class='btn btn-primary' id='but_beli'>Beli Sekarang</button>\
											</div>\
                    </div>\
                </div>\
									");
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
	}

});
