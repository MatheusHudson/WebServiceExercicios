package com.example.webservice.Services

import com.example.webservice.Model.Aluno
import com.example.webservice.Model.Msg
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Repository {

        @GET("sort/aluno")
    suspend fun getSortAluno() : Aluno

    @GET("aluno")
    suspend fun getAlunos() : MutableList<Aluno>

    @GET("produtos")
    suspend fun getProduto() : Msg



}

val retroFit = Retrofit.Builder().baseUrl("https://promoios.com.br/api/")
    .addConverterFactory(GsonConverterFactory.create()).build()
val repositorio: Repository = retroFit.create(Repository::class.java)