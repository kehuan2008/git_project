package com.midea.adapter.common.log4j;

import org.apache.log4j.Hierarchy;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class EisLogger extends Logger {
	
	public EisLogger(String name) {
		super(name);
	}
	/**
	 * 初始化log4j参数
	 */
	private static void doInitLog4j(){
		
		try{
			System.out.println("currentThread.ClassLoader:EisRollingFileAppender");
			//装载自定义类
			Thread.currentThread().setContextClassLoader(EisRollingFileAppender.class.getClassLoader());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			System.out.println("get log4j Hierarchy");
			Hierarchy h = (Hierarchy)LogManager.getLoggerRepository();
			if(h != null){
				System.out.println("log4j Hierarchy not null");
				h.clear();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static EisLogger getLogger(String name) {
		doInitLog4j();
		Object obj = LogManager.getLogger(name,new EisLoggerFactory());
	    return (EisLogger)obj;
	}

//	public static EisLogger getLogger(Class<?> clazz) {
//	    return getLogger(clazz.getName());
//	}
	
	private static final String FQCN = EisLogger.class.getName();
	
	protected void forcedLog(String fqcn, Priority level, Object message, Throwable t,IEisLogParam mode) {
	    callAppenders(new EisLogginEvent(fqcn, this, level, message, t,mode));
	}
	
	public void trace(Object message,IEisLogParam mode) {
      if (repository.isDisabled(Level.TRACE_INT)) {
        return;
      }

      if (Level.TRACE.isGreaterOrEqual(this.getEffectiveLevel())) {
        forcedLog(FQCN, Level.TRACE, message, null,mode);
      }
    }

    public void trace(Object message, Throwable t,IEisLogParam mode) {
      if (repository.isDisabled(Level.TRACE_INT)) {
        return;
      }

      if (Level.TRACE.isGreaterOrEqual(this.getEffectiveLevel())) {
        forcedLog(FQCN, Level.TRACE, message, t,mode);
      }
    }
	    
	 public void debug(Object message,IEisLogParam mode) {
	    if(repository.isDisabled(Level.DEBUG_INT))
	      return;
	    if(Level.DEBUG.isGreaterOrEqual(this.getEffectiveLevel())) {
	      forcedLog(FQCN, Level.DEBUG, message, null,mode);
	    }
	  }
	 
	 public void debug(Object message, Throwable t,IEisLogParam mode) {
	    if(repository.isDisabled(Level.DEBUG_INT))
	      return;
	    if(Level.DEBUG.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.DEBUG, message, t,mode);
	  }
	 
	 public void info(Object message,IEisLogParam mode) {
	    if(repository.isDisabled(Level.INFO_INT))
	      return;
	    if(Level.INFO.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.INFO, message, null,mode);
	  }

	  public void info(Object message, Throwable t,IEisLogParam mode) {
	    if(repository.isDisabled(Level.INFO_INT))
	      return;
	    if(Level.INFO.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.INFO, message, t,mode);
	  }
	  
	  public void warn(Object message,IEisLogParam mode) {
	    if(repository.isDisabled( Level.WARN_INT))
	      return;

	    if(Level.WARN.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.WARN, message, null,mode);
	  }

	  public void warn(Object message, Throwable t,IEisLogParam mode) {
	    if(repository.isDisabled(Level.WARN_INT))
	      return;
	    if(Level.WARN.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.WARN, message, t,mode);
	  }
	  
	  public void error(Object message,IEisLogParam mode) {
	    if(repository.isDisabled(Level.ERROR_INT))
	      return;
	    if(Level.ERROR.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.ERROR, message, null,mode);
	  }

	  public void error(Object message, Throwable t,IEisLogParam mode) {
	    if(repository.isDisabled(Level.ERROR_INT))
	      return;
	    if(Level.ERROR.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.ERROR, message, t,mode);

	  }

	  public void fatal(Object message,IEisLogParam mode) {
	    if(repository.isDisabled(Level.FATAL_INT))
	      return;
	    if(Level.FATAL.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.FATAL, message, null,mode);
	  }

	  public void fatal(Object message, Throwable t,IEisLogParam mode) {
	    if(repository.isDisabled(Level.FATAL_INT))
	      return;
	    if(Level.FATAL.isGreaterOrEqual(this.getEffectiveLevel()))
	      forcedLog(FQCN, Level.FATAL, message, t,mode);
	  }
}
