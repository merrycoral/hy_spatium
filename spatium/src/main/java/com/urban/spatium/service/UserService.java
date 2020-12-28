package com.urban.spatium.service;

import java.util.List;

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
	
	//회원삭제
	public String removeUser(String userId, String userPw, String userLevel) {
		String result = "회원 삭제 실패";

		User user = userMapper.login(userId);
		
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
		int listSize = userList.size();
		for(int i=0; i<listSize; i++) {
			if("1".equals(userList.get(i).getUserGrade())) {
				userList.get(i).setUserGrade("관리자");
			}else if("2".equals(userList.get(i).getUserGrade())) {
				userList.get(i).setUserGrade("판매자");
			}else if("3".equals(userList.get(i).getUserGrade())) {
				userList.get(i).setUserGrade("구매자");	
			}else if("4".equals(userList.get(i).getUserGrade())) {
				userList.get(i).setUserGrade("불량");	
			}else if("5".equals(userList.get(i).getUserGrade())) {
				userList.get(i).setUserGrade("휴면");	
			}else {
				userList.get(i).setUserGrade("탈퇴");
			}
		}
		
		return userList;
	}
		
	//로그인
	public User login(String userId) {
		
		User user = userMapper.login(userId);
		
		return user;
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
}
