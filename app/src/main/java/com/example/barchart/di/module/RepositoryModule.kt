package com.example.barchart.di.module

import com.example.barchart.data.githubreposlist.repository.GithubListRepositoryImpl
import com.example.barchart.domain.githubreposlist.repository.GithubListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
     @Binds
     @Singleton
     abstract fun bindRepository(repository: GithubListRepositoryImpl): GithubListRepository
}