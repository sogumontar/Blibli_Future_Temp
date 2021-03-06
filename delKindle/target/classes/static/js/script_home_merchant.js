$(document).ready(function(){

  hideNavbar();
  assignDataProduct();

  function assignDataProduct(){
		$.ajax({
          type:"GET",
          contentType: "application/json",
          url:"http://localhost:9094/product/",
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-3 col-md-6 mb-4'>\
                    <div class='card h-100'>\
											<img class='card-img-top' src='http://placehold.it/500x325' alt=''>\
											<div class='card-body'>\
												<h4 class='card-title'><center><p>" + users[i].title+"</p></center></h4>\
												<p class='card-text'>" + users[i].description+"</p>\
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
});
