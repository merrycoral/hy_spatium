package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Bookmark;
import com.urban.spatium.dto.User;
import com.urban.spatium.service.BookMarkService;

@Controller
public class BookmarkController {
	
	@Autowired 
	private BookMarkService bookmarkService;
	
		
	//북마크 목록
	@PostMapping("/bookMarkList")
	public String userList(Model model) {

		model.addAttribute("title", "북마크 목록");

		return "bookmark/bookMarkList";
	}

	@GetMapping("/bookMarkList")
	public String bookMarkList(Model model, @RequestParam(name="bookMarkCode", required = false) int bookMarkCode) {
		
		List<Bookmark> bookMarkList = bookmarkService.bookMarkList();
		
		model.addAttribute("bookMarkList", bookMarkList);
		
		return "bookmark/bookMarkList";
	}
	
	
		
		
	
	
	
	
}
