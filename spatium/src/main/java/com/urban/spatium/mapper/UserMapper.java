package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.User;


@Mapper
public interface UserMapper {
	

	//휴면회원 리스트
	public List<User> restUser(); 
	
	//불량회원 리스트
	public List<User> blackUser(); 
	
	//탈퇴회원 업데이트
	int modifyDeleteUser(String userId);
	
	//탈퇴회원 리스트
	public List<User> deleteUser(); 
	
	//탈퇴회원 등록
	public int addDeleteUser(User user);
	
	//관리자용 회원삭제
	 int removeUser(String userId); 

	//구매자 마이페이지 수정
	int myPage(User user);
	
	//관리자 마이페이지 수정
	int myInfo(User user);
	
	//관리자용 회원수정
	int modifyUser(User user);
	
	//회원 리스트
	public List<User> getUserList(); 
		
	//로그인
	public User getUserById(String userId);
	
	//관리자 아이디 중복체크
	public int idCheck(User user);
	
	//아이디 중복체크
	public int idChk(User user);
	
	//관리자 회원가입
	public int addAdmin(User user);
	
	//구매자 회원가입
	public int addUser(User user);

	
}
