package net.n00ner.notes.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "NotesAttachments")
data class NoteAttachment(
    @PrimaryKey
    @ColumnInfo(name = "attachid")
    var attachId: String,

    @ColumnInfo(name = "noteid")
    var noteId: String,

    @ColumnInfo(name = "attachuri")
    var attachUri: String
) {
    constructor(noteId: String, attachUri: String) : this(UUID.randomUUID().toString(), noteId, attachUri)
}