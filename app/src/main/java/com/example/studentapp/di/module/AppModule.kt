package com.example.studentapp.di.module

import android.content.Context
import androidx.room.Room
import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.daos.SubjectDao
import com.example.studentapp.data.daos.TestDao
import com.example.studentapp.data.daos.AppDatabase
import com.example.studentapp.repository.*
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
    fun provideSearchRepository(studentDao: StudentDao):SearchRepository = SearchRepositoryImpl(studentDao)

    @Singleton
    @Provides
    fun provideAddStudentRepository(studentDao: StudentDao): AddStudentRepository = AddStudentRepositoryImpl(studentDao)

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