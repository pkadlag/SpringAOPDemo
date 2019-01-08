package com.cg.app.validationaspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
	private Logger logger = Logger.getLogger(ValidationAspect.class.getName());

	@Before(" execution (* com.cg.app.service.Calculator.*(..))")
	public void log1() {
		logger.info("Before -logging method");
	}

	@After(" execution (* com.cg.app.service.Calculator.*(..))")
	public void log2() {
		logger.info("After -logging method");
	}

	@Around("execution(* com.cg.app.service.Calculator.*(..))")
	public void log3(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before -Logging the method");
		logger.info("Function Name is :" + pjp.getSignature());
		logger.info("Parameters are :");
		Object[] params = pjp.getArgs();
		for (int i = 0; i < params.length; i++) {
			logger.info("Parameter value at index" + i + "is" + params[i]);

		}
		pjp.proceed();
		logger.info("After -Logging the method");
	}

	@AfterReturning(pointcut = "execution(* com.cg.app.service.Calculator.add(..))", returning = "retVal")
	public void log4(Integer retVal) {
		logger.info("" + retVal);
	}
}
