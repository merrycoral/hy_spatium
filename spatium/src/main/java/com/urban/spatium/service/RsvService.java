package com.urban.spatium.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.mapper.RsvMapper;


@Service
@Transactional
public class RsvService {
	// DI
	@Autowired 
	private RsvMapper rsvMapper;
	/**
	 * 예약 등록 메서드
	 */
	public List<Rsv> insertTbRsv(Rsv rsv) {
		//총 예약 시간 구하기
		int rsvTime = 0;
		String startTime = rsv.getStartTime()+":00:00";
		@SuppressWarnings("unused")
		String endTime = null;
		if(rsv.getEndTime()==null || rsv.getEndTime()=="") {
			rsvTime = 1;
			endTime=rsv.getStartTime()+":59:59";
		}else {
			endTime = rsv.getEndTime()+":59:59";
			int stime = Integer.parseInt(rsv.getStartTime());
			int etime = Integer.parseInt(rsv.getEndTime());
			rsvTime = etime-stime+1;
		}
		String rsvStartDateTime = rsv.getRsvDate().substring(0,10) + " " +startTime;
		String rsvEndDateTime = rsv.getRsvDate().substring(rsv.getRsvDate().length()-10,rsv.getRsvDate().length()) + " " +endTime;
		
		rsv.setRsvStartDateTime(rsvStartDateTime);
		rsv.setRsvEndDateTime(rsvEndDateTime);
		System.out.println(rsvStartDateTime + " <-- 예약 시작 일시");
		System.out.println(rsvEndDateTime + " <-- 예약 종료 일시");
		
		//공간 예약이 있을경우에만 예약 중복 체크
		List<Rsv> rsvCheck =null;
		if(rsv.getSpaceList().size()>0) {
			System.out.println("공간있음 예약 중복체크 시작");
			rsvCheck = rsvMapper.rsvCheck(rsv);
		}
		if(rsvCheck == null || rsvCheck.size()<=0) {
			System.out.println("중복없음");
			//예약 등록
			rsvMapper.insertTbRsv(rsv);
			int totalPrice = 0;
			int rsvCode = rsv.getRsvCode();
			if(rsv.getSpaceList() !=null) {
				System.out.println("공간예약 시작");
				for(int i=0; i<rsv.getSpaceList().size();i++) {	//공간 예약
					Map<String, Object> spaceRsv = rsv.getSpaceList().get(i);
					//가격 추가
					int spacePrice = Integer.valueOf(spaceRsv.get("spaceRentalPrice").toString());
					totalPrice = totalPrice + spacePrice;
					
					//세부 공간 예약 등록
					rsvMapper.insertRsvSpaceDetail(spaceRsv);
					Object itemRsvCode = spaceRsv.get("rsvDetailCode");
					//릴레이션 등록
					rsvMapper.insertTbRsvRelation(rsvCode,itemRsvCode);
				}
			}
			if(rsv.getItemList() != null) {
				System.out.println("장비예약 시작");
				for(int i=0; i<rsv.getItemList().size();i++) {	//장비 예약
					Map<String, Object> itemRsv = rsv.getItemList().get(i);
					//가격 추가
					int itemPrice = Integer.valueOf(itemRsv.get("itemTotalPrice").toString());
					totalPrice = totalPrice + itemPrice;
					
					//세부 장비 예약 등록
					rsvMapper.insertRsvItemDetail(itemRsv);
					Object itemRsvCode = itemRsv.get("rsvDetailCode");
					
					//릴레이션 등록
					rsvMapper.insertTbRsvRelation(rsvCode,itemRsvCode);
					
				}
			}
			
			//예약한거 가격 설정
			rsv.setRsvTotalPrice(totalPrice);
			System.out.println("총 시간당 예약 가격 --> "+totalPrice);
			if("시간".equals(rsv.getRsvState())) {
				//총 예약 가격은 시간당 예약가격 x 예약 시간
<<<<<<< HEAD
=======
				System.out.println("가격 : "+totalPrice);
				System.out.println("시간 : "+rsvTime);
>>>>>>> branch 'SHY' of https://github.com/merrycoral/hy_spatium
				totalPrice = totalPrice*(rsvTime);
				rsvMapper.updateRsvPrice(rsvCode, totalPrice);
			}else if("일".equals(rsv.getRsvState())) {
				rsvMapper.updateRsvDayPrice(rsvCode, totalPrice);
			}
			return null; 
		}else {
			System.out.println("공간 중복있음");
		}
		return rsvCheck;
	}

	public List<Rsv> rsvListAdmin() {
		List<Rsv> rsvList = rsvMapper.rsvListAdmin();
		return rsvList;
	}
	public List<Rsv> rsvListAdminByStore(String storeId) {
		List<Rsv> rsvList = rsvMapper.rsvListAdminByStore(storeId);
		return rsvList;
	}
	public List<Rsv> rsvList(String sessionId) {
		List<Rsv> rsvList = rsvMapper.rsvList(sessionId);
		return rsvList;
	}
	public List<Rsv> rsvDetailList() {
		List<Rsv> rsvDetailList = rsvMapper.rsvDetailList();
		return rsvDetailList;
	}
	public List<Rsv> rsvDetailListByStore(String storeId) {
		List<Rsv> rsvDetailList = rsvMapper.rsvDetailListByStore(storeId);
		return rsvDetailList;
	}

	public List<OKSpace> getSpaceByStore(int storeCode) {
		List<OKSpace> getSpaceByStore = rsvMapper.getSpaceByStore(storeCode);
		
		return getSpaceByStore;
	}

	public List<Item> getItemByStore(int storeCode) {
		List<Item> getItemByStore = rsvMapper.getItemByStore(storeCode);
		return getItemByStore;
	}

	public List<Rsv> rsvListExtend(String rsvCode) {
		List<Rsv> rsvListExtend = rsvMapper.rsvListExtend(rsvCode);
		return rsvListExtend;
	}

	public List<Rsv> getExRsv(Rsv rsv) {
		String rsvDate=rsv.getRsvDate();
		List<Rsv> getExRsv = null;
		//일별 예약일때
		if(rsv.getRsvDate().length()>15) {
			rsv.setRsvStartDateTime(rsvDate.substring(0,10));
			rsv.setRsvEndDateTime(rsvDate.substring(13));
			getExRsv = rsvMapper.getExRsv(rsv);
		
		//시간별 예약일때
		}else {
			getExRsv = rsvMapper.getExRsv(rsv);
		}
		
		//이전 예약 가져온후 데이터 다듬기
		for(int i=0; i<getExRsv.size(); i++) {
			String startDT=getExRsv.get(i).getRsvStartDateTime();
			String endDt=getExRsv.get(i).getRsvEndDateTime();
			String startT = startDT.substring(11, 13);
			String endT = endDt.substring(11, 13);
			getExRsv.get(i).setStartTime(startT);
			getExRsv.get(i).setEndTime(endT);
		}
		
		return getExRsv;
	}
	
	/**
	 * 그 시간대 장비 현황 파악 메서드
	 */
	public List<Rsv> getExItemRsv(Rsv rsv) {
		int leng = rsv.getRsvDate().length();
		String startDay = rsv.getRsvDate().substring(0,10);
		String EndDay = rsv.getRsvDate().substring(leng-10,leng);
		if(rsv.getStartTime()!=null &&rsv.getEndTime()!=null) {
			rsv.setRsvStartDateTime(startDay +" "+ rsv.getStartTime() + ":00:00");
			rsv.setRsvEndDateTime(EndDay +" "+ rsv.getEndTime() + ":00:00");
		}else {
			rsv.setRsvStartDateTime(startDay +" "+ "00:00:00");
			rsv.setRsvEndDateTime(EndDay +" "+ "23:59:59");
		}
		
		List<Rsv> getExItemRsv = rsvMapper.getExItemRsv(rsv);
		return getExItemRsv;
	}

	public void cancelRsv(int rsvCode) {
		List<String> rsvDetailList = rsvMapper.getRsvDetailCodeByRsvCode(rsvCode);
		rsvMapper.cancelRsvRelation(rsvCode);
		rsvMapper.cancelRsv(rsvCode);
		rsvMapper.cancelRsvDetail(rsvDetailList);
		System.out.println("삭제완료");
		
	}
	
	/**
	 * 전체 통계 메서드
	 */
	public List<Map<String, Object>> rsvStatAdmin() {
		List<Map<String, Object>> rsvStatAdmin = rsvMapper.rsvStatAdmin();
		//최고 예약수를 기준으로 다른 업체의 예약수를 퍼센트 계산
		for(int i=0; i<rsvStatAdmin.size(); i++) {
			System.out.println("count값 :"+rsvStatAdmin.get(i).get("count"));
			if(rsvStatAdmin.get(i).get("count") != null) {
				int count0 = Integer.parseInt(rsvStatAdmin.get(0).get("count").toString());
				int counti = Integer.parseInt(rsvStatAdmin.get(i).get("count").toString());
				int percentC = (counti*100/count0);
				rsvStatAdmin.get(i).put("percentC", percentC);
			}
			if(rsvStatAdmin.get(i).get("sumPrice") != null) {
				int count0 = Integer.parseInt(rsvStatAdmin.get(0).get("sumPrice").toString());
				for(int j=0; j<rsvStatAdmin.size(); j++) {
					if(count0 < Integer.parseInt(rsvStatAdmin.get(j).get("sumPrice").toString())) {
						count0 =  Integer.parseInt(rsvStatAdmin.get(j).get("sumPrice").toString());
					}
				}
				int counti = Integer.parseInt(rsvStatAdmin.get(i).get("sumPrice").toString());
				int percentS = (counti*100/count0);
				rsvStatAdmin.get(i).put("percentS", percentS);
			}
		}
		return rsvStatAdmin;
	}
	
	/**
	 * 기간별 통계 메서드
	 */
	public List<Map<String, Object>> rsvStatAdmin(String day) {
		List<Map<String, Object>> rsvStatAdmin = null;
		String startDay = null;
		String endDay = null;
		if(day.length()<10) {//월간
			startDay = day+"-01";
			endDay = "월";
		}else if(day.length()<20) {//일간
			startDay = day;
			endDay = "일";
		}else {//주간
			startDay = day.substring(0,10);
			endDay = day.substring(13);
		}
		rsvStatAdmin = rsvMapper.dayRsvStatAdmin(startDay, endDay);
		
		//최고 예약수를 기준으로 다른 업체의 예약수를 퍼센트 계산
		for(int i=0; i<rsvStatAdmin.size(); i++) {
			System.out.println("count값 :"+rsvStatAdmin.get(i).get("count"));
			if(rsvStatAdmin.get(i).get("count") != null) {
				//count순으로 정렬햇으므로 0번 인덱스가 가장 큰 count값
				int count0 = Integer.parseInt(rsvStatAdmin.get(0).get("count").toString());
				int counti = Integer.parseInt(rsvStatAdmin.get(i).get("count").toString());
				int percentC = (counti*100/count0);
				System.out.println("c퍼센트 : "+percentC);
				rsvStatAdmin.get(i).put("percentC", percentC);
			}
			if(rsvStatAdmin.get(i).get("sumPrice") != null) {
				int count0 = 0;
				//가장 큰 sumPrice찾아서 count0에 대입
				for(int j=0; j<rsvStatAdmin.size(); j++) {
					int a = Integer.parseInt(rsvStatAdmin.get(j).get("sumPrice").toString());
					if(a>count0) {
						count0 = a;
					}
				}
				int counti = Integer.parseInt(rsvStatAdmin.get(i).get("sumPrice").toString());
				int percentS = (counti*100/count0);
				System.out.println("s퍼센트 : "+percentS);
				rsvStatAdmin.get(i).put("percentS", percentS);
			}
		}
		return rsvStatAdmin;
	}


	
	

}
