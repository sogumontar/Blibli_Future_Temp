$(document).ready(function(){
var id = new URL(location.href).searchParams.get('id');
var token = new URL(location.href).searchParams.get('token')

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

      <div class="row">
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
  alert("test")
      var temp_token = document.getElementById("temp_token");
      var jsonVar = {
        id: 19,
        id_product: 20,
        status: 1
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
                alert("binatangsss");
              },
              error: function(err) {
                  alert(err)
                 
              }
      });
      console.log("binatang ")
    });
});