package com.djay.newsapp.view.newsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.djay.newsapp.data.Article
import com.djay.newsapp.databinding.RowItemBinding

/**
 * RecyclerView adapter class for News list
 */
class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.MViewHolder>() {

    var articles: List<Article> = emptyList()
    var onItemClick: ((Article) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        return MViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.onBind(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun update(data: List<Article>) {
        articles = data
        notifyDataSetChanged()
    }

    /**
     * ViewHolder class for news list item
     */
    inner class MViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        internal fun onBind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(articles[adapterPosition])
            }
        }
    }
}