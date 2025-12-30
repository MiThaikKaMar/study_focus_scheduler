package com.studyfocusscheduler.app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.studyfocusscheduler.app.R
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.databinding.ActivityViewNoteBinding
import com.studyfocusscheduler.app.mvp.presenters.ViewNotePresenter
import com.studyfocusscheduler.app.mvp.presenters.impls.ViewNotePresenterImpl
import com.studyfocusscheduler.app.mvp.views.ViewNoteView
import com.studyfocusscheduler.app.utils.Utils

class ViewNoteActivity : BaseActivity(),ViewNoteView {

    private lateinit var mPresenter: ViewNotePresenter
    private lateinit var binding: ActivityViewNoteBinding


    companion object{

        const val NOTE = "NOTE"

        fun newIntent(context: Context,noteVo:NoteVO): Intent {
            val intent = Intent(context,ViewNoteActivity::class.java)
            intent.putExtra(NOTE,noteVo)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val noteVo = Utils().getSerializable(this,NOTE,NoteVO::class.java)
        setUpPresenter()
        mPresenter.onUiReady(this,this,noteVo)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ViewNotePresenterImpl::class.java]
        mPresenter.initPresenter(this)
    }

    override fun displayNoteInfo(noteVO: NoteVO) {
        binding.tvViewNoteTitle.text = noteVO.title
        binding.tvViewNoteContent.text = noteVO.content
    }
}