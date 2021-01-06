package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.urban.spatium.dto.User;


@Mapper
public interface UserMapper {
	
	
	
	//회원탈퇴
	int removeMyinfo(String userId, String userLevel);
	
	//회원정보수정
	int myInfo(User user);
	
	//회원삭제
	int removeUser(String userId, String userLevel);
	
	//회원수정
	int modifyUser(User user);
	
	//회원리스트
	 public List<User> getUserList(); 
		
	//로그인
	public User getUserById(String userId);
	
	//아이디 중복체크
	public int idChk(User user);
	
	//회원가입
	public int addUser(User user);

	
}
