package com.xleon.demo.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class FirstJacksonDemo {
	public static void main(String[] args) {
		
		//创建测试实体对象，并封装到List中
		com.xleon.demo.ajax.EntityDemo ed1 = new EntityDemo();
		com.xleon.demo.ajax.EntityDemo ed2 = new EntityDemo();
		ed1.setId(1);
		ed1.setName("xleon");
		ed1.setSex("F");
		ed1.setFlag(1);
		ed1.setBirthDate(new Date());
		
		ed2.setId(2);
		ed2.setName("jace");
		ed2.setSex("M");
		ed2.setFlag(0);
		ed2.setBirthDate(new Date());
		
		List<EntityDemo> list = new ArrayList<EntityDemo>();
		list.add(ed1);
		list.add(ed2);
		
		//创建ObjectMapper对象
		ObjectMapper om = new ObjectMapper();
		try {
			//创建Json读写对象并设置编码为UTF8，输出为标准控制台输出
			JsonGenerator jg = om.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
			jg.writeObject(list);
			
//	        System.out.println();
//	        System.out.println("ObjectMapper");
//	        //用objectMapper直接返回list转换成的JSON字符串
//	        System.out.println("1###" + om.writeValueAsString(list));
//	        System.out.print("2###");
//	        //objectMapper list转换成JSON字符串
//	        om.writeValue(System.out, list);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
