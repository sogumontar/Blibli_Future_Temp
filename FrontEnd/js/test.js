var count=0;
var token=localStorage.getItem("Token")
$(document).ready(function(){
    var id=localStorage.getItem("skuLogin")

    //List Order
    $.ajax({
        type:"GET",
        url:"http://localhost:9081/orders/findOrder/"+id+"/1",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        success: function(data) {
            var users = JSON.parse(JSON.stringify(data));

            for (var i in users) {
                count=1;
                $("#London").append("<div id=\"header_content\">\n" +
                    "        <ul id=\"ul_header\">\n" +
                    "          <li id=\"li_header\"><i>&nbsp;&nbsp;&nbsp;&nbsp;"+users[i].createdAt+"</i></li>\n" +
                    "        </ul>\n" +
                    "        <hr>\n" +
                    "      </div>\n" +
                    "      <div class=\"col-md-12\">\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "                <div class='row'>\n" +
                    "                  <div class='col-md-4'><p> Total :  Rp "+users[i].totTrans+",00</p></div>\n" +
                    "                  <div class='col-md-3'><p>Belum bayar</p></div>\n" +
                    "                  <div class='col-md-1'><a onclick='cancel("+users[i].id+")' class='btn btn-danger'>Cancel</a>&nbsp;&nbsp;&nbsp;</div>\n" +
                    "                  <div class='col-md-2'>&nbsp;&nbsp;&nbsp;<a href='' class='btn btn-success'> Bayar</a></div>\n" +
                    "                </div>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div><hr>")
                // console.log(users[i].virtualaccount)

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
});
if(count===0){
    $("#London").append("<div id=\"header_content\">\n" +
        "      <div class=\"col-md-12\">\n" +
        "        <div class=\"row\">\n" +
        "          <div class=\"col-md-12\">\" +
    "              <h1>Nothing in your order list</h1>        "+
    "          </div>\n" +
    "        </div>\n" +
    "      </div><hr>"+
)
}