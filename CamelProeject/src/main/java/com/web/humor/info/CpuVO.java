package com.web.humor.info;

import lombok.Data;

@Data
public class CpuVO {
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
}
