package com.example.aac_lab.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aac_lab.node.Node
import com.example.aac_lab.node.NodeConnection
import com.example.aac_lab.node.NodeDao
import kotlinx.coroutines.flow.Flow

class ConnectionsViewModel(private val nodeDao: NodeDao) : ViewModel() {
    private var isFilterOnChildren = true

    fun getNodesListConnection(): Flow<List<Node>> = nodeDao.getAllNodesConnection()

    fun getNodeConnection(id: Int): Flow<Node> = nodeDao.getNodeByIdConnection(id)

    fun getNode(id: Int): Node = nodeDao.getNodeById(id)

    private fun addRelation(parent: Node, child: Node) {
        val updatedParentNodes = parent.nodes.toMutableList()

        updatedParentNodes.add(child)


        val newParent = Node(parent.id, parent.value, updatedParentNodes)

        nodeDao.updateNode(newParent)
    }

    private fun removeRelation(parent: Node, child: Node) {
        val updatedParentNodes = parent.nodes.toMutableList().filter { it.id != child.id }

        val newParent = Node(parent.id, parent.value, updatedParentNodes)

        nodeDao.updateNode(newParent)
    }

    fun changeConnection(connection: NodeConnection) {
        val actualFrom = nodeDao.getNodeById(connection.from.id)
        val actualTo = nodeDao.getNodeById(connection.to.id)

        if (actualFrom.nodes.map { it.id }.contains(actualTo.id)) {
            // Connection presents, removing...
            removeRelation(actualFrom, actualTo)
        } else {
            addRelation(actualFrom, actualTo)
        }
    }

    fun setChildFilter(isChildren: Boolean) {
        isFilterOnChildren = isChildren
    }
}

class ConnectionsViewModelFactory(
    private val nodeDao: NodeDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConnectionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ConnectionsViewModel(nodeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}