var penanda=[];
var sub_total = 0;
var id=localStorage.getItem("idLogin");
if(localStorage.getItem("skuLogin")){

}else{
    alert("You must be login");
    location.href = "login.html";
}

$(document).ready(function(){
    $("#tad").append('<a id="bayar" onclick="upd()" class="btn btn-success" href="">Process</a>')

    // var token = new URL(location.href).searchParams.get('token')
    var token=localStorage.getItem("Token")
    var id=localStorage.getItem("skuLogin")
    console.log(id)
    hideNavbar();
    test();
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



    function test(){

        $.ajax({
            type:"GET",
            url:"http://localhost:9081/detailOrder/findAll",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer "+token
            },
            success: function(data) {
                var users = JSON.parse(JSON.stringify(data));
                for (var i in users) {
                    if( users[i].status==2 && users[i].sku_user == id){
                        sub_total = sub_total + users[i].price;
                        $("#dat").
                        append('<div class="row">\
            			          <div class="col-md-4">\
            			            <img src="./product/'+users[i].pict_product+'" id="img_product" alt="">\
            			          </div>\
            			          <div class="col-md-8">\
            			              <table>\
            			                <tr>\
            			                  <td><p><b>Title : </b>'+users[i].title +'</p></td>\
            			                <tr>\
                                  </tr>\
            												<td><p><b>Categori : </b>'+users[i].categories+'</p></td>\
            												<br>\
            			                </tr>\
            			                <tr><br><br>\
            			                  <td><a href="read_book.html?book='+users[i].book+'"><button class="btn btn-secondary"><span class="glyphicon glyphicon-book"></span>&nbsp; Baca</button></a></td>\
            			                </tr>\
            			              </table>\
            			          </div>\
            			        </div><br>');
                    }
                }
                // document.getElementById("set_total").innerHTML = "Sub Total : Rp "+sub_total;
                // console.log(sub_total);

            },
            error: function(data) {
                $("#dat2").
                append("<br><br><br><div class='container-fluid' id='notLogged'>\
          			<center><p>You are not logged in yet <a href='login.html'>Login</a></p></center>\
          		</div>")
                console.log(data);
            }
        });

    }
});
