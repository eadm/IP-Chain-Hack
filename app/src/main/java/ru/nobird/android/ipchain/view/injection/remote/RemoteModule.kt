package ru.nobird.android.ipchain.view.injection.remote

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.nobird.android.ipchain.remote.service.RestService

@Module
class RemoteModule {
    companion object {
        private const val HOST = "https://org1.hackathon1.ipchain.ru/"
        private const val AUTH_HEADER = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NjEwNzUyMDAsInJvbGUiOiJ3cml0ZXIifQ.r2QrkXesExFmufc4d1LEQo_rRryWJbsmAAghPqc8zMY"
    }

    @Provides
    internal fun provideHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addNetworkInterceptor { chain ->
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", AUTH_HEADER)
                    .build()
                chain.proceed(request)
            }
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    @Provides
    internal fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create(Gson())

    @Provides
    internal fun provideRetrofit(client: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(HOST)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    internal fun provideRestService(retrofit: Retrofit): RestService =
        retrofit.create(RestService::class.java)
}