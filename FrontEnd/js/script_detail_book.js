$(document).ready(function(){

var id = new URL(location.href).searchParams.get('id');
var token = localStorage.getItem("Token")
var idLog = localStorage.getItem("skuLogin")
var skuz=localStorage.getItem("skuLogin");
var skuP = '';
var indikator = 0;


$.ajax({
        type:"GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        url:"http://localhost:9081/product/get/"+id,
        success: function(data){
          var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#detail").
                append("<div class='row' id='row1'>
                  <div class='col-md-4'>
                    <img src='C:/product/${i.pict_product}'' class='img-thumbnail' id='image'>
                  </div>
                  <div class='col-md-8'>
                    <p><b>Judul</b> : ${i.title} </p>
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
                    <div class='content'>
                      ${i.description}
                    </div>
              </div>");
            }
        },
        error: function(err) {
            alert(err)
        }
});

});
