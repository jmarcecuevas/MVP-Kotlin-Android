package com.luckycode.mvpkotlin.ui.fragment

import com.luckycode.mvpkotlin.R
import com.luckycode.mvpkotlin.common.LuckyFragment
import com.luckycode.mvpkotlin.ui.viewModel.fragment.MainFragmentView


/**
 * Created by marcelocuevas on 12/27/17.
 */

class MainFragment : LuckyFragment(), MainFragmentView {

    override fun init() {

    }

    override fun layout(): Int {
        return R.layout.fragment_main
    }


}