package com.ahasanidea.mylibrary.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.ahasanidea.mylibrary.R
import com.ahasanidea.mylibrary.data.Book
import com.ahasanidea.mylibrary.fragments.BookDetailFragmentArgs.fromBundle
import com.ahasanidea.mylibrary.utils.InjectorUtils
import com.ahasanidea.mylibrary.viewmodels.BookDetailViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_book_detail.*

/**
 * A simple [Fragment] subclass.
 *
 */
class BookDetailFragment : Fragment() {

    private lateinit var viewModel: BookDetailViewModel
    private val bookId by lazy {
        fromBundle(arguments!!).bookId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = InjectorUtils.provideBookDetailViewModelFactory(requireContext(), bookId)
        viewModel = ViewModelProviders.of(this, factory).get(BookDetailViewModel::class.java)
        viewModel.book.observe(this, Observer { book ->
            book?.let { render(book) } ?: renderBookNotFound()
        })
        fab.setOnClickListener{
            viewModel.addBookToLibrary()
            Snackbar.make(it,"Added book into library",Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun renderBookNotFound() {
     view?.let {
         Snackbar.make(it,"Error",Snackbar.LENGTH_SHORT).show()
     }
    }

    private fun render(book: Book) {
        tvAuthor.text = book.author
        tvBookText.text = book.text
    }


}
