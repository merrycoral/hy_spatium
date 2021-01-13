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
	
	
		
	//북마크 리스트
	public List<Bookmark> bookMarkList(){
		
		return bookmarkMapper.bookMarkList();
	}
	
	public Bookmark getbookmarkByCode(int bookMarkCode) {
	Bookmark bookmark = bookmarkMapper.getbookmarkByCode(bookMarkCode);
					
		return bookmark;
	}
	
 }
