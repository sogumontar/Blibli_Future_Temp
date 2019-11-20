$(document).ready(function(){
  var token = new URL(location.href).searchParams.get('token')
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
          url:"http://localhost:9080/cart/all",
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            console.log(users.log);
            for (var i in users) {
            	if(!users[i].id_user){
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



