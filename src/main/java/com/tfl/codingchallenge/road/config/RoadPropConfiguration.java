package com.tfl.codingchallenge.road.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This class is used to get the appId and appKey configured values in application.properties file.
 */
@Component
@ConfigurationProperties(prefix = "road")
public class RoadPropConfiguration {
    private String appId;
    private String appKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
