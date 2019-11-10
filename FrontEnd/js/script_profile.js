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
  // const url ='https://swapi.co/api/people'
  const url ="http://localhost:9097/product/"+res;
  window.fetch(url).then((res)=>{
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
}


getCasts()
