package com.web.humor.compare;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.humor.info.CpuVO;
import com.web.humor.info.GpuVO;

@Service
public class CompareSvc {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<CpuVO> getCpuList() {
		return sqlSession.selectList("getCpuList");
	}
	public List<GpuVO> getGpuList() {
		return sqlSession.selectList("getGpuList");
	}
	
	public CpuVO getInfoCpu(int compare) {
		return sqlSession.selectOne("getCpuInfo", compare);
	}

	public GpuVO getInfoGpu(int compare) {
		return sqlSession.selectOne("GpuCompare", compare);
	}


}
