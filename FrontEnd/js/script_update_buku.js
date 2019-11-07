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


getCasts()