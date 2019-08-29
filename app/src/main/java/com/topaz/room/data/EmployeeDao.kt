package com.topaz.room.data

import android.arch.persistence.room.*

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id: Int): Employee

    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(employee: Employee)

    @Delete
    fun delete(employee: Employee)
}