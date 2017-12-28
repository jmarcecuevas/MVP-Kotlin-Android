package com.luckycode.mvpkotlin.common

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.j256.ormlite.android.apptools.OpenHelperManager
import com.luckycode.mvpkotlin.R
import com.luckycode.mvpkotlin.utils.DatabaseHelper
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by marcelocuevas on 12/27/17.
 */
abstract class LuckyActivity : AppCompatActivity(){
    protected var dbHelper: DatabaseHelper? = null
    protected abstract val layout: Int
    protected abstract val fragmentLayout: Int

    val helper: DatabaseHelper?
        get() {
            if (dbHelper == null) {
                dbHelper = OpenHelperManager.getHelper(applicationContext, DatabaseHelper::class.java)
            }
            return dbHelper
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(layout)
        addFragmentWithBackStack(getFragmentToAdd(), false);
        init()
    }

    abstract fun getFragmentToAdd(): Class<*>

    protected abstract fun init()


    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun addFragmentWithBackStack(myNewFragmentClass: Class<*>, withBackstack: Boolean?): Fragment {
        val myNewFragment = Fragment.instantiate(applicationContext, myNewFragmentClass.name)
        val newFragment = myNewFragment.javaClass.name
        val t = supportFragmentManager.beginTransaction()
        if (withBackstack!!) {
            t.setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
            t.addToBackStack(newFragment)
        }
        t.add(fragmentLayout, myNewFragment, newFragment)
        t.commit()
        return myNewFragment
    }

    fun replaceFragmentWithBackStack(myNewFragmentClass: Class<*>, withBackstack: Boolean?): Fragment {
        val myNewFragment = Fragment.instantiate(applicationContext, myNewFragmentClass.name)
        val newFragment = myNewFragment.javaClass.name
        val t = supportFragmentManager.beginTransaction()
        if (withBackstack!!) {
            t.setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
            t.addToBackStack(newFragment)
        }
        t.replace(fragmentLayout, myNewFragment, newFragment)
        t.commit()
        return myNewFragment
    }

    fun replaceFragmentWithBackStackAnimation(myNewFragmentClass: Class<*>, withBackstack: Boolean?): Fragment {
        val myNewFragment = Fragment.instantiate(applicationContext, myNewFragmentClass.name)
        val newFragment = myNewFragment.javaClass.name
        val t = supportFragmentManager.beginTransaction()
        t.setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
        if (withBackstack!!) {
            t.addToBackStack(newFragment)
        }
        t.replace(fragmentLayout, myNewFragment, newFragment)
        t.commit()
        return myNewFragment
    }

    override fun onDestroy() {
        super.onDestroy()
        if (dbHelper != null) {
            OpenHelperManager.releaseHelper()
            dbHelper = null
        }
    }
}