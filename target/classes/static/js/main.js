jQuery(function($) {'use strict';

	//Responsive Nav
	$('li.dropdown').find('.fa-angle-down').each(function(){
		$(this).on('click', function(){
			if( $(window).width() < 768 ) {
				$(this).parent().next().slideToggle();
			}
			return false;
		});
	});

	//Fit Vids
	if( $('#video-container').length ) {
		$("#video-container").fitVids();
	}

	//Initiat WOW JS
	new WOW().init();

	// portfolio filter
	$(window).load(function(){

		$('.main-slider').addClass('animate-in');
		$('.preloader').remove();
		//End Preloader

		if( $('.masonery_area').length ) {
			$('.masonery_area').masonry();//Masonry
		}

		var $portfolio_selectors = $('.portfolio-filter >li>a');
		
		if($portfolio_selectors.length) {
			
			var $portfolio = $('.portfolio-items');
			$portfolio.isotope({
				itemSelector : '.portfolio-item',
				layoutMode : 'fitRows'
			});
			
			$portfolio_selectors.on('click', function(){
				$portfolio_selectors.removeClass('active');
				$(this).addClass('active');
				var selector = $(this).attr('data-filter');
				$portfolio.isotope({ filter: selector });
				return false;
			});
		}

	});


	$('.timer').each(count);
	function count(options) {
		var $this = $(this);
		options = $.extend({}, options || {}, $this.data('countToOptions') || {});
		$this.countTo(options);
	}
		
	// Search
	$('.fa-search').on('click', function() {
		$('.field-toggle').fadeToggle(200);
	});

	// Contact form
	var form = $('#main-contact-form');
	form.submit(function(event){
		event.preventDefault();
		var form_status = $('<div class="form_status"></div>');
		$.ajax({
			url: $(this).attr('action'),
			beforeSend: function(){
				form.prepend( form_status.html('<p><i class="fa fa-spinner fa-spin"></i> Email is sending...</p>').fadeIn() );
			}
		}).done(function(data){
			form_status.html('<p class="text-success">Thank you for contact us. As early as possible  we will contact you</p>').delay(3000).fadeOut();
		});
	});

	// Progress Bar
	$.each($('div.progress-bar'),function(){
		$(this).css('width', $(this).attr('data-transition')+'%');
	});

	if( $('#gmap').length ) {
		var map;

		map = new GMaps({
			el: '#gmap',
			lat: 43.04446,
			lng: -76.130791,
			scrollwheel:false,
			zoom: 16,
			zoomControl : false,
			panControl : false,
			streetViewControl : false,
			mapTypeControl: false,
			overviewMapControl: false,
			clickable: false
		});

		map.addMarker({
			lat: 43.04446,
			lng: -76.130791,
			animation: google.maps.Animation.DROP,
			verticalAlign: 'bottom',
			horizontalAlign: 'center',
			backgroundColor: '#3e8bff',
		});
	}

});

//Login Email
$('#email').keyup( function(){
	var username = $( this ).val();
	var regexp = /^(\w+@\w+){1,1}(\.\w+){1,2}$/;
	if( regexp.test( username ) ) {
		$('#emailmsg').css('color','green');
		$('#emailmsg').text('邮箱格式正确哦！');
	}
	else {
		$('#emailmsg').text('邮箱格式错误!');
		$('#emailmsg').css('color','red');
	}
});

$('#email').focus( function(){
	if( $.trim( $(this).val() ).length != 0 ) {
		var username = $(this).val();
		var regexp = /^(\w+@\w+){1,1}(\.\w+){1,2}$/;
		if( regexp.test( username ) ) {
			$('#emailmsg').css('color','green');
			$('#emailmsg').text('邮箱格式正确哦！');
		}
		else {
			$('#emailmsg').text('邮箱格式错误!');
			$('#emailmsg').css('color','red');
		}
	}
});

$('#email').focusout( function(){
	$('#emailmsg').text('');
});



// Login Password
$(function(){ 
	$('#password').keyup(function () { 
		var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g"); 
		var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g"); 
		var enoughRegex = new RegExp("(?=.{6,}).*", "g"); 
	
		if (false == enoughRegex.test($(this).val())) { 
			$('#passwordmsg').css('color','red');
			$('#passwordmsg').text('密码强度有点弱哦！');
		} 
		else if (strongRegex.test($(this).val())) { 
			$('#passwordmsg').css('color','green');
			$('#passwordmsg').text('密码强度令人神往！');
		} 
		else if (mediumRegex.test($(this).val())) { 
			$('#passwordmsg').css('color','orange');
			$('#passwordmsg').text('密码强度还好哦！');
		} 
		else { 
			$('#passwordmsg').css('color','red');
			$('#passwordmsg').text('密码强度有点弱哦！');
		} 
		return true; 
	}); 
}) 

$('#password').focus( function(){
	if( $.trim( $(this).val() ).length != 0 ) {
		var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g"); 
		var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g"); 
		var enoughRegex = new RegExp("(?=.{6,}).*", "g"); 
	
		if (false == enoughRegex.test($(this).val())) { 
			$('#passwordmsg').css('color','red');
			$('#passwordmsg').text('密码强度有点弱哦！');
		} 
		else if (strongRegex.test($(this).val())) { 
			$('#passwordmsg').css('color','green');
			$('#passwordmsg').text('密码强度令人神往！');
		} 
		else if (mediumRegex.test($(this).val())) { 
			$('#passwordmsg').css('color','orange');
			$('#passwordmsg').text('密码强度还好哦！');
		} 
		else { 
			$('#passwordmsg').css('color','red');
			$('#passwordmsg').text('密码强度有点弱哦！');
		}
	}
});

$('#password').focusout( function(){
	$('#passwordmsg').text('');
});

function like ( commentid ) {
	var oldimg = $("#img-comment-like-" + commentid ).attr("src");
	var newimg = oldimg.replace(/black/,"red");
	if( oldimg != newimg ) {
		var projectName = window.location.pathname ;
		projectName = projectName.substring( 1 , projectName.indexOf( '/' , 1 ) );
		var url = "/" + projectName + "/blog/like.do";
		$.post( url , {"commentid":commentid} , 
				function( data ) {
			if( data.length == 0 ) {
				$("#img-comment-like-" + commentid ).attr("src",newimg);
				var num = $("#span-comment-like-" + commentid ).text();
				$("#span-comment-like-" + commentid ).text(parseInt(num)+1);				
			}
			else {
				alert(data);
			}
		});
	}
	else {
		alert("赞，只有一次，我，只爱一次！");
	}
	// 首先，对于一次操作，同一个用户不可能点击两次
	// 然后，对于多次访问，同一个用户也不可能点击两次
	// 所以,ajax 发送的就是不同的时候，其它时候是可以发送的
};


$('#btn-comment-submit').click( function() { 
	var message = $('#comment-message').val();
	var projectName = window.location.pathname ;
	projectName = projectName.substring( 1 , projectName.indexOf( '/' , 1 ) );
	var images = $("#uploadFileName").text();
	var url = "/" + projectName + "/blog/add.do";
	$.post( url , {"message":message,"images":images} , 
			function( data ) {
		location.reload();
	});
});

$('#btn-critic-submit').click( function() { 
	var message = $('#critic-message').val();
	var href = window.location.href ;
	var commentid = href.substring( href.indexOf('?') + 1 );
	commentid = commentid.substring( commentid.indexOf('=') + 1 );
	var projectName = window.location.pathname ;
	projectName = projectName.substring( 1 , projectName.indexOf( '/' , 1 ) );
	var url = "/" + projectName + "/critic/add.do";

	$.post( url , {"message":message,"commentid":commentid},
			function(data) {
		location.reload();
	});
});


$('#btn-search-submit').click( function() { 
//	alert("good");
	var message = $('#search-message').val();
	var href = window.location.href ;
	var commentid = href.substring( href.indexOf('?') + 1 );
	commentid = commentid.substring( commentid.indexOf('=') + 1 );
	var projectName = window.location.pathname ;
	projectName = projectName.substring( 1 , projectName.indexOf( '/' , 1 ) );
	var url = "/" + projectName + "/share/search.do";
//	alert( url + "?message=" + message );
	window.location.href = url + "?message=" + message ;
	
	//	
//	$.post( url , {"message":message},
//			function(data) {
//		alert( data );
//	});
});

function reply ( commentid , criticid ) {
	$( "div[id^='reply-critic']" ).attr("style", "display:none" );
	$( "#" + "reply-critic-" + String(commentid) + "-" + String(criticid) ).removeAttr("style");
};

function replyMessage( commentid , criticid ) {
	$( "div[id^='reply-critic']" ).attr("style", "display:none" );
	var message = $( "#reply-message-" + String(commentid) + "-" + String(criticid)  ).val();
	var href = window.location.href ;
	var commentid = href.substring( href.indexOf('?') + 1 );
	commentid = commentid.substring( commentid.indexOf('=') + 1 );
	var projectName = window.location.pathname ;
	projectName = projectName.substring( 1 , projectName.indexOf( '/' , 1 ) );
	var url = "/" + projectName + "/reply/add.do";
	$.post( url , {"message":message,"commentid":commentid,"criticid":criticid},
			function(data) {
		location.reload();
	});
};

