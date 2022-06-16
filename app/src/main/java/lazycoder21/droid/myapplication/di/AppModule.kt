package lazycoder21.droid.myapplication.di

import android.app.Application
import com.google.gson.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lazycoder21.droid.myapplication.data.remote.MyApi
import lazycoder21.droid.myapplication.data.remote.dto.UsersDto
import lazycoder21.droid.myapplication.data.repository.UserRepositoryImpl
import lazycoder21.droid.myapplication.domain.repository.UsersRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.reflect.Type
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepo(api: MyApi): UsersRepository = UserRepositoryImpl(api)


    //todo add type factory for conversion
    @Provides
    @Singleton
    fun provideMyApi(
        app: Application
    ): MyApi {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(MyApi.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create()
    }
}

internal class MyDeserializer : JsonDeserializer<UsersDto> {

    @Throws(JsonParseException::class)
    override fun deserialize(
        je: JsonElement,
        type: Type,
        jdc: JsonDeserializationContext
    ): UsersDto {
        val content = je.asJsonObject["content"]
        return Gson().fromJson(content, UsersDto::class.java)
    }
}