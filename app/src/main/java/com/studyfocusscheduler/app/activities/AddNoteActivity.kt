package com.studyfocusscheduler.app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.databinding.ActivityAddNoteBinding
import com.studyfocusscheduler.app.mvp.presenters.AddNotePresenter
import com.studyfocusscheduler.app.mvp.presenters.impls.AddNotePresenterImpl
import com.studyfocusscheduler.app.mvp.views.AddNoteView

class AddNoteActivity : BaseActivity(),AddNoteView{

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var mPresenter: AddNotePresenter

    private var folderId = 0

    companion object{
        const val FOLDER_ID ="FOLDER_ID"
        fun newIntent(context: Context,folderId:Int): Intent {
             val intent = Intent(context, AddNoteActivity::class.java)
            intent.putExtra(FOLDER_ID,folderId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpPresenter()
        setUpActionListener()
        mPresenter.onUiReady(this,this)

    }

    private fun setUpActionListener() {
        binding.btnSaveNote.setOnClickListener {
            val saveNoteVo = NoteVO(0,binding.etNoteTitle.text.toString(),binding.etNoteContent.text.toString(),System.currentTimeMillis(),folderId)
            mPresenter.onClickedSave(saveNoteVo)
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[AddNotePresenterImpl::class.java]
        mPresenter.initPresenter(this)
    }

    override fun initView() {
        folderId = intent.getIntExtra(FOLDER_ID,0)
    }

    override fun closeAddNoteScreen() {
        finish()
    }

}