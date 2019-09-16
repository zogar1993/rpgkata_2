package net.jemzart.rpgkata.models.character

class Characters {
	private val characters = mutableMapOf<String, GameCharacter>()
	fun put(character: GameCharacter) {
		characters[character.name] = character
	}

	fun search(name: String): GameCharacter {
		return characters.getValue(name)
	}

	fun clear() {
		characters.clear()
	}
}