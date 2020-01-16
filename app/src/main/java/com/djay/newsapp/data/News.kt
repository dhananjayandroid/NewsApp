package com.djay.newsapp.data

import java.io.Serializable

/**
 * Data class for News
 */
data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

/**
 * Data class for Article implements Serializable
 */
data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Serializable

/**
 * Data class for Source
 */
data class Source(
    val id: String,
    val name: String
) : Serializable