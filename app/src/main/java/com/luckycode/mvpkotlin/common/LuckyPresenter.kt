package com.luckycode.mvpkotlin.common

import java.util.ArrayList

/**
 * Created by marcelocuevas on 12/27/17.
 */

class LuckyPresenter<T>(mView: T) {
    protected var view: T? = null
        private set

    init {
        this.view = mView
    }

    fun detachView() {
        view = null
    }
}