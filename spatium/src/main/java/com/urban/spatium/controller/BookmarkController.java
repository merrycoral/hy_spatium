package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Bookmark;
import com.urban.spatium.service.BookMarkService;

@Controller
public class BookmarkController {
	
	@Autowired 
	private BookMarkService bookmarkService;
	
	 //즐겨찾기 추가
	@PostMapping("/bookMarkList")
	public String bookMarkList(Model model) {
		
		model.addAttribute("title", "찜한공간");
		return "bookMark/bookMarkList";
	}
	
	@GetMapping("/bookMarkList")
	public String bookMarkList(Model model, @RequestParam(name="result", required = false) String result) {
		List<Bookmark> bookMarkList = bookmarkService.getBookMarkList();
		System.out.println(bookMarkList);
		model.addAttribute("title", "찜한공간");
				
		return "bookmark/bookMarkList";
	}
	
	
	
	
}
