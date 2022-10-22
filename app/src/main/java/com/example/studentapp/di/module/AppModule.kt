package com.example.studentapp.di.module

import android.content.Context
import androidx.room.Room
import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.daos.SubjectDao
import com.example.studentapp.data.daos.TestDao
import com.example.studentapp.data.daos.AppDatabase
import com.example.studentapp.ui.addStudent.AddStudentRepository
import com.example.studentapp.ui.addStudent.AddStudentRepositoryImpl
import com.example.studentapp.ui.home.HomeRepository
import com.example.studentapp.ui.home.HomeRepositoryImpl
import com.example.studentapp.ui.search.SearchRepository
import com.example.studentapp.ui.search.SearchRepositoryImpl
import com.example.studentapp.ui.subject.SubjectRepository
import com.example.studentapp.ui.subject.SubjectRepositoryImpl
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
    fun provideSearchRepository(studentDao: StudentDao): SearchRepository = SearchRepositoryImpl(studentDao)

    @Singleton
    @Provides
    fun provideAddStudentRepository(studentDao: StudentDao): AddStudentRepository = AddStudentRepositoryImpl(studentDao)

    @Singleton
    @Provides
    fun provideSubjectRepository(subjectDao: SubjectDao, testDao: TestDao, studentDao: StudentDao): SubjectRepository = SubjectRepositoryImpl(subjectDao, testDao, studentDao)

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