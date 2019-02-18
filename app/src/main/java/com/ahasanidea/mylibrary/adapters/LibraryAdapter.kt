package com.ahasanidea.mylibrary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahasanidea.mylibrary.R
import com.ahasanidea.mylibrary.data.BookAndLibraryBooks
import kotlinx.android.synthetic.main.list_item_library.view.*

class LibraryAdapter :
    ListAdapter<BookAndLibraryBooks, LibraryAdapter.ViewHolder>(LibraryBookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LibraryAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_library,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libraryItem = getItem(position)
        holder.apply {
            bind(libraryItem)
            itemView.tag = "Library"
        }
    }

    class ViewHolder(private val listItem: View) : RecyclerView.ViewHolder(listItem) {
        fun bind(bookAndLibraryBooks: BookAndLibraryBooks) {
            listItem.tvBookName.text = bookAndLibraryBooks.book.name
            listItem.tvAuthor.text = bookAndLibraryBooks.book.author
        }
    }
}

private class LibraryBookDiffCallback : DiffUtil.ItemCallback<BookAndLibraryBooks>() {

    override fun areItemsTheSame(
        oldItem: BookAndLibraryBooks,
        newItem: BookAndLibraryBooks
    ): Boolean {
        return oldItem.book.bookId == newItem.book.bookId
    }

    override fun areContentsTheSame(
        oldItem: BookAndLibraryBooks,
        newItem: BookAndLibraryBooks
    ): Boolean {
        return oldItem.book == newItem.book
    }
}