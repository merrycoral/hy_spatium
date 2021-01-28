		$( document ).ready( function() {
			const nav = document.querySelector('nav');
		    const navTopOffset = nav.offsetTop;
		    $(document).scroll(function(){
		      // nav를 상단에 고정. (브라우저 상단의 차이가 nav와 브라우저 상단의 차이보다 클 경우)
		      if (window.pageYOffset > navTopOffset) { 
		        nav.classList.add('backColor');
		      } else {
		        nav.classList.remove('backColor');
		      }
		    	
		    });
		});
		
