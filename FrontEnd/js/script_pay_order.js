var skuLogin = localStorage.getItem('skuLogin');
var token = localStorage.getItem('Token');
var skuOrderList=new URL(location.href).searchParams.get('id');
var finalVA;
$(document).ready(function(){
  //method


  $("#send").click(function(){
    var virtual = document.getElementById('form2').value;
    if(virtual == ''){
      alert("Accountvirtual tidak boleh kosong");
    }else {
      var inputan=document.getElementById("form2").value;
       checkSKU(skuOrderList);
       $.ajax({
           type:"POST",
           url:"http://localhost:9081/orders/checkVA/"+finalVA+"/"+inputan,
           headers:{
               "Content-Type" : "application/json",
               "Authorization": "Bearer "+token
           },
           success: function (data) {
               console.log(data);
               if(data===1){
                   doPayment();
                   bayar();
                   alert("Virtual Account Benar")
               }
           },
           error: function (err) {
               // alert(err);
           }
       })

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
              localStorage.setItem('total_mon',users[i].totTrans);
               $("#virtual1").
                append("<table class='table-striped'>\
                    <tr>\
                      <td><b>Name </b> </td>\
                      <td>: </td>\
                      <td>"+users[i].name+"</td>\
                    <tr>\
                    <tr>\
                      <td><b>Sku User </b></td>\
                      <td>: </td>\
                      <td>"+users[i].skuUser+"</td>\
                    <tr>\
                    <tr>\
                      <td><b>Total Order </b>  </td>\
                      <td>: </td>\
                      <td>Rp "+users[i].totTrans+"</td>\
                    <tr>\
                    <tr>\
                      <td><b>Tanggal Order </b></td>\
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

function bayar(){
  $.ajax({
        type:"POST",
        beforeSend : function( xhr ) {
          xhr.setRequestHeader( "Authorization", "Bearer "+token );
        },
        url:"http://localhost:9081/orders/updateStatusAcc/"+skuOrderList,
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
                      var plus = 0;
                      for (var i in users) {
                        console.log(plus);
                          //looping
                          $.ajax({
                                type:"POST",
                                beforeSend : function( xhr ) {
                                  xhr.setRequestHeader( "Authorization", "Bearer "+token );
                                },
                                url:"http://localhost:9081/detailOrder/updateStatusAcc/"+data1[plus].id,
                                success: function(data2) {
                                  $.ajax({
                                        type:"GET",
                                        beforeSend : function( xhr ) {
                                          xhr.setRequestHeader( "Authorization", "Bearer "+token );
                                        },
                                        url:"http://localhost:9081/money/existBySkuMerchant/"+skuLogin,
                                        success: function(data3) {
                                          if(data3 == 0){
                                            var jsonVar3 = {
                                        			sku_merchant: data2.sku_merchant,
                                              total_mon: localStorage.getItem('total_mon')
                                        		};
                                            $.ajax({
                                        				type:"POST",
                                        				beforeSend : function( xhr ) {
                                        					xhr.setRequestHeader( "Authorization", "Bearer "+token );
                                        				},
                                                data: JSON.stringify(jsonVar3),
                                                contentType: "application/json",
                                        				url:"http://localhost:9081/money/saveMoney",
                                        				success: function(data4) {

                                        				},
                                        				error: function(data4) {
                                        					console.log(data);
                                        					}
                                        			});
                                          }else{
                                            $.ajax({
                                                type:"GET",
                                                beforeSend : function( xhr ) {
                                                  xhr.setRequestHeader( "Authorization", "Bearer "+token );
                                                },
                                                data: JSON.stringify(jsonVar3),
                                                contentType: "application/json",
                                                url:"http://localhost:9081/money/findBySkuMerchant/"+skuLogin,
                                                success: function(data4){
                                                  jum = data4.total_mon + localStorage.getItem('total_mon');
                                                  console.log(jum);
                                                  $.ajax({
                                              				type:"POST",
                                              				beforeSend : function( xhr ) {
                                              					xhr.setRequestHeader( "Authorization", "Bearer "+token );
                                              				},
                                                      data: JSON.stringify(jsonVar3),
                                                      contentType: "application/json",
                                              				url:"http://localhost:9081/money/updateMoney/"+jum+"/"+skuLogin,
                                              				success: function(data4) {
                                                        alert("berhasil");
                                              				},
                                              				error: function(data4) {
                                              					console.log(data);
                                              					}
                                              			});
                                                },
                                                error: function(data4) {
                                                  console.log(data);
                                                  }
                                              });
                                          }
                                        },
                                        error: function(data3) {
                                          //console.log(data2);
                                        }
                                  });
                                },
                                error: function(data2) {
                                  //console.log(data2);
                                }
                          });
                          plus = plus + 1;
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

function cancel(sku) {
    $.ajax({
        type:"DELETE",
        url:"http://localhost:9081/detailOrder/delByOrderId/"+sku,
        headers:{
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        success: function(response){
            console.log(response);
        },
        error: function (err) {
            alert(err)
        }
    })

    $.ajax({
        type: "DELETE",
        url: "http://localhost:9081/orders/deleteById/"+sku,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        success :function(response){
            alert(response);
            location.href="purchase_order_list.html";
        },
        error : function (err) {
            alert(err);
        }
    });
}

function checkSKU(skuOrder) {

    var result;
    $.ajax({
        type: "GET",
        url: "http://localhost:9081/orders/findVA/"+skuOrder,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer "+token
        },
        success :function(data){
            var users = JSON.parse(JSON.stringify(data));
            result=users.virtualaccount;
            finalVA=users.virtualaccount;
        },
        error : function (err) {
            alert(err);
        }
    });
    return result
}

function doPayment() {
    $.ajax({
       type : "PUT",
       url : "http://localhost:9081/orders/updateById/"+skuOrderList,
        headers:{
            "Content-Type" : "application/json",
            "Authorization" : "Bearer "+token
        },
        success : function(success){
           console.log(success);
        },
        error : function (err) {
            alert(err);
        }
    });

    $.ajax({
        type:"PUT",
        url : "http://localhost:9081/detailOrder/updateByIdOrder/"+skuOrderList,
        headers:{
            "Content-Type" : "application/json",
            "Authorization" : "Bearer "+token
        },
        success : function(success){
            console.log(success);
        },
        error : function (err) {
            alert(err);
        }
    });

    alert("Do Payment")
    location.href="index.html"
}
