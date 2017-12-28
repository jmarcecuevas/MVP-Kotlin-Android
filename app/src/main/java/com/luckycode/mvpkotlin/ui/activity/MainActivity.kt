package com.luckycode.mvpkotlin.ui.activity

import android.os.Bundle
import com.luckycode.mvpkotlin.R
import com.luckycode.mvpkotlin.common.LuckyActivity
import com.luckycode.mvpkotlin.ui.fragment.MainFragment
import com.luckycode.mvpkotlin.ui.viewModel.activity.MainActivityView


class MainActivity : LuckyActivity(), MainActivityView {

    override val layout: Int
        get() = R.layout.activity_main

    override val fragmentLayout: Int
        get() = R.id.fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun init() {

    }

    override fun getFragmentToAdd(): Class<*> {
        return MainFragment::class.java
    }


}
