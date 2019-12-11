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
               if(users[i].status == 1){
								 $("#listOrder").
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
	                            <td>Status Pembayaran : " + (users[i].status == 1 ? 'Belum Bayar': 'Sudah Bayar') + "</td>\
	                          </tr>\
														<tr>\
	                            <td>Virtual Account : " + users[i].virtualaccount + "</td>\
	                          </tr>\
	                        </table>\
	                      </div>\
	                      <div class='col-md-4'>\
	                          <a href='detail_order_book.html?id_order="+users[i].id+"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Detail pemesanan</button></a>\
	                      </div>\
	                    </div>\
	                  </div>\
	                  ");
							 }
            }
					},

					error: function(data) {
						console.log(data);
						}
				});
	}


	function getAllOrderAcc(){
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
	                            <td>Status Pembayaran : " + (users[i].status == 1 ? 'Belum Bayar': 'Sudah Bayar') + "</td>\
	                          </tr>\
														<tr>\
	                            <td>Virtual Account : " + users[i].virtualaccount + "</td>\
	                          </tr>\
	                        </table>\
	                      </div>\
	                      <div class='col-md-4'>\
	                          <a href='detail_order_book.html?id_order="+users[i].id+"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Detail pemesanan</button></a>\
	                      </div>\
	                    </div>\
	                  </div>\
	                  ");
							 }
            }
					},
					error: function(data) {
						console.log(data);
						}
				});
	}
});
