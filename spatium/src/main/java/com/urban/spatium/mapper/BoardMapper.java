package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Board;
import com.urban.spatium.dto.BoardReply;
import com.urban.spatium.dto.Criteria;

@Mapper
public interface BoardMapper {
	
	/**************************************************************************
	*								소모임게시판											
	**************************************************************************/
	
	public List<Board> getBoardsList(Board params); 
	
	public int getBoardTotalCount(Board params);

	public List<Board> getBoardCate();

	public Board getBoardsByCode(int boardIdx);

	public int modifyPost(Board params);
	
	public int addPost(Board params);
	
	public int postHitCnt(int boardIdx);
		
	public int removePost(int boardIdx);
	
	public int blindPost(int boardIdx);
	
	public int declarationPost(int boardIdx);

	/**************************************************************************
	*									댓글							
	**************************************************************************/
	
	public int addReply(BoardReply boardReply);

	public int modifyReply(BoardReply boardReply);
	
	public int removeReply(int replyIdx);
	
	public List<BoardReply> getReplyByCode(int replyIdx);
	
	public List<BoardReply> getReplysList(BoardReply boardReply);
	
	public int getReplyTotalCount(BoardReply boardReply);
	
	public int blindReply(int replyIdx);
	
	public int declarationReply(int replyIdx);

	
	
}
