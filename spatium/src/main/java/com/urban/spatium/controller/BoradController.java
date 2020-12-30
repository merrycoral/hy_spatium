package com.urban.spatium.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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


	@GetMapping("/boardArticleList")
	public String boardArticleList() {
		return "borad/boardArticleList";
	}

	@GetMapping("/faqList")
	public String faqList() {
		return "borad/faqList";
	}
	
	//소모임 게시판 리스트
	@GetMapping("/boardList")
	public String getboardList(Model model
			,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
		model.addAttribute("title", "소모임게시판");
		/*
		 * List<Board> boardsList = boardService.getBoardsList();
		 * model.addAttribute("boardsList", boardMapper.getBoardsList());
		 */
		
		Map<String, Object> resultMap = boardService.getBoardsList(currentPage);

		model.addAttribute("boardList", resultMap.get("boardList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));

		return "borad/boardList";
	}

	//게시글 검색



	//소모임 게시글 작성(view)
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
	 
	 //소모임 게시글 작성(Action)
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
	 
	 //소모임 게시글 상세조회
	 @GetMapping("/detailPost")
		public String detailPost(@RequestParam(name="boardIdx", required = false) int boardIdx
								 ,@RequestParam(name="boardTitle", required = false) String boardTitle
								 ,Model model) {

		Board board = boardService.getBoardsByCode(boardIdx);
		
		model.addAttribute("title", boardTitle);
		model.addAttribute("Board", board);
		
		
		
		return "borad/detailPost";
		}
	 
	 //소모임 게시글 수정(view)
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
	 
	 //소모임 게시글 수정(Action)
		@PostMapping("/modifyPost")
		public String modifyGoods(Board board) {
			
			String result = boardService.modifyPost(board);
			System.out.println(result);
				
			return "redirect:/boardList";
		}

	//소모임 게시판 삭제(Action)
		@RequestMapping(value = "/removePost", method = RequestMethod.GET)
		public String removeGoods(@RequestParam(name="boardIdx", required = false) int boardIdx) {
			
			String result = boardService.removePost(boardIdx);

			return "redirect:/boardList";
		}
}
