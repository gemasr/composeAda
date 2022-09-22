package com.gemasr.composeada.domain.model

data class Pokemon(
    val name: String = "",
    val imageUrl: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val types: List<String> = emptyList(),
    val id: Int? = null,
)