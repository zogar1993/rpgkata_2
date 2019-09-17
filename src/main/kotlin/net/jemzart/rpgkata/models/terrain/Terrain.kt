package net.jemzart.rpgkata.models.terrain

import net.jemzart.rpgkata.models.character.GameCharacter

class Terrain {
    private val map = mutableMapOf<Pair<String, String>, Int>()
    fun separateByMeters(characterA: GameCharacter, characterB: GameCharacter, distance: Int) {
        map[characterA.name to characterB.name] = distance
        map[characterB.name to characterA.name] = distance
    }

    fun distanceOfCharacters(characterA: GameCharacter, characterB: GameCharacter): Int {
        val pair = characterA.name to characterB.name
        if (pair !in map.keys) return 0
        return map.getValue(pair)
    }

    fun clear() {
        map.clear()
    }
}
