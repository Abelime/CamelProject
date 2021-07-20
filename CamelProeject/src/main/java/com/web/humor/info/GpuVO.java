package com.web.humor.info;

import com.web.humor.content.SearchVO;

import lombok.Data;

@Data
public class GpuVO extends SearchVO {
	String name;
	String value;
	String manufacture;
	String clock;
	String stream;
	String ram;
	int infoid;
	int count;
}
