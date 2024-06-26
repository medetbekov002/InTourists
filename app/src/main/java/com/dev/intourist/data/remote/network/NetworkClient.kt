package com.dev.intourist.data.remote.network

//import com.alish.boilerplate.data.remote.authenticator.AuthenticatorApiService
//import com.alish.boilerplate.data.remote.authenticator.TokenAuthenticator
import com.dev.intourist.data.remote.authenticator.AuthenticatorApiService
import com.dev.intourist.data.remote.authenticator.TokenAuthenticator
import com.dev.intourist.data.remote.interceptors.AuthorizationInterceptor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkClient @Inject constructor(
    authenticator: TokenAuthenticator,
    authorizationInterceptor: AuthorizationInterceptor
) {

    val provideRetrofit = provideRetrofit(
        provideOkHttpClientBuilder().apply {
            authenticator(authenticator)
            addInterceptor(authorizationInterceptor)
        }.build()
    )

    inline fun <reified T> provideApiService(): T = provideRetrofit.create(T::class.java)

    class AuthenticatorClient @Inject constructor() {

        private val provideRetrofit = provideRetrofit(provideOkHttpClientBuilder().build())

        fun provideAuthenticatorApiService(): AuthenticatorApiService = provideRetrofit.create(
            AuthenticatorApiService::class.java
        )
    }
}