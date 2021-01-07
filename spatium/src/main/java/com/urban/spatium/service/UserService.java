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
	
	//불량회원 리스트
	public List<User> blackUser(){
		List<User> blackUser = userMapper.blackUser(); 
		return blackUser; 
	}
	
	//탈퇴회원 리스트
	 public List<User> deleteUser(){
	 List<User> deleteUser = userMapper.deleteUser(); 
	  	return deleteUser; 
	 }
	
	//탈퇴회원 등록
	public String addDeleteUser(User user) {
		String insertCheck = "탈퇴회원 등록 실패";
		if(user != null) {
			int result = userMapper.addDeleteUser(user);
			if(result > 0) insertCheck = "탈퇴회원 등록 성공";
		}
		return insertCheck;
	}
	
	//회원탈퇴
	public String removeMyinfo(String userId, String userPw, String userLevel) {
		String result = "회원 삭제 실패";

		User user = userMapper.getUserById(userId);
			
		if(user != null && user.getUserPw() != null && userPw.equals(user.getUserPw())) {
			int removeCheck = userMapper.removeMyinfo(userId, userLevel);
			if(removeCheck > 0) result = "회원 삭제 성공";
		}
		return result;
	}
	
	//회원정보수정
	public String myInfo(User user) {
		String result = "회원정보수정 실패";
			
		int myInfoCheck = userMapper.myInfo(user);
			
		if(myInfoCheck > 0) result = "회원정보수정 성공";
			
		return result;
	}
	
	//회원삭제
	public String removeUser(String userId, String userPw, String userLevel) {
		String result = "회원 삭제 실패";

		User user = userMapper.getUserById(userId);
		
		if(user != null && user.getUserPw() != null && userPw.equals(user.getUserPw())) {
			int removeCheck = userMapper.removeUser(userId, userLevel);
			if(removeCheck > 0) result = "회원 삭제 성공";
		}
		return result;
	}
	
	//회원수정
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
	
	
	
	//아이디 찾기
	public String findId(HttpServletResponse response, String userEmail) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userId = userMapper.findId(userEmail);
		
		if (userId == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return userId;
		}
	}
	
	//아이디 중복체크
	public int idChk(User user) {
		int result = userMapper.idChk(user);
		return result;
	}
	
	//회원가입	
	public String addUser(User user) {
		String insertCheck = "회원가입 실패";
		if(user != null) {
			int result = userMapper.addUser(user);
			if(result > 0) insertCheck = "회원가입 성공";
		}
		
		return insertCheck;
	}
	
	public User getUserById(String userId) {
		
		User user = userMapper.getUserById(userId);
		
		return user;
	}
}
