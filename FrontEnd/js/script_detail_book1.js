$(document).ready(function(){

	var c = new URL(location.href).searchParams.get('token')

	console.log(c);

	hideNavbar();
	assignDataProduct();



	//for navbar
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
					headers: {
			        "Content-Type": "application/json",
			        "Authorization": "Bearer "+c
			    },
          url:"http://localhost:9097/product/get",
          success: function(data) {
						console.log(data.length);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
            	var str=users[i].description;
               $("#listBook").
                append("<h1>asd<h1>");
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
	}

});
