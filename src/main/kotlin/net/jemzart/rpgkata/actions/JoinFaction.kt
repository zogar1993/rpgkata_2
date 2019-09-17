package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.terrain.Terrain

class JoinFaction(private val characters: Characters) {
    operator fun invoke(characterName: String, faction: String) {
        val character = characters.search(characterName)
        character.joinFaction(faction)
        characters.put(character)
    }
}