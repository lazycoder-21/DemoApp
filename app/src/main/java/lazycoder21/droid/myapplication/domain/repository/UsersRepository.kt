package lazycoder21.droid.myapplication.domain.repository

import lazycoder21.droid.myapplication.domain.modal.Users
import lazycoder21.droid.myapplication.util.Resource

interface UsersRepository {
    suspend fun getUsers(pageNo : Int) : Resource<Users>
}