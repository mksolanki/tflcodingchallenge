package com.tfl.codingchallenge.road.service.impl;

import com.tfl.codingchallenge.road.service.RoadService;
import com.tfl.codingchallenge.road.bean.Response;
import com.tfl.codingchallenge.road.config.RoadPropConfiguration;
import com.tfl.codingchallenge.road.exception.RoadNotFoundException;
import io.swagger.client.model.TflApiPresentationEntitiesRoadCorridor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.tfl.codingchallenge.road.constant.RoadConstants.TFL_UNIFIED_API_GET_ROAD_BY_ID_URL;
import static com.tfl.codingchallenge.road.util.RoadUtility.*;
import static com.tfl.codingchallenge.road.util.RoadUtility.getResponseForInvalidRoadId;

/**
 * This is the road service implementation class.
 */
@Service
public class RoadServiceImpl implements RoadService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RoadPropConfiguration configuration;

    /**
     * This method call Unified API for road product and returns the road status by id.
     * @param roadId
     * @return Response
     */
    public Response getRoadStatusById(String roadId){
        try {
            ResponseEntity<TflApiPresentationEntitiesRoadCorridor[]> responseEntity = restTemplate.exchange(TFL_UNIFIED_API_GET_ROAD_BY_ID_URL, HttpMethod.GET,getHttpEntity() ,
                    TflApiPresentationEntitiesRoadCorridor[].class,getUriVariables(roadId,configuration.getAppId(),configuration.getAppKey()));
            if(responseEntity.getStatusCode() == HttpStatus.OK) {
                TflApiPresentationEntitiesRoadCorridor roadCorridor = responseEntity.getBody()[0];
                return getResponse(getResponseForValidRoadId(roadCorridor.getDisplayName(), roadCorridor.getStatusSeverity(), roadCorridor.getStatusSeverityDescription()));
            } else {
                throw new RoadNotFoundException(getResponseForInvalidRoadId(roadId));
            }
        } catch (HttpClientErrorException ex) {
            throw new RoadNotFoundException(getResponseForInvalidRoadId(roadId));
        }
    }
}
