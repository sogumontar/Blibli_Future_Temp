$(document).ready(function(){

  $("#submit").click(function(){
    console.log("cliked")
    // var URLS="http://localhost:9094/api/auth/signup"
    // fetch(URLS).then((resp)=>resp.json())
    // assignUser();
    var title=document.getElementById('title').value;
    var description=document.getElementById('description').value;
    var categories=document.getElementById('categories').value;
    var publication_year=document.getElementById('publication_year').value;
    var price=document.getElementById('price').value;
    var author=document.getElementById('author').value;
    var isbn=document.getElementById('isbn').value;
    var publisher=document.getElementById('publisher').value;
    var pict_product = document.getElementById('picture_product').value;

    if(title === "" || description === "" || categories === "" || publication_year === ""
      || price === "" || author === "" || isbn === "" || publisher === "" || pict_product === ""){
      window.alert("Semua Field Harus di isi")
    }else{
      insert();
    }
  });

  function insertProduct(){

     var jsonVar = {
        title: $("#title").val(),
        description: $("#description").val(),
        categories: $("#categories").val(),
        publication_year: $("#publication_year").val(),
        price: $("#price").val(),
        author: $("#author").val(),
        isbn: $("#isbn").val(),
        publisher: $("#publisher").val(),
        picture_product: $("#picture_product").val()
    };
    $.ajax({
              type:"POST",
              url:"http://localhost:9097/product/simpan",
              data: JSON.stringify(jsonVar),
              contentType: false,
              success: function(data){
                  console.log(data.message);
              },
              error: function(err) {
                  $("#message").append(err.responseJSON.message);
                  console.log(err.responseJSON.message);
              }
    });
  }

  function insert(){
    var formData = new FormData();
            formData.append("file", document.forms["productForm"].file.files[0]);
            formData.append('product', new Blob([JSON.stringify({
                "title": document.getElementById("title").value,
                "description": document.getElementById("description").value,
                "categories": document.getElementById("categories").value,
                "publication_year": document.getElementById("publication_year").value,
                "price": document.getElementById("price").value,
                "author": document.getElementById("author").value,
                "isbn": document.getElementById("isbn").value,
                "publisher": document.getElementById("publisher").value,
            })], {
                    type: "application/json"
                }));
            var boundary = Math.random().toString().substr(2);
            console.log("asd");
            fetch('http://localhost:9097/product/simpan', {
                method: 'post',
                body: formData
            }).then(function (response) {
                if (response.status !== 200) {
                    // alert("There was an error!");
                } else {
                    alert("Request successful");
                }
            }).catch(function (err) {
                //alert("There was an error!");
            });;
  }

});
