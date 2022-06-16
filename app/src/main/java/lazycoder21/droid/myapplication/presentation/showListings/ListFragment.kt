package lazycoder21.droid.myapplication.presentation.showListings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import lazycoder21.droid.myapplication.MainActivity
import lazycoder21.droid.myapplication.R
import lazycoder21.droid.myapplication.domain.modal.Data
import lazycoder21.droid.myapplication.util.Resource

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        UsersAdapter(::onItemClick)
    }
    private lateinit var progressbar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        progressbar = view.findViewById(R.id.progress_circular)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initObservers()
        viewModel.getUsersList(page = 0)
    }

    private fun onItemClick(data: Data) {
        (activity as? MainActivity)?.goToDetail(data)
    }

    private fun initObservers() {
        viewModel.userListLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    progressbar.visibility = View.GONE
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> progressbar.visibility = View.VISIBLE
                is Resource.Success -> {
                    progressbar.visibility = View.GONE
                    adapter.addItems(it.data.data)
                }
            }
        }
    }

    private fun initRecyclerView() {
        view?.findViewById<RecyclerView>(R.id.recycler_view_users)?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ListFragment.adapter
        }
    }


}