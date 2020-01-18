$(document).ready(function(){
  //var
  var id = new URL(location.href).searchParams.get('id_order');
  var token = localStorage.getItem('Token');
  //method
  
alert(id);
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
               if(1 == 1){
								 $("#listOrder").
	                append('<div class="col-xs-12">\
                    <div class="row">\
                      <div class="col-xs-5">\
                        <img src="./product/'+users.pict_product+'" id="image" alt="">\
                      </div>\
                      <div class="col-xs-7">\
                          <table>\
                            <tr>\
                              <td><p><b>Title :'+users.title+'</b></p></td>\
                            </tr>\
                            <tr>\
                              <td><p><b>Price : Rp '+users.price+'<b></p></td>\
                            </tr>\
                            <tr>\
                              <td><b>Status : <b> ' + (users.status == 1 ? ' <span class="badge badge-danger">Belum bayar</span>': '<span class="badge badge-primary"> Sudah Bayar </span>') + '\
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
