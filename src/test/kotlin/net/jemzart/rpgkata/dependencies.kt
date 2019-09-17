package net.jemzart.rpgkata

import net.jemzart.rpgkata.actions.*
import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.terrain.Terrain

val characters = Characters()
val terrain = Terrain()

val getCharacter = GetCharacter(characters)
val createCharacter = CreateCharacter(characters)
val dealDamageToCharacter = DealDamageToCharacter(characters, terrain)
val applyHealingToCharacter = ApplyHealingToCharacter(characters)
val placeCharactersMetersApart = PlaceCharactersMetersApart(characters, terrain)
val joinFaction = JoinFaction(characters)
val leaveFaction = LeaveFaction(characters)