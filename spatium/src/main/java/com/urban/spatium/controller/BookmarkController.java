package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urban.spatium.dto.Bookmark;
import com.urban.spatium.service.BookMarkService;

@Controller("/bookmark")
public class BookmarkController {
	
	@Autowired 
	private BookMarkService bookmarkService;
	
	

	//북마크 삭제
	@GetMapping("/removeBookMark") 
	public String removeBookMark(@RequestParam(name="bookMarkCode", required = false) String bookMarkCode , Model model) {
		 System.out.println("북마크 삭제화면에 입력받은 값 ->" + bookMarkCode);
	  
	 bookmarkService.removeBookMark(bookMarkCode);
	  
	 model.addAttribute("bookMarkCode", bookMarkCode);
	 	  
	 return "redirect:/bookMarkList";
	  }

	//북마크 목록
	@PostMapping("/bookMark")
	public String bookMark(Model model) {

		model.addAttribute("title", "북마크 목록");

		return "bookmark/bookMarkList";
	}

	@GetMapping("/bookMark")
	public String bookMarkList(Model model, @RequestParam(name="userId", required = false) String userId) {
		List<Bookmark> bookMarkList = bookmarkService.bookMark();
		model.addAttribute("bookMarkList", bookMarkList);
		return "bookmark/bookMarkList";
	}
	
	//북마크 추가
	@ResponseBody
	@RequestMapping(value = "/addbookMark",produces = "application/json",method = RequestMethod.POST ) 
    public String addbookMark (HttpSession session
    		, @RequestParam(name="storeCode", required = false)String storeCode) {
		String userId=(String)session.getAttribute("SID");
        if(userId==null) { 
        	return "로그인하고와라";
        }
        List<Bookmark> bookmark = bookmarkService.getBookMark(userId, storeCode);
        if(bookmark.size()>0) {
        	return "야 이거 이미 햇는대?";
        }
		bookmarkService.addbookMark(userId, storeCode);
        return "추가햇어요"; 
    }
	
	
	
}
