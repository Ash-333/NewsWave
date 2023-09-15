package com.ashish.newswave.model

import com.google.gson.annotations.SerializedName

data class NewsItem(

	@field:SerializedName("img_url")
	val imgUrl: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
