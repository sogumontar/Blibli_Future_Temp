var skuLogin = localStorage.getItem('skuLogin');
var token = localStorage.getItem('Token');

$(document).ready(function(){

  //method


  $("#send").click(function(){
    var virtual = document.getElementById('vir').value;
    if(virtual == ''){
      alert("Accountvirtual tidak boleh kosong");
    }else {
      getOrderByVirtual(virtual);
    }

  });


  function getOrderByVirtual(virtual){
    $.ajax({
          type:"GET",
          beforeSend : function( xhr ) {
            xhr.setRequestHeader( "Authorization", "Bearer "+token );
          },
          url:"http://localhost:9081/orders/findByVirtual/"+virtual,
          success: function(data) {
            console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#virtual1").
                append("<table class='table-striped'>\
                    <tr>\
                      <td>Sku User </td>\
                      <td>: </td>\
                      <td>"+users[i].skuUser+"</td>\
                    <tr>\
                    <tr>\
                      <td>Total Order :  </td>\
                      <td>: </td>\
                      <td>Rp "+users[i].totTrans+"</td>\
                    <tr>\
                    <tr>\
                      <td>Tanggal Order </td>\
                      <td>: </td>\
                      <td>"+users[i].createdAt+"</td>\
                    <tr>\
                  </table><br>\
                  <button type='button' class='btn btn-success btn-sm' onclick='bayar("+users[i].id+")'>Bayar</button>\
									");
            }
          },

          error: function(data) {
            console.log(data);
            }
        });
  }


});

function bayar(id){
  $.ajax({
        type:"POST",
        beforeSend : function( xhr ) {
          xhr.setRequestHeader( "Authorization", "Bearer "+token );
        },
        url:"http://localhost:9081/orders/updateStatusAcc/"+id,
        success: function(data) {
            //find Detail Orderan
            $.ajax({
                  type:"GET",
                  beforeSend : function( xhr ) {
                    xhr.setRequestHeader( "Authorization", "Bearer "+token );
                  },
                  url:"http://localhost:9081/detailOrder/findByIdOrder/"+data.id,
                  success: function(data1) {
                      //update Status Detail Order
                      var users = JSON.parse(JSON.stringify(data1));
                      for (var i in users) {
                          //looping
                          $.ajax({
                                type:"POST",
                                beforeSend : function( xhr ) {
                                  xhr.setRequestHeader( "Authorization", "Bearer "+token );
                                },
                                url:"http://localhost:9081/detailOrder/updateStatusAcc/"+data1.id,
                                success: function(data2) {

                                },
                                error: function(data2) {
                                  console.log(data2);
                                }
                          });
                      }
                  },

                  error: function(data1) {
                    console.log(data1);
                    }
                });
        },

        error: function(data) {
          console.log(data);
          }
      });
    setInterval(pindah,2000);  
}

function pindah(){
  alert("success melakukan Pembayaran");
  location.href ="pay_order.html";

}
