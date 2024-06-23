package com.example.noteapp.di


import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.NoteDao
import com.example.noteapp.data.NoteDataBase
import com.example.noteapp.data.NoteRepository
import com.example.noteapp.data.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Module are use to add binding to hilt:Meaning to tell hilt how to provide instances of different type
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase): NoteDao {
        return noteDataBase.noteDao
    }

    @Singleton
    @Provides

    fun provideNoteDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            name = "my_data_base"
        ).build()


    @Singleton
    @Provides
    fun provideNoteRepositoryImpl(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)

    }
}
