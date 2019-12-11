$(document).ready(function(){
  //var
  var id = new URL(location.href).searchParams.get('id_order');
  var token = localStorage.getItem('Token');
  //method
  getDetailOrder();


  function getDetailOrder(){
    $.ajax({
					type:"GET",
					beforeSend : function( xhr ) {
						xhr.setRequestHeader( "Authorization", "Bearer "+token );
					},
					url:"http://localhost:9081/detailOrder/findByIdOrder/"+id,
					success: function(data) {
						console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               if(users[i].status == 1){
								 $("#listOrder").
	                append('<div class="col-md-12">\
                    <div class="row">\
                      <div class="col-md-4">\
                        <img src="C:/product/'+users[i].pict_product+'" id="image" alt="">\
                      </div>\
                      <div class="col-md-8">\
                          <table>\
                            <tr>\
                              <td><p>'+users[i].title+'</p></td>\
                            </tr>\
                            <tr>\
                              <td><p>Rp '+users[i].price+'</p></td>\
                            </tr>\
                            <tr>\
                              <td><h4>Belum bayar</h4></td>\
                            </tr>\
                          </table>\
                      </div>\
                    </div>\
                  </div>');
							 }
            }
					},

					error: function(data) {
						console.log(data);
						}
				});
  }
});
