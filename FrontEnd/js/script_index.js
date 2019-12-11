$(document).ready(function(){

	var c = new URL(location.href).searchParams.get('token')
	var token = localStorage.getItem('Token');

	hideNavbar();
	assignDataProduct();


$('#kategori').append("<br><hr><br><br>\
			<h2 style='color: #008BFF;'><b><font face='Times New Roman'>Kategori</font></b></h2>\
			<ul class='produk'>\
				<li><div id='pelajaran' class='col-md-4'><a style='font-size:12px;' href='kategori_detail.html?val=buku_pelajaran' value='buku_pelajaran'><img src='Pict/buku_pelajaran.jpg' id='kategori_gambar' ><center><p>Buku Pelajaran</p></center></a></div>\
				</li>\
				<li><div id='anak_anak' class='col-md-4'><a  href='kategori_detail.html?val=buku_anak_anak'><img class='card' src='Pict/buku_anak_anak.jpg' id='kategori_gambar'><center><p>Buku Anak-anak</p></center></div>\
				</li>\
				<li><div id='novel'class='col-md-4'><a  href='kategori_detail.html?val=buku_novel'><img src='Pict/buku_novel.jpg' id='kategori_gambar'><center><p>Buku Novel</p></center></div>\
				</li>\
				<li><div id='fashion'class='col-md-4'><a  href='kategori_detail.html?val=buku_fashion'><img src='Pict/buku_fashion.jpg' id='kategori_gambar'><center><p>Buku Fashion</p></center></div>\
				</li>\
				<li><div id='kesehatan'class='col-md-4'><a  href='kategori_detail.html?val=buku_kesehatan'><img src='Pict/buku_kesehatan2.jpg' id='kategori_gambar'><center><p>Buku Kesehatan</p></center></div>\
				</li>\
				<li><div id='ensiklopedia'class='col-md-4'><a  href='kategori_detail.html?val=buku_ensiklopedia'><img src='Pict/ensiklopedia.jpg' id='kategori_gambar'><center><p>Buku Ensiklopedia</p></center></div>\
				</li>\
			</ul>\
	");

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
					beforeSend : function( xhr ) {
        		xhr.setRequestHeader( "Authorization", "Bearer "+token );
    			},
          url:"http://localhost:9081/product/",
          success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='col-lg-3 col-md-6 mb-4'>\
                    <a href='detail_book.html?id="+users[i].sku_product+"'><div class='card h-100'>\
											<div class='card-body'>\
												<h4 class='card-title'> <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
												<p class='card-text'><b>"+users[i].title+"</b></p>\
											</div>\
											<div class='card-footer'>\
												<center><button class='btn btn-primary' id='but_beli'>Rp "+users[i].price+"</button></center>\
											</div>\
                    </div></a>\
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
