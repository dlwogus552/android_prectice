package org.ljh.databaseapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelpe(context:Context):SQLiteOpenHelper(context, "testdb",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql="""
            create table todo_tb(
            _id integer primary key autoincrement,
            name text not null,
            phone text)
        """.trimIndent()
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}