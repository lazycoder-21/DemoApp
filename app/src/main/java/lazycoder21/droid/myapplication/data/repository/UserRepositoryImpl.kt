package lazycoder21.droid.myapplication.data.repository

import lazycoder21.droid.myapplication.data.remote.MyApi
import lazycoder21.droid.myapplication.domain.mapper.UserMapper.mapToUsers
import lazycoder21.droid.myapplication.domain.modal.Users
import lazycoder21.droid.myapplication.domain.repository.UsersRepository
import lazycoder21.droid.myapplication.util.Resource
import retrofit2.HttpException

class UserRepositoryImpl(
    private val api: MyApi
) : UsersRepository {

    override suspend fun getUsers(pageNo: Int): Resource<Users> {
        try {
            val users = api.getUsers(page = pageNo.toString())
            if (users.isSuccessful && users.body() != null) {
                return Resource.Success(users.body()!!.mapToUsers())
            } else {
                return Resource.Error(message = "No data found")
            }
        } catch (e: HttpException) {
            return Resource.Error("Internet connection issue")
        } catch (e: Exception) {
            return Resource.Error("unkown error")
        }
    }
}