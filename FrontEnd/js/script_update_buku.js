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
  const url ="http://localhost:9081/product/"+res;
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
  console.log("ttt")
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
            fetch('http://localhost:9081/product/update/' + res, {
                method: 'put',
                body: formData
            }).then(function (response) {
              alert("Update Success");
                  location.href="list_buku.html";
                if (response.status !== 200) {
                    // alert("There was an error!");
                } else {
                    alert("Request successful");
                }
            }).catch(function (err) {
                //alert("There was an error!");
            });;
    }

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
// }