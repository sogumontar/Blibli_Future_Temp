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

    if(title === "" || description === "" || categories === "" || publication_year === "" 
      || price === "" || author === "" || isbn === "" || publisher === ""){
      window.alert("Semua Field Harus di isi")
    }else{
      insertProduct();  
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
        publisher: $("#publisher").val()
    };
    $.ajax({
              type:"POST",
              url:"http://localhost:9094/product/insert",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
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

  }
});