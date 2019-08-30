package com.topaz.room

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.topaz.room.data.Employee
import com.topaz.room.database.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getInstance(this)
        val dao = db.dao
        dao.insert(Employee(5, "Art", 555))

        CoroutineScope(Dispatchers.Default).launch {
            dao.getAll().observe(this@MainActivity, object : Observer<List<Employee>> {
                override fun onChanged(t: List<Employee>?) {
                    text_view.text = t?.size.toString()
                }

            })
        }
    }
}
