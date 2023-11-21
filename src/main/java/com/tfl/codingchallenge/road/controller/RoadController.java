package com.tfl.codingchallenge.road.controller;

import com.tfl.codingchallenge.road.bean.Response;
import com.tfl.codingchallenge.road.exception.RoadNotFoundException;
import com.tfl.codingchallenge.road.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.tfl.codingchallenge.road.util.RoadUtility.*;

/**
 * This is the main rest controller class for the road product.
 */
@RestController
@RequestMapping("/road")
public class RoadController {

    @Autowired
    private RoadService roadService;

    /**
     * Method to get road status by id.
     * @param roadId
     * @return Response
     */
    @GetMapping(value = "/{roadId}/status" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getRoadStatusById(@PathVariable String roadId){
        return roadService.getRoadStatusById(roadId);
    }

    /**
     * Method to handle exception when no road found.
     * @param ex
     * @return Response
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoadNotFoundException.class)
    public Response handleEntityNotFound(RoadNotFoundException ex) {
        return getResponse(ex.getMessage());
    }

}
