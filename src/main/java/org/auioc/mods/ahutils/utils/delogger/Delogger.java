package org.auioc.mods.ahutils.utils.delogger;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.auioc.mods.ahutils.common.config.CommonConfig;
import org.auioc.mods.ahutils.utils.LogUtil;
import org.auioc.mods.ahutils.utils.delogger.filter.LoggingFilterUtils;
import org.auioc.mods.ahutils.utils.delogger.filter.PrintStreamFilter;

public class Delogger {
    public static void init() {
        LogUtil.info("Delogger loaded");

        // Java system out
        System.setOut(new PrintStreamFilter(System.out));

        // Java logger root
        java.util.logging.Logger.getLogger("").setFilter(LoggingFilterUtils.FILTER);

        // Root Apache/Log4J logger
        ((org.apache.logging.log4j.core.Logger) LogManager.getRootLogger()).addFilter(LoggingFilterUtils.FILTER);

        // Other stray Log4J loggers.
        LoggingFilterUtils.filterOtherLog4JLoggers();
    }

    public static List<? extends String> getBasicFilters() {
        return CommonConfig.DeloggerBasicFilter.get();
    }

    public static List<? extends String> getRegexFilters() {
        return CommonConfig.DeloggerRegexFilter.get();
    }

    public static boolean shouldFilterMessage(String message) {
        for (final String filter : getBasicFilters()) {
            if (message.contains(filter)) {
                return true;
            }
        }

        for (final String filter : getRegexFilters()) {
            if (message.matches(filter)) {
                return true;
            }
        }

        return false;
    }
}
