package com.exc.util;

import com.alibaba.fastjson.JSON;

public class JsonUtils {

	/**
	 * 对象转json对象
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object){
		return JSON.toJSONString(object);
	}
	
	/**
	 * json转对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clazz){
		return JSON.parseObject(json, clazz);
	}
}
