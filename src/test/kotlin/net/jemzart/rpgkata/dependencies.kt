package net.jemzart.rpgkata

import net.jemzart.rpgkata.actions.*
import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.terrain.Terrain
import net.jemzart.rpgkata.models.thing.Things

val characters = Characters()
val things = Things()
val terrain = Terrain()

val getCharacter = GetCharacter(characters)
val getThing = GetThing(things)

val createCharacter = CreateCharacter(characters)
val createThing = CreateThing(things)

val placeCharactersMetersApart = PlaceCharactersMetersApart(characters, terrain)
val joinFaction = JoinFaction(characters)
val leaveFaction = LeaveFaction(characters)

val dealDamageToCharacter = DealDamageToCharacter(characters, terrain)
val dealDamageToThing = DealDamageToThing(characters, things)
val applyHealingToCharacter = ApplyHealingToCharacter(characters)

