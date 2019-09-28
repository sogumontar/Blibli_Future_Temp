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
               $("tbody").
                append("<tr> \
                            <td>" +  users[i].id + "</td> \
                            <td>" +  users[i].title + "</td> \
                            <td>" +  users[i].description + "</td> \
                            <td>" +  users[i].publication_year + "</td> \
                            <td> \ <button id='delete' class='btn btn-danger'>Delete</button> \
                           <button id='edit' class='btn btn-warning'>Edit</button> \ </td> \
                        </tr>");
            }
          },
          error: function(data) { 
            console.log(data);
            }
        });
	}
})