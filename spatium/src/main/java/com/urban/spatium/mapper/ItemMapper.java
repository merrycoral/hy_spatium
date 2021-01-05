package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.User;

@Mapper
public interface ItemMapper {
	
	public List<Item> itemCountList();
	
	public List<Item> itemList();
	
	public int addItem(Item item);

	public List<Item> itemCountListByStoreCode(int storeCode);
	
	/*
	 * //장비수리삭제 int removeUser(String userId, String userLevel);
	 * 
	 * //장비수리수정 int modifyUser(User user);
	 * 
	 * //장비수리내역 public List<Item> getItemList();
	 * 
	 * //장비수리등록 public int addItemRepair(Item item);
	 */
}
