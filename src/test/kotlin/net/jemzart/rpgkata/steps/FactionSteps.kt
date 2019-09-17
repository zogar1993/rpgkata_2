package net.jemzart.rpgkata.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import net.jemzart.rpgkata.characters
import net.jemzart.rpgkata.getCharacter
import net.jemzart.rpgkata.joinFaction
import net.jemzart.rpgkata.leaveFaction
import org.amshove.kluent.shouldBeEmpty
import org.amshove.kluent.shouldContain

class FactionSteps {
    @Given("character {string} is a member of the {string} faction")
    fun `character {name} is a member of the {faction} faction`(name: String, faction: String){
        val character = characters.search(name)
        character.joinFaction(faction)
        characters.put(character)
        getCharacter(name).factions.shouldContain(faction)
    }

    @Given("character {string} and character {string} are allies")
    fun `character {characterA} and character {characterB} are allies`(characterAName: String, characterBName: String){
        val characterA = characters.search(characterAName)
        val characterB = characters.search(characterBName)
        characterA.joinFaction("Best Friends")
        characterB.joinFaction("Best Friends")
        characters.put(characterA)
        characters.put(characterB)
    }

    @When("character {string} joins faction {string}")
    fun `character {name} joins faction {faction}`(name: String, faction: String){
        joinFaction(name, faction)
    }

    @When("character {string} leaves faction {string}")
    fun `character {name} leaves faction {faction}`(name: String, faction: String){
        leaveFaction(name, faction)
    }

    @Then("character {string} should be a member of faction {string}")
    fun `character {name} should be a member of faction {faction}`(name: String, faction: String){
        val character = getCharacter(name)
        character.factions.shouldContain(faction)
    }

    @Then("character {string} should be a member of no faction")
    fun `character {name} should be a member of no faction`(name: String){
        val character = getCharacter(name)
        character.factions.shouldBeEmpty()
    }
}