package com.tfl.codingchallenge.road.constant;

import java.time.Duration;

/**
 * This is the constant class contains for the road product.
 */
public class RoadConstants {
    public static final String TFL_UNIFIED_API_GET_ROAD_BY_ID_URL = "https://api.tfl.gov.uk/Road/{roadId}?app_id={appId}&app_key={appKey}";
    /* 0 = {displayName}, 1 = {statusSeverity}, 2 = {statusSeverityDescription} in GET_ROAD_STATUS_BY_ID_SUCCESS_RESPONSE */
    public static final String GET_ROAD_STATUS_BY_ID_SUCCESS_RESPONSE = "The status of the {0} is {1} and {2}.";
    /* {0} = {RoadId} in GET_ROAD_STATUS_BY_ID_FAILURE_RESPONSE */
    public static final String GET_ROAD_STATUS_BY_ID_FAILURE_RESPONSE = "{0} is not a valid road.";
    public static final Duration TIMEOUT_DURATION = Duration.ofMillis(180000); // 3 seconds
}
