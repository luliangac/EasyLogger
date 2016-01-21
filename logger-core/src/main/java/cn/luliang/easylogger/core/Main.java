package cn.luliang.easylogger.core;

import cn.luliang.easylogger.core.factory.IsolateLoggerFactory;
import cn.luliang.easylogger.core.logger.Logger;

/**
 * Created by luliang on 16/1/21.
 */
public class Main {

    public static void main(String[] args) {

        Logger logger = IsolateLoggerFactory.getLogger(Main.class);
        logger.info("testInfo");
        logger.warn("testWarn");
        logger.error("testError");
    }
}
