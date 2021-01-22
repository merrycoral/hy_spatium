package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Bookmark;

@Mapper
public interface BookmarkMapper {

	//북마크 전체삭제
	void deleteAll(String userId); 
	
    //북마크 삭제
	int removeBookMark(String bookMarkCode);
  
    //북마크 리스트
    public List<Bookmark> bookMark();
   
    //북마크 추가
  	int addbookMark(String userId, String storeCode);

	List<Bookmark> getBookMark(String userId, String storeCode);
 
}
	
	
	