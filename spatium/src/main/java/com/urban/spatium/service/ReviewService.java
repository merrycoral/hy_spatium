package com.urban.spatium.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.Review;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.mapper.CalcMapper;
import com.urban.spatium.mapper.ReviewMapper;
import com.urban.spatium.mapper.RsvMapper;

@Service
@Transactional
public class ReviewService {
		@Autowired
		private RsvMapper rsvMapper;
		@Autowired
		private ReviewMapper reviewMapper;
		@Autowired
		private CalcMapper calcMapper;
		
		public List<Review> getMyReview(String SID) {
			List<Review> myReview = reviewMapper.getMyReview(SID);
			//Map<String, Object> resultMap = new HashMap<String, Object>();
			//resultMap.put("myReview", myReview);
			return myReview;
		}
		
		public Review getReviewForModify(String reviewCode) {
			Review getReviewForModify = reviewMapper.getReviewForModify(reviewCode);
			return getReviewForModify;
		}
		
		public int modifyMyReview(String reviewCode, Review wroteReview) {
			String result = "리뷰 수정 실패";
			Map <String, Object> review = new HashMap<>();
			review.put("reviewCode", reviewCode);
			review.put("reviewTitle", wroteReview.getReviewTitle());
			review.put("reviewContents", wroteReview.getReviewContents());
			review.put("reviewClean", wroteReview.getReviewClean());
			review.put("reviewService", wroteReview.getReviewService());
			review.put("reviewRestroom", wroteReview.getReviewRestroom());
			review.put("reviewFacility", wroteReview.getReviewFacility());
			review.put("reviewAmbience", wroteReview.getReviewAmbience());
			review.put("reviewScore", wroteReview.getReviewScore());
			review.put("reviewPhoto", wroteReview.getReviewPhoto());
			int modfiycnt = 0;
			if(reviewCode != null && reviewCode !="") {
				int removeCheck = reviewMapper.modifyMyReview(review);
				if(removeCheck > 0) modfiycnt ++;
			}
			result = "리뷰" + modfiycnt + "개 수정 성공";
			System.out.println(result);
			return modfiycnt;
		}
		
		public int insertReview(Review wroteReview, String SID) {
			Point addReviewPoint = new Point();
			String rsvCode = Integer.toString(wroteReview.getReviewSpaceRsv());
			List<Rsv> getRsv = rsvMapper.rsvListExtend(rsvCode);
			Map <String, Object> storeInfo = reviewMapper.getStore(rsvCode);
			System.out.println("##########" + getRsv.get(0).getStoreId());
			wroteReview.setReviewSpaceRsv(Integer.parseInt(rsvCode));
			wroteReview.setReviewStoreId((String) storeInfo.get("storeId"));
			wroteReview.setReviewStoreCode(storeInfo.get("storeCode").toString());
			wroteReview.setReviewAddId(SID);
			//review.put("SID", SID);
			if(wroteReview.getReviewPhoto() != null && wroteReview.getReviewPhoto() != "") {
				wroteReview.setReviewType(2);
				wroteReview.setReviewPoint(50);
				addReviewPoint.setPointSellList("포토리뷰 작성");
				addReviewPoint.setPointList(50);
			}else {
				wroteReview.setReviewType(3);
				wroteReview.setReviewPoint(10);
				addReviewPoint.setPointSellList("텍스트리뷰 작성");
				addReviewPoint.setPointList(10);
			}
			//review.put("", wroteReview.get);
			System.out.println(wroteReview);
			reviewMapper.insertReview(wroteReview);
			
			addReviewPoint.setPointAddList("리뷰 작성");
			addReviewPoint.setPointID(wroteReview.getReviewAddId());
			System.out.println(wroteReview.getReviewAddId());
			addReviewPoint.setPointReviewCode(wroteReview.getReviewCode());
			System.out.println(wroteReview.getReviewCode() + "wroteReview.getReviewCode()");
			reviewMapper.addPointReview(addReviewPoint);
			return 7;
		}
		
		public List<Rsv> getRsv(String rsvCode) {
			List<Rsv> getRsv = reviewMapper.getRsv(rsvCode);
			return getRsv;
		}
		
		public List<Review> getReviewByStoreCode(int storeCode) {
			List<Review> reviewList = reviewMapper.getReviewByStoreCode(storeCode);
			return reviewList;
		}
		
		public List<Review> reviewType() {
			/*
			for(int i=0; i<listSize; i++) {
				if("1".equals(exallReview.get(i).getReviewType())) {
					exallReview.get(i).setReviewType("동영상");
				}else if("2".equals(exallReview.get(i).getReviewType())) {
					exallReview.get(i).setReviewType("포토");
				}else if("3".equals(exallReview.get(i).getReviewType())) {
					exallReview.get(i).setReviewType("텍스트");				
				}
			}
			*/
			return null;
		}
		
		public Map<String, Object> getAllReview(String SID){
			int startRow = 0;
			int rowPerPage = 10;
					
			//last 페이지 구하기
			double count = reviewMapper.getAllReviewCount();
			System.out.println(count + "<--- count");
			int lastPage = (int) Math.ceil(count/rowPerPage);
			System.out.println(lastPage + "<--- lastPage");
			
			//페이지 알고리즘
			
			List<Map<String, Object>> allReview = reviewMapper.getAllReview(startRow, rowPerPage);
			
			Map<String, Object> storeInfo = calcMapper.getStoreInfo(SID);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("allReview", allReview);
			resultMap.put("storeInfo", storeInfo);
			
			return resultMap;
		}
		
		public Map<String, Object> searchReview(String searchKey, String searchValue, int currentPage) {
			int startRow = 0;
			int rowPerPage = 10;
			int startPageNum = 1;
			int endPageNum = 10;
			
			//페이지 알고리즘
			startRow = (currentPage - 1) * rowPerPage;
			
			List<Map<String, Object>> searchedReview = reviewMapper.searchReview(startRow, searchKey, searchValue);
			
			//last 페이지 구하기
			double count = searchedReview.size();
			System.out.println(count + "<--- count");
			int lastPage = (int) Math.ceil(count/rowPerPage);
			System.out.println(lastPage + "<--- lastPage");
			
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
			resultMap.put("searchedReview", searchedReview);
			resultMap.put("startPageNum", startPageNum);
			resultMap.put("endPageNum", endPageNum);
			//System.out.println(resultMap.get("startPageNum"));
			//System.out.println(resultMap.get("endPageNum"));
			
			return resultMap;
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

		public Map<String, Object> getStoreReview(String sessionId) {
			//last 페이지 구하기
			double count = reviewMapper.getStoreReviewCount(sessionId);
			
			List<Map<String, Object>> storeReview = reviewMapper.getStoreReview(sessionId);
			
			Map<String, Object> storeInfo = calcMapper.getStoreInfo(sessionId);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("storeInfo", storeInfo);
			resultMap.put("storeReview", storeReview);
			return resultMap;
		}

		public String replyReview(String storeReply, String getReviewCode, String SID) {
			reviewMapper.replyReview(storeReply, getReviewCode, SID);
			String replyReviewResult = "리뷰 답글 등록 완료";
			
			return replyReviewResult;
		}

		public List<Map<String, Object>> viewReplyReview(String reviewCode) {
			System.out.println("service 도착");
			List<Map<String, Object>> storeReplyReview = reviewMapper.getReplyReview(reviewCode);
			return storeReplyReview;
		}

		
		public int deleteMyReview(String SID, String reviewCode) {
			String result = "리뷰 삭제 실패";
			int delcnt = 0;
			if(reviewCode != null && reviewCode !="") {
				int removeCheck = reviewMapper.deleteMyReview(SID, reviewCode);
				if(removeCheck > 0) delcnt ++;
			}
			result = "리뷰" + delcnt + "개 삭제에 성공";
			System.out.println(result);
			return delcnt;
		}


		public int rvReplyDelete(String SID, String rvReplyCode) {
			String result = "리뷰 삭제 실패";
			int delcnt = 0;
			if(rvReplyCode != null && rvReplyCode !="") {
				int removeCheck = reviewMapper.rvReplyDelete(SID, rvReplyCode);
				if(removeCheck > 0) delcnt ++;
			}
			result = "리뷰" + delcnt + "개 삭제에 성공";
			System.out.println(result);
			return delcnt;
		}

		public Map<String, Object> viewMyReview(String getReviewCode) {
			Map<String, Object> getMyReview = reviewMapper.getReview(getReviewCode);
			System.out.println("업체코드 가져오기!!!!");
			System.out.println(getMyReview);
			System.out.println(getMyReview.get("reviewStoreId"));
			String storeCode = reviewMapper.getStoreCodeById((String) getMyReview.get("reviewStoreId"));
			getMyReview.put("reviewStoreCode", storeCode);
			
			return getMyReview;
		}


}
