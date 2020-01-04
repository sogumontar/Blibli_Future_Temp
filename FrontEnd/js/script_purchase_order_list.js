var count=0;
var token=localStorage.getItem("Token")
var skuOrderList=0;
var finalVA;
console.log("asd")
$(document).ready(function(){
	$("#sendVirtualAccount").click(function(){
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
					alert("Virtual Account Benar")
				}else{
					alert("Virtual Account Salah")
				}
			},
			error: function (err) {
				// alert(err);
			}
		})
	});
	var id=localStorage.getItem("skuLogin")
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
				count++;
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
					"<div class='col-md-4'>\\\n" +
					"\t                      <a onclick='cancel(\"+users[i].id+\")' class='btn btn-danger'>Cancel</a>&nbsp;&nbsp;&nbsp;</div> \\\n" +
					"\t                          <a href='detail_order_book.html?id_order=\"+users[i].id+\"'><button type='button' id='but_pemesanan'><img src='Pict/next.png' id='pict_button'> Detail pemesanan</button></a>\\\n" +
					"\t                      </div>\\"+
					"                  <div class='col-md-1'><a onclick='cancel("+users[i].id+")' class='btn btn-danger'>Cancel</a>&nbsp;&nbsp;&nbsp;</div>\n" +
					"                  <div class='col-md-2'>&nbsp;&nbsp;&nbsp;<a href='' class='btn btn-success' data-toggle='modal' onclick='checkSKU("+users[i].id+")' data-target='#modalSubscriptionForm'>Bayar</a></div>\n" +
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
// alert(count)


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
	skuOrderList=skuOrder;

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
	location.href("purchase_order_list.html")
}

