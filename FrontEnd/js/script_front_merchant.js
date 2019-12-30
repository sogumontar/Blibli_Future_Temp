$(document).ready(function(){

  var skuMerchant = new URL(location.href).searchParams.get('sku');
  var token = localStorage.getItem('Token');

  var temp="";
  hideNavbar();
  setMerchant();
  assignDataProduct();



  function assignDataProduct(){
		var gbr="5.png";
		$.ajax({
          type:"GET",
          contentType: 'application/json',
          beforeSend : function( xhr ) {
           xhr.setRequestHeader( "Authorization", "Bearer "+token);
          },
          url:"http://localhost:9081/merchant/getAllByMerchant/"+skuMerchant,
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-3 col-md-6 mb-4'>\
                    <a href='detail_book.html?id="+users[i].sku_product+"'><div class='card h-100'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='./product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'><b>"+users[i].title+"</b></p>\
											</div></a>\
											<div class='card-footer'>\
												<div class='col-md-12'>\
													<div class='row'>\
														<div class='col-md-6'>\
														 <center><span class='badge badge-success'>Rp "+users[i].price+"</span></center>\
														</div>\
														<div class='col-md-6'>\
															<center><span class='badge badge-light'>"+users[i].name_merchant+"</span></center>\
														</div>\
													</div>\
												</div>\
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

  function setMerchant(){
    //set name of merchant
    $.ajax({
          type:"GET",
          beforeSend : function( xhr ) {
        		xhr.setRequestHeader( "Authorization", "Bearer "+token);
    			},
          url:"http://localhost:9081/user/findById/"+skuMerchant,
          success: function(data) {
            console.log(data);
            $('#toko').text(data.name);
            temp =data.name;
          },

          error: function(data) {
            console.log(data);
            }
        });

        //set Count Product
        $.ajax({
              type:"GET",
              beforeSend : function( xhr ) {
            		xhr.setRequestHeader( "Authorization", "Bearer "+token );
        			},
              url:"http://localhost:9081/merchant/countIdMerchant/"+skuMerchant,
              success: function(data) {
                console.log(data);
                $('#number_produk').text("Product : "+data);
                temp =data.name;
              },

              error: function(data) {
                console.log(data);
                }
            });

  }


});
