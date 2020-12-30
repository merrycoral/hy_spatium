package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Item;
import com.urban.spatium.mapper.ItemMapper;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> itemCountList(){
		List<Item> itemTotalLi = itemMapper.itemCountList();
		return itemTotalLi;
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
