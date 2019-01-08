package com.cg.app.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.cg.app.validationaspect.ValidationAspect;

@Service
public class Calculator {
	
public Integer add(int num1,int num2)
{
	Logger logger = Logger.getLogger(ValidationAspect.class.getName());
	int sum= num1+num2;
	logger.info("" +sum);
	return sum;
}

}
