package br.com.luiz.buscacep.repository

import br.com.luiz.buscacep.api.getAddressService
import br.com.luiz.buscacep.model.Address
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressRepository{

    fun search(cep: String,
               onComplete:(Address?) -> Unit,
               onError:(Throwable?) -> Unit){
        getAddressService()
                .busca(cep)
                .enqueue(object : Callback<Address> {
                    override fun onFailure(call: Call<Address>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                        if(response?.isSuccessful == true){
                            onComplete(response?.body())
                        }else{
                            onError(Throwable(response?.errorBody().toString()))
                        }
                    }

                })


    }

}