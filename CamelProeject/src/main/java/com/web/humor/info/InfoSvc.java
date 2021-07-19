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

	public List<CpuVO> getCpuInfo(SearchVO sv) {
		if (sv.getF() == null || sv.getF() == "") {
			sv.setF("name");
		}
		if (sv.getP() == 0) {
			sv.setP(0);
		} else {
			sv.setP((sv.getP() - 1) * 10);
		}
		if (sv.getQ() == null) {
			sv.setQ("");
		}

		return sqlSession.selectList("CpuList", sv);
	}

	public List<GpuVO> getGpuInfo(SearchVO sv) {
		if (sv.getF() == null || sv.getF() == "") {
			sv.setF("name");
		}
		if (sv.getP() == 0) {
			sv.setP(0);
		} else {
			sv.setP((sv.getP() - 1) * 10);
		}
		if (sv.getQ() == null) {
			sv.setQ("");
		}
		return sqlSession.selectList("GpuList", sv);
	}
}
