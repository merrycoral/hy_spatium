package com.urban.spatium.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.urban.spatium.dto.Review;
import com.urban.spatium.service.ReviewService;


@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
	
								
		
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
			
			model.addAttribute("title", "리뷰전체조회");
			model.addAttribute("allReview", resultMap.get("allReview"));
			model.addAttribute("lastPage", resultMap.get("lastPage"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPageNum", resultMap.get("startPageNum"));
			model.addAttribute("endPageNum", resultMap.get("endPageNum"));
			
			System.out.println(resultMap.get("startPageNum"));
			System.out.println(resultMap.get("endPageNum"));
			
				//return "redirect:/";
			
			return "review/reviewAll";
		}
		
		@PostMapping("/reviewAll")
		public String searchReview(@RequestParam(name = "sk", required = false) String searchKey
								,@RequestParam(name = "sv", required = false) String searchValue
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
			
			model.addAttribute("title", "검색된 리뷰");
			model.addAttribute("allReview", reviewService.searchReview(searchKey, searchValue));
			
			return "review/reviewAll";
		}
		
		@GetMapping("/writeReview")
		public String writeReview() {
			return "review/writeReview";
		}
	
}
