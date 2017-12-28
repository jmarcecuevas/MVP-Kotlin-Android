package com.luckycode.mvpkotlin.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by marcelocuevas on 12/27/17.
 */

abstract class LuckyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(layout(), container, false)
        init()
        return v
    }

    protected abstract fun layout(): Int

    protected abstract fun init()


}