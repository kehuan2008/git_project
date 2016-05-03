package com.midea.adapter.common.log4j;

import org.apache.log4j.PropertyConfigurator;

import com.midea.adapter.common.config.ConfigManager;

public class Log  {
	
	private static EisLogger logger ;
	
	private static Log EISLog = null;
	
	private Log(){
	}

	
	public static Log getInstance(){
		if(EISLog == null){
			createInstance();
		}
		
		return EISLog;
	}
	
	
	public void trace(Object message,Object mode) {
		logger.trace(message,toLogParam(mode));
	}

	public void trace(Object message, Throwable t,Object mode) {
		logger.trace(message,t,toLogParam(mode));
	}

	public void debug(Object message,Object mode) {
		logger.debug(message,toLogParam(mode));
	}

	public void debug(Object message, Throwable t,Object mode) {
		logger.debug(message,t,toLogParam(mode));
	}

	public void info(Object message,Object mode) {
		logger.info(message,toLogParam(mode));
	}

	public void info(Object message, Throwable t,Object mode) {
		logger.info(message,t,toLogParam(mode));
	}

	public void warn(Object message,Object mode) {
		logger.warn(message,toLogParam(mode));
	}

	public void warn(Object message, Throwable t,Object mode) {
		logger.warn(message,t,toLogParam(mode));
	}

	public void error(Object message,Object mode) {
		logger.error(message,toLogParam(mode));
	}

	public void error(Object message, Throwable t,Object mode) {
		logger.error(message,t,toLogParam(mode));
	}

	public void fatal(Object message,Object mode) {
		logger.fatal(message,toLogParam(mode));
	}

	public void fatal(Object message, Throwable t,Object mode) {
		logger.fatal(message,t,toLogParam(mode));
	}
	
	private IEisLogParam toLogParam(Object obj) {
		if (obj != null){
			if (obj instanceof IEisLogParam){
				return (IEisLogParam)obj;
			}else {
				EisLogParamImpl logPara = new EisLogParamImpl();
				//logPara.setEsbServId((String)obj);
				return logPara;
			}
		}else{
			return new EisLogParamImpl();
		}
		
	}
}
