package com.example.klivvrassignment.data.node_trie

import com.example.klivvrassignment.domain.model.CityModel

class TrieNode {
    val children : MutableMap<Char, TrieNode> = HashMap()
    var isEndOfWord : Boolean = false
    var city : CityModel? = null
}