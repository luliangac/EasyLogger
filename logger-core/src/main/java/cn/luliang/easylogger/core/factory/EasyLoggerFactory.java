//package cn.luliang.easylogger.core.factory;
//
//import org.slf4j.ILoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.reflect.Method;
//import java.net.URL;
//
///**
// *
// */
//public class EasyLoggerFactory {
//
//
//    static {
//        initLoggerFactory();
//    }
//
//    private static void initLoggerFactory() {
//
//        String logConfigFilePath =
//                System.getProperty("log.configFile", System.getenv("LOG_CONFIGFILE"));
//        Boolean isloadconfig =
//                Boolean.parseBoolean(System.getProperty("log.loadconfig", "true"));
//
//        final String log4j_resource_file =
//                System.getProperty("log4j.resource.fileName", "log4j_default.xml");
//
//        final String logback_resource_file =
//                System.getProperty("logback.resource.fileName", "logback_default.xml");
//
//        if (isloadconfig) {
//            try {
//                ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
//                Class classType = iLoggerFactory.getClass();
//                if (classType.getName().equals("org.slf4j.impl.Log4jLoggerFactory")) {
//                    Class<?> DOMConfigurator = null;
//                    Object DOMConfiguratorObj = null;
//                    DOMConfigurator = Class.forName("org.apache.log4j.xml.DOMConfigurator");
//                    DOMConfiguratorObj = DOMConfigurator.newInstance();
//                    if (null == logConfigFilePath) {
//                        Method configure = DOMConfiguratorObj.getClass().getMethod("configure", URL.class);
//                        URL url = EasyLoggerFactory.class.getClassLoader().getResource(log4j_resource_file);
//                        configure.invoke(DOMConfiguratorObj, url);
//                    } else {
//                        Method configure = DOMConfiguratorObj.getClass().getMethod("configure", String.class);
//                        configure.invoke(DOMConfiguratorObj, logConfigFilePath);
//                    }
//
//                } else if (classType.getName().equals("ch.qos.logback.classic.LoggerContext")) {
//                    Class<?> joranConfigurator = null;
//                    Class<?> context = Class.forName("ch.qos.logback.core.Context");
//                    Object joranConfiguratoroObj = null;
//                    joranConfigurator = Class.forName("ch.qos.logback.classic.joran.JoranConfigurator");
//                    joranConfiguratoroObj = joranConfigurator.newInstance();
//                    Method setContext = joranConfiguratoroObj.getClass().getMethod("setContext", context);
//                    setContext.invoke(joranConfiguratoroObj, iLoggerFactory);
//                    if (null == logConfigFilePath) {
//                        URL url = EasyLoggerFactory.class.getClassLoader().getResource(logback_resource_file);
//                        Method doConfigure =
//                                joranConfiguratoroObj.getClass().getMethod("doConfigure", URL.class);
//                        doConfigure.invoke(joranConfiguratoroObj, url);
//                    } else {
//                        Method doConfigure =
//                                joranConfiguratoroObj.getClass().getMethod("doConfigure", String.class);
//                        doConfigure.invoke(joranConfiguratoroObj, logConfigFilePath);
//                    }
//
//                }
//            } catch (Exception e) {
//                System.err.println(e);
//            }
//        }
//    }
//
//
//    public static Logger getLogger(String loggerName) {
//        return LoggerFactory.getLogger(loggerName);
//    }
//
//    public static Logger getLogger(Class clazz) {
//        return LoggerFactory.getLogger(clazz);
//    }
//
//
//}
