var penanda=[];
var sub_total = 0;

$(document).ready(function(){
	$("#tad").append('<a id="bayar" onclick="upd()" class="btn btn-success" href="">Process</a>')

  // var token = new URL(location.href).searchParams.get('token')
  var token=localStorage.getItem("Token")
	var id=localStorage.getItem("skuLogin")
	console.log(id)
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



	// $("#bayar").click(function(){

	// 		var jsonVar = {
	// 	        name: $("#name").val(),
	// 	        email: $("#email").val(),
	// 	        password: $("#password").val(),
	// 	        username: $("#username").val(),
	// 	        telepon: $("#telepon").val(),
	// 	        alamat: $("#alamat").val(),
	// 	        tanggal_lahir: $("#tanggal_lahir").val(),
	// 	        role: $("#role").val()
	// 	    };
	// 	alert("bayar")
	// 	$.ajax({
	// 		type:"POST",
	// 		url:"http://localhost:9081/cart/purchase/"+id,
	// 		data:JSON.stringify(jsonvar),
	// 		Content-Type:"application/json",
	// 		headers: {
 //              "Content-Type": "application/json",
 //              "Authorization": "Bearer "+token
 //          	},
	// 		success: function(data){

	// 		}
	// 	});

	// });

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
            	if(users[i].sku_user===id && users[i].status==1){
            		sub_total = sub_total + users[i].price;
               $("#dat").
                append('<div class="row">\
			          <div class="col-md-4">\
			            <img src="./product/'+users[i].pict_product+'" class="card" id="img_product" alt="">\
			          </div>\
			          <div class="col-md-8">\
			              <table>\
			                <tr>\
			                  <td><p>'+users[i].title +'</p></td>\
			                </tr>\
			                <tr>\
												<td><p>Rp '+users[i].price+',00</p></td>\
												<br>\
			                </tr>\
			                <tr>\
			                  <td><a onclick="hap('+users[i].id+')"><button class="btn btn-danger">Hapus dari keranjang</button></a></td>\
			                </tr>\
			              </table>\
			          </div>\
			        </div><br>');
            	}
			}
			if(sub_total==0){
				document.getElementById("checkoutButton").disabled=true;
			}else{
				
			}
							document.getElementById("set_total").innerHTML = "Sub Total : Rp "+sub_total;
							console.log("test",sub_total);

          },
          error: function(data) {
          	$("#dat2").
          	append("<br><br><br><div class='container-fluid' id='notLogged'>\
          			<center><p>You are not logged in yet <a href='login.html'>Login</a></p></center>\
          		</div>")
            console.log(data);
            }
				});
				var arr=[];
				var harg=0;
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
            	if(users[i].sku_user===id && users[i].status==2){
								harg+=users[i].price;
								penanda.push(users[i].sku_product);
								arr.push(users[i].title);
            }
					}
					$("#tad2").append('<a id="bayar" onclick="bay()" class="btn btn-success" href="">Pay</a>')
					$("#dat2").
						append('<b>Product</b> :'+arr+' <b>Total Price</b> '+ harg );
					}
					,
          error: function(data) {
          	$("#dat2").
          	append("<br><br><br><div class='container-fluid' id='notLogged'>\
          			<center><p>You are not logged in yet <a href='login.html'>Login</a></p></center>\
          		</div>")
            console.log(data);
            }
        });
	}
});

function hap(test){
	var token=localStorage.getItem("Token");
	$.ajax({
		type:"DELETE",
		url:"http://localhost:9081/cart/delete/"+test,
		headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
		},
		success:function(data){
			alert("success remove book from cart");
			location.href="cart.html";
		}
	});
}


function upd(){
	var token=localStorage.getItem("Token")
	var id=localStorage.getItem("skuLogin")
	alert(id);
	$.ajax({
		type:"PUT",
		url:"http://localhost:9081/cart/purchase/"+id,
		headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
		},
		success:function(data){
			alert("Update Succes");
		}
	});

alert("test");
}
function bay(){
	var token=localStorage.getItem("Token")
	var isd=localStorage.getItem("skuLogin")
	console.log(isd)
	console.log(penanda);

	alert("Process Success");
	$.ajax({
		type:"POST",
		url:"http://localhost:9081/cart/final/"+isd+"/"+penanda,
		headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
		},
		success:function(data){
			alert("Update Succes");
		}
	});
}
