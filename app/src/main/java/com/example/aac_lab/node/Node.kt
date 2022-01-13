package com.example.aac_lab.node

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Node(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @NonNull @ColumnInfo(name = "value") val value: Int,
    @NonNull @ColumnInfo(name = "nodes") val nodes: List<Node> = emptyList()
)