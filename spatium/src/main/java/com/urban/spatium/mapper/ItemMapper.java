package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Item;

@Mapper
public interface ItemMapper {
	
	public List<Item> itemCountList();
	
	public List<Item> itemList();
	
	public int addItem(Item item);
	
}
