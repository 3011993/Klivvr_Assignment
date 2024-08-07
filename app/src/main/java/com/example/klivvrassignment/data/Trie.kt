package com.example.klivvrassignment.data

import com.example.klivvrassignment.domain.model.CityModel

//I choose Trie because It's perfect match for our case
//Trie is a prefix tree, meaning it efficiently stores and retrieves words based on their shared prefixes.
//pros: Autocomplete suggestions, faster prefix searches and memory efficiency..etc
class TrieNode {
    val children : MutableMap<Char, TrieNode> = HashMap()
    var isEndOfWord : Boolean = false
    var city : CityModel? = null
}

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
        val cities = mutableListOf<CityModel>()
        for (char in prefix.lowercase()) {
            if (!current.children.containsKey(char)) {
                break
            }
            current = current.children[char]!!
        }
        cities.addAll(collectCities(current))

        if (prefix.isNotEmpty() && prefix[0].isUpperCase()) {
            current = root
            val initial = prefix[0].lowercaseChar()
            if (current.children.containsKey(initial)) {
                cities.addAll(collectCities(current.children[initial]!!))
            }
        }
        return cities.distinct()
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

