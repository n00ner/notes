package net.n00ner.notes

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import net.n00ner.notes.data.db.AttachmentsDatabase
import net.n00ner.notes.data.db.dao.AttachmentsDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class AttachmentsDatabaseCRUDTest {
    private lateinit var attachmentsDao: AttachmentsDao
    private lateinit var db: AttachmentsDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AttachmentsDatabase::class.java).build()
        attachmentsDao = db.attachmentsDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadAttachmentTest(){
        val oldAttachment = TestUtils.getRandomAttachment()
        attachmentsDao.insertAttachment(oldAttachment)
        val attachment = attachmentsDao.getAttachmentById(oldAttachment.attachId)
        val noteAttachment = attachmentsDao.getAttachmentByNoteId(oldAttachment.noteId)
        assert(oldAttachment != attachment)
    }
}