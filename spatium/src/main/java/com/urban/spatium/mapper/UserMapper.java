package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.urban.spatium.dto.User;


@Mapper
public interface UserMapper {
	
	//구매자 포인트
	public List<User> pointList(); 
		
	//휴면회원 리스트
	public List<User> restUser(); 
	
	//불량회원 리스트
	public List<User> blackUser(); 
	
	//탈퇴회원 리스트
	public List<User> deleteUser(); 
	
	//탈퇴회원 등록
	public int addDeleteUser(User user);
	
	//회원탈퇴
	int removeMyinfo(String userId, String userLevel);
	
	//마이페이지 수정
	int modifyMyinfo(User user);
	
	//회원삭제
	int removeUser(String userId, String userLevel);
	
	//회원수정
	int modifyUser(User user);
	
	//회원 리스트
	public List<User> getUserList(); 
		
	//로그인
	public User getUserById(String userId);
	
	//아이디 찾기
	
	
	//아이디 중복체크
	public int idChk(User user);
	
	//회원가입
	public int addUser(User user);

	
}
