$(document).ready(function(){

  hideNavbar();
  assignDataUser();

  $('#search').click(function(){
    var input=document.getElementById('input').value;
    assignDataByName(input);
  });

  // function asd(){
  //   console.log("andreas");
  // }

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
  function assignDataUser(){
    $.ajax({
          type:"GET",
          headers: {
              "Content-Type": "application/json",
              // "Authorization": "Bearer "+c
          },
          url:"http://localhost:9081/user/getAll",
          success: function(data) {
            console.log(data);
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               if(users[i].roles[0].name== "ROLE_USER"){
                 $("#listSearch").
                  append('<div class="col-md-12">\
                      <div class="row">\
                        <div class="col-md-8">\
                          <table>\
                            <tr>\
                              <td>Name : ' + users[i].name + '</td>\
                            </tr>\
                            <tr>\
                              <td>Role : ' + users[i].roles[0].name+ '</td>\
                            </tr>\
                            <tr>\
                              <td>Status : ' + (users[i].status == 1 ? 'Active': 'Block') + '</td>\
                            </tr>\
                          </table>\
                        </div>\
                        <div>\
                          ' + (users[i].status == 1 ? '<a href="update_block.html?id='+users[i].id+'"><button type="button" class="btn btn-outline-danger" id="but_block"><img src="Pict/wrong.png" id="pict_button"> Block</button></a>': '<a href="update_active.html?id='+users[i].id+'"><button type="button" class="btn btn-outline-primary" id="but_active"><img src="Pict/cek.png" id="pict_button"> Active</button></a>') + '\
                        </div>\
                      </div>\
                  </div>\
                    ');
               }
            }
          },
          error: function(data) {
            console.log(data);
            }
        });
      }

      function assignDataByName(name){
        $.ajax({
              type:"GET",
              headers: {
                  "Content-Type": "application/json",
                  // "Authorization": "Bearer "+c
              },
              url:"http://localhost:9081/user/findByName/"+name,
              success: function(data) {
                console.log(data);
                $("#listSearch").hide();
                var users = JSON.parse(JSON.stringify(data));
                for (var i in users) {
                   $("#listUser").
                    append('<div class="col-md-12">\
                        <div class="row">\
                          <div class="col-md-8">\
                            <table>\
                              <tr>\
                                <td>Name : ' + users[i].name + '</td>\
                              </tr>\
                              <tr>\
                                <td>Role : ' + users[i].roles[0].name+ '</td>\
                              </tr>\
                              <tr>\
                                <td>Status : ' + (users[i].status == 1 ? 'Active': 'Block') + '</td>\
                              </tr>\
                            </table>\
                          </div>\
                          <div>\
                            ' + (users[i].status == 1 ? '<button type="button" class="btn btn-outline-danger" id="but_block"><img src="Pict/wrong.png" id="pict_button"> Block</button>': '<button type="button" class="btn btn-outline-primary" id="but_active"><img src="Pict/cek.png" id="pict_button"> Active</button>') + '\
                          </div>\
                        </div>\
                    </div>\
                      ');
                }
              },
              error: function(data) {
                console.log(data);
                }
            });
      }


});
