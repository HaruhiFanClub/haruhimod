package org.auioc.mods.ahutils.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Deprecated
public class Loggers {
    public static final Logger logger = LogManager.getLogger();

    public static void log(Level level, String message, Object... fields) {
        logger.log(level, message, fields);
    }

    public static void log(Level level, String message) {
        log(level, message, (Object) null);
    }

    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Object object) {
        System.out.println(object);
    }
}
