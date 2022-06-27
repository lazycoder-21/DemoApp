package lazycoder21.droid.myapplication.presentation.detailScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import lazycoder21.droid.myapplication.R
import lazycoder21.droid.myapplication.domain.modal.Data
import lazycoder21.droid.myapplication.presentation.SharedViewModel
import lazycoder21.droid.myapplication.util.loadImage

const val ARG_DATA = "data"

class UserDetailFragment : Fragment() {

    private val sharedViewModel by lazy {
        ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = sharedViewModel.dataToDetail

        view.findViewById<TextView>(R.id.userName)?.text = data?.firstName ?: ""
        data?.avatar?.let { view.findViewById<ImageView>(R.id.ivUser)?.loadImage(it) }
    }

}