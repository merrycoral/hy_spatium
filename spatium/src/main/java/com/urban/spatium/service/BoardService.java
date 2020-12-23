package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Board;
import com.urban.spatium.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	@Autowired 
	private BoardMapper boardMapper;
	

	
	public List<Board> getBoardsList(){
		
		return boardMapper.getBoardsList();
	}
	
	public String addPost(Board board) {
		String result = "상품 등록 실패";
		
		int insertCheck = boardMapper.addPost(board);
		
		if(insertCheck > 0) result = "상품 등록 완료";
		
		return result;
	}

	public List<Board> getBoardCate() {
		List<Board> getBoardCate = boardMapper.getBoardCate();
		return getBoardCate;
	}
}
