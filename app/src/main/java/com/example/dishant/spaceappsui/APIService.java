package com.example.dishant.spaceappsui;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by dishant on 30/4/17.
 */

public interface APIService {

    @POST("/login")
    @FormUrlEncoded
    Call<LoginPost> saveLogin(@Field("username") String username,
                             @Field("password") String password);

    @POST("/login")
    @FormUrlEncoded
    Call<LoginPost> saveRegister(@Field("username") String username,
                             @Field("password") String password,
                                 @Field("name") String name,
                                 @Field("email") String email);

}
