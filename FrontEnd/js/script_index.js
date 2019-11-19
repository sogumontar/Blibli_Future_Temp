$(document).ready(function(){


	var c = new URL(location.href).searchParams.get('token')
	

	hideNavbar();
	assignDataProduct();

	$('#listBook').click(function(){
		location.href = "detail_book.html?token="+c;
	});
$('#kategori').append("<br><hr><br><br>\
			<h2 style='color: #008BFF;'><b><font face='Times New Roman'>Kategori</font></b></h2>\
			<ul class='produk'>\
				<li><div id='pelajaran'><a style='font-size:12px;' href='kategori_detail.html?val=buku_pelajaran&token="+c+"' value='buku_pelajaran'><img src='Pict/buku_pelajaran.jpg' id='kategori_gambar' ><center><p id='buku_pelajaran' value='Buku Pelajaran'>Buku Pelajaran</p></center></a></div>\
				</li>\
				<li><div id='anak_anak' ><a  href='kategori_detail.html?val=buku_anak_anak&token="+c+"'><img src='Pict/buku_anak_anak.jpg' id='kategori_gambar'><center><p style='font-size:12px;' id='buku_anak_anak' value='Buku Anak anak'>Buku Anak - anak</p></center></div>\
				</li>\
				<li><div id='novel'><a  href='kategori_detail.html?val=buku_novel&token="+c+"'><img src='Pict/buku_novel.jpg' id='kategori_gambar'><center><p id='buku_novel' value='Buku Novel'>Buku Novel</p></center></div>\
				</li>\
				<li><div id='fashion'><a  href='kategori_detail.html?val=buku_fashion&token="+c+"'><img src='Pict/buku_fashion.jpg' id='kategori_gambar'><center><p id='buku_fashion' value='Buku Fashion'>Buku Fashion</p></center></div>\
				</li>\
				<li><div id='kesehatan'><a  href='kategori_detail.html?val=buku_kesehatan&token="+c+"'><img src='Pict/buku_kesehatan2.jpg' id='kategori_gambar'><center><p id='buku_kesehatan' value='Buku Kesehatan'>Buku Kesehatan</p></center></div>\
				</li>\
				<li><div id='ensiklopedia'><a  href='kategori_detail.html?val=buku_ensiklopedia&token="+c+"'><img src='Pict/ensiklopedia.jpg' id='kategori_gambar'><center><p id='buku_ensiklopedia' value='Buku Ensiklopedia'>Ensiklopedia</p></center></div>\
				</li>\
			</ul>\
	");

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
		var gbr="5.png";
		$.ajax({
          type:"GET",
					headers: {
			        "Content-Type": "application/json",
			        "Authorization": "Bearer "+c
			    },
          url:"http://localhost:9080/product/",
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-3 col-md-6 mb-4'>\
                    <div class='card h-100'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'>.....</p>\
											</div>\
											<div class='card-footer'>\
												<button class='btn btn-primary' id='but_beli'>Beli Sekarang</button>\
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
