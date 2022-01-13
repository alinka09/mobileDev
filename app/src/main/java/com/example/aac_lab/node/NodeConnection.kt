package com.example.aac_lab.node

data class NodeConnection(
    val from: Node,
    val to: Node,
    val isActive: Boolean
)