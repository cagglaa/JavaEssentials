package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 3)
public class SmsLoggingAspect {

	@Before(value = "com.aop.aspect.BaseAspect.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {
		System.out.println("before sms icin calisti." + getClass());
		Signature methodSignature = joinPoint.getSignature();
		// MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		// ikiside ayni

		System.out.println("Metot: " + methodSignature);

		Object[] args = joinPoint.getArgs();// parametreleri dizi seklinde aldik
		for (Object temp : args) {
			System.out.println(temp);
		}

	}
}
