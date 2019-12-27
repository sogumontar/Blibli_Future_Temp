var url = window.location.toString();
var res = new URL(location.href).searchParams.get('id')
var token = localStorage.getItem('Token');
getCasts();
document.getElementById('pict_product').addEventListener('change', handleFileSelect, false);
function handleFileSelect() {
    // var f = evt.target.files[0];
    // var reader = new FileReader();
    // reader.onload = (function(theFile) {
    //     return function(e) {
    //         var binaryData = e.target.result;
    //         //Converting Binary Data to base 64
    //         var base64String = window.btoa(binaryData);
    //         console.log(base64String);
    //         base = base64String;
    //
    //         var jsonVar = {
    //             pict_product: base64String,
    //             book_file: base64String
    //         };
    //         $.ajax({
    //             type:"POST",
    //             url:"http://localhost:9081/merchant/addProductImage",
    //             data: JSON.stringify(jsonVar),
    //             contentType: "application/json",
    //             success: function(data){
    //                 console.log(data.message);
    //             },
    //             error: function(err) {
    //                 $("#message").append(err.responseJSON.message);
    //                 console.log(err.responseJSON.message);
    //             }
    //         });
    //
    //
    //     };
    // })(f);
    // reader.readAsBinaryString(f);
}   

  function getCasts(){
      const url ="http://localhost:9081/product/get/"+res;
      window.fetch(url).then((res)=>{
          return res.json()
  }).then((i)=>{
      $("#gambar").append("<a href='./product/"+i.pict_product+"'><img id='blah' src='./product/"+i.pict_product+"' style='width: 500px; height: 350px;' alt='your image' /></a>")
      // document.getElementById('pict').value="./product/"+i.pict_product;
      document.getElementById('title').value=i.title;
      document.getElementById('descriptions').value=i.description;
      document.getElementById('categories').value=i.categories;
      document.getElementById('publication_year').value=i.publication_year;
      document.getElementById('price').value=i.price;
      document.getElementById('author').value=i.author;
      document.getElementById('isbnV').value=i.isbn;
      document.getElementById('publisher').value=i.publisher;

  }).then(() => {
    // console.log("selesai")
  })

  const wait = time => new Promise((resolve) => setTimeout(resolve, time));


}

getCasts()
 function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah')
                        .attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }

function push(){
  console.log(document.getElementById("pict_product").value);
    alert(document.getElementById("pict_product").value)
    if(document.getElementById("pict_product").value==""){
        alert("tak ada")
    }else{
        alert("ada");
    }
    // var formData = new FormData();
    //         formData.append("file", document.forms["productForm"].file.files[0]);
    //         formData.append('product', new Blob([JSON.stringify({
    //             "title": document.getElementById("title").value,
    //             "description": document.getElementById("description").value,
    //             "categories": document.getElementById("categories").value,
    //             "publication_year": document.getElementById("publication_year").value,
    //             "price": document.getElementById("price").value,
    //             "author": document.getElementById("author").value,
    //             "isbn": document.getElementById("isbn").value,
    //             "publisher": document.getElementById("publisher").value,
    //         })], {
    //                 type: "application/json"
    //             }));
    //         var boundary = Math.random().toString().substr(2);
    //         console.log("asd");
    //         fetch('http://localhost:9081/product/update/' + res, {
    //             method: 'put',
    //             body: formData
    //         }).then(function (response) {
    //           alert("Update Success");
    //               location.href="list_buku.html";
    //             if (response.status !== 200) {
    //                 // alert("There was an error!");
    //             } else {
    //                 alert("Request successful");
    //             }
    //         }).catch(function (err) {
    //             //alert("There was an error!");
    //         });;
    // }

    // var jsonVar = {

    //     title: $("#title").val(),  
    //     description: $("#description").val(),
    //     categories: $("#categories").val(),
    //     publication_year: $("#publication_year").val(),
    //     price: $("#price").val(),  
    //     author: $("#author").val(),
    //     isbn: $("#isbn").val(),
    //     publisher: $("#publisher").val(),
    //     pict_product: $("#pict_product").val()
    // };
    // $.ajax({

    //           type:"PUT",
    //           url:"http://localhost:9081/product/update/" + res,
    //           data: JSON.stringify(jsonVar),
    //           contentType: "application/json",
    //           data: JSON.stringify(jsonVar),
    //           contentType: "application/json",
    //           success: function(data){
    //               alert("Update Success");
    //               location.href="list_buku.html";
    //           },
    //           error: function(err) {
    //               $("#message").append(err.responseJSON.message);
    //               console.log(err.responseJSON.message);
    //           }
    // });
}

function checkPict() {
    if(document.getElementById("pict_product").value===""){
        updateWithoutPict();
    }else{
        updateWithPict();
    }
}
function updateWithoutPict() {

    var title=document.getElementById('title').value;
    var description=document.getElementById('descriptions').value;
    var categories= document.getElementById('categories').value;
    var publication_year=document.getElementById('publication_year').value;
    var price=document.getElementById('price').value;
    var author=document.getElementById('author').value;
    var isbns=document.getElementById('isbnV').value;
    var publisher=document.getElementById('publisher').value;
    console.log(title,description,categories,publication_year,price,author,isbns,publisher);
    $.ajax({
        type : "PUT",
        url : "http://localhost:9081/product/updateWithoutPict/"+title+"/"+description+"/"+categories+"/"+publication_year+"/"+price+"/"+author+"/"+isbns+"/"+publisher+"/"+res,
        contentType: "application/json",
        success:function (data) {
            alert("Update Success")
        },
        error:function (err) {
            alert(err);
        }
    });
}
function updateWithPict(){
    var title=document.getElementById('title').value;
    var description=document.getElementById('descriptions').value;
    var categories= document.getElementById('categories').value;
    var publication_year=document.getElementById('publication_year').value;
    var price=document.getElementById('price').value;
    var author=document.getElementById('author').value;
    var isbns=document.getElementById('isbnV').value;
    var publisher=document.getElementById('publisher').value;
    console.log(title,description,categories,publication_year,price,author,isbns,publisher);
    $.ajax({
        type : "PUT",
        url : "http://localhost:9081/product/updateWithoutPict/"+title+"/"+description+"/"+categories+"/"+publication_year+"/"+price+"/"+author+"/"+isbns+"/"+publisher+"/"+res,
        contentType: "application/json",
        success:function (data) {
            alert("Update Success")
        },
        error:function (err) {
            alert(err);
        }
    });
}