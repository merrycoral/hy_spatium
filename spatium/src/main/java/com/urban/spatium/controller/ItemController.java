package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.urban.spatium.dto.User;
import com.urban.spatium.service.UserService;

@Controller
public class ItemController {

	@Autowired
	private UserService userService;

	/*
	 * ============= //장비구입리스트
	 * 
	 * @PostMapping("/userList") public String userList(@RequestParam(name = "sk",
	 * required = false)String searchKey ,@RequestParam(name = "sv", required =
	 * false)String searchValue ,Model model) {
	 * log.info("화면에서 전달받은 파라미터값 sk :::::::  {}",searchKey);
	 * log.info("화면에서 전달받은 파라미터값 sv :::::::  {}",searchValue);
	 * if("아이디".equals(searchKey)) { searchKey="u_id"; }else
	 * if("권한".equals(searchKey)) { searchKey="u_level";
	 * }if("관리자".equals(searchValue)) { searchValue="1"; }else
	 * if("판매자".equals(searchValue)) { searchValue="2"; }else
	 * if("구매자".equals(searchValue)) { searchValue="3"; }else
	 * if("휴면회원".equals(searchValue)) { searchValue="4"; }else
	 * if("탈퇴회원".equals(searchValue)) { searchValue="5"; }else
	 * if("불량회원".equals(searchValue)) { searchValue="6";
	 * 
	 * }else if("이메일".equals(searchKey)) { searchKey="u_email"; }
	 * 
	 * 
	 * log.info("변경한 파라미터값 sv :::::::  {}",searchKey);
	 * log.info("변경한 파라미터값 sk :::::::  {}",searchValue);
	 * 
	 * 
	 * model.addAttribute("title", "회원 목록"); List<User> userList =
	 * userService.getSearchUserList(searchKey,searchValue);
	 * 
	 * return "user/uList"; }
	 * 
	 * @GetMapping("/userList") public String getUserList(Model
	 * model, @RequestParam(name="result", required = false) String result) {
	 * List<User> UserList = userService.getUserList();
	 * System.out.println(UserList); model.addAttribute("title", "회원 목록");
	 * model.addAttribute("userList", UserList); if(result != null)
	 * model.addAttribute("result", result);
	 * 
	 * return "user/uList"; } ===========
	 */

	// 장비구입
	/*
	 * @RequestMapping(value = "/addItem", method = RequestMethod.POST) public
	 * String addItem(Item item, @RequestParam(name = "itemBuy", required = false)
	 * String itemBuy) { System.out.println("장비구입화면에서 입력받은 값--->" + item); String
	 * result = userService.addItem(item); System.out.println(result); return
	 * "redirect:/myinfo"; }
	 */
	@GetMapping("/addItem")
	public String addUser(Model model) {
		return "item/buy";
	}

}
