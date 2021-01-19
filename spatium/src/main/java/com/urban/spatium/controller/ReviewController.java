package com.urban.spatium.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.urban.spatium.URLgetter;
import com.urban.spatium.dto.Review;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.service.ReviewService;
import com.urban.spatium.service.RsvService;


@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private RsvService rsvService;
	
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
		
		@GetMapping("/writeReview")
		public String writeReview(Model model, HttpServletRequest request, HttpSession session
				) {
			String sessionId = (String) session.getAttribute("SID");
			System.out.println(URLgetter.getURL(request));
			String[] array = URLgetter.getURL(request).split("=");
			System.out.println(array);
			String rsvCode = array[1]; 
			//URL에서 가져온 값 자르기
			System.out.println(rsvCode + " <-- rsvCode");
			
			List<Rsv> rsvListExtend = rsvService.rsvListExtend(rsvCode);
			List<Rsv> getRsv = reviewService.getRsv(rsvCode);
			model.addAttribute("rsvCode", rsvCode);
			model.addAttribute("getRsv", getRsv);
			model.addAttribute("title", "리뷰 작성하기");
			model.addAttribute("rsvListExtend", rsvListExtend);
			return "review/writeReview";
		}
		
		@PostMapping("/writeReview")
		public String insertReview(HttpSession session, Model model, Review wroteReview) {
			System.out.println(wroteReview);
			System.out.println(wroteReview.getReviewTitle());
			String SID = (String) session.getAttribute("SID");
			reviewService.insertReview(wroteReview, SID);
			
			//int result = reviewService.insertReview(review);
			//System.out.println(result);
			// /memberList?result=회원삭제성공
			return "redirect:/reviewAll";
		}
		
		@GetMapping("/reviewStore")
		public String reviewStore(HttpSession session, Model model, @RequestParam(name="result", required = false) String result
					, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
			//List<Review> allReview = reviewService.getAllReview();
			String sessionId = (String) session.getAttribute("SID");
			System.out.println(sessionId);
			
			Map<String, Object> resultMap = reviewService.getStoreReview(currentPage, sessionId);
			
			model.addAttribute("title", "내 매장 리뷰 조회");
			model.addAttribute("allReview", resultMap.get("storeReview"));
			model.addAttribute("lastPage", resultMap.get("lastPage"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPageNum", resultMap.get("startPageNum"));
			model.addAttribute("endPageNum", resultMap.get("endPageNum"));
			model.addAttribute("sessionId", sessionId);
			
			System.out.println(resultMap.get("startPageNum"));
			System.out.println(resultMap.get("endPageNum"));
			
				//return "redirect:/";
			
			return "review/reviewStore";
		}
								
		
		@PostMapping("/blindReview")
		public String blindReview(@RequestParam(name="table_records", required = false) String reviewCode
				,@RequestParam(name="blindValue", required = true) String blindValue
				,RedirectAttributes redirectAttr) {
			System.out.println("blindReview 통과");
			System.out.println("입력받은 값(reviewCode)--->"	+ reviewCode);
			System.out.println("입력받은 값(blindValue)--->"	+ blindValue);
			
			//서비스계층에서 권한 별 삭제 처리 후 결과 
			int result = reviewService.blindReview(reviewCode, blindValue);
			System.out.println(result);
			redirectAttr.addAttribute("result", result);
			// /memberList?result=회원삭제성공
			return "redirect:/reviewAll";
		}
		
		@PostMapping("/deleteReview")
		public String deleteReview(@RequestParam(name="table_records", required = false) String reviewCode
								  ,RedirectAttributes redirectAttr) {
			System.out.println("입력받은 값(reviewCode)--->"	+ reviewCode);
			
			//서비스계층에서 권한 별 삭제 처리 후 결과 
			int result = reviewService.deleteReview(reviewCode);
			System.out.println(result);
			redirectAttr.addAttribute("result", result);
			// /memberList?result=회원삭제성공
			return "redirect:/reviewAll";
		}
	
		@GetMapping("/reviewAll")
		public String reviewAll(Model model, @RequestParam(name="result", required = false) String result
					, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
			//List<Review> allReview = reviewService.getAllReview();
			
			Map<String, Object> resultMap = reviewService.getAllReview(currentPage);
			
			model.addAttribute("title", "리뷰 전체 조회");
			model.addAttribute("allReview", resultMap.get("allReview"));
			model.addAttribute("lastPage", resultMap.get("lastPage"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPageNum", resultMap.get("startPageNum"));
			model.addAttribute("endPageNum", resultMap.get("endPageNum"));
			return "review/reviewAll";
		}
		
		@PostMapping("/reviewAll")
		public String searchReview(@RequestParam(name = "sk", required = false) String searchKey
								,@RequestParam(name = "sv", required = false) String searchValue
								, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
								,Model model) {
			log.info("화면에서 전달받은 파라미터 값 sk ::: {}", searchKey);
			log.info("화면에서 전달받은 파라미터 값 sv ::: {}", searchValue);
			
			if(searchKey != null && "작성자".equals(searchKey)) {
				searchKey = "reviewAddId";
			}else if(searchKey != null && "리뷰제목".equals(searchKey)) {
				searchKey = "reviewTitle";
			}else if(searchKey != null && "리뷰코드".equals(searchKey)) {
				searchKey = "reviewCode";
			}else if(searchKey != null && "예약코드".equals(searchKey)) {
				searchKey = "reviewSpaceRsv";
			}else {
				//"방코드"일 때
				searchValue = "reviewSpaceCode";
			}
			
			log.info("searchKey 변환한 값 ::: {}", searchKey);
			
			model.addAttribute("title", searchValue + "- 리뷰 검색 결과");
			//model.addAttribute("allReview", reviewService.searchReview(searchKey, searchValue, currentPage));
			
			Map<String, Object> resultMap = reviewService.searchReview(searchKey, searchValue, currentPage);
			
			model.addAttribute("allReview", resultMap.get("searchedReview"));
			model.addAttribute("lastPage", resultMap.get("lastPage"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPageNum", resultMap.get("startPageNum"));
			model.addAttribute("endPageNum", resultMap.get("endPageNum"));
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("searchValue", searchValue);
			
			System.out.println(resultMap.get("startPageNum"));
			System.out.println(resultMap.get("endPageNum"));
			
			return "review/reviewSearch";
		}
}
