package lazycoder21.droid.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import lazycoder21.droid.myapplication.domain.modal.Data
import lazycoder21.droid.myapplication.presentation.SharedViewModel
import lazycoder21.droid.myapplication.presentation.detailScreen.ARG_DATA
import lazycoder21.droid.myapplication.presentation.detailScreen.UserDetailFragment
import lazycoder21.droid.myapplication.presentation.showListings.ListFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val listFragment = ListFragment()
    private val detailFragment = UserDetailFragment()
    private val sharedViewModel by lazy {
        ViewModelProvider(this)[SharedViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gotoListingsFragment()

    }

    private fun gotoListingsFragment() {
        addFragment(listFragment)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    fun goToDetail(data: Data) {
        sharedViewModel.dataToDetail = data
        addFragment(detailFragment)
    }
}