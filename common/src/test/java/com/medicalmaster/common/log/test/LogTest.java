package com.medicalmaster.common.log.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest 
{
	static Logger logger = LoggerFactory.getLogger(LogTest.class);
	public static void main(String[] args)
	{
		logger.info("{} say {}", "111", "11");
	}
}
