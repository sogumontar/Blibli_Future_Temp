$(document).ready(function(){

  var skuLogin = localStorage.getItem('skuLogin');
  var token = localStorage.getItem('Token');
  var c = new URL(location.href).searchParams.get('token')

  var temp="";
  hideNavbar();
  setMerchant();
  assignDataProduct();

  console.log(idLogin);

  function assignDataProduct(){
		var gbr="5.png";
		$.ajax({
          type:"GET",
          contentType: 'application/json',
          beforeSend : function( xhr ) {
           xhr.setRequestHeader( "Authorization", "Bearer "+token );
         },
          url:"http://localhost:9081/merchant/getAllByMerchant/"+skuLogin,
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-4 col-md-6 mb-5'>\
                    <div id='h'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'>"+users[i].title+"</p>\
											</div>\
											<div class=''>\
												<div class='col-md-12'>\
                          <div class='row'>\
                            <div class='col-md-6'>\
                              <p>Rp "+users[i].price+"</p>\
                            </div>\
                            <div class='col-md-6'>\
                              <p></p>\
                            </div>\
                          </div>\
                        </div>\
											</div>\
                      <hr>\
                      <p class='card-text'>Dijual Oleh : "+temp+"</p>\
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
        		xhr.setRequestHeader( "Authorization", "Bearer "+token );
    			},
          url:"http://localhost:9081/user/findById/"+skuLogin,
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
              url:"http://localhost:9081/merchant/countIdMerchant/"+skuLogin,
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
