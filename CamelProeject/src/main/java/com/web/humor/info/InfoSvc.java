package com.web.humor.info;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoSvc {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<CpuVO> getCpuInfo() {
		
		return sqlSession.selectList("CpuList");
	}

	public List<GpuVO> getGpuInfo() {
		return sqlSession.selectList("GpuList");
	}
}
