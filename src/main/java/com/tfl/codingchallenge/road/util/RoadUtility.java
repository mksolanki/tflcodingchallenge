package com.tfl.codingchallenge.road.util;

import com.tfl.codingchallenge.road.bean.Response;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.tfl.codingchallenge.road.constant.RoadConstants.GET_ROAD_STATUS_BY_ID_FAILURE_RESPONSE;
import static com.tfl.codingchallenge.road.constant.RoadConstants.GET_ROAD_STATUS_BY_ID_SUCCESS_RESPONSE;

/**
 * This is road utility class and contains all utility methods used for road component.
 */
public class RoadUtility {

    /**
     * This method format the response for invalid road id.
     * @param roadId
     * @return String
     */
    public static String getResponseForInvalidRoadId(String roadId) {
        return MessageFormat.format(GET_ROAD_STATUS_BY_ID_FAILURE_RESPONSE, roadId);
    }

    /**
     * This method format the response to return in response for valid road id.
     * @param roadId
     * @param statusSeverity
     * @param statusSeverityDescription
     * @return String
     */
    public static String getResponseForValidRoadId(String roadId, String statusSeverity, String statusSeverityDescription) {
        return MessageFormat.format(GET_ROAD_STATUS_BY_ID_SUCCESS_RESPONSE, roadId, statusSeverity, statusSeverityDescription);
    }

    /**
     * This method prepare the uri variables map to use in rest template for api call.
     * @param roadId
     * @param appId
     * @param appKey
     * @return Map<String, String>
     */
    public static Map<String, String> getUriVariables(String roadId, String appId, String appKey) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("roadId", roadId);
        uriVariables.put("appId", appId);
        uriVariables.put("appKey", appKey);
        return uriVariables;
    }

    /**
     * This method returns the http entity to set in rest template for api call.
     * @return HttpEntity<Object>
     */
    public static HttpEntity<Object> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noStore());
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(headers);
    }

    /**
     * Method returns response object.
     * @param responseMsg
     * @return Response
     */
    public static Response getResponse(String responseMsg) {
        return new Response(responseMsg);
    }
}
