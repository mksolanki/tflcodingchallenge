package com.tfl.codingchallenge.road.service;


import com.tfl.codingchallenge.road.bean.Response;

/**
 * The road service interface.
 */
public interface RoadService {
    Response getRoadStatusById(String roadId);
}
