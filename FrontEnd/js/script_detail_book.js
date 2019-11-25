$(document).ready(function(){
var id = new URL(location.href).searchParams.get('id');
var token = localStorage.getItem("Token")
var idLog = localStorage.getItem("idLogin")

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
    const html= `

      <div class="row" id="row1">
          <div class="col-md-4">
            <img src="pict/buku_pelajaran.jpg" id="pict_book" class="img-thumbnail">
          </div>
          <div class="col-md-8">
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
            <div class="content">
              ${i.description}
            </div>
      </div>

    `
    window.detail.innerHTML =html


  }).then(() => {
    console.log("selesai")
  }).then(()=>console.log("del"))


  const wait = time => new Promise((resolve) => setTimeout(resolve, time));


  console.log("test")


$("#addToCart").click(function(){
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

                window.alert("Add To Cart, Success");
                window.location.href="cart.html";
      $.ajax({
              type:"POST",
              headers: {
                  "Content-Type": "application/json",
                  "Authorization": "Bearer "+token
              },
              url:"http://localhost:9080/cart/add",
              data: JSON.stringify(jsonVar),
              success: function(data){
                window.alert("Add To Cart, Success");
                window.location.href="cart.html";
              },
              error: function(err) {
                  alert(err)

              }
      });

      console.log("binatang ")
    });
});
