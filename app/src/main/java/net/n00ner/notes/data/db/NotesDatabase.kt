package net.n00ner.notes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.n00ner.notes.data.db.dao.NotesDao
import net.n00ner.notes.data.db.entities.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class NotesDatabase : RoomDatabase(){

    companion object {
        var INSTANCE: NotesDatabase? = null

        fun getAppDataBase(context: Context): NotesDatabase? {
            if (INSTANCE == null){
                synchronized(NotesDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, NotesDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

    abstract val notesDao: NotesDao
}