package com.web.humor.info;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoCtr {
	@Autowired
	private InfoSvc InfoSvc;
	
	@RequestMapping(value = "/cpu/list")
	public String getCpuList(HttpServletRequest req, ModelMap modelMap) {
		List<CpuVO> list =InfoSvc.getCpuInfo();
		System.out.println(list.get(0).getInfoid());
		modelMap.addAttribute("list" , list);
		return "info/Cpu";
	}
	
	
	@RequestMapping(value = "/gpu/list")
	public String getGpuList(HttpServletRequest req, ModelMap modelMap) {
		List<GpuVO> list =InfoSvc.getGpuInfo();
		modelMap.addAttribute("list" , list);
		return "info/Gpu";
	}
	
}
 