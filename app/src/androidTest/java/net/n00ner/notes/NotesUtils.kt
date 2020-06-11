package net.n00ner.notes

import net.n00ner.notes.data.db.entities.Note
import java.util.*
import kotlin.collections.ArrayList

class NotesUtils {
    companion object{
        fun getTestNote(): Note {
            return Note( "Test", "text")
        }

        fun getRandomNote(): Note{
            return Note( getRandomString(), getRandomString())
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