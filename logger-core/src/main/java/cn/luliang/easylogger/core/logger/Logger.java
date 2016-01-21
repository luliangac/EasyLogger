package cn.luliang.easylogger.core.logger;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by luliang on 16/1/20.
 */
public class Logger {

    private Object logger;

    public Logger(Object logger) {
        this.logger = logger;
    }

    
    public String getName() {
        return null;
    }

    
    public boolean isTraceEnabled() {
        return false;
    }

    
    public void trace(String msg) {

    }

    
    public void trace(String format, Object...args) {

    }

    
    public void trace(String msg, Throwable t) {

    }

    
//    public boolean isTraceEnabled(Marker marker) {
//        return false;
//    }
//
//
//    public void trace(Marker marker, String msg) {
//
//    }
//
//
//    public void trace(Marker marker, String format, Object arg) {
//
//    }
//
//
//    public void trace(Marker marker, String format, Object arg1, Object arg2) {
//
//    }
//
//
//    public void trace(Marker marker, String format, Object[] argArray) {
//
//    }
//
//
//    public void trace(Marker marker, String msg, Throwable t) {
//
//    }

    
    public boolean isDebugEnabled() {
        return false;
    }

    
    public void debug(String msg) {
        try {
            Method infoMethod = logger.getClass().getMethod("debug", String.class);
            infoMethod.invoke(logger, msg);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    
    public void debug(String format, Object arg) {

    }

    
    public void debug(String format, Object arg1, Object arg2) {

    }

    
    public void debug(String format, Object[] argArray) {

    }

    
    public void debug(String msg, Throwable t) {

    }

    
//    public boolean isDebugEnabled(Marker marker) {
//        return false;
//    }
//
//
//    public void debug(Marker marker, String msg) {
//
//    }
//
//
//    public void debug(Marker marker, String format, Object arg) {
//
//    }
//
//
//    public void debug(Marker marker, String format, Object arg1, Object arg2) {
//
//    }
//
//
//    public void debug(Marker marker, String format, Object[] argArray) {
//
//    }
//
//
//    public void debug(Marker marker, String msg, Throwable t) {
//
//    }

    
    public boolean isInfoEnabled() {
        return false;
    }

    
    public void info(String msg) {
        try {
            Method infoMethod = logger.getClass().getMethod("info", String.class);
            infoMethod.invoke(logger, msg);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    
    public void info(String format, Object arg) {

    }

    
    public void info(String format, Object arg1, Object arg2) {

    }

    
    public void info(String format, Object[] argArray) {

    }

    
    public void info(String msg, Throwable t) {

    }

    
//    public boolean isInfoEnabled(Marker marker) {
//        return false;
//    }
//
//
//    public void info(Marker marker, String msg) {
//
//    }
//
//
//    public void info(Marker marker, String format, Object arg) {
//
//    }
//
//
//    public void info(Marker marker, String format, Object arg1, Object arg2) {
//
//    }
//
//
//    public void info(Marker marker, String format, Object[] argArray) {
//
//    }
//
//
//    public void info(Marker marker, String msg, Throwable t) {
//
//    }

    
    public boolean isWarnEnabled() {
        return false;
    }

    
    public void warn(String msg) {
        try {
            Method infoMethod = logger.getClass().getMethod("warn", String.class);
            infoMethod.invoke(logger, msg);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    
    public void warn(String format, Object arg) {

    }

    
    public void warn(String format, Object[] argArray) {

    }

    
    public void warn(String format, Object arg1, Object arg2) {

    }

    
    public void warn(String msg, Throwable t) {

    }

    
//    public boolean isWarnEnabled(Marker marker) {
//        return false;
//    }

    
//    public void warn(Marker marker, String msg) {
//
//    }
//
//
//    public void warn(Marker marker, String format, Object arg) {
//
//    }
//
//
//    public void warn(Marker marker, String format, Object arg1, Object arg2) {
//
//    }
//
//
//    public void warn(Marker marker, String format, Object[] argArray) {
//
//    }

//
//    public void warn(Marker marker, String msg, Throwable t) {
//
//    }

    
    public boolean isErrorEnabled() {
        return false;
    }

    
    public void error(String msg) {
        try {
            Method infoMethod = logger.getClass().getMethod("error", String.class);
            infoMethod.invoke(logger, msg);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    
    public void error(String format, Object arg) {

    }

    
    public void error(String format, Object arg1, Object arg2) {

    }

    
    public void error(String format, Object[] argArray) {

    }

    
    public void error(String msg, Throwable t) {

    }

    
//    public boolean isErrorEnabled(Marker marker) {
//        return false;
//    }
//
//
//    public void error(Marker marker, String msg) {
//
//    }
//
//
//    public void error(Marker marker, String format, Object arg) {
//
//    }
//
//
//    public void error(Marker marker, String format, Object arg1, Object arg2) {
//
//    }
//
//
//    public void error(Marker marker, String format, Object[] argArray) {
//
//    }
//
//
//    public void error(Marker marker, String msg, Throwable t) {
//
//    }
}
