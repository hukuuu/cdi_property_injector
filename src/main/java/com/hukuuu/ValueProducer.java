package com.hukuuu;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class ValueProducer {
	
	private Map<String, ResourceBundle> bundles;
	
	@PostConstruct
	public void init() {
		bundles = new HashMap<String, ResourceBundle>();
	}
	
	@Produces
	@Value
	public String getValueString(InjectionPoint ip) {
		return get(ip);
	}
	
	@Produces
	@Value
	public Integer getValueInteger(InjectionPoint ip) {
		return Integer.valueOf(get(ip));
	}
	
	@Produces
	@Value
	public Double getValueDouble(InjectionPoint ip) {
		return Double.valueOf(get(ip));
	}
	
	@Produces
	@Value
	public Boolean getValueBoolean(InjectionPoint ip) {
		return Boolean.parseBoolean(get(ip));
	}

	private String get(InjectionPoint ip) {
		Value annotation = ip.getAnnotated().getAnnotation(Value.class);
		String key = annotation.key();
		String bundleName = annotation.bundle();
		ResourceBundle bundle = getBundle(bundleName);
		return bundle.getString(key);
	}
	
	private ResourceBundle getBundle(String name) {
		ResourceBundle bundle = bundles.get(name);
		if(bundle == null) {
			bundle = ResourceBundle.getBundle(name);
			bundles.put(name, bundle);
		}
		return bundle;
	}
}
