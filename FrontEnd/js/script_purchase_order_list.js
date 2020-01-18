var id=localStorage.getItem("skuLogin")
var token=localStorage.getItem("Token")

$(document).ready(function(){
	hideNavbar();
	getAllOrder();
	getAllOrderAcc();


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


	function getAllOrder(){
			var countt=0;
		$.ajax({
					type:"GET",
					beforeSend : function( xhr ) {
						xhr.setRequestHeader( "Authorization", "Bearer "+token );
					},
					url:"http://localhost:9081/orders/findBySkuUser/"+id,
					success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));

            for (var i in users) {
							countt++;
               if(users[i].status == 1){
								 $("#listOrder").
	                append("<div class='col-md-12'>\
	                    <div class='row'>\
	                      <div class='col-md-6'>\
	                        <table>\
	                          <tr>\
	                            <td>Total Pemesanan: Rp."+users[i].totTrans+"</td>\
	                          </tr>\
	                          <tr>\
	                            <td>Tanggal Pemesanan : "+users[i].createdAt+"</td>\
	                          </tr>\
	                          <tr>\
	                            <td>Status Pembayaran : " + (users[i].status == 1 ? '<span class="badge badge-danger">Belum Bayar</span>': '<span class="badge badge-success">Sudah Bayar</span>') + "</td>\
	                          </tr>\
														<tr>\
	                          </tr>\
	                        </table>\
	                      </div>\
												<div class='col-md-2'><br>\
	                          <a href=''><button class='btn btn-danger' onclick='cancel("+users[i].id+")' > Cancel</button></a>\
	                      </div>\
	                      <div class='col-md-2'>\
	                          <a href='detail_order_book.html?id_order="+users[i].id+"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Detail</button></a>\
	                      </div>\
												<div class='col-md-2'>\
	                          <a href='pay_order.html?id="+users[i].id+"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Bayar</button></a>\
	                      </div>\
	                    </div>\
	                  </div>\
					 <br><br>\
	                  ");
							 }
            }
						if(countt===0){
								$("#listOrder").append("\
								<div id='header_merchant' class='row'>\
										<div><center><p>Order Is Empty</p></center></div>\
								</div><br><br><br><br>\
								")
						}
					},

					error: function(data) {
						console.log(data);
						}
				});
	}


	function getAllOrderAcc(){
		var counttt=0;
		$.ajax({
					type:"GET",
					beforeSend : function( xhr ) {
						xhr.setRequestHeader( "Authorization", "Bearer "+token );
					},
					url:"http://localhost:9081/orders/findBySkuUser/"+id,
					success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
							counttt++;
               if(users[i].status == 2){
								 $("#listOrderAcc").
	                append("<div class='col-md-12'>\
	                    <div class='row'>\
	                      <div class='col-md-8'>\
	                        <table>\
	                          <tr>\
	                            <td>Total Pemesanan: Rp."+users[i].totTrans+"</td>\
	                          </tr>\
	                          <tr>\
	                            <td>Tanggal Pemesanan : "+users[i].createdAt+"</td>\
	                          </tr>\
	                          <tr>\
	                            <td>Status Pembayaran : " + (users[i].status == 1 ? '<span class="badge badge-danger">Belum Bayar</span>': '<span class="badge badge-success">Sudah Bayar</span>') + "</td>\
	                          </tr>\
														<tr>\
	                            <td>Virtual Account : " + users[i].virtualaccount + "</td>\
	                          </tr>\
	                        </table>\
	                      </div>\
	                      <div class='col-md-4'>\
	                          <a href='detail_order_book.html?id_order="+users[i].id+"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Detail</button></a>\
	                      </div>\
	                    </div>\
	                  </div><br><br><br><br><br><br><br><br>\
	                  ");
							 }
            }
						if(counttt===0){
							$("#listOrderAcc").append("\
							<div id='header_merchant' class='row'>\
									<div><center><p>Purchase Order Is Empty</p></center></div>\
							</div><br><br><br><br>\
							 ");
						}
					},
					error: function(data) {
						console.log(data);
						}
				});
	}
});
function cancel(sku){
var ans=window.confirm("Are you sure want to cancel?")
if(ans){
	alert("Cancel Success")
	$.ajax({
	        type:"DELETE",
	        url:"http://localhost:9081/detailOrder/delByOrderId/"+sku,
	        headers:{
	            "Content-Type": "application/json",
	            "Authorization": "Bearer "+token
	        },
	        success: function(response){
						console.log(response);
	        },
	        error: function (err) {
	            alert(err)
	        }
	    })

	    $.ajax({
	        type: "DELETE",
	        url: "http://localhost:9081/orders/deleteById/"+sku,
	        headers: {
	            "Content-Type": "application/json",
	            "Authorization": "Bearer "+token
	        },
	        success :function(response){
							console.log(response)
	            location.href="purchase_order_list.html";
	        },
	        error : function (err) {
	            alert(err);
	        }
	    });
		}
}
