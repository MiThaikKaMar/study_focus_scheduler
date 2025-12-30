package com.studyfocusscheduler.app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.studyfocusscheduler.app.data.vos.NoteVO

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: NoteVO)

    @Query("SELECT * FROM note WHERE folderId = :folderId")
    fun getLiveNotes(folderId: Int): LiveData<List<NoteVO>>

    @Query("SELECT * FROM note WHERE folderId = :folderId")
    fun getNotes(folderId: Int):List<NoteVO>

    @Query("SELECT COUNT(*) FROM note WHERE folderId = :folderId")
    fun getNoteCountInFolder(folderId: Int): LiveData<Int>

    @Query("SELECT * FROM note WHERE noteId = :noteId")
    fun getNoteById(noteId: Int): NoteVO?

    @Update
    fun updateNoteContent(note: NoteVO)

    @Query("UPDATE note SET folderId = :folderId WHERE noteId = :noteId")
    fun updateNoteFolder(noteId: Int, folderId: Int)

    @Delete
    fun deleteNote(note: NoteVO)
}