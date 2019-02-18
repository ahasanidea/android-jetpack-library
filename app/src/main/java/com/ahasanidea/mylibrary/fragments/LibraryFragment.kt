package com.ahasanidea.mylibrary.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.ahasanidea.mylibrary.R
import com.ahasanidea.mylibrary.adapters.LibraryAdapter
import com.ahasanidea.mylibrary.utils.InjectorUtils
import com.ahasanidea.mylibrary.viewmodels.LibraryBookListViewModel
import kotlinx.android.synthetic.main.fragment_library.*


/**
 * A simple [Fragment] subclass.
 *
 */
class LibraryFragment : Fragment() {

    private lateinit var viewModel: LibraryBookListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = InjectorUtils.provideLibraryBookListViewModelFactory(requireContext())
        viewModel = ViewModelProviders.of(this, factory)
            .get(LibraryBookListViewModel::class.java)

        val adapter=LibraryAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this.context)
        recyclerView.adapter=adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: LibraryAdapter) {

        viewModel.bookAndLibraryBooks.observe(viewLifecycleOwner, Observer { libraryBooks->
            if (libraryBooks!=null)
                adapter.submitList(libraryBooks)
        })



    }


}
