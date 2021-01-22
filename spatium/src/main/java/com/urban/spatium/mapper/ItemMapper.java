package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.Store;

@Mapper
public interface ItemMapper {
	
	public List<Store> addItmeChoice(String storeId);
	
	public List<Item> itemCountList();
	
	public List<Item> itemList();
	
	public int addItem(Item item);

	public List<Item> itemCountListByStoreCode(int storeCode);
	
	//장비파기내역 삭제
	int removeitemDelete(String storeDeleteCode);
			  
	//장비파기내역 수정
	int modifyitemDelete(Item storeDeleteCode);
			  
	//장비파기내역
	public List<Item> itemDeleteList();
	
	//장비파기 등록
	public int addItemDelete(Item item);
	
	//장비수리내역 삭제
	int removeitemRepair(String itemRepairCode);
		  
	//장비수리내역 수정
	int modifyitemRepair(Item item);
		  
	//장비수리내역
	public List<Item> itemRepairList();
	
	//장비수리 등록
	public int addItemRepair(Item item);
		
	//장비구입내역 삭제
	int removeitemBuy(String itemBuyCode);
	  
	//장비구입내역 수정
	int modifyitemBuy(Item item);
	  
	//장비구입내역
	public List<Item> itemBuyList();
	
	//장비구입 등록
	public int addItemBuy(Item item);

	public Item itemListByCode(String itemBuyCode);
	
	public Item itemRepairByCode(String itemRepairCode);
	
	public Item itemDeleteByCode(String storeDeleteCode);
	  
}
