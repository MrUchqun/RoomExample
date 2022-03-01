package com.example.roomexample.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomexample.database.entity.Product


@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<Product>

    @Query("DELETE FROM product")
    fun clearProduct()

    @Query("DELETE FROM product WHERE productId=:productId")
    fun removeProduct(productId: Int)

    @Query("UPDATE product SET price=:price WHERE productId=:productId")
    fun updateProduct(productId: Int, price: Int)
}