package com.topaz.room.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey var id: Int,
    var name: String,
    var salary: Int
)