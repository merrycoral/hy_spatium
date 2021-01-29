package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.Store;
import com.urban.spatium.mapper.ItemMapper;


@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> itemDetailBuy(String storeId){
		
		List<Item> itemDetailBuy = itemMapper.itemDetailBuy(storeId);
		
		return itemDetailBuy;
	}
	
	public List<Item> myItemCountList(String itemTotalUserId){
		
		List<Item> myItemCountList = itemMapper.myItemCountList(itemTotalUserId);
		
		return myItemCountList;
	}
	
	public List<Item> myItemList(String itemDetailUserId){
		
		List<Item> myItemList = itemMapper.myItemList(itemDetailUserId);
		
		return myItemList;
	}
	
	//장비구입내역 삭제
	public String removeitemBuy(String itemBuyCode) {
		String result = "장비구입내역 삭제 실패";
		
		int removeCheck = itemMapper.removeitemBuy(itemBuyCode);
		if(removeCheck > 0) result = "장비구입내역 삭제 완료";
		return result;
	}		
	
	//장비구입내역 수정
	public String modifyitemBuy(Item item) {
		String result = "장비구입내역 수정 실패";
	
		int modifyCheck = itemMapper.modifyitemBuy(item);
		if(modifyCheck > 0) result = "장비구입내역 수정 완료";
	
		return result;
	}
	
	//장비구입내역
	public List<Item> itemBuyList(){
		
		return itemMapper.itemBuyList();
	}
	
	//장기구입 등록
	public String addItemBuy(Item item) {
			
	String addCheck = "장비파기 등록 실패";
		if(item != null) {
		itemMapper.addItemBuy(item);
			addCheck = "장비파기 등록 성공";
		}
		return addCheck;
	}
	//장비수리내역 삭제
	public String removeitemRepair(String itemRepairCode) {
		String result = "장비수리내역 삭제 실패";
		
		int removeCheck = itemMapper.removeitemRepair(itemRepairCode);
		if(removeCheck > 0) result = "장비수리내역 삭제 완료";
		return result;
	}	
	
	//장비수리내역 수정
	public String modifyitemRepair(Item item) {
		String result = "장비수리내역 수정 실패";
		
		int modifyCheck = itemMapper.modifyitemRepair(item);
		if(modifyCheck > 0) result = "장비수리내역 수정 완료";
		
		return result;
	}
		
	//장비수리내역
	public List<Item> itemRepairList(){
			
		return itemMapper.itemRepairList();
	}
	
	//장비수리 등록
	public String addItemRepair(Item item) {
			
	String addCheck = "장비파기 등록 실패";
		if(item != null) {
		itemMapper.addItemRepair(item);
			addCheck = "장비파기 등록 성공";
		}
		return addCheck;
	}
	
	//장비파기내역 삭제
	public String removeitemDelete(String storeDeleteCode) {
		String result = "장비파기내역 삭제 실패";
		
		int removeCheck = itemMapper.removeitemDelete(storeDeleteCode);
		if(removeCheck > 0) result = "장비파기내역 삭제 완료";
		return result;
	}	

	//장비파기내역 수정
	public String modifyitemDelete(Item item) {
		String result = "장비파기내역 수정 실패";
		
		int modifyCheck = itemMapper.modifyitemDelete(item);
		if(modifyCheck > 0) result = "장비파기내역 수정 완료";
		
			return result;
		}
		
	//장비파기내역
	public List<Item> itemDeleteList(){
		
		return itemMapper.itemDeleteList();
		}	
	
	//장기파기 등록
	public String addItemDelete(Item item) {
		
		String addCheck = "장비파기 등록 실패";
			if(item != null) {
				itemMapper.addItemDelete(item);
				addCheck = "장비파기 등록 성공";
			}
		return addCheck;
	}
	
	
	public Item getitemBuyCode(int itemBuyCode) {
		
		//itemsMapper에서 코드에 일치하는 상품정보가 담긴 객체 받아오기
		Item item = getitemBuyCode(itemBuyCode);
	
		return item;
	}
	
	
	public List<Item> itemCountList(){
		List<Item> itemTotalLi = itemMapper.itemCountList();
		return itemTotalLi;
	}
	
	public List<Item> itemCountListByStoreCode(int storeCode){
		List<Item> itemCountListByStoreCode = itemMapper.itemCountListByStoreCode(storeCode);
		return itemCountListByStoreCode;
	}
	
	public List<Item> itemList(){
		List<Item> itemLi = itemMapper.itemList();
		return itemLi;
	}
	
	public String addItem(Item item) {
		
		String addCheck = "장비 등록 실패";
			if(item != null) {
				itemMapper.addItem(item);
				addCheck = "장비 등록 성공";
			}
			
		return addCheck;
	}
	
	public List<Store> addItemChoice(String storeId){
		
		List<Store> itemList = itemMapper.addItmeChoice(storeId);
		
		return itemList;
	}

	public Item itemListByCode(String itemBuyCode) {
		Item item = itemMapper.itemListByCode(itemBuyCode);
		return item;
	}
	
	public Item itemRepairByCode(String itemRepairCode) {
		Item item = itemMapper.itemRepairByCode(itemRepairCode);
		return item;
	}
	
	public Item itemDeleteByCode(String storeDeleteCode) {
		Item item = itemMapper.itemDeleteByCode(storeDeleteCode);
		return item;
	}

}
