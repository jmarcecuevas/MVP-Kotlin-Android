package com.luckycode.mvpkotlin.common

import android.app.Application
import android.content.Context
import com.luckycode.mvpkotlin.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * Created by marcelocuevas on 12/27/17.
 */

class LuckyCodeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Seravek-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }

    companion object {
        fun getApp(context: Context): LuckyCodeApp {
            return context.applicationContext as LuckyCodeApp
        }
    }

}