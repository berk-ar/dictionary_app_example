package com.example.dictionaryexample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("en/{word}")
    suspend fun getKelimeler(@Path("word") kelime : String) : Response<List<KelimeRes>>

}