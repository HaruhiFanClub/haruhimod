package org.auioc.mods.ahutils.utils.delogger.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class LoggingFilterUtils {
    public static final LoggingFilter FILTER = new LoggingFilter();

    private static final List<LoggerConfig> FOUND_LOG4J_LOGGERS = new ArrayList<>();

    public static void filterOtherLog4JLoggers() {
        final LoggerContext logContext = (LoggerContext) LogManager.getContext(false);
        final Map<String, LoggerConfig> map = logContext.getConfiguration().getLoggers();

        for (final LoggerConfig logger : map.values()) {
            if (!FOUND_LOG4J_LOGGERS.contains(logger)) {
                logger.addFilter(FILTER);
                FOUND_LOG4J_LOGGERS.add(logger);
            }
        }
    }

}
