package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.Review;
import com.urban.spatium.dto.Rsv;

@Mapper
public interface ReviewMapper {


	public List<Map<String, Object>> getAllReview(int startRow, int rowPerPage);

	public int deleteReview(String reviewCode);

	public int getAllReviewCount();

	public int blindReview(String reviewCode, String blindValue);

	public int getStoreReviewCount(String sessionId);

	public List<Map<String, Object>> getStoreReview(String sessionId);

	public List<Map<String, Object>> searchReview(int startRow, String searchKey, String searchValue);

	public List<Review> exallReview(int startRow, int rowPerPage);

	public List<Review> getReviewByStoreCode(int storeCode);

	public List<Rsv> getRsv(String rsvCode);

	public Map<String, Object> getStore(String rsvCode);

	public void insertReview(Review wroteReview);

	public void replyReview(String storeReply, String getReviewCode, String SID);

	public List<Review> getMyReview(String SID);

	public int deleteMyReview(String SID, String reviewCode);

	public List<Map<String, Object>> getReplyReview(String reviewCode);

	public int rvReplyDelete(String SID, String rvReplyCode);

	public Review getReviewForModify(String reviewCode);

	public int modifyMyReview(Map<String, Object> review);

	public Map<String, Object> getReview(String getReviewCode);

	public String getStoreCodeById(String storeId);

	public void addPointReview(Point addReviewPoint);


}
