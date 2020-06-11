package net.n00ner.notes.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesAttachments")
data class NoteAttachment(
    @PrimaryKey
    @ColumnInfo(name = "attachid")
    var attachId: String?,

    @ColumnInfo(name = "attachuri")
    var attachUri: String?
)