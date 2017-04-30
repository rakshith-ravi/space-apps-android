package com.example.dishant.spaceappsui;

/**
 * Created by dishant on 30/4/17.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "rakshith.co.in:8080";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
