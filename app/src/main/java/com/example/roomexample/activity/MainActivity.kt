package com.example.roomexample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.RoomDatabase
import com.example.roomexample.R
import com.example.roomexample.database.AppDatabase
import com.example.roomexample.database.entity.Product
import com.example.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        appDatabase = AppDatabase.getInstance(this)

        binding.apply {
            saveBtn.setOnClickListener {
                val product = Product(
                    name = nameEt.text.toString(),
                    price = priceEt.text.toString().toInt()
                )

                appDatabase.productDao().insertProduct(product)
            }

            getAllProductBtn.setOnClickListener {
                Log.d("@@@Products", appDatabase.productDao().getAllProduct().toString())
            }

            deleteBtn.setOnClickListener {
                appDatabase.productDao().removeProduct(5)
            }

            deleteAllBtn.setOnClickListener {
                appDatabase.productDao().clearProduct()
            }
        }
    }
}