package net.jemzart.rpgkata.steps

import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import net.jemzart.rpgkata.characters
import net.jemzart.rpgkata.dealDamageToCharacter
import net.jemzart.rpgkata.models.character.GameCharacter
import org.amshove.kluent.shouldEqual

class DamageSteps {
	@When("character {string} deals {int} damage to character {string}")
	fun `character {attacker} deals {amount} damage to character {target}`
				(attacker: String, amount: Int, target: String) {
		dealDamageToCharacter(attacker, target, amount)
	}

	@When("character {string} deals damage to character {string}")
	fun `character {attacker} deals damage to character {target}`
				(attacker: String, target: String) {
		dealDamageToCharacter(attacker, target, 100)
	}

	@Then("character {string} should have received {int} damage")
	fun `character {name} should have received {damage} damage`
				(name: String, damage: Int) {
		val character = characters.search(name)
		character.health.shouldEqual(GameCharacter.INITIAL_HEALTH - damage)
	}
}
