$(document).ready(function(){

  var idLogin = localStorage.getItem('idLogin');
  var token = localStorage.getItem('Token');
  var c = new URL(location.href).searchParams.get('token')

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
          url:"http://localhost:9080/merchant/getAllByMerchant/"+idLogin,
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-4 col-md-6 mb-4'>\
                    <div class='card h-100'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'>"+users[i].title+"</p>\
											</div>\
											<div class='card-footer'>\
												<div class='col-md-12'>\
                          <div class='row'>\
                            <div class='col-md-6'>\
                              <p><button type='button' class='btn btn-outline-primary'  data-toggle='modal' data-target='#updateModal'>Update</button></p>\
                            </div>\
                            <div class='col-md-6'>\
                              <p><button type='button' class='btn btn-outline-danger' onclick='hai("+users[i].id+")'  data-toggle='modal' data-target='#exampleModal'>Delete</button></p>\
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
        		xhr.setRequestHeader( "Authorization", "Bearer "+token );
    			},
          url:"http://localhost:9081/user/findById/"+idLogin,
          success: function(data) {
            console.log(data);
            temp =data.name;
          },

          error: function(data) {
            console.log(data);
            }
        });
  }

  $('#but_yes').click(function(){
    var id = localStorage.getItem("productId");
    $.ajax({
          type:"POST",
          beforeSend : function( xhr ) {
        		xhr.setRequestHeader( "Authorization", "Bearer "+token );
    			},
          url:"http://localhost:9081/merchant/deleteById/"+id,
          success: function(data) {
            alert("success");
            location.href = "product_page.html";
          },

          error: function(data) {
            console.log(data);
            }
        });
  })

  // $('#but_yes').click(function(){
  //   localStorage.removeItem("nama");
  // });

});

function hai(product_id){
  localStorage.setItem("productId",product_id);
}
