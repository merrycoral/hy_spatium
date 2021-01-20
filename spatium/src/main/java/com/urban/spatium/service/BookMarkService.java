package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Bookmark;
import com.urban.spatium.mapper.BookmarkMapper;


@Service
@Transactional
public class BookMarkService {
	
	@Autowired 
	private BookmarkMapper bookmarkMapper;
	
	//북마크 전체삭제
	/*
	 * public void deleteAll(String userId) { bookmarkMapper.deleteAll(userId); }
	 */
	
	//북마크 삭제
	public String removeBookMark(String bookMarkCode) {
		String result = "북마크  삭제 실패";
		
		int removeCheck = bookmarkMapper.removeBookMark(bookMarkCode);
		if(removeCheck > 0) result = "북마크  삭제 완료";
		return result;
	}	
	
	//북마크 리스트
	public List<Bookmark> bookMark(){
		
		return bookmarkMapper.bookMark();
	}
	
	//북마크 추가
	public void addbookMark(String userId, String storeCode) {
        
		bookmarkMapper.addbookMark(userId,storeCode);
    }

	public List<Bookmark> getBookMark(String userId, String storeCode) {
		List<Bookmark> bookmark = bookmarkMapper.getBookMark(userId, storeCode);
		return bookmark;
	}
	
	
 }
