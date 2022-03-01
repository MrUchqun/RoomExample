package com.example.roomexample.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
open class Product(

    @PrimaryKey(autoGenerate = true)
    var productId: Int? = null,
    var name: String,
    var price: Int
) {
    override fun toString(): String {
        return "Product(productId=$productId, name='$name', price=$price)"
    }
}