package com.studyfocusscheduler.app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folder")
data class FolderVO(
    @PrimaryKey(autoGenerate = true)
    val folderId: Int = 0,
    val name: String,
    val color: Int
)