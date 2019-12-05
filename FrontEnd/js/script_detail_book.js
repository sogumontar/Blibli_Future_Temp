
var indikator;
$(document).ready(function(){

  var id = new URL(location.href).searchParams.get('id');
  var token = localStorage.getItem("Token")
  var idLog = localStorage.getItem("skuLogin")
  var judul, gambar,kategori,publikasi,harga,pencipta,publish,ibn,skuU,skuP;
  var skuz=localStorage.getItem("skuLogin");
  var skuzz;
  var wis=0;
  
    // const url ='https://swapi.co/api/people'
    const url ="http://localhost:9081/product/get/"+id;
    window.fetch(url,{
      method: 'GET',
      headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer "+token
            },
    }).then((res)=>{
      return res.json()
    }).then((i)=>{
    
       skuzz=i.sku_product;
       judul=i.title;
       gambar=i.pict_product;
       kategori=i.categories;
       publikasi=i.publication_year;
       harga=i.price;
       pencipta=i.author;
       publish=i.publisher;
       ibn=i.isbn;
       skuU=i.sku_user;
       skuP=i.sku_product;
       html= `
  
        <div class="row" id="row1">
            <div class="col-md-4">
              <img src="/../../e.png" id="pict_book" class="img-thumbnail">
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
  
    $.ajax({
      type:"GET",
      headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer "+token
      },
      url:"http://localhost:9081/cart/check/"+skuz+"/"+id,
      success: function(data){
        indikator=data;
        console.log(indikator);
      },
      error: function(err) {
          alert(err)
  
      }
  
  });
  $("#addToCart").click(function(){
  
        var temp_token = localStorage.getItem("Token");
        var jsonVar = {
          status:1,
          title:judul,
          pict_product:gambar,
          categories:kategori,
          publication_year:publikasi,
          price:harga,
          author:pencipta,
          publisher:publish,
          isbn:ibn,
          sku_user:idLog,
          sku_product:skuP
        };
      if(indikator==0){
        alert("Success Add To Cart")
        $.ajax({
                type:"POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer "+token
                },
                url:"http://localhost:9081/cart/add",
                data: JSON.stringify(jsonVar),
                success: function(data){
                },
                error: function(err) {
                    alert(err)
  
                }
        });
  
                  location.href="cart.html";
        console.log("binatang ")
      }else{
        alert("This Book Already In Cart")
        // asd();
        
      }
      });
  
  
      $.ajax({
        type:"GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        url:"http://localhost:9081/wishlist/check/"+skuz+"/"+id,
        success: function(data){
          wis=data;
          console.log(wis)
        },
        error: function(err) {
            alert(err)
    
        }
    
    });
  
  
      $("#addToWishlist").click(function(){
  
        var temp_token = localStorage.getItem("Token");
        var jsonVar = {
          status:1,
          title:judul,
          pict_product:gambar,
          categories:kategori,
          publication_year:publikasi,
          price:harga,
          author:pencipta,
          publisher:publish,
          isbn:ibn,
          sku_user:idLog,
          sku_product:skuP
        };
      if(wis===0){
  
        $.ajax({
                type:"POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer "+token
                },
                url:"http://localhost:9081/wishlist/add",
                data: JSON.stringify(jsonVar),
                success: function(data){
                  alert(data)
                },
                error: function(err) {
                    alert(err)
  
                }
        });
  
                  location.href="cart.html";
        
      }else{
        alert("This Book Already In WishList")
        
      }
      });
    
  });
  // function asd(){
  //   alert("bunatanga")
  //   location.href="cart.html";
  // }
  