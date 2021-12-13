package com.amrilhs.italiaseria.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amrilhs.italiaseria.core.data.source.local.entity.ItaliaSeriaEntity

@Database(entities = [ItaliaSeriaEntity::class], version = 1, exportSchema = false)
abstract class ItaliaSeriADatabase : RoomDatabase() {

    abstract fun italianSeriaDao(): ItalianSeriaDao

}