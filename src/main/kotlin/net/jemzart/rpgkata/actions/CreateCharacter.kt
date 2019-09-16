package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.GameCharacter
import net.jemzart.rpgkata.models.character.Characters

class CreateCharacter(private val characters: Characters) {
	operator fun invoke(name: String) {
		val character = GameCharacter(name = name)
		characters.put(character)
	}
}