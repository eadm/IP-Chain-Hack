package ru.nobird.android.ipchain.view.injection.remote

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
        private const val HOST = ""
    }

    @Provides
    internal fun provideHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
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