package com.xleon.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.xleon.demo.log4jdemo.Demo_01;


//junit demo
public class TestDemo_01 {
	@Test
	public void testAdd() {
		com.xleon.demo.log4jdemo.Demo_01 demo01 = new Demo_01();
		assertTrue(demo01.add(2, 3)==5);
	}
}
