package com.walter.pokedata.util

sealed class Status<T> {

    data class Success<T>(val data: T): Status<T>()
    data class Error<T>(val message: String): Status<T>()

}

fun <T>Status<T>.onSuccess(lambda: (T) -> Unit): Status<T> {
    if (this is Status.Success) lambda.invoke(this.data)
    return this
}

fun <T>Status<T>.onError(lambda: (String) -> Unit): Status<T> {
    if (this is Status.Error) lambda.invoke(this.message)
    return this
}
