package org.auioc.mods.ahutils.utils.delogger.filter;

import java.util.logging.LogRecord;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.auioc.mods.ahutils.utils.delogger.Delogger;

public class LoggingFilter extends AbstractFilter implements java.util.logging.Filter {
    // Oracle/Java Filter
    @Override
    public boolean isLoggable(LogRecord record) {
        return !Delogger.shouldFilterMessage(record.getMessage());
    }

    // Apache/Log4J Filter
    @Override
    public Result filter(LogEvent event) {
        return Delogger.shouldFilterMessage("[" + event.getLoggerName() + "]: " + event.getMessage().getFormattedMessage()) ? Result.DENY : Result.NEUTRAL;
    }
}
