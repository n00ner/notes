package net.n00ner.notes

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import net.n00ner.notes.data.db.NotesDatabase
import net.n00ner.notes.data.db.dao.NotesDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class NotesDatabaseCRUDTest {
    private lateinit var notesDao: NotesDao
    private lateinit var db: NotesDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NotesDatabase::class.java).build()
        notesDao = db.notesDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeNoteAndReadNote(){
        val oldNote = TestUtils.getTestNote()
        notesDao.insertNote(oldNote)
        val note = notesDao.getNote(oldNote.noteId)
        assert(oldNote == note)
    }

    @Test
    fun generateNoteIdTest(){
        val note = TestUtils.getTestNote()
        val anotherNote = TestUtils.getTestNote()
        notesDao.insertNote(note)
        notesDao.insertNote(anotherNote)
        assert(notesDao.getNote(note.noteId) != notesDao.getNote(anotherNote.noteId))
    }

    @Test
    fun updateNoteTest(){
        val note = TestUtils.getTestNote()
        val title = "My Favorite Animals"
        notesDao.insertNote(note)
        note.title = title
        notesDao.update(note)
        assert(notesDao.getNote(note.noteId).title == title)
    }

    @Test
    fun deleteNoteTest(){
        val note = TestUtils.getTestNote()
        notesDao.insertNote(note)
        if(notesDao.getAll().size == 0){
            assert(false)
        }else{
            notesDao.delete(note)
            assert(notesDao.getAll().size == 0)
        }
    }

    @Test
    fun getAllNotesTest(){
        TestUtils.getNoteList().forEach {
            notesDao.insertNote(it)
        }
        val notes = notesDao.getAll()
        assert(notes.size > 0)
    }

    @Test
    fun getNoteTest(){
        val notes = TestUtils.getNoteList()
        notes.forEach {
            notesDao.insertNote(it)
        }
        val note = notesDao.getNote(notes.get(7).noteId)
        assert(note == notes.get(7))
    }
}