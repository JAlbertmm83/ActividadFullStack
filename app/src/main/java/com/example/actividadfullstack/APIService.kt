package com.example.actividadfullstack

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
 @GET
 fun getData(@Url url:String):Response<response>
}