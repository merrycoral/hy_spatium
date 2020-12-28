package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Board;
import com.urban.spatium.mapper.BoardMapper;
import com.urban.spatium.service.BoardService;

@Controller
public class BoradController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private BoardMapper boardMapper;

	@GetMapping("/boardList")
	public String getboardList(Model model) {
		List<Board> boardsList = boardService.getBoardsList();
		model.addAttribute("title", "소모임게시판");
		model.addAttribute("boardsList", boardMapper.getBoardsList());

		return "borad/boardList";
	}

	
	 @RequestMapping(value = "/addPost", method = RequestMethod.POST) 
	 public String addPost(Board board ,@RequestParam(name = "userId", required = false)
	 String userId) { 
		 System.out.println("회원가입화면에서 입력받은 값--->" + userId); 
		 String result = boardService.addPost(board); 
		 System.out.println(result); 
		 return "redirect:/boardList"; 
	 }
	 

	@GetMapping("/boardArticleList")
	public String boardArticleList() {
		return "borad/boardArticleList";
	}

	@GetMapping("/faqList")
	public String faqList() {
		return "borad/faqList";
	}

	@GetMapping("/boardWrite")
	public String boardWrite(Model model) {
		model.addAttribute("title", "소모임 계시판");
		List<Board> boardCate = boardService.getBoardCate();
		model.addAttribute("boardCate", boardCate);
		return "borad/boardWrite";
	}

}
