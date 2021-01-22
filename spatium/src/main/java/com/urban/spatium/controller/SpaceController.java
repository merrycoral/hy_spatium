package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;
import com.urban.spatium.dto.Store;
import com.urban.spatium.service.SpaceService;

@Controller
public class SpaceController {
	
	@Autowired
	private SpaceService spaceService;
	
	/* 공간 승인 대기 목록에서 승인 버튼을 클릭 후 승인까지 완벽히 되었을시 들어오는 컨트롤러*/
	@PostMapping("/space/admin/spaceListOK")
	public String spaceAccept (Model model, HttpSession session, ReadySpace readySpace
							,@RequestParam(name = "readySpace", required = false) String readySpaceCode
							,@RequestParam(name = "spaceChk", required = false) String spaceChk) {
			
				System.out.println(readySpaceCode);
				System.out.println(spaceChk);
				String idChk = (String) session.getAttribute("SID");
				readySpace.setreadySpaceId(idChk);
				String readySpaceId = readySpace.getreadySpaceId();
				System.out.println(readySpaceId);
				if(spaceChk.equals("승인")) {
					spaceService.OKSpaceInsert(readySpaceId, readySpaceCode);
					spaceService.readySpaceDelete(readySpaceCode);
				}else if(spaceChk.equals("미승인")) {
					spaceService.readySpaceDelete(readySpaceCode);
				}
		
		return "redirect:/space/admin/spaceListOK";
	}
	
	/* 공간 승인 대기 목록에서 승인 버튼을 클릭할시 들어오는 컨트롤러 */
	@GetMapping("/space/admin/readySpaceAccept")
	public String readySpaceAccept (Model model, ReadySpace readySpaceDto
									,@RequestParam(name = "readySpace", required = false)int readySpaceCode) {
		
		List<ReadySpace> rsl = spaceService.readySpaceAccept(readySpaceCode);
		
		System.out.println(readySpaceCode);
		System.out.println(rsl + "11111111 rsl 부분");
		model.addAttribute("title", "공간 승인 화면");
		model.addAttribute("rsl", rsl);
		
		return "space/admin/readySpaceAccept";
	}
	
	/* 공간 등록 폼에서 포스트 맵핑으로 들어오는 컨트롤러
	 * (공간 등록 이후 바로 공간 승인 대기 리스트로 가게 됩니다.) */
	@PostMapping("/space/admin/spaceListReady")
	public String addSpace(Model model, ReadySpace readySpace, String readyStoreBusinessType
								,@RequestParam(name = "readyStoreCode", required = false) String readyStoreCode) {
			System.out.println(readySpace);
			System.out.println(readyStoreCode + " readyStoreCode");
			String ReadyStore = spaceService.addReadySpace(readySpace, readyStoreCode);
			System.out.println(ReadyStore);
			
		return "redirect:/space/admin/spaceListReady";
	}
	
	/* 공간 등록 클릭 후 등록 하고자 하는 공간을 클릭시 들어오는 컨트톨러 */
	@GetMapping("/space/seller/addSpace")
	public String addSpace(Model model, HttpSession session, Store store, String storeCode) {
		System.out.println(storeCode + "spacecontroller에서 받은 스토어 코드 값");
		model.addAttribute("title", "공간 등록");
		String storeId = (String) session.getAttribute("SID");
		store.setStoreId(storeId);
		String okId = store.getStoreId();
		System.out.println(okId + "스페이스 컨트롤러에서 받은 okId");
		String spaceCateList = spaceService.addSpace(storeCode);
		System.out.println(spaceCateList);
		String[] array = spaceCateList.split(",");
		model.addAttribute("storeBusiness", array);
		model.addAttribute("storeCode", storeCode);
		
		return "space/seller/addSpace";
	}
	
	/* 왼쪽 메뉴에서 공간 등록 클릭시 들어오는 컨트롤러 */
	@GetMapping("/space/seller/addSpaceChoice")
	public String addSpaceChoice(Model model, HttpSession session, Store store) {
		model.addAttribute("title", "공간 등록");
		String storeId = (String) session.getAttribute("SID");
		store.setStoreId(storeId);
		List<Store> spaceChoice = spaceService.addSpaceChoice(storeId);
		model.addAttribute("spaceChoice", spaceChoice);
		
		return "space/seller/addSpaceChoice";
	}
	
	/* 왼쪽 메뉴에서 공간 승인 대기 클릭시 들어오는 컨트롤러 */
	@GetMapping("/space/admin/spaceListReady")
	public String readySpaceList(Model model) {
		List<ReadySpace> readySpaceList = spaceService.readySpaceList();
			model.addAttribute("title", "공간 승인 대기 리스트");
			model.addAttribute("readySpaceList", readySpaceList);
		return "space/admin/readySpaceList";
	}
	
	/* 왼쪽 메뉴에서 공간 승인 완료 클릭시 들어오는 컨트롤러 */
	@GetMapping("/space/admin/spaceListOK")
	public String OKSpaceList(Model model) {
		List<OKSpace> spaceListO = spaceService.OKSpaceList();
			model.addAttribute("title", "공간 승인 완료 리스트");
			model.addAttribute("spaceListO", spaceListO);
		return "space/admin/OKSpaceList";
	}
}