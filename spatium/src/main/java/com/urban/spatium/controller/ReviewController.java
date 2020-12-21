package com.urban.spatium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

		@GetMapping("/allReviewAdmin")
		public String allReviewAdmin() {
			return "review/allReviewAdmin";
		}
		
		@GetMapping("/writeReview")
		public String writeReview() {
			return "review/writeReview";
		}
	
}
