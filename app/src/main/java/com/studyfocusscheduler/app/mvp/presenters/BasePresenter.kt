package com.studyfocusscheduler.app.mvp.presenters

import com.studyfocusscheduler.app.mvp.views.BaseView

interface BasePresenter<T:BaseView> {

    fun initPresenter(view:T)
}