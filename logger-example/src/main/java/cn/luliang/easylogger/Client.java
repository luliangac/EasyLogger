package cn.luliang.easylogger;

import org.slf4j.Logger;

/**
 * Created by luliang on 16/1/15.
 */
public class Client {

    private static Logger logger = IsolateLoggerFactory.getLogger(Client.class);

    public void init() {
        logger.info("loggerFactory class loader " + IsolateLoggerFactory.loggerFactoryClass.getClassLoader());
        logger.info("test client init.");
    }
}
