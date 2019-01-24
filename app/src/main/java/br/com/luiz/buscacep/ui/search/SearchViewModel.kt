package br.com.luiz.buscacep.ui.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.luiz.buscacep.model.Address
import br.com.luiz.buscacep.repository.AddressRepository

class SearchViewModel : ViewModel() {

    val addressRepository = AddressRepository()

    val address = MutableLiveData<Address>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun search(cep: String) {

        isLoading.value = true

        addressRepository.search(
                cep,
                onComplete = {
                    address.value = it
                    isLoading.value = false
                },
                onError = {
                    address.value = null
                    errorMessage.value = it?.message
                    isLoading.value = false
                }
        )

    }

}