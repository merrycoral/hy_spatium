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
		String result = "게시글 등록 실패";
		
		int insertCheck = boardMapper.addPost(board);
		
		if(insertCheck > 0) result = "게시글 등록 완료";
		
		return result;
	}

	public List<Board> getBoardCate() {
		List<Board> getBoardCate = boardMapper.getBoardCate();
		return getBoardCate;
	}
	
	public Board getBoardsByCode(int boardIdx) {
		
		Board board = boardMapper.getBoardsByCode(boardIdx);
		System.out.println(board);
		return board;
	}

	public String modifyPost(Board board) {
		String result = "게시글 등록 실패";
		
		int insertCheck = boardMapper.modifyPost(board);
		
		if(insertCheck > 0) result = "등록 완료";
		
		return result;
	}
}
