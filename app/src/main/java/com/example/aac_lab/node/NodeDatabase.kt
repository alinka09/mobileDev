package com.example.aac_lab.node

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Node::class], version = 4)
@TypeConverters(NodeTypeConverter::class)
abstract class NodeDatabase : RoomDatabase() {

    abstract fun nodeDao(): NodeDao

    companion object {
        @Volatile
        private var INSTANCE: NodeDatabase? = null

        private val converterInstance = NodeTypeConverter()

        fun getDatabase(context: Context): NodeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    NodeDatabase::class.java,
                    "node_database"
                )
                    .allowMainThreadQueries()
                    .addTypeConverter(converterInstance)
                    .createFromAsset("database/nodes.db")
//                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}