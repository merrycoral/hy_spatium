package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Item;

@Mapper
public interface ItemMapper {
	
	public List<Item> itemCountList();
	
	public List<Item> itemList();
	
	public int addItem(Item item);

	public List<Item> itemCountListByStoreCode(int storeCode);
	
	
	//장비구입삭제
	int removeitemBuy(int itemBuyCode);
	  
	//장비구입수정
	int modifyitemBuy(Item item);
	  
	//장비구입내역
	public List<Item> getItemBuyList();
	  
	  //장비구입등록 public int addItemRepair(Item item);
	 
}
