package com.hukuuu;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.enterprise.inject.Stereotype;
import javax.enterprise.util.Nonbinding;

@Stereotype
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
	@Nonbinding String key() default "";
	@Nonbinding String bundle() default "";
}
