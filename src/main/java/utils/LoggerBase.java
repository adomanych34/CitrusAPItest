package utils;

import org.apache.log4j.Logger;

public class LoggerBase {

    protected String loggerName;

    LoggerBase(String name) {
        this.loggerName = name;
    }

    protected Logger getLogger() {
        return Logger.getLogger(loggerName);
    }
}
