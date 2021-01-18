package com.urban.spatium.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.Review;
import com.urban.spatium.dto.Store;
import com.urban.spatium.service.ItemService;
import com.urban.spatium.service.ReviewService;
import com.urban.spatium.service.SpaceService;
import com.urban.spatium.service.StoreService;


@Controller
public class MainController {
	@Autowired 
	private StoreService storeService;
	@Autowired 
	private SpaceService spaceService;
	@Autowired 
	private ItemService itemService;
	@Autowired 
	private ReviewService reviewService;
	
	@PostMapping("/searchAll")
	public String mainSearchAll(Model model, Store store
								,@RequestParam(name = "searchName", required = false) String searchName) {
			
		System.out.println(searchName);
		List<Store> searchAll = storeService.mainSearchAll(searchName);
		model.addAttribute("searchAll", searchAll);
		model.addAttribute("searchName", searchName);
		return "indexSearch";
	}
	
	@GetMapping("/mainSpaceOrder")
	public String mainSpaceOrder() {
		return "promotion/mainSpaceOrder";
	}
	
	//추천 공간 선정
	@GetMapping("/bestSpaceOrder")
	public String bestSpaceOrder(Model model) {
		List<Store> storeList = storeService.storeList();
		model.addAttribute("title", "추천 공간 선정");
		model.addAttribute("storeList", storeList);
		return "promotion/bestSpaceOrder";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "main";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Store> storeList = storeService.storeList();
		model.addAttribute("storeList", storeList);
		return "index";
	}
	
	@GetMapping("/")
	public String mainPage(Model model) {
		
		model.addAttribute("title", "37기 포트폴리오");
		return "mainPage";
	}
	
	@GetMapping("/storeInfo")
	public String storeInfo(Model model, int storeCode) {
		Store storeInfo = storeService.getStoreInfoByStoreCode(storeCode);
		List<OKSpace> spaceList = spaceService.OKSpaceListByStoreCode(storeCode);
		List<Item> itemCountListByStoreCode = itemService.itemCountListByStoreCode(storeCode);
		List<Map<String,Object>> refundRule = storeService.getRefundRuleByStoreCode(storeCode); 
		List<Review> reviewList = reviewService.getReviewByStoreCode(storeCode);
		model.addAttribute("title", "업체 정보");
		model.addAttribute("storeInfo", storeInfo);
		model.addAttribute("itemCountListByStoreCode", itemCountListByStoreCode);
		model.addAttribute("spaceList", spaceList);
		model.addAttribute("refundRule", refundRule);
		model.addAttribute("reviewList", reviewList);
		return "store/storeInfo";
	}
	
	@CrossOrigin("https://naveropenapi.apigw.ntruss.com")
	@ResponseBody
	@RequestMapping(value = "/adressAjax",produces = "application/json",method = RequestMethod.POST ) 
	public Map<String, Object> adressAjax(@RequestParam(name="address", required = false) String address, HttpSession session) {
		System.out.println("-----");
		System.out.println(address);
		System.out.println("-----");
		try {
			String addr = URLEncoder.encode(address,"utf-8");
			URL url = new URL("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "rt37xgq4ur"); //key값 설정
			con.setRequestProperty("X-NCP-APIGW-API-KEY","5BkSP6GpdD80nNBz2kABLUPwgoLZzPjYGWHKqRh9"); //key값 설정
			con.setRequestMethod("GET");
//URLConnection에 대한 doOutput 필드값을 지정된 값으로 설정한다. URL 연결은 입출력에 사용될 수 있다. URL 연결을 출력용으로 사용하려는 경우 DoOutput 플래그를 true로 설정하고, 그렇지 않은 경우는 false로 설정해야 한다. 기본값은 false이다.
                       con.setDoOutput(false); 

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//Stream을 처리해줘야 하는 귀찮음이 있음. 
				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println("" + sb.toString());
				JSONParser json = new JSONParser(sb.toString()); 
				LinkedHashMap<String, Object> map = json.parseObject();
				String geoCode = map.get("addresses").toString();
				System.out.println("x인덱스 : "+geoCode.indexOf("x="));
				System.out.println("y인덱스 : "+geoCode.indexOf("y="));
				System.out.println("geoCode --> "+geoCode);
				String xCode = geoCode.substring(geoCode.indexOf("x=")+2, geoCode.indexOf("y=")-2);
				String yCode = geoCode.substring(geoCode.indexOf("y=")+2, geoCode.indexOf("distance=")-2);
				System.out.println("x좌표 --> "+xCode);
				System.out.println("y좌표 --> "+yCode);
				
				Map<String, Object> addrCode = new HashMap<String, Object>();
				addrCode.put("xCode", xCode);
				addrCode.put("yCode", yCode);
				
				return addrCode;
			} else {
				System.out.println(con.getResponseMessage());
				return null;
			}

		} catch (Exception e) {
			System.err.println(e.toString());
			return null;
		}

		
	}
	
}
