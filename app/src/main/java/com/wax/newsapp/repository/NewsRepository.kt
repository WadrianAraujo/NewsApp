package com.wax.newsapp.repository

import com.wax.newsapp.api.RetrofitInstance
import com.wax.newsapp.database.ArticleDatabase
import com.wax.newsapp.models.Article
import java.util.Locale.IsoCountryCode


class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

    fun getFavoriteNews() = db.getArticleDao().getAllArticles()

}