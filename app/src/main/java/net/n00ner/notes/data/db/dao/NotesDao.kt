package net.n00ner.notes.data.db.dao

import androidx.room.*
import net.n00ner.notes.data.db.entities.Note

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * From Notes")
    fun getAll(): MutableList<Note>

    @Query("SELECT * FROM Notes WHERE noteid = :noteId")
    fun getNote(noteId: String): Note

   // @Query("")
   // fun getNotesByTitle(title: String): MutableList<Note>
}