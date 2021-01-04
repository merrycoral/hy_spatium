package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.Criteria2;
import com.urban.spatium.dto.Review;

@Mapper
public interface ReviewMapper {

	public List<Map<String, Object>> getAllReview(int startRow, int rowPerPage);

	public int deleteReview(String reviewCode);

	public int getAllReviewCount();

	public int blindReview(String reviewCode, String blindValue);

	public int getStoreReviewCount(String sessionId);

	public List<Map<String, Object>> getStoreReview(String sessionId, int startRow, int rowPerPage);


	public List<Map<String, Object>> searchReview(int startRow, String searchKey, String searchValue);

	public List<Review> exallReview(int startRow, int rowPerPage);

	public List<Review> getReviewByStoreCode(int storeCode);




}
