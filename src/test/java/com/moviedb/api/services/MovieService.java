package com.moviedb.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MovieService {

  public static RequestSpecification createRequest(String baseUrl, String apiKey) {
    return RestAssured.given()
        .baseUri(baseUrl)
        .queryParam("api_key", apiKey)
        .contentType("application/json");
  }

  public static Response getMovieDetails(RequestSpecification request, int movieId) {
    return request.when().get("/movie/" + movieId);
  }
}
