$(document).ready(function(){
    var id=localStorage.getItem("skuLogin")
    var token=localStorage.getItem("Token")
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
                $("#London").append("<div id=\"header_content\">\n" +
                    "        <ul id=\"ul_header\">\n" +
                    "          <li id=\"li_header\"><a href=\"\"><b>Gudangnya Buku</b></a></li>\n" +
                    "        </ul>\n" +
                    "        <hr>\n" +
                    "      </div>\n" +
                    "      <div class=\"col-md-12\">\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-8\">\n" +
                    "              <table>\n" +
                    "                <tr>\n" +
                    "                  <td><p>Rp "+users[i].totTrans+",00</p></td>\n" +
                    "                  <td><h4>Belum bayar</h4></td>\n" +
                    "                  <td><a href='' class='btn btn-success'>Bayar</a></td>\n" +
                    "                </tr>\n" +
                    "              </table>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>")
                console.log(users[i].virtualaccount)

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
