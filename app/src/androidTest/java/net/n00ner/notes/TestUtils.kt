package net.n00ner.notes

import net.n00ner.notes.data.db.entities.Note
import net.n00ner.notes.data.db.entities.NoteAttachment
import java.util.*
import kotlin.collections.ArrayList

class TestUtils {
    companion object{
        fun getTestNote(): Note {
            return Note( "Test", "text")
        }

        fun getTestAttachment(): NoteAttachment{
            return NoteAttachment("Test", "Test")
        }

        fun getRandomNote(): Note{
            return Note(getRandomString(), getRandomString())
        }

        fun getRandomAttachment(): NoteAttachment{
            return NoteAttachment(getRandomString(), getRandomString())
        }

        fun getNoteList(): ArrayList<Note>{
            val notes = ArrayList<Note>()
            for(i in 0..50){
                notes.add(getRandomNote())
            }
            return notes
        }

        private fun getRandomString(length: Int = Random().nextInt(100)) : String {
            val allowedChars = ('A'..'Z') + ('a'..'z')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }
    }
}