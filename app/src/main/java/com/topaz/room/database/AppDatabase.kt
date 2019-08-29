package com.topaz.room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.topaz.room.data.Employee
import com.topaz.room.data.EmployeeDao

@Database(entities = [Employee::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: EmployeeDao
}