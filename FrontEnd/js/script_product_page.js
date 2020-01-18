$(document).ready(function(){

  var skuLogin = localStorage.getItem('skuLogin');
  var token = localStorage.getItem('Token');
  var c = new URL(location.href).searchParams.get('token')

  hideNavbar();
  setMerchant();
  assignDataProduct();


  function assignDataProduct(){
		var gbr="5.png";

		$.ajax({
          type:"GET",
          headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
         async: false,
          url:"http://localhost:9081/merchant/getAllByMerchant/"+skuLogin,
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-4 col-md-6 mb-4'>\
                    <div class='card h-100'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='./product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'>"+users[i].title+"</p>\
											</div>\
											<div class='card-footer'>\
												<div class='col-md-12'>\
                          <div class='row'>\
                            <div class='col-md-6'>\
                              <p><a href='update_book.html?id="+users[i].sku_product+"'><button type='button' class='btn btn-outline-primary'  >Update</button></a></p>\
                             </div>\
                            <div class='col-md-6'>\
                              <p><a href='deleteProduk.html?id="+users[i].sku_product+"'><button type='button' class='btn btn-outline-danger' onclick='hai1("+users[i].sku_product+")'>Delete</button></p>\
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
          url:"http://localhost:9081/user/findById/"+skuLogin,
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
  });

  $('#delete_product').click(function(){
    alert("andreas");
  });

  $('#save_change').click(function(){
    var jsonVar = {
      title: document.getElementById('title'),
      description: document.getElementById('description'),
      categories: document.getElementById('category'),
      publication_year: document.getElementById('publication_year'),
      author: document.getElementById('author'),
      publisher: document.getElementById('publisher'),
      isbn: document.getElementById('isbn'),
      price: document.getElementById('price')
    }
  })

});

function hai1(test){
  alert(test)
  // var token=localStorage.getItem("Token");
  // $.ajax({
  //   type:"DELETE",
  //   url:"http://localhost:9081/wishlist/delete/"+test,
  //   headers: {
  //       "Content-Type": "application/json",
  //       "Authorization": "Bearer "+token
  //   },
  //   success:function(data){
  //     alert("Success Delete Book from Wishlist");
  //     location.href="wishlist.html";
  //    }
  // });

}
function updateProduct(){
  var token = localStorage.getItem('Token');
  var id = "MERC-0001-0006";
  $.ajax({
        type:"GET",
        beforeSend : function( xhr ) {
          xhr.setRequestHeader( "Authorization", "Bearer "+token );
        },
        async: false,
        url:"http://localhost:9081/merchant/get/"+id,
        success: function(data) {
          console.log(data.title);
          document.getElementById("title").value = data.title;
          document.getElementById("description").value = data.description;
          document.getElementById("category").value = data.categories;
          document.getElementById("publication_year").value = data.publication_year;
          document.getElementById("author").value = data.author;
          document.getElementById("publisher").value = data.publisher;
          document.getElementById("isbn").value = data.isbn;
          document.getElementById("price").value = data.price;
        },

        error: function(data) {
          console.log(data);
          }
      });
}

