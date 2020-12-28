package com.urban.spatium.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	

	
	/*
	 * public List<Board> getBoardsList(){
	 * 
	 * return boardMapper.getBoardsList(); }
	 */
	
	public Map<String, Object> getBoardsList(int currentPage){
		int startRow = 0;
		int rowPerPage = 10;
		int startPageNum = 1;
		int endPageNum = 10;
				
		//last 페이지 구하기
		double count = boardMapper.getBoardsListCount();
		int lastPage = (int) Math.ceil(count/rowPerPage);
		
		//페이지 알고리즘
		startRow = (currentPage - 1) * rowPerPage;
		
		List<Map<String, Object>> boardList = boardMapper.getBoardsList(startRow, rowPerPage);
		
		if(currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum  = currentPage + 4;
			
			if(endPageNum >= lastPage) {
				startPageNum = (lastPage - 9);
				endPageNum = lastPage;
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lastPage", lastPage);
		resultMap.put("boardList", boardList);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		
		return resultMap;
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
	
	public String removePost(int boardIdx) {
		String result = "게시글 삭제 실패";
		
		int insertCheck = boardMapper.removePost(boardIdx);
		
		if(insertCheck > 0) result = "삭제 완료";
		
		return result;
		
	}
	
}
