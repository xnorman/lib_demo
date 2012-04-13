package com.xleon.demo.log4jdemo;

import org.apache.log4j.*;

public class Demo_01 {
	private static Logger log = org.apache.log4j.Logger.getLogger(Demo_01.class.getName());

	public static void main(String[] args) {
		System.out.println("hello java world!\n");
		log.debug("这里是debug信息");
		log.info("这里是info信息");
		log.warn("这里是warnning信息");
		log.error("这里是error信息");
		log.fatal("这里是fatal信息");
	}

	public int add(int a, int b) {
		log.debug("测试add方法");
		return a + b;
	}

}
