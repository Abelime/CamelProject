package com.web.humor.info;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.humor.content.SearchVO;

@Service
public class InfoSvc {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<CpuVO> getCpuInfo(CpuVO cv) {
		if (cv.getF() == null || cv.getF() == "") {
			cv.setF("name");
		}
		if (cv.getP() == 0) {
			cv.setP(0);
		} else {
			cv.setP((cv.getP() - 1) * 10);
		}
		if (cv.getQ() == null) {
			cv.setQ("");
		}

		return sqlSession.selectList("CpuList", cv);
	}

	public List<GpuVO> getGpuInfo(GpuVO gv) {
		if (gv.getF() == null || gv.getF() == "") {
			gv.setF("name");
		}
		if (gv.getP() == 0) {
			gv.setP(0);
		} else {
			gv.setP((gv.getP() - 1) * 10);
		}
		if (gv.getQ() == null) {
			gv.setQ("");
		}
		return sqlSession.selectList("GpuList", gv);
	}
}
