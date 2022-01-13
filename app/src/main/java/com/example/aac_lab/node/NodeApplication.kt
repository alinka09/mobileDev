package com.example.aac_lab.node

import android.app.Application

class NodeApplication : Application() {
    val database: NodeDatabase by lazy { NodeDatabase.getDatabase(this) }
}