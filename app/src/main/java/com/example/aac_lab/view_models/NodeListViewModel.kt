package com.example.aac_lab.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aac_lab.node.Node
import com.example.aac_lab.node.NodeDao
import kotlinx.coroutines.flow.Flow

class NodeListViewModel(private val nodeDao: NodeDao) : ViewModel() {
    fun getNodesList(): Flow<List<Node>> = nodeDao.getAllNodesConnection()

    private fun getLastId(): Int = nodeDao.getSize()

    fun addNode(value: Int) = nodeDao.pushNodes(Node(getLastId(), value))
}

class NodeListViewModelFactory(
    private val nodeDao: NodeDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NodeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NodeListViewModel(nodeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}