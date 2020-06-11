package net.n00ner.notes.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import net.n00ner.notes.data.db.NotesDatabase
import net.n00ner.notes.data.db.dao.NotesDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getNotesDatabase(context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java, "notes_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideNotesDao(db: NotesDatabase):  NotesDao{
        return db.notesDao
    }

}