package com.midea.adapter.common.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class EisLoggerFactory implements LoggerFactory {

	@Override
	public Logger makeNewLoggerInstance(String name) {
		return new EisLogger(name);
	}

}
