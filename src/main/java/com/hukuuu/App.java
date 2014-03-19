package com.hukuuu;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@Inject
	@Value(key="string")
	private String str;
	
	@Inject
	@Value(key="double")
	private Double dbl;

	@Inject
	@Value(key="int")
	private Integer integ;

	@Inject
	@Value(key="boolean")
	private Boolean bool;
	
	
	public void init(@Observes ContainerInitialized event)
    {
		System.out.println(str);
		System.out.println(dbl);
		System.out.println(integ);
		System.out.println(bool);
    }

}
