package com.studyfocusscheduler.app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.studyfocusscheduler.app.data.model.impls.TalkNoteModelImpl
import com.studyfocusscheduler.app.data.vos.FolderVO

abstract class BaseActivity : AppCompatActivity() {

    companion object{
        var selectedFolderId = 0
        var addFolderVo = MutableLiveData<FolderVO>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDb()
    }

    private fun initDb() {
        TalkNoteModelImpl.initDatabase(this)
    }
}