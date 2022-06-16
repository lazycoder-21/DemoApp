package lazycoder21.droid.myapplication.presentation

import androidx.lifecycle.ViewModel
import lazycoder21.droid.myapplication.domain.modal.Data

class SharedViewModel : ViewModel() {
    var dataToDetail: Data? = null
}