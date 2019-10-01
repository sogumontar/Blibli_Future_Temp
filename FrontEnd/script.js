$(document).ready(function(){

	assignDataProduct();

	function assignDataProduct(){
		$.ajax({    
          type:"GET",
          contentType: "application/json",
          url:"http://localhost:9090/delKindle/product/",
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#listBook").
                append("<div class='card' style='width: 18rem;margin-right: 5px;margin-left: 5px;margin-bottom:20px'>\
                  <img src='pict/rahasia-penerbit-ini-gambaran-royalti-ketika-buku-diretur-dari-toko-170526s.jpg' class='card-img-top' alt=''>\
                    <div class='card-body'>\
                      <center><p>" + users[i].title+"</p></center>\
                      <div class='row'>\
                        <div class='col-md-6'>\
                          <p>"+ users[i].price+ "</p>\
                        </div>\
                        <div class='col-md-6'>\
                          <p>"+ users[i].publisher+ "</p>\
                        </div>\
                      </div>\
                    </div>\
                  </div>");
            }
          },
          error: function(data) { 
            console.log(data);
            }
        });
	}
})