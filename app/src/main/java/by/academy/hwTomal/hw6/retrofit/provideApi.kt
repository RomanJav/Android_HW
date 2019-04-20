package by.academy.hwTomal.hw6.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun provideApi() : StudentApi {

    val retrofit  = Retrofit.Builder()
        .baseUrl("https://api.backendless.com/6F5DF07E-FDF1-2BD3-FF19-4EEA42398B00/39FC19A7-6FB0-409E-FFC9-89CD05F24F00/data/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(OkHttpClient.Builder().build())
        .build()

    return retrofit.create(StudentApi::class.java)
}