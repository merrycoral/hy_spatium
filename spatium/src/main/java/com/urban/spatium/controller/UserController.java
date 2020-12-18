package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.urban.spatium.dto.User;
import com.urban.spatium.service.UserService;

@Controller
public class UserController {
	
	@Autowired 
	private UserService userService; 
	
	//회원수정
	@PostMapping("/modifyUser")
	public String modifyUser(User user) {
		//화면에서 입력받은 값
		System.out.println("회원 수정 폼에서 입력받은 값" + user);
		
		// update 처리
		String result = userService.modifyUser(user);
		
		//update 결과
		System.out.println(result);
		
		return "redirect:/userList";
	}
	
	@GetMapping("/modifyUser")
	public String modifyUser( Model model
							   ,@RequestParam(name="userId", required = false) String userId) {
		System.out.println("회원 수정 폼에 보여질 회원아이디" + userId);
		
		User user = userService.getUserById(userId);		
		
		System.out.println("db에서 검색한 회원정보-->" + user);
		
		model.addAttribute("title", "회원 수정화면");
		// db에서 검색한 회원정보
		model.addAttribute("user", user);
		
		return "user/uUpdate";
	}	
	
	//회원리스트
	@PostMapping("/userList")
	public String userList(@RequestParam(name = "sk", required = false)String searchKey
			,@RequestParam(name = "sv", required = false)String searchValue
			,Model model) {
		/*log.info("화면에서 전달받은 파라미터값 sk :::::::  {}",searchKey);
		log.info("화면에서 전달받은 파라미터값 sv :::::::  {}",searchValue);*/
		if("아이디".equals(searchKey)) {
			searchKey="u_id";
		}else if("권한".equals(searchKey)) {
			searchKey="u_level";
			}if("관리자".equals(searchValue)) {
				searchValue="1";
			}else if("판매자".equals(searchValue)) {
				searchValue="2";
			}else if("구매자".equals(searchValue)) {
				searchValue="3";
			}else if("휴면회원".equals(searchValue)) {
				searchValue="4";
			}else if("탈퇴회원".equals(searchValue)) {
				searchValue="5";
			}else if("불량회원".equals(searchValue)) {
				searchValue="6";

			}else if("이메일".equals(searchKey)) {
				searchKey="u_email";
		}

	/*
	 * log.info("변경한 파라미터값 sv :::::::  {}",searchKey);
	 * log.info("변경한 파라미터값 sk :::::::  {}",searchValue);
	 */

		model.addAttribute("title", "회원 목록");
		/*List<User> userList = userService.getSearchUserList(searchKey,searchValue);*/
		
		return "user/uList";
	}
	
	@GetMapping("/userList")
	public String getUserList(Model model, @RequestParam(name="result", required = false) String result) {
		List<User> UserList = userService.getUserList();
		System.out.println(UserList);
		model.addAttribute("title", "회원 목록");
		model.addAttribute("userList", UserList);
		if(result != null) model.addAttribute("result", result);

		return "user/uList";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/login";
	}
	
	//로그인
	@PostMapping("/login")
	public String login( @RequestParam(name="UserId", required = false) String UserId
			,@RequestParam(name="UserPw", required = false) String UserPw
			,HttpSession session
			,RedirectAttributes rAttr) {

		System.out.println("로그인 화면에서 입력받은 값->" + UserId);
		System.out.println("로그인 화면에서 입력받은 값->" + UserPw);

		User User = userService.getUserById(UserId);

		if(UserId != null && UserPw != null && User != null && User.getUserPw() != null && UserPw.equals(User.getUserPw())) {
			session.setAttribute("SID", UserId);
			session.setAttribute("SLEVEL", User.getUserLevel());
			session.setAttribute("SNAME", User.getUserName());
			System.out.println(UserId + " : 로그인 성공");
		}else {
			rAttr.addAttribute("result", "입력하신 정보는 없습니다.");
			System.out.println(UserId + " : 로그인 실패");
			return "redirect:/login";
		}

		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login(Model model
			,@RequestParam(name="result", required = false) String result) {
		System.out.println("로그인 컨트롤러");
		model.addAttribute("title", "로그인 화면");
		if(result != null) model.addAttribute("result", result);

		return "user/login";
	}
	
	//회원가입
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(User user
			,@RequestParam(name = "userId", required = false) String userId) {
		System.out.println("회원가입화면에서 입력받은 값--->" + user);
		String result = userService.addUser(user);
		System.out.println(result);
		return "redirect:/myinfo";
	}
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
	return "user/join";
}
	
}
