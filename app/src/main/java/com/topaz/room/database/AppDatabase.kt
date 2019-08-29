package com.topaz.room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.topaz.room.data.Employee
import com.topaz.room.data.EmployeeDao

@Database(entities = [Employee::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: EmployeeDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, AppDatabase::class.java, "Employee.db").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}