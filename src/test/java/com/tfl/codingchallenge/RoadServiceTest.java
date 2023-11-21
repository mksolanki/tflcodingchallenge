package com.tfl.codingchallenge;

import com.tfl.codingchallenge.road.bean.Response;
import com.tfl.codingchallenge.road.config.RoadPropConfiguration;
import com.tfl.codingchallenge.road.exception.RoadNotFoundException;
import com.tfl.codingchallenge.road.service.RoadService;
import com.tfl.codingchallenge.road.service.impl.RoadServiceImpl;
import io.swagger.client.model.TflApiPresentationEntitiesRoadCorridor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import static com.tfl.codingchallenge.road.constant.RoadConstants.TFL_UNIFIED_API_GET_ROAD_BY_ID_URL;
import static com.tfl.codingchallenge.road.util.RoadUtility.*;

@ExtendWith(MockitoExtension.class)
@EnableConfigurationProperties
@ContextConfiguration(classes = { RoadPropConfigurationTest.class })
@SpringBootTest
public class RoadServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RoadService roadService = new RoadServiceImpl();

    @Autowired
    private RoadPropConfigurationTest configurationTest;

    @Mock
    private RoadPropConfiguration configurationMock;

    /**
     * This method is to test road service for valid road id, A2.
     */
    @Test
    public void testRoadService_getRoadStatusById_Valid_A2() {
        String roadId = "A2";
        String statusSeverity = "Good";
        String statusSeverityDescription = "No Exceptional Delays";
        Response expectedResponse = new Response(getResponseForValidRoadId(roadId, statusSeverity,statusSeverityDescription));
        ResponseEntity responseEntity = new ResponseEntity(getRoadCorridorObject(roadId,statusSeverity,statusSeverityDescription), HttpStatus.OK);
        Mockito.when(restTemplate.exchange(TFL_UNIFIED_API_GET_ROAD_BY_ID_URL, HttpMethod.GET,getHttpEntity(), TflApiPresentationEntitiesRoadCorridor[].class,getUriVariables(roadId,configurationTest.getAppId(),configurationTest.getAppKey())))
                .thenReturn(responseEntity);
        Mockito.when(configurationMock.getAppId()).thenReturn(configurationTest.getAppId());
        Mockito.when(configurationMock.getAppKey()).thenReturn(configurationTest.getAppKey());
        Response actualResponse = roadService.getRoadStatusById(roadId);
        Assertions.assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCode().value());
        Assertions.assertEquals(expectedResponse.getResponse(), actualResponse.getResponse());
    }

    /**
     * This method is to test road service for valid road id, A205.
     */
    @Test
    public void testRoadService_getRoadStatusById_Valid_A205() {
        String roadId = "A205";
        String roadDisplayName = "South Circular (A205)";
        String statusSeverity = "Good";
        String statusSeverityDescription = "No Exceptional Delays";
        Response expectedResponse = new Response(getResponseForValidRoadId(roadDisplayName, statusSeverity,statusSeverityDescription));
        ResponseEntity responseEntity = new ResponseEntity(getRoadCorridorObject(roadDisplayName,statusSeverity,statusSeverityDescription), HttpStatus.OK);
        Mockito.when(restTemplate.exchange(TFL_UNIFIED_API_GET_ROAD_BY_ID_URL, HttpMethod.GET,getHttpEntity(), TflApiPresentationEntitiesRoadCorridor[].class,getUriVariables(roadId,configurationTest.getAppId(),configurationTest.getAppKey())))
                .thenReturn(responseEntity);
        Mockito.when(configurationMock.getAppId()).thenReturn(configurationTest.getAppId());
        Mockito.when(configurationMock.getAppKey()).thenReturn(configurationTest.getAppKey());
        Response actualResponse = roadService.getRoadStatusById(roadId);
        Assertions.assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCode().value());
        Assertions.assertEquals(expectedResponse.getResponse(), actualResponse.getResponse());
    }

    /**
     * This method is to test road service for valid road id, A406.
     */
    @Test
    public void testRoadService_getRoadStatusById_Valid_A406() {
        String roadId = "A406";
        String roadDisplayName = "North Circular (A406)";
        String statusSeverity = "Good";
        String statusSeverityDescription = "No Exceptional Delays";
        Response expectedResponse = new Response(getResponseForValidRoadId(roadDisplayName, statusSeverity,statusSeverityDescription));
        ResponseEntity responseEntity = new ResponseEntity(getRoadCorridorObject(roadDisplayName,statusSeverity,statusSeverityDescription), HttpStatus.OK);
        Mockito.when(restTemplate.exchange(TFL_UNIFIED_API_GET_ROAD_BY_ID_URL, HttpMethod.GET,getHttpEntity(), TflApiPresentationEntitiesRoadCorridor[].class,getUriVariables(roadId,configurationTest.getAppId(),configurationTest.getAppKey())))
                .thenReturn(responseEntity);
        Mockito.when(configurationMock.getAppId()).thenReturn(configurationTest.getAppId());
        Mockito.when(configurationMock.getAppKey()).thenReturn(configurationTest.getAppKey());
        Response actualResponse = roadService.getRoadStatusById(roadId);
        Assertions.assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCode().value());
        Assertions.assertEquals(expectedResponse.getResponse(), actualResponse.getResponse());
    }

    /**
     * This method is to test road service for valid road id, A2mm.
     */
    @Test
    public void testRoadService_getRoadStatusById_Invalid_A2mm() {
        String roadId = "A2mm";
        Response expectedResponse = new Response(getResponseForInvalidRoadId(roadId));
        ResponseEntity responseEntity = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        Mockito.when(restTemplate.exchange(TFL_UNIFIED_API_GET_ROAD_BY_ID_URL, HttpMethod.GET,getHttpEntity(), TflApiPresentationEntitiesRoadCorridor[].class,getUriVariables(roadId,configurationTest.getAppId(),configurationTest.getAppKey())))
                .thenReturn(responseEntity);
        Mockito.when(configurationMock.getAppId()).thenReturn(configurationTest.getAppId());
        Mockito.when(configurationMock.getAppKey()).thenReturn(configurationTest.getAppKey());
        RoadNotFoundException thrown = Assertions.assertThrows(RoadNotFoundException.class, () -> {
            roadService.getRoadStatusById(roadId);
        });
        Assertions.assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
        Assertions.assertEquals(expectedResponse.getResponse(), thrown.getMessage());
    }

    /**
     * This method returns TflApiPresentationEntitiesRoadCorridor response array based on parameters.
     * @param roadId
     * @param statusSeverity
     * @param statusSeverityDescription
     * @return TflApiPresentationEntitiesRoadCorridor[]
     */
    private TflApiPresentationEntitiesRoadCorridor[] getRoadCorridorObject(String roadId, String statusSeverity,String statusSeverityDescription){
        TflApiPresentationEntitiesRoadCorridor roadCorridor = new TflApiPresentationEntitiesRoadCorridor();
        roadCorridor.displayName(roadId);
        roadCorridor.statusSeverity(statusSeverity);
        roadCorridor.statusSeverityDescription(statusSeverityDescription);
        return new TflApiPresentationEntitiesRoadCorridor[]{roadCorridor};
    }
}

