package com.ahasanidea.mylibrary.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.ahasanidea.mylibrary.R
import com.ahasanidea.mylibrary.adapters.BookAdapter
import com.ahasanidea.mylibrary.utils.InjectorUtils
import com.ahasanidea.mylibrary.viewmodels.BookListViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*


/**
 * This is book list fragment.
 *
 */
class BookListFragment : Fragment() {

    private lateinit var viewModel:BookListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory=InjectorUtils.provideBookListViewModelFactory(context!!)
        viewModel=ViewModelProviders.of(this,factory).get(BookListViewModel::class.java)
        val adapter=BookAdapter()
        booksRecyclerView.layoutManager=LinearLayoutManager(this.context)
        booksRecyclerView.adapter=adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: BookAdapter) {
        viewModel.getBooks().observe(viewLifecycleOwner, Observer { books->
            if(books!=null)
                adapter.submitList(books)
        })
    }


}
