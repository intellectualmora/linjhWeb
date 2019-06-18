$(function(){
	
	$(window).scroll(function(){
		// 滚动条距离顶部的距离 大于 200px时
		if($(window).scrollTop() >=400){
			$(".gotop").fadeIn(300)
		} else{
			$(".gotop").fadeOut(300)
		}
	});
	
	$(".gotop").click(function(){
		 $('body,html').animate({scrollTop:0},300);
	})
	
	
	
	
	$(".nav-logo").click(function(){
		if($(".phone-nav").hasClass("active")){
			$(".phone-nav").removeClass("active")
			$("body").css("overflow","auto")
		}
		else{
			$(".phone-nav").addClass("active");
			$("body").css("overflow","hidden")
		}
	})
	
	
	
})
