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
		$.ajax({
          type:"GET",
					headers: {
			        "Content-Type": "application/json",
			        "Authorization": "Bearer "+c
			    },
          url:"http://localhost:9097/product/get",
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
							var img = 'C://product/'+users[i].pict_product;
							console.log(img)
            	var str=users[i].description;
               $("#listBook").
                append("<div class='col-lg-3 col-md-6 mb-4'>\
                    <div class='card h-100'>\
											<img class='card-img-top' src=''>\
											<div class='card-body'>\
												<h4 class='card-title'><center><p>" + users[i].title+"</p></center></h4>\
												<p class='card-text'>" + str +".....</p>\
											</div>\
											<div class='card-footer'>\
												<button class='btn btn-primary' id='but_beli'>Beli Sekarang</button>\
											</div>\
                    </div>\
                  </div>");
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
	}

});
