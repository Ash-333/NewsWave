package com.ashish.newswave.model

data class Article(
	val articles: List<ArticlesItem?>? = null
)

data class ArticlesItem(
	val urlMobile: String? = null,
	val socialimage: String? = null,
	val domain: String? = null,
	val seendate: String? = null,
	val language: String? = null,
	val sourcecountry: String? = null,
	val title: String? = null,
	val url: String? = null
)

