package com.studyfocusscheduler.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.studyfocusscheduler.app.R
import com.studyfocusscheduler.app.activities.BaseActivity
import com.studyfocusscheduler.app.activities.MainActivity
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.databinding.FragmentCreateFolderDialogBinding
import com.studyfocusscheduler.app.mvp.presenters.CreateFolderPresenter
import com.studyfocusscheduler.app.mvp.presenters.impls.CreateFolderPresenterImpl
import com.studyfocusscheduler.app.mvp.presenters.impls.MainPresenterImpl
import com.studyfocusscheduler.app.mvp.views.CreateFolderView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateFolderDialog : DialogFragment(),CreateFolderView {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentCreateFolderDialogBinding
    private lateinit var mPresenter: CreateFolderPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateFolderDialogBinding.inflate(LayoutInflater.from(this.context))
        return binding.root
    }

    companion object {

        const val TAG = "Create Folder Dialog"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateFolderDialog().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        binding.btnPositive.setOnClickListener {
            mPresenter.onAddClicked(binding.etFolderName.text.toString())
        }
        binding.btnNegative.setOnClickListener {
            mPresenter.onCancelClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun cancelDialog() {
        dismiss()
    }

    override fun addFolder() {
        dismiss()

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateFolderPresenterImpl::class.java]
        mPresenter.initPresenter(this)
    }

}