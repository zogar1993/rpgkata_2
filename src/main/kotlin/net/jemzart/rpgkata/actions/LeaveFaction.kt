package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters

class LeaveFaction(private val characters: Characters) {
    operator fun invoke(characterName: String, faction: String) {
        val character = characters.search(characterName)
        character.leaveFaction(faction)
        characters.put(character)
    }
}