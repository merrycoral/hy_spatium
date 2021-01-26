package com.urban.spatium.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.urban.spatium.dto.User;
import com.urban.spatium.service.UserService;

@Controller("/user")
public class UserController {

	@Autowired 
	private UserService userService;


	//탈퇴회원 업데이트
	@GetMapping("/user/admin/modifyDeleteUser")
	public String modifyDeleteUser( Model model
			,@RequestParam(name="userId", required = false) String userId) {
		System.out.println("회원 수정 폼에 보여질 회원아이디" + userId);

		User user = userService.login(userId);		

		System.out.println("db에서 검색한 회원정보-->" + user);

		model.addAttribute("title", "회원 수정화면");
		model.addAttribute("user", user);

		return "user/admin/uUpdate";
	}	

	//탈퇴회원 리스트
	@GetMapping("/user/admin/deleteUser")
	public String deleteUser(Model model) {
		List<User> deleteUser = userService.deleteUser();
		System.out.println(deleteUser);

		model.addAttribute("deleteUser", deleteUser);
		return "user/admin/deleteUser";
	}

	//관리자용 회원삭제
	@PostMapping("/user/admin/removeUser") 
	public String removeUser(@RequestParam(name="reason", required = false) String reason  
			,@RequestParam(name="userId", required = false) String userId
			,RedirectAttributes redirectAttr) { 
		System.out.println("회원탈퇴화면에서 입력받은 값(id)--->" + userId);
		System.out.println("회원탈퇴화면에서 입력받은 값(reason)--->"+ reason);

		userService.removeUser(userId, reason);
		
		return "redirect:/user/admin/userList";
	}	

	@GetMapping("/user/admin/removeUser")
	public String removeUser(Model model, HttpSession session
			,@RequestParam(name="userId", required = false) String userId) {
		model.addAttribute("title", "강제 탈퇴");
		model.addAttribute("userId", userId);

		return "user/admin/adminDelete";
	}

	//회원탈퇴
	@PostMapping("/user/removeMyinfo")
	public String removeMyinfo(@RequestParam(name="reason", required = false) String reason  
			,@RequestParam(name="userPw", required = false) String userPw
			,@RequestParam(name="userId", required = false) String userId
			,RedirectAttributes redirectAttr) { 
		System.out.println("회원탈퇴화면에서 입력받은 값(reason)--->"	+ reason);
		System.out.println("회원탈퇴화면에서 입력받은 값(pw)--->"	+ userPw);
		System.out.println("회원탈퇴화면에서 입력받은 값(id)--->"	+ userId);
		//가져온 값을 서비스로 가져가
		userService.removeMyinfo(userId,userPw,reason);

		return "redirect:/logout";
	}

	@GetMapping("/user/removeMyinfo")
	public String removeMyinfo( Model model
			,HttpSession session) {
		model.addAttribute("title", "회원 탈퇴");
		String SID = (String) session.getAttribute("SID");
		model.addAttribute("SID", SID);

		return "user/userDelete";
	}


	//관리자 마이페이지 수정
	@PostMapping("/user/admin/myInfo")
	public String myInfo(User user) {
		System.out.println("회원 수정 폼에서 입력받은 값" + user);

		String result = userService.myInfo(user);
		System.out.println(result);

		return "redirect:/user/admin/myInfo";
	}
	
	@GetMapping("/user/admin/myInfo") 
	public String myInfo(Model model, HttpSession session) {

		String userIdchk = (String) session.getAttribute("SID"); //로그인한 아이디를 가져오겠다는 코드
		System.out.println(userIdchk);
		User user = userService.login(userIdchk);	

		System.out.println("db에서 검색한 회원정보-->" + user);

		model.addAttribute("title", "회원 수정화면");
		model.addAttribute("user", user);
		return "/user/admin/myInfo";
	}
	
	//구매자 마이페이지 수정
	@PostMapping("/user/userUpdate")
	public String userUpdate(User user) {
		System.out.println("회원 수정 폼에서 입력받은 값" + user);
		
		String result = userService.myPage(user);
		System.out.println(result);
		
		return "redirect:/user/userUpdate";
	}

	@GetMapping("/user/userUpdate") 
	public String userUpdate(Model model, HttpSession session) {

		String userIdchk = (String) session.getAttribute("SID"); //로그인한 아이디를 가져오겠다는 코드
		System.out.println(userIdchk);
		User user = userService.login(userIdchk);	

		System.out.println("db에서 검색한 회원정보-->" + user);

		model.addAttribute("title", "회원 수정화면");
		model.addAttribute("user", user);
		return "user/userUpdate";
	}
	
	@GetMapping("/user/myPage") 
	public String myPage(Model model, HttpSession session) {
		
		String userIdchk = (String) session.getAttribute("SID"); //로그인한 아이디를 가져오겠다는 코드
		System.out.println(userIdchk);
		User user = userService.login(userIdchk);	
		
		System.out.println("db에서 검색한 회원정보-->" + user);
		
		model.addAttribute("title", "회원 수정화면");
		model.addAttribute("user", user);
		return "user/myPage";
	}

	//관리자용 회원수정
	@PostMapping("/user/admin/modifyUser")
	public String modifyUser(User user) {
		System.out.println("회원 수정 폼에서 입력받은 값" + user);

		String result = userService.modifyUser(user);
		System.out.println(result);

		return "redirect:/user/admin/userList";
	}

	@GetMapping("/user/admin/modifyUser")
	public String modifyUser( Model model
			,@RequestParam(name="userId", required = false) String userId) {
		System.out.println("회원 수정 폼에 보여질 회원아이디" + userId);

		User user = userService.login(userId);		

		System.out.println("db에서 검색한 회원정보-->" + user);

		model.addAttribute("title", "회원 수정화면");
		model.addAttribute("user", user);

		return "user/admin/adminUpdate";
	}	

	//불량회원 삭제
	@GetMapping("/user/admin/removeBlack") 
	 public String removeBlack(Model model, @RequestParam(name="blackUserId", required = false) String blackUserId) {
		 System.out.println("장비파기 삭제화면에 입력받은 값 ->" + blackUserId);
		 userService.removeBlack(blackUserId);
		 model.addAttribute("blackUserId", blackUserId);
		 return "redirect:/user/admin/blackUser";
	  }
	
	//불량회원 리스트
	@GetMapping("/user/admin/blackUser")
	public String blackUser(Model model) {
		List<User> blackUser = userService.blackUser();
		System.out.println(blackUser);

		model.addAttribute("blackUser", blackUser);
		return "/user/admin/blackUser";
	}

	//불량회원 등록
	@PostMapping("/user/admin/addBlackUser") 
	public String addBlackUser(User user ,@RequestParam(name = "userId", required = false)	String userId) {
		System.out.println("불량회원 등록화면에서 입력받은 값--->" + user); 
		String result = userService.addBlackUser(user); 
		System.out.println(result);
		return "redirect:/user/admin/blackUser"; 
	}

	@GetMapping("/user/admin/addBlackUser") 
	public String addBlackUser(Model model) {
		model.addAttribute("title", "불량회원 등록");
		return "user/admin/blackUserForm";
	}
	
	//휴면회원 리스트
	@GetMapping("/user/admin/restUser")
	public String restUser(Model model) {
		return "user/admin/restUser";
	}

	//회원리스트
	@PostMapping("/user/admin/userList")
	public String userList(Model model) {

		model.addAttribute("title", "회원 목록");

		return "user/admin/userList";
	}

	@GetMapping("/user/admin/userList")
	public String getUserList(Model model, @RequestParam(name="result", required = false) String result) {
		List<User> UserList = userService.getUserList();
		System.out.println(UserList);
		model.addAttribute("title", "회원 목록");
		model.addAttribute("userList", UserList);
		if(result != null) model.addAttribute("result", result);

		return "user/admin/userList";
	}

	//간편로그인
	@GetMapping("/imsilogin")
	public String imsilogin(HttpSession session) {
		session.setAttribute("SID", "id001");
		session.setAttribute("SLEVEL", "1");
		session.setAttribute("SNAME", "이순신");
		return "redirect:/";
	}

	//로그아웃
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/user/login";
	}

	//로그인
	@PostMapping("/login")
	public String login( @RequestParam(name="userId", required = false) String userId
			,@RequestParam(name="userPw", required = false) String userPw
			,HttpSession session
			,RedirectAttributes rAttr) {

		System.out.println("로그인 화면에서 입력받은 값->" + userId);
		System.out.println("로그인 화면에서 입력받은 값->" + userPw);

		User User = userService.login(userId);

		if(userId != null && userPw != null && User != null && User.getUserPw() != null && userPw.equals(User.getUserPw())) {
			session.setAttribute("SID", userId);
			session.setAttribute("SLEVEL", Integer.toString(User.getUserLevel()));
			session.setAttribute("SNAME", User.getUserName());
			System.out.println(userId + " : 로그인 성공");
		}else {
			System.out.println(userId + " : 로그인 실패");
			return "redirect:/login";
		}
		return "redirect:/index";
	}

	@GetMapping("/login")
	public String login(Model model
			,@RequestParam(name="result", required = false) String result) {
		System.out.println("로그인 컨트롤러");
		model.addAttribute("title", "로그인 화면");
		if(result != null) model.addAttribute("result", result);

		return "user/login";
	}

	//아이디 찾기
	@GetMapping("/findIdform")
	public String findIdform()	{ 
		return "/user/findIdform"; 
	}

	//관리자아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/user/admin/idCheck", method = RequestMethod.POST)
	public int idCheck(User user) throws Exception {
		int result = userService.idCheck(user);
		return result;
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/user/idChk", method = RequestMethod.POST)
	public int idChk(User user) throws Exception {
		int result = userService.idChk(user);
		return result;
	}

	//관리자 회원가입
	@PostMapping("/user/admin/addAdmin") 
	public String addAdmin(User user ,@RequestParam(name = "userId", required = false)
	String userId) {
		System.out.println("회원가입화면에서 입력받은 값--->" + user); 
		String result = userService.addAdmin(user); 
		System.out.println(result);
		return "redirect:/user/admin/userList"; 
	}
	
	@GetMapping("/user/admin/addAdmin") public String addAdmin(Model model) {
		model.addAttribute("title", "회원 가입");
		return "user/admin/adminJoin";
	}
	
	//구매자 회원가입
	@PostMapping("/user/addUser") 
	public String addUser(User user ,@RequestParam(name = "userId", required = false)
	String userId) {
		System.out.println("회원가입화면에서 입력받은 값--->" + user); 
		String result = userService.addUser(user); 
		System.out.println(result);
		return "redirect:/main"; 
	}

	@GetMapping("/user/addUser") public String addUser(Model model) {
		model.addAttribute("title", "회원 가입");
		return "user/userJoin";
	}
	
	//비밀번호찾기
	/*
	 * @RequestMapping(value = "/user/findPwform", method = RequestMethod.POST)
	 * public ModelAndView find_pass(HttpServletRequest request, String userId,
	 * String userEmail, HttpServletResponse response_email) throws IOException{
	 * 
	 * //랜덤한 난수 (인증번호)를 생성해서 이메일로 보내고 그 인증번호를 입력하면 비밀번호를 변경할 수 있는 페이지로 이동시킴
	 * 
	 * Random r = new Random(); int dice = r.nextInt(157211)+48271;
	 * 
	 * String setfrom = "dlgkstjq623@gmail.com"; String tomail =
	 * request.getParameter("userEmail"); //받는 사람의 이메일 String title =
	 * "비밀번호 찾기 인증 이메일 입니다."; //제목 String content =
	 * 
	 * System.getProperty("line.separator")+
	 * 
	 * System.getProperty("line.separator")+
	 * 
	 * "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
	 * 
	 * +System.getProperty("line.separator")+
	 * 
	 * System.getProperty("line.separator")+
	 * 
	 * "비밀번호 찾기 인증번호는 " +dice+ " 입니다. "
	 * 
	 * +System.getProperty("line.separator")+
	 * 
	 * System.getProperty("line.separator")+
	 * 
	 * "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
	 * 
	 * try {
	 * 
	 * MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
	 * messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	 * 
	 * messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
	 * messageHelper.setTo(tomail); // 받는사람 이메일 messageHelper.setSubject(title); //
	 * 메일제목은 생략이 가능하다 messageHelper.setText(content); // 메일 내용
	 * 
	 * mailSender.send(message);
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * 
	 * ModelAndView mv = new ModelAndView(); //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을
	 * 지정한다. mv.setViewName("/user/passEmail"); //뷰의이름 mv.addObject("dice", dice);
	 * mv.addObject("userEmail", userEmail);
	 * 
	 * System.out.println("mv : "+mv);
	 * 
	 * response_email.setContentType("text/html; charset=UTF-8"); PrintWriter
	 * out_email = response_email.getWriter();
	 * out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
	 * out_email.flush();
	 * 
	 * return mv; }
	 * 
	 * //인증번호를 입력한 후에 확인 버튼을 누르면 자료가 넘어오는 컨트롤러
	 * 
	 * @RequestMapping(value = "pass_injeung.do{dice},{userEmail}", method =
	 * RequestMethod.POST) public ModelAndView pass_injeung(String
	 * pass_injeung, @PathVariable String dice, @PathVariable String userEmail,
	 * HttpServletResponse response_equals) throws IOException{
	 * 
	 * System.out.println("마지막 : pass_injeung : "+pass_injeung);
	 * 
	 * System.out.println("마지막 : dice : "+dice);
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * mv.setViewName("/user/passChange");
	 * 
	 * mv.addObject("userEmail",userEmail);
	 * 
	 * if (pass_injeung.equals(dice)) {
	 * 
	 * //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 비밀번호 변경창으로 이동시킨다
	 * 
	 * mv.setViewName("user/passChange");
	 * 
	 * mv.addObject("userEmail",userEmail);
	 * 
	 * //만약 인증번호가 같다면 이메일을 비밀번호 변경 페이지로 넘기고, 활용할 수 있도록 한다.
	 * 
	 * response_equals.setContentType("text/html; charset=UTF-8"); PrintWriter
	 * out_equals = response_equals.getWriter(); out_equals.
	 * println("<script>alert('인증번호가 일치하였습니다. 비밀번호 변경창으로 이동합니다.');</script>");
	 * out_equals.flush();
	 * 
	 * return mv;
	 * 
	 * 
	 * }else if (pass_injeung != dice) {
	 * 
	 * 
	 * ModelAndView mv2 = new ModelAndView();
	 * 
	 * mv2.setViewName("user/passEmail");
	 * 
	 * response_equals.setContentType("text/html; charset=UTF-8"); PrintWriter
	 * out_equals = response_equals.getWriter(); out_equals.
	 * println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>"
	 * ); out_equals.flush();
	 * 
	 * return mv2; } return mv; }
	 * 
	 * //변경할 비밀번호를 입력한 후에 확인 버튼을 누르면 넘어오는 컨트롤러
	 * 
	 * @RequestMapping(value = "pass_change.do{e_mail}", method =
	 * RequestMethod.POST) public ModelAndView pass_change(@PathVariable String
	 * userEmail, HttpServletRequest request, User user, HttpServletResponse pass)
	 * throws Exception{
	 * 
	 * String userPass = request.getParameter("userPass");
	 * 
	 * String userEmail1 = userEmail;
	 * 
	 * user.setUserEmail(userEmail1); user.setMember_pass(userPass);
	 * 
	 * //값을 여러개 담아야 하므로 해쉬맵을 사용해서 값을 저장함
	 * 
	 * Map<String, Object> map = new HashMap<>();
	 * 
	 * map.put("userEmail", user.getUserEmail()); map.put("userPass",
	 * user.getMember_pass());
	 * 
	 * userService.passChange(map,user);
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * mv.setViewName("user/find_pass_result");
	 * 
	 * return mv;
	 * 
	 * }
	 */
}

