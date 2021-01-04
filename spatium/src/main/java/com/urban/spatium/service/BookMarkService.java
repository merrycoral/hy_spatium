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
	
	
	  public List<Bookmark> getBookMarkList(){
		  List<Bookmark> bookMarkList = bookmarkMapper.getBookMarkList(); 
		  int listSize =  bookMarkList.size();
				  
				  return bookMarkList;
				  }
	  }
	  
	/*
	 * public int addBookmark(Bookmark bookmark) { int result =
	 * bookmarkMapper.addBookmark(bookmark);
	 * 
	 * return result; }
	 * 
	 * public void delete(int bookMarkCode) { cartDao.delete(bookMarkCode); }
	 * 
	 * 
	 * public void deleteAll(String userId) { cartDao.deleteAll(userId); }
	 * 
	 * 
	 * public void update(int bookMarkCode) {
	 * 
	 * 
	 * }
	 * 
	 * public int countCart(String userId, int storeCode) {
	 * 
	 * return 0; }
	 * 
	 * 
	 * public void updateCart(Bookmark bookmark) {
	 * 
	 * 
	 * }
	 */
	 

