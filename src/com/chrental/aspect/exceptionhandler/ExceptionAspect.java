package com.chrental.aspect.exceptionhandler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.application.exception.BusinessException;
import com.chrental.util.Util;

@Aspect
public class ExceptionAspect {

	@Around("execution(* com.chrental.service..*(..))")
	public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
		Object ret = null;
		try {
			ret = joinPoint.proceed();
			return ret;
		}catch(BusinessException bex){
			return	Util.constructJSON("fail",bex.getMessage() ,false);
		}catch (Exception ex) {
			ex.printStackTrace();
		    return	Util.constructJSON("fail",ex.getMessage() ,false);
		}
	}
}
