package com.studyfocusscheduler.app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.studyfocusscheduler.app.data.vos.FolderVO

@Dao
interface FolderDao {
    @Insert
    fun insertFolder(folder: FolderVO)

    @Query("SELECT * FROM folder")
    fun getLiveFolders(): LiveData<List<FolderVO>>

    @Query("SELECT * FROM folder")
    fun getFolders(): List<FolderVO>

    @Query("DELETE FROM folder WHERE folderId = :folderId")
    fun deleteFolder(folderId: Int)

    @Query("SELECT COUNT(*) FROM folder")
    fun getFolderCount(): LiveData<Int>
}