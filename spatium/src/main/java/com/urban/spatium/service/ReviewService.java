package com.urban.spatium.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		public Map<String, Object> getAllReview(int currentPage){
			int startRow = 0;
			int rowPerPage = 10;
			int startPageNum = 1;
			int endPageNum = 10;
					
			//last 페이지 구하기
			double count = reviewMapper.getAllReviewCount();
			System.out.println(count + "<--- count");
			int lastPage = (int) Math.ceil(count/rowPerPage);
			System.out.println(lastPage + "<--- lastPage");
			
			//페이지 알고리즘
			startRow = (currentPage - 1) * rowPerPage;
			
			List<Map<String, Object>> allReview = reviewMapper.getAllReview(startRow, rowPerPage);
			
			if(currentPage > 6 && lastPage < 10) {
				startPageNum = currentPage - 5;
				endPageNum  = currentPage + 4;
				
				if(endPageNum >= lastPage) {
					startPageNum = (lastPage - 9);
					endPageNum = lastPage;
				}
			}else {
				endPageNum = lastPage;
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("lastPage", lastPage);
			resultMap.put("allReview", allReview);
			resultMap.put("startPageNum", startPageNum);
			resultMap.put("endPageNum", endPageNum);
			System.out.println(resultMap.get("startPageNum"));
			System.out.println(resultMap.get("endPageNum"));
			
			return resultMap;
		}
		
		public List<Review> searchReview(String searchKey, String searchValue) {
			List<Review> searchedReview = reviewMapper.searchReview(searchKey, searchValue);
			return searchedReview;
		}

		public int blindReview(String reviewCode, String blindValue) {
			String result = "블라인드 수정 실패";
			
			String[] array = reviewCode.split(",");
			
			int delcnt = 0;
			if(reviewCode != null) {
				for(int i=0 ; i < array.length ; i++) {
					int blindCheck = reviewMapper.blindReview(array[i], blindValue);
					if(blindCheck > 0) delcnt ++;
				}
			}
			result = "리뷰" + delcnt + "개 수정 성공";
			return delcnt;
		}
		
		public int deleteReview(String reviewCode) {
			String[] array = reviewCode.split(",");
				//for(String cha : array){ 
				//query += (query.equals("")) ? "'"+cha+"'" : ",'"+cha+"'"; 
				//}
			String result = "리뷰 삭제 실패";
			int delcnt = 0;
			if(reviewCode != null) {
				for(int i=0 ; i < array.length ; i++) {
					int removeCheck = reviewMapper.deleteReview(array[i]);
					if(removeCheck > 0) delcnt ++;
				}
			}
			result = "리뷰" + delcnt + "개 삭제에 성공";
			return delcnt;
		}

		public Map<String, Object> getStoreReview(int currentPage, String sessionId) {
			int startRow = 0;
			int rowPerPage = 10;
			int startPageNum = 1;
			int endPageNum = 10;
					
			//last 페이지 구하기
			double count = reviewMapper.getStoreReviewCount();
			System.out.println(count + "<--- count");
			int lastPage = (int) Math.ceil(count/rowPerPage);
			System.out.println(lastPage + "<--- lastPage");
			
			//페이지 알고리즘
			startRow = (currentPage - 1) * rowPerPage;
			
			List<Map<String, Object>> storeReview = reviewMapper.getStoreReview(sessionId, startRow, rowPerPage);
			
			if(currentPage > 6 && lastPage < 10) {
				startPageNum = currentPage - 5;
				endPageNum  = currentPage + 4;
				
				if(endPageNum >= lastPage) {
					startPageNum = (lastPage - 9);
					endPageNum = lastPage;
				}
			}else {
				endPageNum = lastPage;
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("lastPage", lastPage);
			resultMap.put("storeReview", storeReview);
			resultMap.put("startPageNum", startPageNum);
			resultMap.put("endPageNum", endPageNum);
			System.out.println(resultMap.get("startPageNum"));
			System.out.println(resultMap.get("endPageNum"));
			
			return resultMap;
		}

}
