package com.urban.spatium.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Access;
import com.urban.spatium.dto.Browser4;
import com.urban.spatium.service.AccessService;
import com.urban.spatium.service.StatisticService;

@Controller("statistic")
public class StatisticController {
	
	@Autowired
	private AccessService accessService;
	@Autowired
	private StatisticService statisticService;
	
	@GetMapping("/statistic/seller/buyStat")
	public String buyStat(Model model, HttpSession session,
			 @RequestParam(name="result", required = false) String result) {
		String SID = (String) session.getAttribute("SID");
		Map<String, Object> resultMap = statisticService.statGenderJob(SID);
		List<Map <String, Object>> latest7days = statisticService.getDailyRsv(SID);
		model.addAttribute("latest7days", latest7days);
		model.addAttribute("title", SID + "님의 판매 통계");
		model.addAttribute("getByAge", resultMap.get("getByAge"));
		model.addAttribute("getByJob", resultMap.get("getByJob"));
		model.addAttribute("getByGender", resultMap.get("getByGender"));
		model.addAttribute("storeInfo", resultMap.get("storeInfo"));
		return "statistic/seller/buyStatistic";
	}
	
	@GetMapping("/statistic/seller/chartEx")
	public String chartEx(Model model,  HttpSession session,
			@RequestParam(name="result", required = false) String result) {
		String SID = (String) session.getAttribute("SID");
		Map<String, Object> resultMap = statisticService.statGenderJob(SID);
		List<Map <String, Object>> latest7days = statisticService.getDailyRsv(SID);
		model.addAttribute("latest7days", latest7days);
		model.addAttribute("title", SID + "님의 판매 통계");
		model.addAttribute("getByAge", resultMap.get("getByAge"));
		model.addAttribute("getByJob", resultMap.get("getByJob"));
		model.addAttribute("getByGender", resultMap.get("getByGender"));
		model.addAttribute("storeInfo", resultMap.get("storeInfo"));
		return "statistic/seller/chartEx";
	}

	@GetMapping("/statistic/admin/accessStat")
	public String statisticEx(Model model, @RequestParam(name="result", required = false) String result) {
		List<Access> accessList = accessService.getAccessRecord();
		int accessCount = accessService.getAccessCount();
		List<Browser4> browser4 = accessService.getBrowserTop4();
		int lsize = browser4.size();
		String[] btopname = new String[5];
		int[] btopcount = new int[5];
		String[] brate = new String[5];
		//System.out.println(accessCount[0]); //전체 숫자
		
		double betcrate = 100.0;
		for(int i=0;i < 4;i++) {
			btopname[i] = browser4.get(i).getBrowserName();
			model.addAttribute("btopname" + i, btopname[i]);

			btopcount[i] = browser4.get(i).getBrowserCount();
			//model.addAttribute("btopcount" + i, btopcount[i]);
			double rate = (double) 100*btopcount[i] / accessCount;
			betcrate -=rate;
			brate[i] = String.format("%.1f" , rate);
			System.out.println(rate);
			System.out.println(brate[i]);
			model.addAttribute("btopcount" + i, btopcount[i]);
			model.addAttribute("btoprate" + i, brate[i]);
		}
		brate[4] = String.format("%.1f" , betcrate);
		btopname[4] = browser4.get(4).getBrowserName();
		btopcount[4] = browser4.get(4).getBrowserCount();
		model.addAttribute("btopname4", btopname[4]);
		model.addAttribute("btoprate4", brate[4]);
		model.addAttribute("btopcount4", btopcount[4]);
		
		//model.addAttribute("btopname1", btopname[1]);
		model.addAttribute("title", "접속 목록");
		model.addAttribute("accessList", accessList);
		model.addAttribute("browser4", browser4);
		model.addAttribute("accessTotalCount", accessCount);
		//model.addAttribute("accessOtherCount", accessCount[1]);
		if(result != null) model.addAttribute("result", result);
		
		int max = brate.length;
		
		return "statistic/admin/statisticEx";
	}
	//name=result 일치하는 값을 가져오겠다.
	//false일 시 필수X, String result에 null로 들어간다. false시 : localhost/memberList true시 : localhost/memberList?result=123
}
