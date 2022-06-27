package lazycoder21.droid.myapplication.data.remote

import lazycoder21.droid.myapplication.data.remote.dto.UsersDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("users")
    suspend fun getUsers(@Query(PAGE) page: String): Response<UsersDto>

    companion object {
        const val BASE_URL = "https://reqres.in/api/"
        private const val PAGE = "page"
    }
}