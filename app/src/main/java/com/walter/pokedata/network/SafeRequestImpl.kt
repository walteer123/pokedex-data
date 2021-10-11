package com.walter.pokedata.network

import android.util.Log
import com.walter.pokedata.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SafeRequestImpl @Inject constructor(): SafeRequest {
    override suspend operator fun <T> invoke(lambda: suspend () -> T): Status<T> = withContext(Dispatchers.IO) {
        try {
            Status.Success(lambda.invoke())
        } catch (throwable:Throwable){
            Log.d("Erro", throwable.message ?: "Erro sem mensagem")
            Status.Error(throwable.message ?: "Erro!")
        }
    }
}
