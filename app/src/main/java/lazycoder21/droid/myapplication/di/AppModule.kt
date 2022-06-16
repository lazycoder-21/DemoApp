package lazycoder21.droid.myapplication.di

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lazycoder21.droid.myapplication.data.remote.MyApi
import lazycoder21.droid.myapplication.data.remote.dto.UsersDto
import lazycoder21.droid.myapplication.data.repository.UserRepositoryImpl
import lazycoder21.droid.myapplication.domain.repository.UsersRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
    fun provideMyApi(): MyApi =
        Retrofit.Builder()
            .baseUrl(MyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
}