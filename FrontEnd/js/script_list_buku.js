$(document).ready(function(){

	hideNavbar();
	assignDataProduct();

	$('#listBook').click(function(){
		location.href = "detail.html";
	});



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
          contentType: "application/json",
          url:"http://localhost:9080/product/",
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#dat").
                append("<div class='ard' id='card'>\
						      <img src='C:/product/"+users[i].title+"' class='card-img-top' id='image'>\
						      <div class='card-body'>\
						        <div class=''>\
						          <center><h5>" + users[i].title + "</h5></center>\
						        </div>\
						        <div class=''>\
						          <center><h6>SKU : " + users[i].categories + "</h6></center>\
						        </div>\
						        <div class=''>\
						          <center><h5>Rp " + users[i].price + ",00</h5></center>\
						        </div>\
						        <div class=''>\
						          <button type='button' name='button' style='float:left' id='but_del'><a href='update_book.html?id="+users[i].id+"'>Update</a></button>\
						          <button type='button' name='button'  style='float:right' id='but_update'><a href='detail_book.html?id="+users[i].id+"'>Detail</a></button>\
						        </div>\
						      </div>\
						    </div>");
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
	}

});
