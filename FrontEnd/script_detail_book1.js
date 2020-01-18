var wis;
 var indikator;
 $(document).ready(function(){


  var id = new URL(location.href).searchParams.get('id');
  var token = localStorage.getItem("Token")
  var idLog = localStorage.getItem("skuLogin");
  var role=localStorage.getItem("Role");
  var judul, gambar,kategori,publikasi,harga,pencipta,publish,ibn,skuU,skuP;
  var skuz=localStorage.getItem("skuLogin");
  var skuzz;

        if(role==="ROLE_USER"){
            $("#actions")
            .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id=\"addToCart\" class=\"btn btn-success\">Add To Cart</button>\n \
                <button id=\"addToWishlist\" class=\"btn btn-primary\">Add To WishList</button>\
               ");
        }else if(role==="ROLE_MERCHANT"){
            $("#actions")
                .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id=\"updates\" class=\"btn btn-primary\">Update</button>\n \
                <button id=\"delete\" class=\"btn btn-danger\">Delete</button>\
               ");
        }


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
        $("#gudang").append("<a href='gudang.html?id="+i.sku_merchant+"'>"+i.sku_merchant+"</a>")
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
       skuM=i.sku_merchant;
       html= `

        <div class="row" id="row1">
            <div class="col-md-4">
              <img src="./product/${i.pict_product}" class="card-img-top" id="image">
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
      // console.log("selesai")
    })

    const wait = time => new Promise((resolve) => setTimeout(resolve, time));

    //cek there product in cart
    $.ajax({
      type:"GET",
      headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer "+token
      },
      url:"http://localhost:9081/cart/check/"+skuz+"/"+id,
      success: function(data){
        var checkStatus=JSON.parse(JSON.stringify(data));
        indikator=data;
        // console.log(indikator);
      },
      error: function(err) {
          // alert(err)
      }

  });
    $("#updates").click(function () {
        location.href="update_book.html?id="+id;
    });

     $("#delete").click(function(){
         deletes();
     });
     function deletes(){
         $.ajax({
             type:"DELETE",
             headers: {
                 "Content-Type": "application/json",
                 "Authorization": "Bearer "+token
             },
             url:"http://localhost:9081/product/del/"+id,
             success: function(data){
                 alert("Delete Success");
                 location.href="home_merchant.html?id="+id;
             },
             error: function(err) {
                 // alert(err)
             }
         });
     }
     $("#addToCart").click(function(){
         addCart();
     });

  function addCart(){

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
          sku_product:skuP,
          sku_merchant:skuM
        };
      if(indikator==0){
        $.ajax({
            type:"POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer "+token
            },
            url:"http://localhost:9081/cart/add",
            data: JSON.stringify(jsonVar),
            success: function(data){
                alert("Success add to Cart");
                location.href="detail_book.html?id="+id;
            },
            error: function(err) {
                // alert(err)
            }
        });
      }else{
        alert("This Book Already In Cart");
      }
      }


      $.ajax({
        type:"GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "
        },
        url:"http://localhost:9081/wishlist/check/"+skuz+"/"+id,
        success: function(data){
          wis=data;
          // console.log(wis)
        },
        error: function(err) {
            // alert(err)
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
      if(wis==0){
        $.ajax({
                type:"POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer "+token
                },
                url:"http://localhost:9081/wishlist/add",
                data: JSON.stringify(jsonVar),
                success: function(data){
                  alert("Success add to wisthlist");
                  location.href="detail_book.html?id="+id;
                },
                error: function(err) {
                    alert(err)
                }
        });
      }else{
        alert("This Book Already In WishList");
      }
      });

  });
  // function asd(){
  //   alert("bunatanga")
  //   location.href="cart.html";
  // }