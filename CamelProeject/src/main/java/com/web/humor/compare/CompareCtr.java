package com.web.humor.compare;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.humor.info.CpuVO;
import com.web.humor.info.GpuVO;

@Controller
public class CompareCtr {
	@Autowired
	CompareSvc CompareSvc;
	
	@RequestMapping(value = "/cpu/compare")
	public String getCpuList(HttpServletRequest req,  ModelMap modelMap) {
		int compare1;
		int compare2;
		CpuVO vo1;
		CpuVO vo2;
		if(req.getParameter("compare1")!=null && req.getParameter("compare2")!=null) {
			compare1=Integer.parseInt(req.getParameter("compare1"));
			compare2=Integer.parseInt(req.getParameter("compare2"));
			vo1=CompareSvc.getInfoCpu(compare1);
			vo2=CompareSvc.getInfoCpu(compare2);
			modelMap.addAttribute("compare1" ,vo1);
			modelMap.addAttribute("compare2" ,vo2);
		}
	
		
		List<CpuVO> list =CompareSvc.getCpuList();
		modelMap.addAttribute("list" ,list);
		return "Performance/cpu_compare";
	}
	
	@RequestMapping(value = "/gpu/compare")
	public String getGpuList(HttpServletRequest req,  ModelMap modelMap) {
		int compare1;
		int compare2;
		GpuVO vo1;
		GpuVO vo2;
		if(req.getParameter("compare1")!=null && req.getParameter("compare2")!=null) {
			compare1=Integer.parseInt(req.getParameter("compare1"));
			compare2=Integer.parseInt(req.getParameter("compare2"));
			vo1=CompareSvc.getInfoGpu(compare1);
			vo2=CompareSvc.getInfoGpu(compare2);
			modelMap.addAttribute("compare1" ,vo1);
			modelMap.addAttribute("compare2" ,vo2);
		}
		
		List<GpuVO> list =CompareSvc.getGpuList();
		modelMap.addAttribute("list" ,list);
		return "Performance/gpu_compare";
	}
	
}
