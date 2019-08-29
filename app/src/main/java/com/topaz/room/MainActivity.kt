package com.topaz.room

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.topaz.room.data.Employee
import com.topaz.room.database.AppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java,
            "Employee.db"
        ).allowMainThreadQueries().build()
        val dao = db.dao
        dao.insert(Employee(1, "Art", 555))

        val data = dao.getAll()
        data.forEach {
            Log.d("MYDB", "${it.id} ${it.name} ${it.salary}")
        }
    }
}
