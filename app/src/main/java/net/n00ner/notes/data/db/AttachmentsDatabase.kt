package net.n00ner.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import net.n00ner.notes.data.db.dao.AttachmentsDao
import net.n00ner.notes.data.db.entities.NoteAttachment

@Database(entities = [NoteAttachment::class], version = 2, exportSchema = false)
abstract class AttachmentsDatabase : RoomDatabase(){

    abstract val attachmentsDao: AttachmentsDao
}