package lazycoder21.droid.myapplication.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lazycoder21.droid.myapplication.domain.modal.Users
import lazycoder21.droid.myapplication.domain.repository.UsersRepository
import lazycoder21.droid.myapplication.util.Resource
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    suspend fun getUser(pageNo: Int = 0): Resource<Users> {
        return repository.getUsers(pageNo)
    }
}