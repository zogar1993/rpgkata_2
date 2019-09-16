package net.jemzart.rpgkata.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import net.jemzart.rpgkata.characters
import net.jemzart.rpgkata.createCharacter
import net.jemzart.rpgkata.getCharacter
import net.jemzart.rpgkata.models.character.GameCharacter
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.amshove.kluent.shouldEqual

class CharacterSteps {
	@Given("character {string} is created")
	fun `character {name} is created`(name: String) {
		createCharacter(name)
	}

	@Given("character {string} is dead")
	fun `{name} is dead`(name: String) {
		val character = characters.search(name)
		character.receiveDamage(GameCharacter.MAX_HEALTH)
		characters.put(character)
		getCharacter(name).alive.shouldBeFalse()
	}

	@Given("character {string} has {int} health")
	fun `{name} has {amount} health`(name: String, amount: Int) {
		val character = characters.search(name)
		character.receiveDamage(character.health - amount)
		characters.put(character)
		getCharacter(name).health.shouldEqual(amount)
	}

	@Given("character {string} is level {int}")
	fun `character {name} is level {level}`(name: String, level: Int) {
		val character = characters.search(name)
		character.level = level
		characters.put(character)
		getCharacter(name).level.shouldEqual(level)
	}

	@Then("character {string} should be level {int}")
	fun `{name} should be level {level}`(name: String, level: Int) {
		val character = getCharacter(name)
		character.level.shouldEqual(level)
	}

	@Then("character {string} should have {int} health")
	fun `{name} should have {health} health`(name: String, health: Int) {
		val character = getCharacter(name)
		character.health.shouldEqual(health)
	}

	@Then("character {string} should be unharmed")
	fun `character {string} should be unharmed`(name: String) {
		val character = getCharacter(name)
		character.health.shouldEqual(GameCharacter.INITIAL_HEALTH)
	}

	@Then("character {string} should be alive")
	fun `character {name} should be alive`(name: String) {
		val character = getCharacter(name)
		character.alive.shouldBeTrue()
	}

	@Then("character {string} should be dead")
	fun `character {name} should be dead`(name: String) {
		val character = getCharacter(name)
		character.alive.shouldBeFalse()
	}
}
