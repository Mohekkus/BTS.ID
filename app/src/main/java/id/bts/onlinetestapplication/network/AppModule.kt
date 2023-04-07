package id.bts.onlinetestapplication.network

import id.bts.onlinetestapplication.network.bin.ModuleInfo
import id.bts.onlinetestapplication.network.bin.RetrofitInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun setupLogging(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideBaseURL() = ModuleInfo.getAddress()

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, retrofitInterceptor: RetrofitInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(retrofitInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .callTimeout(2, TimeUnit.MINUTES)
            .build()

    @Singleton
    @Provides
    fun setupRetrofit(okHttpClient: OkHttpClient, baseURL: String): Retrofit =
         Retrofit.Builder()
             .addConverterFactory(JacksonConverterFactory.create())
             .baseUrl(baseURL)
             .client(okHttpClient)
             .build()
}