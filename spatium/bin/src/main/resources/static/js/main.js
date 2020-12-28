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
		
		$( document ).ready( function() {
			var loginBtn = document.querySelector('.login-btn');
			var login = document.querySelector('.login');
			var lineOne = document.querySelector('.login-btn .line--1');
			var lineTwo = document.querySelector('.login-btn .line--2');
			var lineThree = document.querySelector('.login-btn .line--3');
			var link = document.querySelector('.login .login-links');
			loginBtn.addEventListener('click', () => {
				login.classList.toggle('login-open');
			    lineOne.classList.toggle('line-cross');
			    lineTwo.classList.toggle('line-fade-out');
			    lineThree.classList.toggle('line-cross');
			    link.classList.toggle('fade-in');
			});
		});