$(document).ready(function(){

var id = new URL(location.href).searchParams.get('id');
var token = localStorage.getItem("Token")
var idLog = localStorage.getItem("idLogin")
var indikator=0;
  $.ajax({
              type:"GET",
              headers: {
                  "Content-Type": "application/json",
                  "Authorization": "Bearer "+token
              },
              url:"http://localhost:9080/cart/exist/"+idLog+"/"+id,
              success: function(data){
                console.log(data);
                indikator=data;
              },
              error: function(err) {
                

              }
      });


  // const url ='https://swapi.co/api/people'
  const url ="http://localhost:9080/product/get/"+id;
  window.fetch(url,{
    method: 'GET',
    headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },
  }).then((res)=>{
    return res.json()
  }).then((i)=>{
    console.log(i.categories)
    $("#detail").
                append('\
                   <div class="row" id="row1">\
                    <div class="col-md-4">\
                      <img src="pict/buku_pelajaran.jpg" id="pict_book" class="img-thumbnail">\
                    </div>\
                    <div class="col-md-8">\
                      <p><b>Judul</b> : '+i.title+' </p>\
                      <p><b>Penerbit</b> : '+i.publisher+' </p>\
                      <p><b>Penulis</b> : '+i.author+'</p>\
                      <p><b>Jumlah halaman</b> : 125(+cover)</p>\
                      <p><b>ISBN</b> : '+i.isbn+'</p>\
                      <p><b>Bahasa</b> : Indonesia</p>\
                      <p><b>Harga(IDR)</b> : '+i.price+'</p>\
                    </div>\
                    <br>\
                    <hr>\
                    <br>\
                      <div class="content">\
                        '+i.description+'\
                      </div>\
                </div>\
                <br>\
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\
                  ');
                
                
    
  }).then(() => {
    console.log("selesai")
  }).then(()=>console.log("del"))


  const wait = time => new Promise((resolve) => setTimeout(resolve, time));


  console.log("test")


$("#addToCart").click(function(){
  if(indikator!=0){
        alert("Product Sudah Ada Di Cart");
  }else{
   ff();
  var title = new URL(location.href).searchParams.get('title');
  var pict_product = new URL(location.href).searchParams.get('pict_product');
  var categories = new URL(location.href).searchParams.get('categories');
  var publication_year = new URL(location.href).searchParams.get('publication_year');
  var price = new URL(location.href).searchParams.get('price');
  var author = new URL(location.href).searchParams.get('author');
  var publisher = new URL(location.href).searchParams.get('publisher');
  var isbn = new URL(location.href).searchParams.get('isbn');

      var temp_token = localStorage.getItem("Token");
      var jsonVar = {
        id_user: idLog,
        id_product: id,
        status: 1,
        title:title,
        pict_product:pict_product,
        categories:categories,
        publication_year:publication_year,
        price:price,
        author:author,
        publisher:publisher,
        isbn:isbn,
      };

      $.ajax({
              type:"POST",
              headers: {
                  "Content-Type": "application/json",
                  "Authorization": "Bearer "+token
              },
              url:"http://localhost:9080/cart/add",
              data: JSON.stringify(jsonVar),
              success: function(data){
                ff();
                
              },
              error: function(err) {
                  alert(err)

              }
      });
    }

      console.log("binatang ")
    });
});
function ff(){
  alert("Add To Cart Success")

  location.href="cart.html";
}
