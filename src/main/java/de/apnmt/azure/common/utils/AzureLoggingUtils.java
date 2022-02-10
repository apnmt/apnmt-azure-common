/*
 * LoggingUtils.java
 *
 * (c) Copyright AUDI AG, 2022
 * All Rights reserved.
 *
 * AUDI AG
 * 85057 Ingolstadt
 * Germany
 */
package de.apnmt.azure.common.utils;

import ch.qos.logback.classic.LoggerContext;
import com.microsoft.applicationinsights.logback.ApplicationInsightsAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzureLoggingUtils {

    private static final Logger log = LoggerFactory.getLogger(AzureLoggingUtils.class);

    public static void addApplicationInsightsAppender(LoggerContext context, String instrumentationKey) {
        log.info("Initializing ApplicationInsights loggingProperties");
        ApplicationInsightsAppender applicationInsightsAppender = new ApplicationInsightsAppender();
        applicationInsightsAppender.setContext(context);
        applicationInsightsAppender.setName("ASYNC_APPLICATION_INSIGHTS");
        applicationInsightsAppender.setInstrumentationKey(instrumentationKey);
        applicationInsightsAppender.start();
        context.getLogger("ROOT").addAppender(applicationInsightsAppender);
    }

}
