package com.ahasanidea.mylibrary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahasanidea.mylibrary.R
import com.ahasanidea.mylibrary.data.Book
import com.ahasanidea.mylibrary.fragments.BookListFragmentDirections
import kotlinx.android.synthetic.main.list_item_book.view.*


/**
 * Adapter for the [RecyclerView] in [BookListFragment]
 */
class BookAdapter : ListAdapter<Book, BookAdapter.ViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.ViewHolder {
     return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_book,parent,false))
    }

    override fun onBindViewHolder(holder: BookAdapter.ViewHolder, position: Int) {
    val book=getItem(position)
        holder.apply {
            bind(book)
            itemView.tag=book
        }
    }
    class ViewHolder(
        private val item: View
    ) : RecyclerView.ViewHolder(item) {
     fun bind(book: Book){
         item.tvBookName.text=book.name
         item.tvAuthor.text=book.author
         item.setOnClickListener{
            val direction=BookListFragmentDirections.actionBookListFragmentToBookDetailFragment(book.bookId)
             it.findNavController().navigate(direction)
         }
     }
    }
}
private class BookDiffCallback : DiffUtil.ItemCallback<Book>() {

    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.bookId == newItem.bookId
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}