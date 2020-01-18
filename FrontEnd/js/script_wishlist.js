var token = localStorage.getItem("Token")
var idLog = localStorage.getItem("skuLogin")
var judul, gambar,kategori,publikasi,harga,pencipta,publish,ibn,skuU,skuP;
var skuz=localStorage.getItem("skuLogin");
var skuzz;
$(document).ready(function(){
	if(localStorage.getItem("skuLogin")){
		var token=localStorage.getItem("Token")
		var id=localStorage.getItem("skuLogin")

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

		existBySkuUser();

		//function existBySkuUser
		function existBySkuUser(){
			$.ajax({
				type:"GET",
				url:"http://localhost:9081/wishlist/existBySkuUser/"+id,
				headers: {
						"Content-Type": "application/json",
						"Authorization": "Bearer "+token
				},
				success:function(data){
					if(data == 0){
						console.log(data);
						$("#alert").append('<div class="alert alert-warning" role="alert">\
			          <h4 class="alert-heading"><i class="glyphicon glyphicon-info-sign"></i> &nbsp; No Book in Wishlist!</h4>\
			      </div>\
						');
					}
				}
			});
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
					if(users.length == 0){
						$("#wish").append("&nbsp;&nbsp;&nbsp;&nbsp;<h3><b>No Book in Wishlist</b></h3>");
					}
					for (var i in users) {
						if(users[i].sku_user == id){
							console.log("test")
						 $("#wish").
						 append("<div class='col-lg-4 col-md-6 mb-5'>\
								<div id='h'>\
									<a href='detail_book.html?id="+users[i].sku_product+"' style='text-decoration:none'>\
									<div class='card-body'>\
										<h4 class='card-title'> <img src='./product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
										<p class='card-text' style='color:black'><b>"+users[i].title+"</b></p>\
									</div>\
									</a>\
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
										<button class='btn btn-outline-danger btn-block' onclick='hap("+users[i].id+")'><i class='glyphicon glyphicon-trash'></i> Remove From Wishlist</button>\
										<a href='detail_book.html?id="+users[i].sku_product+"'><button class='btn btn-outline-success btn-block'><i class='glyphicon glyphicon-check'></i> Detail Book</button></a>\
									</div>\
								</div>\
						</div>\
							");
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

	}else{
			alert("You must be Login to open wistlist");
			location.href = "login.html";
	}

});
function hap(test){
	//alert(test)
	var token=localStorage.getItem("Token");
	$.ajax({
		type:"DELETE",
		url:"http://localhost:9081/wishlist/delete/"+test,
		headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
		},
		success:function(data){
			alert("Success Delete Book from Wishlist");
			location.href="wishlist.html";
		}
	});

}
function addToCart(id){
	alert(id)
	const url ="http://localhost:9081/product/get/"+id;
	window.fetch(url,{
		method: 'GET',
		headers: {
							"Content-Type": "application/json",
							"Authorization": "Bearer "+token
					},
	}).then((i)=>{
		alert(i.sku_user);
		 skuzz=i.sku_product;
		 judul=i.title;
		 gambar=i.pict_product;
		 kategori=i.categories;
		 publikasi=i.publication_year;
		 harga=i.price;
		 pencipta=i.author;
		 publish=i.publisher;
		 ibn=i.isbn;
		 skuU=i.sku_user;
		 skuP=i.sku_product;
		 skuM=i.sku_merchant;
	 }).then(() => {
		 console.log("selesai")
	 })
	// if(localStorage.skuLogin){
	// 	var temp_token = localStorage.getItem("Token");
	// 	var jsonVar = {
	// 		status:1,
	// 		title:judul,
	// 		pict_product:gambar,
	// 		categories:kategori,
	// 		publication_year:publikasi,
	// 		price:harga,
	// 		author:pencipta,
	// 		publisher:publish,
	// 		isbn:ibn,
	// 		sku_user:idLog,
	// 		sku_product:skuP,
	// 		sku_merchant:skuM
	// 	};
	// 	if(indikator==0){
	// 		$.ajax({
	// 						type:"POST",
	// 						headers: {
	// 								"Content-Type": "application/json",
	// 								"Authorization": "Bearer "+token
	// 						},
	// 						url:"http://localhost:9081/cart/add",
	// 						data: JSON.stringify(jsonVar),
	// 						success: function(data){
	// 							alert("Success Add To Cart");
	// 							location.href="detail_book.html?id="+id;
	// 						},
	// 						error: function(err) {
	// 								alert(err)
	// 						}
	// 		});
	// 	}else{
	// 		alert("This Book Already In Cart");
	// 	}
	// }else{
	// 	alert("You must be login");
	// 	location.href = "login.html";
	// }

}
