package lazycoder21.droid.myapplication.presentation.showListings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lazycoder21.droid.myapplication.domain.modal.Users
import lazycoder21.droid.myapplication.domain.use_case.GetUserUseCase
import lazycoder21.droid.myapplication.util.Resource
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: GetUserUseCase
) : ViewModel() {

    private val _userListLiveData = MutableLiveData<Resource<Users>>()
    val userListLiveData: LiveData<Resource<Users>> get() = _userListLiveData

    fun getUsersList(page: Int) {
        viewModelScope.launch {
            _userListLiveData.value = Resource.Loading()
            val users = useCase.getUser(pageNo = page)
            _userListLiveData.value = users
        }
    }

}