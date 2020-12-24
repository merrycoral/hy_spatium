package com.urban.spatium.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Review;
import com.urban.spatium.service.ReviewService;


@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

		@GetMapping("/reviewAll")
		public String reviewAll(Model model, @RequestParam(name="result", required = false) String result) {
			List<Review> allReview = reviewService.getAllReview();
			model.addAttribute("allReview", allReview);
			return "review/reviewAll";
		}
		
		@PostMapping("/searchReview")
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
			
			model.addAttribute("title", "회원목록");
			model.addAttribute("searchReview", reviewService.searchReview(searchKey, searchValue));
			
			return "review/reviewAll";
		}
		
		@GetMapping("/writeReview")
		public String writeReview() {
			return "review/writeReview";
		}
	
}
