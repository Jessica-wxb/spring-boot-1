package com.dmsdbj.team.springbootdemo.util.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName CustomLogColor.java
 * @Description TODO
 * @createTime 2020年03月14日 05:52:00
 */
public class CustomLogColor extends ForegroundCompositeConverterBase<ILoggingEvent> {
    @Override
    protected String getForegroundColorCode(ILoggingEvent iLoggingEvent) {
        Level level = iLoggingEvent.getLevel();
        switch (level.toInt()) {
            case Level.INFO_INT:
                return ANSIConstants.GREEN_FG;
            case Level.WARN_INT:
                return ANSIConstants.YELLOW_FG;
            default:
                return ANSIConstants.DEFAULT_FG;
        }
    }
}
