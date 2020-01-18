
var url = window.location.toString();
var res = new URL(location.href).searchParams.get('id')
var token = localStorage.getItem('Token');
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
function checkPict() {
    alert("mask")
    if(document.getElementById("picture_product").value===""){
        alert("ada")
        updateWithoutPict();
    }else{
        alert("gadak")
        updateWithPict();
    }
}
function updateWithoutPict() {
    var title=document.getElementById('title').value;
    var description=document.getElementById('descriptions').value;
    var categories= document.getElementById('categories').value;
    var publication_year=document.getElementById('publication_year').value;
    var price=document.getElementById('price').value;
    var author=document.getElementById('author').value;
    var isbns=document.getElementById('isbnV').value;
    var publisher=document.getElementById('publisher').value;
    console.log(title,description,categories,publication_year,price,author,isbns,publisher);
    $.ajax({
        type : "PUT",
        url : "http://localhost:9081/product/updateWithoutPict/"+title+"/"+description+"/"+categories+"/"+publication_year+"/"+price+"/"+author+"/"+isbns+"/"+publisher+"/"+res,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        success:function (data) {
            alert("Update Success")
        },
        error:function (err) {
            alert(err);
        }
    });
    alert("Update Success")
}
function updateWithPict(){

    var title=document.getElementById('title').value;
    var description=document.getElementById('descriptions').value;
    var categories= document.getElementById('categories').value;
    var publication_year=document.getElementById('publication_year').value;
    var price=document.getElementById('price').value;
    var author=document.getElementById('author').value;
    var isbns=document.getElementById('isbnV').value;
    var publisher=document.getElementById('publisher').value;
    console.log(title,description,categories,publication_year,price,author,isbns,publisher);
    $.ajax({
        type : "PUT",
        url : "http://localhost:9081/product/updateWithoutPict/"+title+"/"+description+"/"+categories+"/"+publication_year+"/"+price+"/"+author+"/"+isbns+"/"+publisher+"/"+res,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        success:function (data) {
            alert("Update Success")
        },
        error:function (err) {
            alert(err);
        }
    });
    alert("Update Success")
}
$(document).ready(function(){
    getCasts();
    var c = new URL(location.href).searchParams.get('token')
    var token = localStorage.getItem('Token');
    var idLogin = localStorage.getItem('skuLogin');
    var base = "";
    var name = localStorage.getItem('name');

    // Check for the File API support.
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        document.getElementById('picture_product').addEventListener('change', handleFileSelect, false);
        document.getElementById('book_file').addEventListener('change', handlePdf, false);
    } else {
        alert('The File APIs are not fully supported in this browser.');
    }



    function getCasts(){
        const url ="http://localhost:9081/product/get/"+res;
        window.fetch(url).then((res)=>{
            return res.json()
        }).then((i)=>{
            $("#gambar").append("<a href='./product/"+i.pict_product+"'><img id='blah' src='./product/"+i.pict_product+"' style='width: 500px; height: 350px;' alt='your image' /></a>")
            // document.getElementById('pict').value="./product/"+i.pict_product;
            document.getElementById('title').value=i.title;
            document.getElementById('descriptions').value=i.description;
            document.getElementById('categories').value=i.categories;
            document.getElementById('publication_year').value=i.publication_year;
            document.getElementById('price').value=i.price;
            document.getElementById('author').value=i.author;
            document.getElementById('isbnV').value=i.isbn;
            document.getElementById('publisher').value=i.publisher;

        }).then(() => {
            // console.log("selesai")
        })

        const wait = time => new Promise((resolve) => setTimeout(resolve, time));


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
                    beforeSend : function( xhr ) {
                        xhr.setRequestHeader( "Authorization", "Bearer "+token );
                    },
                    data: JSON.stringify(jsonVar),
                    contentType: "application/json",
                    success: function(data){
                        alert("masuk")
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
                    beforeSend : function( xhr ) {
                        xhr.setRequestHeader( "Authorization", "Bearer "+token );
                    },
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
            sku_merchant: localStorage.getItem("skuLogin"),
            name_merchant: localStorage.getItem("name")
        };
        //ajax
        $.ajax({
            type:"POST",
            url:"http://localhost:9081/merchant/saveProduct",
            data: JSON.stringify(jsonVar),
            contentType: "application/json",
            success: function(data){
                alert("success add product");
                location.href = "home_merchant.html";
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
