package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.urban.spatium.dto.User;


@Mapper
public interface UserMapper {
	
	//회원삭제
	int removeUser(String userId, String userLevel);
	
	//회원수정
	int modifyUser(User user);
	
	//회원리스트
	public List<User> getUserList();
		
	//로그인
	public User login(String userId);
	
	//회원가입
	public int addUser(User user);

	
}
