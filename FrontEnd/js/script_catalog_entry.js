$(document).ready(function(){
  var c = new URL(location.href).searchParams.get('token')
  var token = localStorage.getItem('Token');
  var idLogin = localStorage.getItem('idLogin');

  // Check for the File API support.
if (window.File && window.FileReader && window.FileList && window.Blob) {
  document.getElementById('files').addEventListener('change', handleFileSelect, false);
} else {
  alert('The File APIs are not fully supported in this browser.');
}

function handleFileSelect(evt) {
  var f = evt.target.files[0]; // FileList object
  var reader = new FileReader();
  // Closure to capture the file information.
  reader.onload = (function(theFile) {
    return function(e) {
      var binaryData = e.target.result;
      //Converting Binary Data to base 64
      var base64String = window.btoa(binaryData);
      //showing file converted to base64
      //document.getElementById('base64').value = base64String;
      console.log(base64String);
    };
  })(f);
  // Read in the image file as a data URL.
  reader.readAsBinaryString(f);
}

  $('#submit1').click(function(){
    $('#book_file').change(function () {
    console.log(this.files[0].mozFullPath);
  });
  });



  // $("#submit").click(function(){
  //   console.log("cliked")
  //   // var URLS="http://localhost:9094/api/auth/signup"
  //   // fetch(URLS).then((resp)=>resp.json())
  //   // assignUser();
  //   var title=document.getElementById('title').value;
  //   var description=document.getElementById('description').value;
  //   var categories=document.getElementById('categories').value;
  //   var publication_year=document.getElementById('publication_year').value;
  //   var price=document.getElementById('price').value;
  //   var author=document.getElementById('author').value;
  //   var isbn=document.getElementById('isbn').value;
  //   var publisher=document.getElementById('publisher').value;
  //   var pict_product = document.getElementById('picture_product').value;
  //
  //   if(title === "" || description === "" || categories === "" || publication_year === ""
  //     || price === "" || author === "" || isbn === "" || publisher === "" || pict_product === ""){
  //     window.alert("Semua Field Harus di isi")
  //   }else{
  //     insert();
  //   }
  // });


  // function insert(){
  //   var formData = new FormData();
  //       formData.append("file", document.forms["productForm"].file.files[0]);
  //       formData.append('product', new Blob([JSON.stringify({
  //           "title": document.getElementById("title").value,
  //           "description": document.getElementById("description").value,
  //           "categories": document.getElementById("categories").value,
  //           "publication_year": document.getElementById("publication_year").value,
  //           "price": document.getElementById("price").value,
  //           "author": document.getElementById("author").value,
  //           "isbn": document.getElementById("isbn").value,
  //           "publisher": document.getElementById("publisher").value,
  //           "id_merchant": idLogin,
  //       })],
  //       {
  //           type: "application/json"
  //       }));
  //           var boundary = Math.random().toString().substr(2);
  //           console.log("asd");
  //           fetch('http://localhost:9081/merchant/saveProduct', {
  //               method: 'post',
  //               body: formData
  //           }).then(function (response) {
  //               if (response.status !== 200) {
  //                   console.log(response);
  //               } else {
  //                   alert("Request successful");
  //               }
  //           }).catch(function (err) {
  //               console.log(err);
  //           });;
  // }

  function insert2(){
    var formData = new FormData();
        formData.append("file", document.forms["productForm"].book_file.files[0]);
        {
            type: "application/json"
        }));
            var boundary = Math.random().toString().substr(2);
            console.log("asd");
            fetch('http://localhost:9081/merchant/saveProduct2', {
                method: 'post',
                body: formData
            }).then(function (response) {
                if (response.status !== 200) {
                    console.log(response);
                } else {
                    alert("Request successful");
                }
            }).catch(function (err) {
                console.log(err);
            });;
  }

});
