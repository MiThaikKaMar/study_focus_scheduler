package com.studyfocusscheduler.app.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.studyfocusscheduler.app.R
import com.studyfocusscheduler.app.adapters.FolderAdapter
import com.studyfocusscheduler.app.adapters.NoteAdapter
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.databinding.ActivityMainBinding
import com.studyfocusscheduler.app.delegates.TalkNoteDelegate
import com.studyfocusscheduler.app.fragments.CreateFolderDialog
import com.studyfocusscheduler.app.mvp.presenters.MainPresenter
import com.studyfocusscheduler.app.mvp.presenters.impls.MainPresenterImpl
import com.studyfocusscheduler.app.mvp.views.MainView

class MainActivity : BaseActivity() ,MainView{

    private lateinit var mPresenter: MainPresenter
    private lateinit var mFolderAdapter: FolderAdapter
    private lateinit var mNoteAdapter : NoteAdapter

    private val SHAREDPREF_NAME = "TalkNotes"
    private val SHAREDPREF_NIGHT_MODE = "night"


    private lateinit var binding: ActivityMainBinding

    private var nightMode :Boolean = false

    private var editor :SharedPreferences.Editor? = null

    private var sharedPreferences :SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpPresenter()
        initView()
        setUpRecyclerView()
        setUpModeSwitch()
        setUpActionListener()
        mPresenter.onUiReady(this,this)

    }

    private fun setUpActionListener() {
        binding.btnAddNote.setOnClickListener {
            mPresenter.onAddNoteClicked()
        }

        binding.btnNewFolder.setOnClickListener {
            mPresenter.onAddFolderClicked()
        }
    }

    private fun setUpPresenter() {
            mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
            mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {

        mFolderAdapter = FolderAdapter(this,mPresenter)
       // val gridLayoutManager = GridLayoutManager(this, 2)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFolder.adapter = mFolderAdapter
        binding.rvFolder.layoutManager = linearLayoutManager

        mNoteAdapter = NoteAdapter(mPresenter)
        val linearLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNote.adapter = mNoteAdapter
        binding.rvNote.layoutManager = linearLayoutManager1
    }



    private fun initView(){

        sharedPreferences = getSharedPreferences(SHAREDPREF_NAME,Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()

        nightMode = sharedPreferences?.getBoolean(SHAREDPREF_NIGHT_MODE,false)!!
        if(nightMode){
            binding.modeSwitch.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun setUpModeSwitch() {
        binding.modeSwitch.setOnCheckedChangeListener { compoundButton, state ->
            Log.e("switch state", state.toString())
            mPresenter.onModeSwitchClicked(state)
        }
    }

    private fun nightModeOff(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        editor?.putBoolean(SHAREDPREF_NIGHT_MODE,false)

    }

    private fun nightModeOn(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        editor?.putBoolean(SHAREDPREF_NIGHT_MODE,true)
    }

    override fun setNightModeChecked(checked: Boolean) {
        if(checked){
            nightModeOn()
        }else{
            nightModeOff()
        }
        editor?.apply()
    }

    override fun navToAddNote() {
startActivity(AddNoteActivity.newIntent(this, selectedFolderId) )
    }

    override fun showFolderList(list: List<FolderVO>) {
mFolderAdapter.setData(list.toMutableList())
    }

    override fun showCreateFolderDialog() {
        CreateFolderDialog().show(supportFragmentManager, CreateFolderDialog.TAG)
    }

    override fun showNotesInFolder(folderVO: FolderVO, noteList: List<NoteVO>) {
        selectedFolderId = folderVO.folderId
        binding.tvFolderName.text = folderVO.name
        mNoteAdapter.setData(noteList.toMutableList())

    }

    override fun navToViewNote(noteVO: NoteVO) {
        startActivity(ViewNoteActivity.newIntent(this,noteVO))
    }


}