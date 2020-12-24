package com.urban.spatium.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	
	 @RequestMapping("/addPost") 
	 public String addPost(Board board 
			 			   ,@RequestParam(name = "boardAddId", required = false) String boardAddId) {

		 if(boardAddId == null) {
			 
			 return "redirect:/login";
		 }else {
			 String result = boardService.addPost(board); 
			 System.out.println(result); 
			 return "redirect:/boardList"; 
		 }
	 }
	 
	 @GetMapping("/detailPost")
		public String detailPost(@RequestParam(name="boardIdx", required = false) int boardIdx
								 ,@RequestParam(name="boardTitle", required = false) String boardTitle
								 ,Model model) {

		Board board = boardService.getBoardsByCode(boardIdx);
		
		model.addAttribute("title", boardTitle);
		model.addAttribute("Board", board);
		
		return "borad/detailPost";
		}
	 
	 @GetMapping("/modifyPost")
	 public String modifyPost(@RequestParam(name="boardIdx", required = false) int boardIdx
							 ,@RequestParam(name="boardTitle", required = false) String boardTitle
							 ,Model model) {
		 
		 Board board = boardService.getBoardsByCode(boardIdx);
		 List<Board> boardCate = boardService.getBoardCate();
		 model.addAttribute("boardCate", boardCate);
		 model.addAttribute("title", boardTitle);
		 model.addAttribute("Board", board);
		 
		 return "borad/modifyPost";
	 }
	 
		@PostMapping("/modifyPost")
		public String modifyGoods(Board board) {
			
			String result = boardService.modifyPost(board);
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
	public String boardWrite(Model model
							,@RequestParam(name = "userId", required = false) String userId
							,HttpServletResponse response) throws IOException {
		model.addAttribute("title", "소모임 게시판");
		if(userId.equals("")) {
			 response.setContentType("text/html; charset=UTF-8");
             PrintWriter out = response.getWriter();
             out.println("<script>alert('로그인 후 이용해주세요'); location.href='/login';</script>");
             out.flush();
			return "redirect:/login";
		}
		else {
			
			List<Board> boardCate = boardService.getBoardCate();
			model.addAttribute("boardCate", boardCate);
			return "borad/boardWrite";
		}

		
		
		
	}

}
