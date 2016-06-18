package com.exc.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exc.sys.service.SysPageBS;
import com.exc.test.service.TestBS;

@Service("testBS")
public class TestBSImpl implements TestBS {

	@Autowired
	private SysPageBS sysPageBS;
	@Override
	public String test() {
		sysPageBS.getOne(1L);
		// TODO Auto-generated method stub
		return "test";
	}


}
