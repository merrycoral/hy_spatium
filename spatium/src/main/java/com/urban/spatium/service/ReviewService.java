package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Review;
import com.urban.spatium.mapper.ReviewMapper;

@Service
@Transactional
public class ReviewService {
		@Autowired
		private ReviewMapper reviewMapper;
		
		public List<Review> getAllReview() {
			List<Review> allReview = reviewMapper.getAllReview();
			int listSize = allReview.size();
			for(int i=0; i<listSize; i++) {
				if("1".equals(allReview.get(i).getReviewType())) {
					allReview.get(i).setReviewType("동영상");
				}else if("2".equals(allReview.get(i).getReviewType())) {
					allReview.get(i).setReviewType("포토");
				}if("3".equals(allReview.get(i).getReviewType())) {
					allReview.get(i).setReviewType("텍스트");	
				}
			}
			return allReview;
		}

		public Object searchReview(String searchKey, String searchValue) {
			List<Review> searchedReview = reviewMapper.searchReview(searchKey, searchValue);
			return searchedReview;
		}

}
