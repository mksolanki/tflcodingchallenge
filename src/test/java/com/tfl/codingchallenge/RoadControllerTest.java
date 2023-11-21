package com.tfl.codingchallenge;

import com.tfl.codingchallenge.road.bean.Response;
import com.tfl.codingchallenge.road.controller.RoadController;
import com.tfl.codingchallenge.road.exception.RoadNotFoundException;
import com.tfl.codingchallenge.road.service.RoadService;
import com.tfl.codingchallenge.road.util.RoadUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.tfl.codingchallenge.road.util.RoadUtility.getResponseForInvalidRoadId;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This is junit/ unit test class for RoadController class.
 */
@WebMvcTest(RoadController.class)
public class RoadControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    RoadService roadService;

    /**
     * This method is to test valid road id.
     * {RoadId}=A2 is set to "/road/{RoadId}/status" to uri.
     */
    @Test
    public void testRoadController_getRoadStatusById_Valid_A2(){
        String roadId ="A2";
        String responseMsg = getResponseForValidRoadId(roadId);
        Mockito.when(roadService.getRoadStatusById(Mockito.anyString())).thenReturn(new Response(responseMsg));
        try {
            mvc.perform(MockMvcRequestBuilders
                            .get(getAPIUrl(roadId))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(responseMsg));
        }catch (Exception e) {
            Assertions.assertFalse(true);
        }
    }

    /**
     * This method is to test valid road id.
     * {RoadId}=A205 is set to "/road/{RoadId}/status" to uri.
     */
    @Test
    public void testRoadController_getRoadStatusById_Valid_A205(){
        String responseMsg = getResponseForValidRoadId("South Circular (A205)");
        Mockito.when(roadService.getRoadStatusById(Mockito.anyString())).thenReturn(new Response(responseMsg));
        try {
            mvc.perform(MockMvcRequestBuilders
                            .get(getAPIUrl("A205"))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(responseMsg));
        }catch (Exception e) {
            Assertions.assertFalse(true);
        }
    }

    /**
     * This method is to test valid road id.
     * {RoadId}=A406 is set to "/road/{RoadId}/status" to uri.
     */
    @Test
    public void testRoadController_getRoadStatusById_Valid_A406(){
        String responseMsg = getResponseForValidRoadId("North Circular (A406)");
        Mockito.when(roadService.getRoadStatusById(Mockito.anyString())).thenReturn(new Response(responseMsg));
        try {
            mvc.perform(MockMvcRequestBuilders
                            .get(getAPIUrl("A406"))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(responseMsg));
        }catch (Exception e) {
            Assertions.assertFalse(true);
        }
    }
    /**
     * This method is to test invalid road id.
     * {RoadId}=A2mm is set to "/road/{RoadId}/status" to uri.
     */
    @Test
    public void testRoadController_getRoadStatusById_InValid_A2mm(){
        String roadId ="A2mm";
        String responseMsg = getResponseForInvalidRoadId(roadId);
        Mockito.when(roadService.getRoadStatusById(Mockito.anyString())).thenThrow(new RoadNotFoundException(responseMsg));
        try {
            mvc.perform(MockMvcRequestBuilders
                            .get(getAPIUrl(roadId))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(responseMsg));
        }catch (Exception e) {
            Assertions.assertFalse(true);
        }
    }

    /**
     * This method returns response for valid road id.
     * @param roadDisplayName
     * @return String
     */
    private String getResponseForValidRoadId(String roadDisplayName) {
        String statusSeverity = "Good";
        String statusSeverityDescription = "No Exceptional Delays";
        return RoadUtility.getResponseForValidRoadId(roadDisplayName,statusSeverity,statusSeverityDescription);
    }

    /**
     * This method returns the uri to test for rest controller.
     * @param roadId
     * @return String
     */
    private String getAPIUrl(String roadId){
        String getRoadURL = "/road/{RoadId}/status";
        return getRoadURL.replace("{RoadId}",roadId);
    }
}
