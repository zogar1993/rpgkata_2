package net.jemzart.rpgkata.steps

import cucumber.api.java.en.Given
import net.jemzart.rpgkata.characters
import net.jemzart.rpgkata.getCharacter
import net.jemzart.rpgkata.models.character.RangeType
import net.jemzart.rpgkata.placeCharactersMetersApart
import org.amshove.kluent.shouldEqual

class DistanceSteps {
    @Given("character {string} is a {string} fighter")
    fun `character {name} is a {range} fighter`(name: String, range: String) {
        val character = characters.search(name)
        character.range = RangeType.from(range)
        characters.put(character)
        getCharacter(name).range.shouldEqual(range)
    }

    @Given("character {string} and character {string} are {int} meters apart")
    fun `character {characterA} and character {characterB} are {distance} meters apart`
                (characterA: String, characterB: String, distance: Int) {
        placeCharactersMetersApart(characterA, characterB, distance)
    }
}