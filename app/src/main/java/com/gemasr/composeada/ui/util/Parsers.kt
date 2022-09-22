package com.gemasr.composeada.ui.util

import androidx.compose.ui.graphics.Color
import com.gemasr.composeada.R
import com.gemasr.composeada.domain.model.PokemonThrowable
import com.gemasr.composeada.ui.theme.*

fun parseTypeToColor(type: String): Color {
    return when (type.lowercase()) {
        "normal" -> NormalType
        "fire" -> FireType
        "water" -> WaterType
        "electric" -> ElectricType
        "grass" -> GrassType
        "ice" -> IceType
        "fighting" -> FightingType
        "poison" -> PoisonType
        "ground" -> GroundType
        "flying" -> FlyingType
        "psychic" -> PsychicType
        "bug" -> BugType
        "rock" -> RockType
        "ghost" -> GhostType
        "dragon" -> DragonType
        "dark" -> DarkType
        "steel" -> SteelType
        "fairy" -> FairyType
        else -> Color.Black
    }
}

fun parseTypeToImage(type: String): Int {
    return when (type.lowercase()) {
        "normal" -> R.drawable.ic_normal
        "fire" -> R.drawable.ic_fire
        "water" -> R.drawable.ic_water
        "electric" -> R.drawable.ic_electric
        "grass" -> R.drawable.ic_grass
        "ice" -> R.drawable.ic_ice
        "fighting" -> R.drawable.ic_fighting
        "poison" -> R.drawable.ic_poison
        "ground" -> R.drawable.ic_ground
        "flying" -> R.drawable.ic_flying
        "psychic" -> R.drawable.ic_psychic
        "bug" -> R.drawable.ic_bug
        "rock" -> R.drawable.ic_rock
        "ghost" -> R.drawable.ic_ghost
        "dragon" -> R.drawable.ic_dragon
        "dark" -> R.drawable.ic_dark
        "steel" -> R.drawable.ic_steel
        "fairy" -> R.drawable.ic_fairy
        else -> R.drawable.ic_unknown
    }
}

fun parseError(throwable: PokemonThrowable?): Int {
    return when(throwable) {
        PokemonThrowable.Connection -> R.string.error_connection
        else -> R.string.error_generic
    }
}