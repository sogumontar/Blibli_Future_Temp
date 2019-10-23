$(document).ready(function(){

  $(".btn").click(function(){
    uploadFile();

    // var jsonVar = {
    //   title: $("#title").val(),
    //   description: $("#description").val(),
    //   categories: $("#categories").val(),
    //   publication_year: $("#publication_year").val(),
    //   price: $("#price").val(),
    //   author: $("#author").val(),
    //   isbn: $("#isbn").val(),
    //   picture_product: $("#picture_product").val(),
    //   publisher: $("#publisher").val()
    // };

    // $.ajax({
    //     type:"POST",
    //     url:"http://localhost:9094/product/createProduct",
    //     data: JSON.stringify(jsonVar),
    //     contentType: "application/json",
    //     success: function(data){
    //         $("#notifikasi").
    //         append("<div class='alert alert-success'> Success add product..</div>")
    //     },
    //     error: function(err) {
    //         console.log(err);
    //         alert(err);
    //     }
    // });

  });

  function uploadFile(){
    var fullPath = document.getElementById('picture_product').value;
    if (fullPath) {
        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
        var filename = fullPath.substring(startIndex);
        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
            filename = filename.substring(1);
        }
        alert(filename);
    }
  }
  function doAjax() {

    // Get form
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/file/upload",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        success: (data) => {
            $("#listFiles").text(data);
        },
        error: (e) => {
            $("#listFiles").text(e.responseText);
        }
    });
}



});
