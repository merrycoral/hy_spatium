package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.urban.spatium.dto.Item;
import com.urban.spatium.mapper.ItemMapper;
import com.urban.spatium.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemMapper itemMapper;
	
	
	//장비구입내역삭제
	@PostMapping("/removeitemBuy")
	public String removeitemBuy(@RequestParam(name="itemBuyCode", required = false) int itemBuyCode
								,@RequestParam(name="userId", required = false) String userId
								,@RequestParam(name="userPw", required = false) String userPw) {
		System.out.println("장비구입 삭제화면에서 입력 받은 값->" + itemBuyCode);
		System.out.println("장비구입 삭제화면에서 입력 받은 값->" + userId);
		System.out.println("장비구입 삭제화면에서 입력 받은 값->" + userPw);
				
		String result = itemService.removeitemBuy(itemBuyCode, userId, userPw);
		System.out.println(itemBuyCode + " : " + result);
		
		return "redirect:/itemBuyList";
	}
	
	@GetMapping("/removeitemBuy")
	public String removeitemBuy(@RequestParam(name="itemBuyCode", required = false) int itemBuyCode
				,Model model) {
	System.out.println("장비구입 수정화면에 입력받은 값 ->" + itemBuyCode);
	
	Item item = itemService.getitemBuyCode(itemBuyCode);
	
	model.addAttribute("itemBuyCode", itemBuyCode);
	model.addAttribute("getStoreBuyCode", item.getStoreBuyCode());
		
		return "item/dItemBuy";
}

	//장비구입내역 수정
	@PostMapping("/modifyitemBuy")
	public String modifyitemBuy(Item item) {
		System.out.println("장비구입 수정화면에서 입력 받은 값->"+ item);
		
		String result = itemService.modifyitemBuy(item);
		System.out.println(item.getItemBuyCode() + " : " + result);
			return "redirect:/itemBuyList";
	}
	
	@GetMapping("/modifyitemBuy")
	public String modifyitemBuy(@RequestParam(name="itemBuyCode", required = false) int itemBuyCode
								,Model model) {
		System.out.println("장비구입 수정화면에 입력받은 값 ->" + itemBuyCode);	
		
		Item item = itemService.getitemBuyCode(itemBuyCode);
			
		return "item/uItemBuy";
	}
	
	//장비구입내역
	@GetMapping("/itemBuyList")
	public String itemBuyList(Model model) {
		List<Item> itemBuyList = itemService.itemBuyList();
		System.out.println("장비구입내역");
		System.out.println(itemBuyList);
		model.addAttribute("itemBuyList", itemBuyList);
			
			return "item/itemBuyList";
	}
	
	
	//장비수리내역 삭제
	@PostMapping("/removeitemRepair")
	public String removeitemRepair(@RequestParam(name="itemRepairCode", required = false) int itemRepairCode
								  ,@RequestParam(name="userId", required = false) String userId
								  ,@RequestParam(name="userPw", required = false) String userPw) {
		System.out.println("장비수리내역 삭제화면에서 입력 받은 값->" + itemRepairCode);
		System.out.println("장비수리내역 삭제화면에서 입력 받은 값->" + userId);
		System.out.println("장비수리내역 삭제화면에서 입력 받은 값->" + userPw);
			
		String result = itemService.removeitemRepair(itemRepairCode, userId, userPw);
			System.out.println(itemRepairCode + " : " + result);
				
			return "redirect:/itemRepairList";
		}
		
		@GetMapping("/removeitemRepair")
		public String removeitemRepair(@RequestParam(name="itemRepairCode", required = false) int itemRepairCode
										,Model model) {
		System.out.println("장비수리내역 수정화면에 입력받은 값 ->" + itemRepairCode);
		
		Item item = itemService.getitemBuyCode(itemRepairCode);
		
		model.addAttribute("itemRepairCode", itemRepairCode);
		model.addAttribute("getStoreBuyCode", item.getStoreBuyCode());
			
		return "item/dItemRepair";
	}
	
	//장비수리내역 수정
	@PostMapping("/modifyitemRepair")
	public String modifyitemRepair(Item item) {
		System.out.println("장비수리내역 수정화면에서 입력 받은 값->"+ item);
			
		String result = itemService.modifyitemRepair(item);
		System.out.println(item.getItemRepairCode() + " : " + result);
			
		return "redirect:/itemRepairList";
		}
	
	@GetMapping("/modifyitemRepair")
	public String modifyitemRepair(@RequestParam(name="itemRepairCode", required = false) int itemRepairCode
								 ,Model model) {
		System.out.println("장비수리내역 수정화면에 입력받은 값 ->" + itemRepairCode);	
		
		Item item = itemService.getitemBuyCode(itemRepairCode);
			
		return "item/uItemRepair";
	}
	
	//장비수리내역
	@GetMapping("/itemRepairList")
	public String itemRepairList(Model model) {
		List<Item> itemRepairList = itemService.itemRepairList();
		
		model.addAttribute("title", "장비수리내역");
		System.out.println(itemRepairList);
		model.addAttribute("itemRepairList", itemRepairList);
				
		return "item/itemRepairList";
	}
	
	//장비파기내역 삭제
		@PostMapping("/removeitemDelete")
		public String removeitemDelete(@RequestParam(name="itemDeleteCode", required = false) int itemDeleteCode
				 					  ,@RequestParam(name="userId", required = false) String userId
				 					  ,@RequestParam(name="userPw", required = false) String userPw) {
			System.out.println("장비파기내역 삭제화면에서 입력 받은 값->" + itemDeleteCode);
			System.out.println("장비파기내역 삭제화면에서 입력 받은 값->" + userId);
			System.out.println("장비파기내역 삭제화면에서 입력 받은 값->" + userPw);
			
			String result = itemService.removeitemDelete(itemDeleteCode, userId, userPw);
			System.out.println(itemDeleteCode + " : " + result);
			
			return "redirect:/itemDeleteList";
		}
		
		@GetMapping("/removeitemDelete")
		public String removeitemDelete(@RequestParam(name="itemDeleteCode", required = false) int itemDeleteCode
					,Model model) {
		System.out.println("장비파기내역 수정화면에 입력받은 값 ->" + itemDeleteCode);
		
		Item item = itemService.getitemBuyCode(itemDeleteCode);
		
		model.addAttribute("itemDeleteCode", itemDeleteCode);
		model.addAttribute("getStoreBuyCode", item.getStoreBuyCode());
			
			return "item/dItemDelete";
	}

		//장비파기내역 수정
		@PostMapping("/modifyitemDelete")
		public String modifyitemDelete(Item item) {
			System.out.println("장비파기내역 수정화면에서 입력 받은 값->"+ item);
			
			String result = itemService.modifyitemDelete(item);
			System.out.println(item.getItemBuyCode() + " : " + result);
				return "redirect:/itemDeleteList";
		}
		
		@GetMapping("/modifyitemDelete")
		public String modifyitemDelete(@RequestParam(name="itemDeleteCode", required = false) int itemDeleteCode
									,Model model) {
			System.out.println("장비파기내역 수정화면에 입력받은 값 ->" + itemDeleteCode);	
			
			Item item = itemService.getitemBuyCode(itemDeleteCode);
				
			return "item/uItemDelete";
		}
		
		//장비파기내역
		@GetMapping("/itemDeleteList")
		public String itemDeleteList(Model model) {
			List<Item> itemDeleteList = itemService.itemDeleteList();
			System.out.println("장비파기내역");
			System.out.println(itemDeleteList);
			model.addAttribute("itemDeleteList", itemDeleteList);
				
				return "item/itemDeleteList";
		}
		
		//장비파기등록
		@PostMapping("/addItemDelte")
		public String addItemDelte(Model model, Item item) {
				System.out.println(item + "=========== 장비 넘어온 값 ============");
				String result = itemService.addItemDelte(item);
				item.getItemDetailCode();
				item.setItemDetailCode(item.getItemCode());
				System.out.println(result);
				
			return "redirect:/addItem";
		}
		
		@GetMapping("/addItemDelte")
		public String addItemDelte(Model model) {
			
			model.addAttribute("title", "장비 등록");
			
			return "item/itemDeleteForm";
		}
			
	
	//장비수량목록
	@GetMapping("/itemCountList")
	public String itemCountList(Model model) {
		
		List<Item> itemTotalLi = itemService.itemCountList();
		
		model.addAttribute("title", "장비 수량 목록");
		model.addAttribute("itemTotalLi", itemTotalLi);
		
		return "item/itemTotalAmount";
	}
	
	//장비목록
	@GetMapping("/itemList")
	public String itemList(Model model) {
		
		List<Item> itemLi = itemService.itemList();
		
		model.addAttribute("title", "장비 목록");
		model.addAttribute("itemLi", itemLi);
		
		return "item/itemDetail";
	}
	
	//장비등록
	@PostMapping("/addItem")
	public String addItem(Model model, Item item) {
			System.out.println(item + "=========== 장비 넘어온 값 ============");
			String result = itemService.addItem(item);
			item.getItemDetailCode();
			item.setItemDetailCode(item.getItemCode());
			System.out.println(result);
			
		return "redirect:/addItem";
	}
	
	@GetMapping("/itemInfo")
	public String itemInfo(Model model, Item item
							,@RequestParam(name = "storeItemCode", required = false) int storeItemCode) {
		
			model.addAttribute("title", "장비 상세 정보");
			model.addAttribute("item", item);
			
		return "item/itemInfo";
	}
	
	@GetMapping("/addItem")
	public String addItem(Model model) {
		
		model.addAttribute("title", "장비 등록");
		
		return "item/itemBuyForm";
	}
	
}
