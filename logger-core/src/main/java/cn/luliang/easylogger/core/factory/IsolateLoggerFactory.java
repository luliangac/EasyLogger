package cn.luliang.easylogger.core.factory;

import cn.luliang.easylogger.core.classloader.EasyLoggerClassLoader;
import cn.luliang.easylogger.core.logger.Logger;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * isolate the app log with others.
 * Created by luliang on 16/1/14.
 */
public class IsolateLoggerFactory {

    private static ConcurrentHashMap<String, Logger> loggerCache = new ConcurrentHashMap<String, Logger>();

    public static Class loggerFactoryClass;

    static {
        loadClazz();
    }

    private static void loadClazz() {
        EasyLoggerClassLoader easyLoggerClassLoader = new EasyLoggerClassLoader();
        System.out.println(easyLoggerClassLoader.getParent());
        try {
            loggerFactoryClass = easyLoggerClassLoader.loadClass("org.slf4j.LoggerFactory");
            String classLoader = loggerFactoryClass.getClassLoader().toString();
            System.out.println(classLoader);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
    }

    public static Logger getLogger(String name) {

        try {

            Method getLoggerMethod = loggerFactoryClass.getMethod("getLogger", String.class);
            Object logger = getLoggerMethod.invoke(loggerFactoryClass, name);
            Method getNameMethod = logger.getClass().getMethod("getName");
            String loggerName = (String)getNameMethod.invoke(logger);

            if(loggerCache.containsKey(loggerName)) {
                return loggerCache.get(loggerName);
            } else {

                Logger easyLogger = new Logger(logger);
                loggerCache.put(loggerName, easyLogger);
                return easyLogger;
            }

        } catch (Throwable e) {
//            e.printStackTrace();
            return null;
        }
    }

    public static Logger getLogger(Class clazz) {
        return getLogger(clazz.getName());
    }

    public static void main(String[] args) {

        IsolateLoggerFactory loggerFactory = new IsolateLoggerFactory();
    }

}
