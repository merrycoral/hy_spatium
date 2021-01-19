package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	

	//북마크 삭제
	@GetMapping("/removeBookMark")
	public String removeBookMark(@RequestParam(name="bookMarkCode", required = false) int bookMarkCode) {
			
		bookmarkService.removeBookMark(bookMarkCode);

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
	@GetMapping("/addbookMark")
    public String addbookMark (HttpSession session, Bookmark bookmark) {
		String userId=(String)session.getAttribute("SID");
        if(userId==null) { 
		
        	return "redirect:/login";
        }
		bookmark.setUserId(userId);
		bookmarkService.addbookMark(bookmark);
        return "redirect:/bookMarkList"; 
    }

}
