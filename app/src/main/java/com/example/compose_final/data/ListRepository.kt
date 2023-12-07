package com.example.compose_final.data

import com.example.compose_final.model.ListHero
import com.example.compose_final.model.ListHeroData

class ListRepository {
    fun getListHero(): List<ListHero> {
        return ListHeroData.listHero
    }
    fun searcListHero(query: String): List<ListHero> {
        return ListHeroData.listHero.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
    fun getHeroById(query: String): ListHero?{
        return ListHeroData.listHero.firstOrNull{
            it.id == query
        }
    }
}