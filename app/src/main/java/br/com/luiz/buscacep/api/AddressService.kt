package br.com.luiz.buscacep.api

import br.com.luiz.buscacep.model.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService{

    @GET("ws/{cep}/json/")
    fun busca(@Path("cep")cep: String): Call<Address>

}