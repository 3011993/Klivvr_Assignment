package com.example.klivvrassignment.data.node_trie

import com.example.klivvrassignment.domain.model.CityModel

class Trie {
    private val root = TrieNode()

    fun insert(city: CityModel) {
        var current = root
        for (char in city.city.lowercase()) {
            if (!current.children.containsKey(char)) {
                current.children[char] = TrieNode()
            }
            current = current.children[char]!!
        }
        current.isEndOfWord = true
        current.city = city
    }

    fun searchPrefix(prefix: String): List<CityModel> {
        var current = root
        for (char in prefix.lowercase()) {
            if (!current.children.containsKey(char)) {
                return emptyList()
            }
            current = current.children[char]!!
        }
        return collectCities(current)
    }

    private fun collectCities(node: TrieNode): List<CityModel> {
        val cities = mutableListOf<CityModel>()
        if (node.isEndOfWord) {
            node.city?.let { cities.add(it) }
        }
        for (child in node.children.values) {
            cities.addAll(collectCities(child))
        }
        return cities
    }

    companion object {
        fun preprocessCities(cities: List<CityModel>): Trie {
            val trie = Trie()
            for (city in cities) {
                trie.insert(city)
            }
            return trie
        }
    }
}

