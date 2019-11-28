$(document).ready(function(){

  hideNavbar();

  $(".user").click(function(){
    location.href="block_user.html";
  });
  $(".merchant").click(function(){
    location.href="block_merchant.html";
  });
  $(".category").click(function(){
    location.href="category_book.html";
  });


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
});
