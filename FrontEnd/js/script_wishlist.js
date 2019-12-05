$(document).ready(function(){
	var token=localStorage.getItem("Token")
  var id=localStorage.getItem("idLogin")

	hideNavbar();

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
test();
	function test(){
		$.ajax({
			type:"GET",
			url:"http://localhost:9081/wishlist/",
			headers: {
					"Content-Type": "application/json",
					"Authorization": "Bearer "+token
			},
			success: function(data) {
				var users = JSON.parse(JSON.stringify(data));
				for (var i in users) {
					if(users[i].sku_user===id && users[i].status==1){
						console.log("test")
					 $("#dat").
						append('<div class="row">\
						<div class="col-md-4">\
							<img src="C:\product/'+users[i].pict_product+'" id="img_product" alt="">\
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
										<td><a class="btn btn-danger" onclick="hap('+users[i].id+')">Hapus dari keranjang</a></td>\
									</tr>\
								</table>\
						</div>\
					</div>');
					}
				}

			},
			error: function(data) {
				$("#dat2").
				append("<br><br><br><div class='container-fluid' id='notLogged'>\
						<center><p>You are not logged in yet <a href='login.html'>Login</a></p></center>\
					</div>")
				console.log(data);
				}
		});
	}
	// $("#del").click(function(){
	// 	alert("bayar")
	// 	$.ajax({
	// 		type:"POST",
	// 		url:"http://localhost:9081/cart/purchase/"+id,
	// 		Content-Type:"application/json",
	// 		headers: {
 //              "Content-Type": "application/json",
 //              "Authorization": "Bearer "+token
 //          	},
	// 		success: function(data){

	// 		}
	// 	});

	// });


});
