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
	@Value(bundle="config", key="string")
	private String str;
	
	@Inject
	@Value(bundle="config", key="double")
	private Double dbl;

	@Inject
	@Value(bundle="config", key="int")
	private Integer integ;

	@Inject
	@Value(bundle="config", key="boolean")
	private Boolean bool;
	
	@Inject
	@Value(bundle="monfig", key="integer")
	private Integer i;
	
	@Inject
	@Value(bundle="monfig", key="nested.value")
	private String s;
	
	public void init(@Observes ContainerInitialized event)
    {
		System.out.println(str);
		System.out.println(dbl);
		System.out.println(integ);
		System.out.println(bool);
		System.out.println(i);
		System.out.println(s);
    }

}
