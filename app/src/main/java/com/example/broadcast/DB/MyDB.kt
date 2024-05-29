package com.example.broadcast.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDB(context: Context) : SQLiteOpenHelper(context,"Users",null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Users (id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT, password TEXT)")
        db?.execSQL("INSERT INTO Users(email, password) values ('longvu@gmail.com','123456')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}