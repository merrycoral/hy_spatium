package com.urban.spatium.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.urban.spatium.dto.Item;

import com.urban.spatium.dto.Store;
import com.urban.spatium.service.ItemService;


@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;



	//장비구입내역삭제
	 @GetMapping("/removeitemBuy") 
	 public String removeitemBuy(@RequestParam(name="itemBuyCode", required = false) String
	 itemBuyCode ,Model model) {
	 System.out.println("장비구입 삭제화면에 입력받은 값 ->" + itemBuyCode);
	 itemService.removeitemBuy(itemBuyCode);
	 model.addAttribute("itemBuyCode", itemBuyCode);
	 	  
	 return "redirect:/itemBuyList";
	  }
	 
	//장비구입내역 수정
	@PostMapping("/modifyitemBuy")
	public String modifyitemBuy(Item item) {
		System.out.println("장비구입 수정화면에서 입력 받은 값->"+ item);
		itemService.modifyitemBuy(item);
		return "redirect:/itemBuyList";
	}

	  @GetMapping("/modifyitemBuy") 
	  public String modifyitemBuy(@RequestParam(name="itemBuyCode", required = false) String itemBuyCode, Model model) { 
		  System.out.println("장비구입 수정화면에 입력받은 값 ->" +  itemBuyCode);
		  Item item = itemService.itemListByCode(itemBuyCode);
		  model.addAttribute("item", item);
	  
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

	//장비구입등록
	@PostMapping("/addItemBuy") 
	public String addItemBuy(Model model, Item  item, HttpSession session,
			@RequestParam(name = "userBuyId", required = false) String userBuyId) {
		System.out.println(item +	  "=========== 장비 넘어온 값 ============"); 
		String sessionId = (String) session.getAttribute("SID");
		System.out.println(userBuyId );

		System.out.println(sessionId); item.setItemDetailUserId(sessionId);

		String result = itemService.addItemBuy(item); 
		System.out.println(result);

		return "redirect:/itemBuyList"; 
	}

	@GetMapping("/addItemBuy") 
	public String addItemBuy(Model model) {
		model.addAttribute("title", "장비수리 등록 하기"); 
		return "item/itemBuyForm2"; 
	}

	//장비수리내역 삭제
	@GetMapping("/removeitemRepair") 
	 public String removeitemRepair(@RequestParam(name="itemRepairCode", required = false) String itemRepairCode ,Model model) {
		 System.out.println("장비구입 수정화면에 입력받은 값 ->" + itemRepairCode);
	 itemService.removeitemRepair(itemRepairCode);
	 model.addAttribute("itemRepairCode", itemRepairCode);
	 	  
	 return "redirect:/itemRepairList";
	  }

	//장비수리내역 수정
	@PostMapping("/modifyitemRepair")
	public String modifyitemRepair(Item item) {
		System.out.println("장비구입 수정화면에서 입력 받은 값->"+ item);
		itemService.modifyitemRepair(item);
		return "redirect:/itemRepairList";
	}

	@GetMapping("/modifyitemRepair") 
	public String modifyitemRepair(@RequestParam(name="itemRepairCode", required = false) String itemRepairCode, Model model) { 
	  System.out.println("장비구입 수정화면에 입력받은 값 ->" +  itemRepairCode);
	  Item item = itemService.itemListByCode(itemRepairCode);
	  model.addAttribute("item", item);
	  
	  return "item/uitemRepair"; 
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

	//장비수리등록
	@PostMapping("/addItemRepair") public String addItemRepair(Model model, Item  item, HttpSession session,
			@RequestParam(name = "userRepairId", required = false) String userId) {
		System.out.println(item +	  "=========== 장비 넘어온 값 ============"); 
		String sessionId = (String) session.getAttribute("SID");
		System.out.println(userId );

		System.out.println(sessionId); item.setItemDetailUserId(sessionId);

		String result = itemService.addItemRepair(item); 
		System.out.println(result);

		return "redirect:/itemRepairList"; 
	}

	@GetMapping("/addItemRepair") public String addItemRepair(Model model) {
		model.addAttribute("title", "장비수리 등록 하기"); 
		return "item/itemRepairForm"; 
	}

	//장비파기내역 삭제
	@GetMapping("/removeitemDelete") 
	 public String removeitemDelete(@RequestParam(name="storeDeleteCode", required = false) String storeDeleteCode ,Model model) {
		 System.out.println("장비파기 수정화면에 입력받은 값 ->" + storeDeleteCode);
		 itemService.removeitemDelete(storeDeleteCode);
		 model.addAttribute("storeDeleteCode", storeDeleteCode);
		 return "redirect:/itemDeleteList";
	  }
	
	//장비파기내역 수정
	@PostMapping("/modifyitemDelete")
	public String modifyitemDelete(Item item) {
		System.out.println("장비구입 수정화면에서 입력 받은 값->"+ item);
		itemService.modifyitemDelete(item);
		return "redirect:/itemRepairList";
	}

	@GetMapping("/modifyitemDelete") 
	public String modifyitemDelete(@RequestParam(name="storeDeleteCode", required = false) String storeDeleteCode, Model model) { 
	  System.out.println("장비구입 수정화면에 입력받은 값 ->" +  storeDeleteCode);
	  Item item = itemService.itemListByCode(storeDeleteCode);
	  model.addAttribute("item", item);
	  
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
	@PostMapping("/addItemDelete") public String addItemDelete(Model model, Item  item, HttpSession session,
			@RequestParam(name = "userDeleteId", required = false) String userDeleteId) {
		System.out.println(item +	  "=========== 장비 넘어온 값 ============"); 
		String sessionId = (String) session.getAttribute("SID");
		System.out.println(userDeleteId );

		System.out.println(sessionId); item.setItemDetailUserId(sessionId);

		String result = itemService.addItemDelete(item); 
		System.out.println(result);

		return "redirect:/itemDeleteList"; 

	}

	@GetMapping("/addItemDelete") public String addItemDelte(Model model) {
		model.addAttribute("title", "장비 등록 하기"); 
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
	public String addItem(Model model, Item item, HttpSession session, Store store
							,@RequestParam(name = "code", required = false) int code) {
		System.out.println(item + "=========== 장비 넘어온 값 ============");
		String sessionId = (String) session.getAttribute("SID");
		System.out.println(sessionId);
		item.setItemDetailUserId(sessionId);
		System.out.println(code + "포스트 맵핑 장비등록 스토어코드");
		item.setStoreDetailCode(code);
		String result = itemService.addItem(item);
		
		System.out.println(result);

		return "redirect:/itemList";
	}

	@GetMapping("/addItem")
	public String addItem(Model model, Item item
			,@RequestParam(name = "storeCode", required = false) int storeCode) {

		System.out.println(storeCode);
		item.setStoreDetailCode(storeCode);
		int code = item.getStoreDetailCode();
		System.out.println(code);
		model.addAttribute("code", code);

		model.addAttribute("title", "장비 등록 하기");

		return "item/itemBuyForm";
	}

	@GetMapping("/itemInfo")
	public String itemInfo(Model model, Item item
			,@RequestParam(name = "storeItemCode", required = false) int storeItemCode) {

		model.addAttribute("title", "장비 상세 정보");
		model.addAttribute("item", item);

		return "item/itemInfo";
	}

	@GetMapping("/addItemChoice")
	public String addItemChoice(Model model, HttpSession session) {

		String storeId = (String) session.getAttribute("SID");

		List<Store> itemList = itemService.addItemChoice(storeId);

		model.addAttribute("title", "장비 등록");
		model.addAttribute("itemList", itemList);

		return "item/itemBuyChoice";
	}

}
