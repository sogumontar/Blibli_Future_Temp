var id=localStorage.getItem("skuLogin")
var token=localStorage.getItem("Token")
var totPesanan = 0;
var last = 0;
var plus = 0;
var VA="VA";
$(document).ready(function(){

	hideNavbar();
	assignDataProduct();
	// findLast();
	console.log(id);

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
					contentType: 'application/json',
					beforeSend : function( xhr ) {
					 xhr.setRequestHeader( "Authorization", "Bearer "+token );
				 },
					url:"http://localhost:9081/cart/",
					success: function(data) {
						var users = JSON.parse(JSON.stringify(data));
						for (var i in users) {
							if(users[i].sku_user == id){
								totPesanan = totPesanan + users[i].price;
								$("#listProduct").
								append('<div class="col-md-12">\
									<div class="row" id="price">\
										<div class="col-md-8">'+users[i].title+'</div>\
										<div class="col-md-4">'+users[i].price+'</div>\
									</div>\
								</div><br>\
								');
								document.getElementById("tot_pesanan").innerHTML = "Total Pesanan : Rp "+totPesanan;
							}
						}
					},
					error: function(data) {

					}
				});
	}

	function makeVirtualaccount(length) {
	   var result           = '';
	   var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	   var charactersLength = characters.length;
	   for ( var i = 0; i < length; i++ ) {
		  result += characters.charAt(Math.floor(Math.random() * charactersLength));
	   }
	   VA=result;
	   return result;
 	}



	function makeOrder(){
		//virtualAccount
		var virtual = makeVirtualaccount(10);
		//Get date now
		let today = new Date().toISOString().slice(0, 10);

		var jsonVar = {
			skuUser: id,
			status: 1,
			createdAt: today,
			virtualaccount: virtual,
			tipeTrans: document.getElementById('tipe_trans').value,
			totTrans: totPesanan
		};
		$.ajax({
							type:"POST",
							url:"http://localhost:9081/orders/saveOrder",
							beforeSend : function( xhr ) {
							 xhr.setRequestHeader( "Authorization", "Bearer "+token );
							},
							data: JSON.stringify(jsonVar),
							contentType: "application/json",
							success: function(data){
								//findLast from Order

								$.ajax({
									type:"GET",
									url:"http://localhost:9081/orders/findLast",
									beforeSend : function( xhr ) {
									xhr.setRequestHeader( "Authorization", "Bearer "+token );
									},
									contentType: "application/json",
									success: function(data1){
									//get all cart by sku user
										$.ajax({
										type:"GET",
										url:"http://localhost:9081/cart/",
										beforeSend : function( xhr ) {
										xhr.setRequestHeader( "Authorization", "Bearer "+token );
										},
										contentType: "application/json",
										success: function(data2){
										var userss = JSON.parse(JSON.stringify(data2));
										for (var i in userss) {
											if(userss[i].sku_user == id){

												console.log("data2");
												//save detail order
												var jsonVar1 = {
													sku_product: userss[i].sku_product,
													sku_merchant: userss[i].sku_merchant,
													sku_user: id,
													idOrder: data1.id,
													title: userss[i].title,
													pict_product: userss[i].pict_product ,
													categories: userss[i].categories,
													publication_year: userss[i].publication_year,
													price: userss[i].price,
													author: userss[i].author,
													publisher: userss[i].publisher,
													isbn: userss[i].isbn
												}
												$.ajax({
													type:"POST",
													url:"http://localhost:9081/detailOrder/saveDetailOrder",
													beforeSend : function( xhr ) {
														xhr.setRequestHeader( "Authorization", "Bearer "+token );
													},
													data: JSON.stringify(jsonVar1),
													contentType: "application/json",
													success: function(data3){
													},
													error: function(err) {
														console.log(err.responseJSON.message);
													}
												});
												delCart(users[i].id);

											}
										}
										},
										error: function(err) {
												console.log(err.responseJSON.message);
										}
										});
									},
									error: function(err) {
										console.log(err.responseJSON.message);
									}
								});
							},
							error: function(err) {
									console.log(err.responseJSON.message);
							}
		});
	}
	function sendEmail(){
		$.ajax({
			type:"GET",
			headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
			},
			url:"http://localhost:9081/user/findById/"+id,
			success: function(data){
				var users = JSON.parse(JSON.stringify(data));
				$.ajax({
					type:"POST",
					headers: {
						"Content-Type": "application/json",
						"Authorization": "Bearer "+token
					},
					url:"http://localhost:9081/orders/sendMail/"+users.email+"/"+VA,
					success: function(data){
						alert(VA);
					},
					error: function(err) {
						// alert(err)
					}
				});
			},
			error: function(err) {
				// alert(err)
			}
		});
	}

	function delCart() {
		$.ajax({
			type:"DELETE",
			headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
			},
			url:"http://localhost:9081/cart/delBySkuUser/"+id,
			success: function(data){

			},
			error: function(err) {
				// alert(err)
			}
		});
	}
	function pindah(){
		// var jsonData = {
		//
		// }
		// $.ajax({
		// 		type:"POST",
		// 		url:"",
		// 		headers:{
		// 			"Content-Type":"application/json",
		// 			"Authentication":"Bearer "+token
		// 		},success: function(response){
		// 			alert(response);
		// 		},
		// 		error: function (err) {
		// 			alert(err);
		// 		}
		// })
		alert("success make order");
		location.href = "purchase_order_list.html";
	}
	$('#but_pesanan').click(function(){
		makeOrder();
		delCart();
		sendEmail();
		setInterval(pindah,2000);
	});

	// function findLast(){
	// 	$.ajax({
	// 						type:"GET",
	// 						url:"http://localhost:9081/orders/findLast",
	// 						contentType: "application/json",
	// 						success: function(data){
	// 							alert(data.id);
	// 							last = data.id;
	// 						},
	// 						error: function(err) {
	// 								console.log(err.responseJSON.message);
	// 						}
	// 	});
	// }

});
