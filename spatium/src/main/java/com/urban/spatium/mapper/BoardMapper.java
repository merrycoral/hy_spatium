package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Board;

@Mapper
public interface BoardMapper {
	public List<Board> getBoardsList(); 
	
	/*
	public int getBoardsListCount();
	
	public List<Map<String, Object>> getBoardsList(int startRow, int rowPerPage);
	
	*/
	public int addPost(Board board);

	public List<Board> getBoardCate();

	public Board getBoardsByCode(int boardIdx);

	public int modifyPost(Board board);
	
	public int removePost(int boardIdx);
	
	
}
