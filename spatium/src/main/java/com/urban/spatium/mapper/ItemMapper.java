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
	
	
	  //장비구입삭제 int removeUser(String userId, String userLevel);
	  
	  //장비구입수정 int modifyUser(User user);
	  
	  //장비구입내역
		public List<Item> itembuyList();
	  
	  //장비구입등록 public int addItemRepair(Item item);
	 
}
