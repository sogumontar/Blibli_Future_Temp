$(document).ready(function(){

	hideNavbar();
	test();
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



function test(){
	var kate=28;
	$("#dat").
                append('<div class="row">\
			          <div class="col-md-4">\
			            <img src="Pict/buku_fashion.jpg" id="img_product" alt="">\
			          </div>\
			          <div class="col-md-8">\
			              <table>\
			                <tr>\
			                  <td><p>Fashion figure</p></td>\
			                </tr>\
			                <tr>\
			                  <td><p>Rp 12123123</p></td>\
			                </tr>\
			                <tr>\
			                  <td><button class="btn btn-danger">Hapus dari keranjang</button></td>\
			                </tr>\
			              </table>\
			          </div>\
			        </div>');
	$.ajax({
          type:"GET",
          url:"http://localhost:9080/cart/find/"+kate,
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#dat").
                append('<div class="row">\
			          <div class="col-md-4">\
			            <img src="Pict/buku_fashion.jpg" id="img_product" alt="">\
			          </div>\
			          <div class="col-md-8">\
			              <table>\
			                <tr>\
			                  <td><p>Fashion figure</p></td>\
			                </tr>\
			                <tr>\
			                  <td><p>Rp 12123123</p></td>\
			                </tr>\
			                <tr>\
			                  <td><button class="btn btn-danger">Hapus dari keranjang</button></td>\
			                </tr>\
			              </table>\
			          </div>\
			        </div>');
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



