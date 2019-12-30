$(document).ready(function(){

	var c = new URL(location.href).searchParams.get('token')
	var token = localStorage.getItem('Token');

	assignDataProduct();



$('#kategori').append("<br>\
			<h2 style='color: #008BFF;'><b><font face='Times New Roman'>Kategori</font></b></h2>\
			<ul class='produk'>\
				<li><div id='pelajaran' class='col-md-4'><a style='font-size:12px;' href='kategori_detail.html?val=buku_pelajaran' value='buku_pelajaran'><img src='Pict/buku_pelajaran.jpg' id='kategori_gambar' ><center><p style='text-align:center'>Pelajaran</p></center></a></div>\
				</li>\
				<li><div id='anak_anak' class='col-md-4'><a  href='kategori_detail.html?val=buku_anak_anak'><img class='card' src='Pict/buku_anak_anak.jpg' id='kategori_gambar'><center><p>Anak-anak</p></center></div>\
				</li>\
				<li><div id='novel'class='col-md-4'><a  href='kategori_detail.html?val=buku_novel'><img src='Pict/buku_novel.jpg' id='kategori_gambar'><center><p>Novel</p></center></div>\
				</li>\
				<li><div id='fashion'class='col-md-4'><a  href='kategori_detail.html?val=buku_fashion'><img src='Pict/buku_fashion.jpg' id='kategori_gambar'><center><p>Fashion</p></center></div>\
				</li>\
				<li><div id='kesehatan'class='col-md-4'><a  href='kategori_detail.html?val=buku_kesehatan'><img src='Pict/buku_kesehatan2.jpg' id='kategori_gambar'><center><p>Kesehatan</p></center></div>\
				</li>\
				<li><div id='ensiklopedia'class='col-md-4'><a  href='kategori_detail.html?val=buku_ensiklopedia'><img src='Pict/ensiklopedia.jpg' id='kategori_gambar'><center><p>Ensiklopedia</p></center></div>\
				</li>\
			</ul>\
	");


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
                append("<div class='col-lg-3 col-md-6 mb-4' id='produk1'>\
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
															<center><a href='front_merchant.html?sku="+users[i].sku_merchant+"'><span class='badge badge-light'>"+users[i].name_merchant+"</span></a></center>\
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

});
