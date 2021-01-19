package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Bookmark;

@Mapper
public interface BookmarkMapper {

    //즐겨찾기 삭제
    int removeBookMark(int bookMarkCode);
  
    //즐겨찾기 리스트
    public List<Bookmark> bookMarkList();
   
    //즐겨찾기 추가
  	int addBookmark(Bookmark bookmark);
  	
 
}
	
	
	