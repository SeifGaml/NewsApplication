package com.example.newsapplication.di

import android.app.Application
import androidx.room.Room
import com.example.newsapplication.Constants.BASE_URL
import com.example.newsapplication.Constants.NEWS_DATA_BASE_NAME
import com.example.newsapplication.data.local.NewsDao
import com.example.newsapplication.data.local.NewsDatabase
import com.example.newsapplication.data.local.NewsTypeConverter
import com.example.newsapplication.data.manger.LocalUserMangerImp
import com.example.newsapplication.data.remote.dto.NewsApi
import com.example.newsapplication.data.repository.NewsRepositoryImpl
import com.example.newsapplication.domain.manger.LocalUserManger
import com.example.newsapplication.domain.repository.NewsRepository
import com.example.newsapplication.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsapplication.domain.usecases.app_entry.ReadAppEntry
import com.example.newsapplication.domain.usecases.app_entry.SaveAppEntry
import com.example.newsapplication.domain.usecases.news.DeleteArticle
import com.example.newsapplication.domain.usecases.news.GetNews
import com.example.newsapplication.domain.usecases.news.NewsUseCases
import com.example.newsapplication.domain.usecases.news.SearchNews
import com.example.newsapplication.domain.usecases.news.GetArticles
import com.example.newsapplication.domain.usecases.news.UpsertArticle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProvideLocalUserManger(
        application: Application

    ):LocalUserManger = LocalUserMangerImp(application)

    @Provides
    @Singleton
    fun ProvideAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        ReadAppEntry(localUserManger),
        SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun ProvideNewsApp():NewsApi{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun ProvideNewsRepository(
        newsApi: NewsApi
    ):NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun ProvideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ):NewsUseCases{
        return NewsUseCases(getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getArticles = GetArticles(newsDao),

        )
    }
    @Provides
    @Singleton
    fun ProvideNewsDAtabase(
        application: Application
    ):NewsDatabase {
        return  Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATA_BASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun ProvideNewsDao(
        newsDatabase: NewsDatabase
    ):NewsDao =newsDatabase.newsDao

}