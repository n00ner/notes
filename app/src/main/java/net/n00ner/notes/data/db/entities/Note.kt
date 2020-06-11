package net.n00ner.notes.data.db.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Notes")
data class Note (
    @PrimaryKey
    @ColumnInfo(name = "noteid")
    var noteId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "text")
    var text: String
) {
    constructor(title: String, text: String) : this(UUID.randomUUID().toString(), title, text)
}