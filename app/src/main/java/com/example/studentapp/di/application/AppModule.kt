package com.example.studentapp.di.application

import android.content.Context
import androidx.room.Room
import com.example.studentapp.daos.StudentDao
import com.example.studentapp.daos.SubjectDao
import com.example.studentapp.daos.TestDao
import com.example.studentapp.repository.HomeRepository
import com.example.studentapp.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "student.db"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideMainRepository(subjectDao: SubjectDao): HomeRepository = HomeRepositoryImpl(subjectDao)

    @Singleton
    @Provides
    fun provideSubjectDao(appDatabase: AppDatabase): SubjectDao = appDatabase.subjectDao()

    @Singleton
    @Provides
    fun provideStudentDao(appDatabase: AppDatabase): StudentDao = appDatabase.studentDao()

    @Singleton
    @Provides
    fun provideTestDao(appDatabase: AppDatabase): TestDao = appDatabase.testDao()


}