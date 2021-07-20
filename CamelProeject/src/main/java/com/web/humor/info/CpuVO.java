package com.web.humor.info;

import com.web.humor.content.SearchVO;

import lombok.Data;

@Data
public class CpuVO extends SearchVO {
	String name;
	String socket;
	String manufacture;
	String core;
	String thread;
	String baseclock;
	String boosterclock;
	String cache;
	String tdp;
	String infoname;
	int count;
	int infoid;
	String cpu_id;
}
