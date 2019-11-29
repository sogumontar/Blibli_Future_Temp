$(document).ready(function(){
  var c = new URL(location.href).searchParams.get('token')
  var token = localStorage.getItem('Token');
  var idLogin = localStorage.getItem('idLogin');
  var base = "";

  // Check for the File API support.
if (window.File && window.FileReader && window.FileList && window.Blob) {
  document.getElementById('picture_product').addEventListener('change', handleFileSelect, false);
  document.getElementById('book_file').addEventListener('change', handlePdf, false);
} else {
  alert('The File APIs are not fully supported in this browser.');
}

function handleFileSelect(evt) {
  var f = evt.target.files[0];
  var reader = new FileReader();
  reader.onload = (function(theFile) {
    return function(e) {
      var binaryData = e.target.result;
      //Converting Binary Data to base 64
      var base64String = window.btoa(binaryData);
      console.log(base64String);
      base = base64String;

      var jsonVar = {
          pict_product: base64String,
          book_file: base64String
      };
      $.ajax({
                type:"POST",
                url:"http://localhost:9081/merchant/addProductImage",
                data: JSON.stringify(jsonVar),
                contentType: "application/json",
                success: function(data){
                    console.log(data.message);
                },
                error: function(err) {
                    $("#message").append(err.responseJSON.message);
                    console.log(err.responseJSON.message);
                }
      });


    };
  })(f);
  reader.readAsBinaryString(f);
}


function handlePdf(evt) {
  var f = evt.target.files[0];
  var reader = new FileReader();
  reader.onload = (function(theFile) {
    return function(e) {
      var binaryData = e.target.result;
      //Converting Binary Data to base 64
      var base64String = window.btoa(binaryData);
      console.log(base64String);
      base = base64String;

      var jsonVar = {
          pict_product: base64String,
          book_file: base64String

      };
      $.ajax({
                type:"POST",
                url:"http://localhost:9081/merchant/addBook",
                data: JSON.stringify(jsonVar),
                contentType: "application/json",
                success: function(data){
                    console.log(data.message);
                },
                error: function(err) {
                    $("#message").append(err.responseJSON.message);
                    console.log(err.responseJSON.message);
                }
      });


    };
  })(f);
  reader.readAsBinaryString(f);
}

  function assignDataProduct(){

      //access APIs
      var jsonVar = {
          title:document.getElementById('title').value,
          description:document.getElementById('description').value,
          categories:document.getElementById('categories').value,
          publication_year:document.getElementById('publication_year').value,
          price:document.getElementById('price').value,
          author:document.getElementById('author').value,
          isbn:document.getElementById('isbn').value,
          publisher:document.getElementById('publisher').value,
          sku_merchant: localStorage.getItem("skuLogin")
      };
      //ajax
      $.ajax({
                type:"POST",
                url:"http://localhost:9081/merchant/saveProduct",
                data: JSON.stringify(jsonVar),
                contentType: "application/json",
                success: function(data){
                    console.log(fix_book);
                },
                error: function(err) {
                    $("#message").append(err.responseJSON.message);
                    console.log(err.responseJSON.message);
                }
      });
      //endlend onload
    }
  

  $('#submit1').click(function(){
    assignDataProduct();
  });


});
