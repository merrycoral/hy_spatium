package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.OKSpace;


@Mapper
public interface RsvMapper {
	
	public void insertTbRsv(Rsv rsv);

	public List<Rsv> rsvList();
	
	public List<Rsv> rsvDetailList();
	
	public List<OKSpace> getSpaceByStore(int storeCode);
	
	public List<Item> getItemByStore(int storeCode);

	public void insertRsvItemDetail(Map<String, Object> itemRsv);

	public void insertRsvSpaceDetail(Map<String, Object> spaceRsv);

	public Item getItemByCode(int tbRecord);

	public OKSpace getSpaceByCode(int tbRecord);

	public void insertTbRsvRelation(int rsvCode, Object itemRsvCode);

	public void updateRsvPrice(int rsvCode, int totalPrice);

	public List<Rsv> rsvListExtend(String rsvCode);

	public List<Rsv> getExRsv(Rsv rsv);

	public List<Rsv> getExItemRsv(Rsv rsv);

	public List<String> getRsvDetailCodeByRsvCode(int rsvCode);

	public void cancelRsvRelation(int rsvCode);

	public void cancelRsv(int rsvCode);

	public void cancelRsvDetail(List<String> rsvDetailList);
	
	
}
