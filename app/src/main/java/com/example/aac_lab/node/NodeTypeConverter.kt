package com.example.aac_lab.node

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class NodeTypeConverter {
    @TypeConverter
    fun nodeToString(nodes: List<Node>): String {
        return Gson().toJson(nodes)
    }

    @TypeConverter
    fun stringToNode(nodes: String): List<Node> {
        val convertType = object : TypeToken<List<Node>>() {}.type
        return Gson().fromJson(nodes, convertType)
    }

}