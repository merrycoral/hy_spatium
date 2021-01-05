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
	
	//즐겨찾기 리스트
	  public List<Bookmark> getBookMarkList(){
		  List<Bookmark> bookMarkList = bookmarkMapper.getBookMarkList(); 
		  int listSize =  bookMarkList.size();
				  
				  return bookMarkList;
				  }
	  
	//즐겨찾기 수정  
	public void modifyBookmark(int storeCode) {
		int result = bookmarkMapper.modifyBookmark(storeCode);
		
	}
	
	/*
	 * //즐겨찾기 삭제 public void delete(Bookmark bookmark) { int result =
	 * bookmarkMapper.delete(bookmark);
	 * 
	 * }
	 */
	
	
	 }
