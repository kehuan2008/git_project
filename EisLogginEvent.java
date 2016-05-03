package com.soa.adapter.common.log4j;

import org.apache.log4j.Category;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;


public class EisLogginEvent extends LoggingEvent{
	
	protected IEisLogParam eisLogPara;

	public EisLogginEvent(String fqnOfCategoryClass, Category logger,
			Priority level, Object message, Throwable throwable,IEisLogParam eisLogginMode) {
		super(fqnOfCategoryClass, logger, level, message, throwable);
		this.eisLogPara = eisLogginMode;
	}

	public IEisLogParam getEisLogParameter() {
		return eisLogPara;
	}

	public void setEisLogParameter(IEisLogParam eisLogParameter) {
		this.eisLogPara = eisLogParameter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6217015957919454517L;

}
