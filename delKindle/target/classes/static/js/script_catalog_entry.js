$(document).ready(function(){

  hideNavbar();

  $(".btn").click(function(){
    event.preventDefault();
    doAjax();

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

    var jsonVar = {
      data1: data,
      title: $("#title").val()
    };

    // console.log(data);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        // url: "/api/file/upload",
        url: "http://localhost:9094/product/createFile",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        success: (data) => {
            // $("#listFiles").text(data);
            console.log("suksess");
        },
        error: (e) => {
            console.log(e.responseText);
            // $("#listFiles").text(e.responseText);
        }
    });
  }

  function hideNavbar(){
		var prevScrollpos = window.pageYOffset;
		window.onscroll = function() {
		var currentScrollPos = window.pageYOffset;
		  if (prevScrollpos > currentScrollPos) {
		    document.getElementById("navbar").style.top = "0";
		  } else {
		    document.getElementById("navbar").style.top = "-50px";
		  }
		  prevScrollpos = currentScrollPos;
		}
	}



});
