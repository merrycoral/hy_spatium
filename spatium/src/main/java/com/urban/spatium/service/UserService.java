package com.urban.spatium.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.User;
import com.urban.spatium.mapper.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired 
	private UserMapper userMapper;

	//불량회원 삭제
	public String removeBlack(String blackUserId) { 
		String result =	"불량회원 삭제 실패";

	int removeCheck = userMapper.removeBlack(blackUserId);
	if(removeCheck > 0) 
		result = "불량회원 삭제 완료"; 
	return result; 
	}

	//불량회원 리스트
	public List<User> blackUser(){
		List<User> blackUser = userMapper.blackUser(); 
		return blackUser; 
	}

	//불량회원 등록
	public String addBlackUser(User user) {
		String insertCheck = "불량회원 등록 실패";
		if(user != null) {
			int result = userMapper.addBlackUser(user);
			if(result > 0) insertCheck = "불량회원 등록 성공";
		}

		return insertCheck;
	}
	
	//탈퇴회원 리스트
	public List<User> deleteUser(){
		List<User> deleteUser = userMapper.deleteUser(); 
		return deleteUser; 
	}

	//회원탈퇴
	public void removeMyinfo(String userId, String userPw, String reason) {
		//1. 아이디로 유저 정보를 가져오는 쿼리문을 돌려서 user에 넣어준다.
		User user = userMapper.getUserById(userId);

		if(user != null && user.getUserPw() != null && userPw.equals(user.getUserPw())) {
			//2. user에다가 추가로 탈퇴 사유와 탈퇴 타입을 넣어준다.
			user.setDeleteReason(reason);
			user.setDeleteCate("일반 탈퇴");

			//3. 유저 정보를 delelteUser테이블에 백업한다.
			userMapper.addDeleteUser(user);    //하나의 서비스에서 여러 매퍼를 호출할 수 있다.

			//4. 유저정보를 죄다 (탈퇴)로 바꾼다
			userMapper.modifyDeleteUser(userId);
		}
	}

	//관리자용 회원삭제
	public void removeUser(String userId, String reason) {

		User user = userMapper.getUserById(userId);
		if(user != null) {
			user.setDeleteReason(reason);
			user.setDeleteCate("강제 탈퇴");
			userMapper.addDeleteUser(user);
			userMapper.modifyDeleteUser(userId);
		}
	}	

	//관리자 마이페이지 수정
	public String myInfo(User user) {
		String result = "마이페이지 수정 실패";

		int myInfoCheck = userMapper.myInfo(user);

		if(myInfoCheck > 0) result = "마이페이지 수정 성공";

		return result;
	}

	//구매자 마이페이지 수정
	public String myPage(User user) {
		String result = "마이페이지 수정 실패";
		int myInfoCheck = userMapper.myPage(user);
		if(myInfoCheck > 0) result = "마이페이지 수정 성공";
		return result;
	}


	//관리자용 회원수정
	public String modifyUser(User user) {
		String result = "회원 수정 실패";

		int modifyCheck = userMapper.modifyUser(user);

		if(modifyCheck > 0) result = "회원 수정 성공";

		return result;
	}

	//회원리스트
	public List<User> getUserList(){
		List<User> userList = userMapper.getUserList(); 
		return userList; 
	}

	//로그인
	public User login(String userId) {

		User user = userMapper.getUserById(userId);

		return user;
	}

	//관리자 아이디 중복체크
	public int idCheck(User user) {
		int result = userMapper.idCheck(user);
		return result;
	}

	//아이디 중복체크
	public int idChk(User user) {
		int result = userMapper.idChk(user);
		return result;
	}

	//관리자 회원가입	
	public String addAdmin(User user) {
		String insertCheck = "회원가입 실패";
		if(user != null) {
			int result = userMapper.addAdmin(user);
			if(result > 0) insertCheck = "회원가입 성공";
		}

		return insertCheck;
	}

	//구매자 회원가입	
	public String addUser(User user) {
		String insertCheck = "회원가입 실패";
		if(user != null) {
			int result = userMapper.addUser(user);
			if(result > 0) insertCheck = "회원가입 성공";
		}

		return insertCheck;
	}
	
	//비밀번호찾기 이메일 설정
	/*public void sendEmail(User user, String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; 
		String hostSMTPid = "서버 이메일 주소(보내는 사람 이메일 주소)";
		String hostSMTPpwd = "서버 이메일 비번(보내는 사람 이메일 비번)";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
		String fromName = "Spatium";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "Spatium 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += user.getUserId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += user.getUserPw() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = user.setUserEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	//비밀번호찾기
	public void findPw(HttpServletResponse response, User user) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		User ck = mdao.readMember(user.getUserId());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(mdao.idCheck(user.getUserId()) == null) {
			out.print("등록되지 않은 아이디입니다.");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if(!user.setUserEmail().equals(ck.setUserEmail())) {
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		}else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			user.setUserPw(pw);
			
			 * // 비밀번호 변경 mdao.updatePw(user);
			 
			// 비밀번호 변경 메일 발송
			sendEmail(user, "findpw");

			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
	}*/
	
	public String findIdajax(String userEmail) {
		String id = userMapper.findIdajax(userEmail);
		System.out.println("userId는  : " + id);
		String result = null;
		if (id == null) {
			result = "해당 이메일에 해당하는 아이디가 없습니다.";
		} else {
			result = "고객님의 아이디는 : "+id+" 입니다.";
		}
		return result;
	}
}
