package net.n00ner.notes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.n00ner.notes.data.db.dao.NotesDao
import net.n00ner.notes.data.db.entities.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class NotesDatabase : RoomDatabase(){

    abstract val notesDao: NotesDao
}