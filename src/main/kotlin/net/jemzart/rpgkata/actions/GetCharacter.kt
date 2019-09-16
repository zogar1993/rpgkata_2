package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters

class GetCharacter(private val characters: Characters) {
	operator fun invoke(name: String): GameCharacter {
		val character = characters.search(name)
		return GameCharacter(character)
	}

	class GameCharacter(character: net.jemzart.rpgkata.models.character.GameCharacter){
		val level = character.level
		val health = character.health
		val alive = character.alive
	}
}