package com.hukuuu;

import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


public class ValueProducer {
	
	private ResourceBundle bundle = ResourceBundle.getBundle("config");

	@Produces
	@Value
	public String getValue(InjectionPoint ip) {
		Value annotation = ip.getAnnotated().getAnnotation(Value.class);
		String key = annotation.key();
		return bundle.getString(key);
	}
	
	@Produces
	@Value
	public Integer getValueInteger(InjectionPoint ip) {
		return Integer.valueOf(getValue(ip));
	}
	
	@Produces
	@Value
	public Double getValueDouble(InjectionPoint ip) {
		return Double.valueOf(getValue(ip));
	}
	
	@Produces
	@Value
	public Boolean getValueBoolean(InjectionPoint ip) {
		return Boolean.parseBoolean(getValue(ip));
	}
}
