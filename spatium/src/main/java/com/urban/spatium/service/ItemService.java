package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.User;
import com.urban.spatium.mapper.ItemMapper;
import com.urban.spatium.mapper.UserMapper;


@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private UserMapper userMapper; 
	
	//장비구입내역 삭제
	public String removeitemBuy(int itemBuyCode, String userId, String userPw) {
		String result = "장비구입내역 삭제 실패";
		
		User user = userMapper.getUserById(userId);
		
		if(user != null && user.getUserPw() != null && userPw.equals(user.getUserPw())) {
		int removeCheck = itemMapper.removeitemBuy(itemBuyCode);
		if(removeCheck > 0) result = "장비구입내역 삭제 완료";
		}		
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
	
	//장비수리내역 삭제
	public String removeitemRepair(int itemRepairCode, String userId, String userPw) {
		String result = "장비구입내역 삭제 실패";
		
		User user = userMapper.getUserById(userId);
		
		if(user != null && user.getUserPw() != null && userPw.equals(user.getUserPw())) {
		int removeCheck = itemMapper.removeitemRepair(itemRepairCode);
		if(removeCheck > 0) result = "장비구입내역 삭제 완료";
		}			
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
	
	//장비파기내역 삭제
	public String removeitemDelete(int itemDeleteCode, String userId, String userPw) {
			String result = "장비구입내역 삭제 실패";
			
			User user = userMapper.getUserById(userId);
			
			if(user != null && user.getUserPw() != null && userPw.equals(user.getUserPw())) {
			int removeCheck = itemMapper.removeitemDelete(itemDeleteCode);
			if(removeCheck > 0) result = "장비구입내역 삭제 완료";
			}
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
	
}
