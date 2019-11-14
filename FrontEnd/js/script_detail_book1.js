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
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
            	var str=users[i].description;
               $("#listBook").
                append("<div class='row'>\
                    <div class='col-md-4'>\
                      <img src='pict/buku_pelajaran.jpg' id='pict_book' class='img-thumbnail'>
                    </div>
                    <div class='col-md-8'>
                      <p><b>Judul</b> : users[i]. </p>
                      <p><b>Penerbit</b> : ${i.publisher} </p>
                      <p><b>Penulis</b> : ${i.author}</p>
                      <p><b>Jumlah halaman</b> : 125(+cover)</p>
                      <p><b>ISBN</b> : ${i.isbn}</p>
                      <p><b>Bahasa</b> : Indonesia</p>
                      <p><b>Harga(IDR)</b> : ${i.price}</p>
                    </div>
                    <br>
                    <hr>
                    <br>
                      <div class="content">
                        ${i.description}
                      </div>
                </div>

                  ");
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
	}

});
