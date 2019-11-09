getCasts()
var url = window.location.toString();
url.match(/\?(.+)$/);
var params = RegExp.$1;
var params = params.split("&");
var queryStringList = {};
for(var i=0;i<params.length;i++)
{   var tmp = params[i].split("=");
    queryStringList[tmp[0]] = unescape(tmp[1]);
}
for(var i in queryStringList)
{   var res = queryStringList[i].replace(/[+]/g, " ");
    console.log(i+" = "+res+"<br/>");
}

  function getCasts(){
  const url ="http://localhost:9097/product/"+res;
  window.fetch(url).then((res)=>{
    return res.json()
  }).then((i)=>{
      document.getElementById('title').value=i.title;
      document.getElementById('description').value=i.description;
      document.getElementById('categories').value=i.categories;
      document.getElementById('publication_year').value=i.publication_year;
      document.getElementById('price').value=i.price;
      document.getElementById('author').value=i.author;
      document.getElementById('isbn').value=i.isbn;
      document.getElementById('publisher').value=i.publisher;

  }).then(() => {
    console.log("selesai")
  }).then(()=>console.log("del"))


  const wait = time => new Promise((resolve) => setTimeout(resolve, time));

  
  console.log("test")
}

function push(){
    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var categories = document.getElementById('categories');
    var publication_year = document.getElementById('publication_year');
    var price = document.getElementById('price');
    var author = document.getElementById('author');
    var isbn = document.getElementById('isbn');
    var publisher = document.getElementById('publisher');

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
              type:"PUT",
              url:"http://localhost:9097/product/update/" + res,
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              success: function(data){
                  alert("Update Book Success");
                  location.href="list_buku.html";
              },
              error: function(err) {
                  $("#message").append(err.responseJSON.message);
                  console.log(err.responseJSON.message);
              }
    });
}