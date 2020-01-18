var id=localStorage.getItem("skuLogin");
var token = localStorage.getItem('Token');
$(document).ready(function(){

  hideNavbar();
  assignDataOrder();



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


  function assignDataOrder(){
    $.ajax({
          type:"GET",
          contentType: 'application/json',
          beforeSend : function( xhr ) {
           xhr.setRequestHeader( "Authorization", "Bearer "+token );
         },
          url:"http://localhost:9081/detailOrder/findBySkuMerchant/"+id,
          success: function(data) {
            console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listOrder").
                append("<div class='col-md-12'>\
                    <div class='row' id='row'>\
                      <div class='col-md-8'>\
                        <table>\
                        <tr>\
                          <td>Nama : "+users[i].name+"</td>\
                        </tr>\
                          <tr>\
                            <td>Total Pemesanan: Rp."+users[i].price+"</td>\
                          </tr>\
                          <tr>\
                            <td>Tanggal Pemesanan : 24 Oktober 2019</td>\
                          </tr>\
                          <tr>\
                            <td>Status Pembayaran : " + (users[i].status == 1 ? '<span class="badge badge-danger">Belum Bayar</span>': '<span class="badge badge-success">Sudah Bayar</span>') + "</td>\
                          </tr>\
                        </table>\
                      </div>\
                      <div class='col-md-4'>\
                          <a href='detail_order_merchant.html?id_order="+users[i].id+"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Detail Pemesanan</button></a>\
                      </div>\
                    </div>\
                  </div>\
                  ");
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
  }

});
