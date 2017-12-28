package com.luckycode.mvpkotlin.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import java.sql.SQLException

/**
 * Created by marcelocuevas on 12/27/17.
 */

class DatabaseHelper(context: Context) : OrmLiteSqliteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(database: SQLiteDatabase, connectionSource: ConnectionSource) {
        try {
            //Create your tables here.
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    override fun onUpgrade(database: SQLiteDatabase, connectionSource: ConnectionSource, oldVersion: Int, newVersion: Int) {
        onCreate(database, connectionSource)
    }

    override fun close() {
        super.close()
    }

    companion object {
        private val DATABASE_NAME = "players.db"
        private val DATABASE_VERSION = 1
    }
}