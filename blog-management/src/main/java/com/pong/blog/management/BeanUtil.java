package com.pong.blog.management;

import java.beans.PropertyDescriptor;
import java.util.Map;

import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtil {

	public static Map<String, Object> beanToMap(final Object object) {
		@SuppressWarnings("unchecked")
		Map<String, Object> result = new MultiValueMap();
		BeanWrapper beanWrapper = new BeanWrapperImpl(object);
		PropertyDescriptor[] descriptor = beanWrapper.getPropertyDescriptors();
		for (int i = 0; i < descriptor.length; i++) {
			String name = descriptor[i].getName();
			if (name != "class") {
				result.put(name, beanWrapper.getPropertyValue(name));
			}
		}

		return result;
	}

}
