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
import com.urban.spatium.dto.BoardReply;
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

	public Board getBoardsByCode(int boardIdx) {
		Board board = boardMapper.getBoardsByCode(boardIdx);
		System.out.println(board);
		return board;
	}
	
	public String modifyPost(Board board) {
		String result = "게시글 수정 실패";
		int insertCheck = boardMapper.modifyPost(board);
		if(insertCheck > 0) result = "수정 완료";
		return result;
	}
	
	public String removePost(int boardIdx) {
		String result = "게시글 삭제 실패";
		int insertCheck = boardMapper.removePost(boardIdx);
		if(insertCheck > 0) result = "삭제 완료";
		return result;
	}

	public List<Board> getBoardCate() {
		List<Board> getBoardCate = boardMapper.getBoardCate();
		return getBoardCate;
	}

	public int postHitCnt(int boardIdx) {
		return boardMapper.postHitCnt(boardIdx);
	}
	
	public int blindPost(int boardIdx){
		return boardMapper.blindPost(boardIdx);
	}
	
	public int declarationPost(int boardIdx){
		return boardMapper.declarationPost(boardIdx);
	}
	
	/**************************************************************************
	*********							댓글							***********
	**************************************************************************/
	
	public String addReply(BoardReply boardReply) {
		String result = "댓글 작성 실패";
		int insertCheck = boardMapper.addReply(boardReply);
		if(insertCheck > 0) result = "댓글 작성 완료";
		return result;
	};

	public String modifyReply(BoardReply boardReply) {
		String result = "댓글 수정 실패";
		int insertCheck = boardMapper.modifyReply(boardReply);
		if(insertCheck > 0) result = "수정 완료";
		return result;
	};
	
	public String removeReply(int replyIdx) {
		String result = "댓글 삭제 실패";
		int insertCheck = boardMapper.removePost(replyIdx);
		if(insertCheck > 0) result = "삭제 완료";
		return result;
	};
	
	public List<BoardReply> getReplyByCode(int replyIdx){
		List<BoardReply> boardReply = boardMapper.getReplyByCode(replyIdx);
		System.out.println(boardReply);
		return boardReply;
	};
	
	public List<BoardReply> getReplysList(BoardReply boardReply){
		List<BoardReply> replysList = boardMapper.getReplysList(boardReply);
		return replysList;
	};
	
	public String blindReply(int replyIdx) {
		String result = "블라인드 실패";
		int insertCheck = boardMapper.blindReply(replyIdx);
		if(insertCheck > 0) result = "블라인드 완료";
		return result;
	};
	
	public String declarationReply(int replyIdx) {
		String result = "신고 실패";
		int insertCheck = boardMapper.blindReply(replyIdx);
		if(insertCheck > 0) result = "신고 완료";
		return result;
	};
	
	
	
}

