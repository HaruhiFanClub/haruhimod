package org.auioc.mods.ahutils.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class LogUtil {
    public static void trace(String msg) {
        getLogger().trace(msg);
    }

    public static void debug(String msg) {
        getLogger().debug(msg);
    }

    public static void info(String msg) {
        getLogger().info(msg);
    }

    public static void warn(String msg) {
        getLogger().warn(msg);
    }

    public static void error(String msg) {
        getLogger().error(msg);
    }

    public static void error(String msg, Throwable t) {
        getLogger().error(msg, t);
    }

    public static void log(Level level, String message, Object... fields) {
        getLogger().log(level, message, fields);
    }

    private static Logger getLogger() {
        return LogManager.getLogger(getCaller().getClassName());
    }

    private static StackTraceElement getCaller() {
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();

        StackTraceElement caller = null;

        String logClassName = LogUtil.class.getName();

        int i = 0;
        for (int len = callStack.length; i < len; i++) {
            if (logClassName.equals(callStack[i].getClassName())) {
                break;
            }
        }

        caller = callStack[i + 3];
        return caller;
    }
}
