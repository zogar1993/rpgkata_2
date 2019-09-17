package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.terrain.Terrain

class PlaceCharactersMetersApart(
    private val characters: Characters,
    private val terrain: Terrain
) {
    operator fun invoke(characterAName: String, characterBName: String, distance: Int) {
        val characterA = characters.search(characterAName)
        val characterB = characters.search(characterBName)

        terrain.separateByMeters(characterA, characterB, distance)
    }
}