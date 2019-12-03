$(document).ready(function(){
  // var token = new URL(location.href).searchParams.get('token')
  var token=localStorage.getItem("Token")
  var id=localStorage.getItem("idLogin")
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



	$("#bayar").click(function(){

			var jsonVar = {
		        name: $("#name").val(),
		        email: $("#email").val(),
		        password: $("#password").val(),
		        username: $("#username").val(),
		        telepon: $("#telepon").val(),
		        alamat: $("#alamat").val(),
		        tanggal_lahir: $("#tanggal_lahir").val(),
		        role: $("#role").val()
		    };
		alert("bayar")
		$.ajax({
			type:"POST",
			url:"http://localhost:9081/cart/purchase/"+id,
			data:JSON.stringify(jsonvar),
			Content-Type:"application/json",
			headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          	},
			success: function(data){

			}
		});

	});

function test(){

	$.ajax({
          type:"GET",
          url:"http://localhost:9081/cart/",
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
            	if(users[i].id_user){
            		console.log("test")
               $("#dat").
                append('<div class="row">\
			          <div class="col-md-4">\
			            <img src="Pict/buku_fashion.jpg" id="img_product" alt="">\
			          </div>\
			          <div class="col-md-8">\
			              <table>\
			                <tr>\
			                  <td><p>'+users[i].status +'</p></td>\
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



