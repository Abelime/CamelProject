package com.web.humor.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.humor.info.CpuVO;
import com.web.humor.info.GpuVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class mainCtr {
	@Autowired
	private mainSvc mainSvc;

	// 메인 화면
	@RequestMapping(value = "/main")
	public String MainListGroup(HttpServletRequest req, ModelMap modelMap) throws IOException {
		
		//크롤링
		String url = "https://quasarzone.com";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select(".right-box dd a");
		List<CrawilingVO> cv = new ArrayList<>();

		for (Element element : elements) {
			String title = element.text();
			String urls = url+element.attr("href");
			CrawilingVO vo = new CrawilingVO(title, urls);
			cv.add(vo);
		}

		List<mainVO> count = mainSvc.getBoardCount(); // 게시판
		List<mainVO> info_count = mainSvc.getInfoCount(); // 부품정보
 
		/* 메인화면 게시판 글 */
		for (int i = 0; i < count.size(); i++) {
			List<mainVO> list = mainSvc.getMainList(count.get(i).getBoardid());
			modelMap.addAttribute("board" + count.get(i).getBoardid(), list); //게시판 목록
		}  
		
		/* 메인화면 부품 정보 */
		for (int i = 0; i < 2; i++) {
			List<CpuVO> info = mainSvc.getInfoList(info_count.get(i).getInfoid());
			modelMap.addAttribute("info" + info_count.get(i).getInfoid(), info); //cpu info
		}
		/* 메인화면 부품 정보 */
		List<GpuVO> g_info=mainSvc.getGpuInfo();
		
		modelMap.addAttribute("GpuList", g_info); //gpu info
		modelMap.addAttribute("info_count", info_count); 
		modelMap.addAttribute("list", cv); //크롤링 게시판
		modelMap.addAttribute("count", count); 
		modelMap.addAttribute("select", 1);

		return "main/main";
	}
}