package com.urban.spatium.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Board;
import com.urban.spatium.dto.Criteria;
import com.urban.spatium.dto.PaginationInfo;
import com.urban.spatium.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	@Autowired 
	private BoardMapper boardMapper;
	
	public List<Board> getBoardsList(Board params){
		List<Board> boardList = Collections.emptyList();

		int boardTotalCount = boardMapper.getBoardTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(boardTotalCount);

		params.setPaginationInfo(paginationInfo);
		
		if (boardTotalCount > 0) {
			boardList = boardMapper.getBoardsList(params);
		}
		
		return boardList;
		
	}

	public String addPost(Board board) {
		String result = "게시글 등록 실패";
		
		int insertCheck = boardMapper.addPost(board);
		
		if(insertCheck > 0) result = "게시글 등록 완료";
		
		return result;
	}

	public String modifyPost(Board board) {
		String result = "게시글 수정 실패";
		
		int insertCheck = boardMapper.modifyPost(board);
		
		if(insertCheck > 0) result = "수정 완료";
		
		return result;
	}
	
	public Map<String, Object> getPagingParams(Criteria criteria) {

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("currentPageNo", criteria.getCurrentPageNo());
		params.put("recordsPerPage", criteria.getRecordsPerPage());
		params.put("pageSize", criteria.getPageSize());
		params.put("searchType", criteria.getSearchType());
		params.put("searchKeyword", criteria.getSearchKeyword());

		return params;
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
	
	public String removePost(int boardIdx) {
		String result = "게시글 삭제 실패";
		
		int insertCheck = boardMapper.removePost(boardIdx);
		
		if(insertCheck > 0) result = "삭제 완료";
		
		return result;
		
	}
	
	public int postHitCnt(int boardIdx) {
		return boardMapper.postHitCnt(boardIdx);
		
	}
	

	
	
}

