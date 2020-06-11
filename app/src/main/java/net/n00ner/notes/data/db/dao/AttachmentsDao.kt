package net.n00ner.notes.data.db.dao

import androidx.room.*
import net.n00ner.notes.data.db.entities.NoteAttachment

@Dao
interface AttachmentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAttachment(attachment: NoteAttachment)

    @Delete
    fun delete(attachment: NoteAttachment)

    @Update
    fun update(attachment: NoteAttachment)

    @Query("SELECT * FROM NotesAttachments WHERE noteid = :noteId")
    fun getAttachmentByNoteId(noteId: String): NoteAttachment

    @Query("SELECT * FROM NotesAttachments WHERE attachid = :attachid")
    fun getAttachmentById(attachid: String): NoteAttachment

}