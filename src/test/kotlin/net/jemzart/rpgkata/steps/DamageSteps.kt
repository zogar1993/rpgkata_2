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

	@Then("character {string} should have received {int}% of {int} damage")
	fun `character {name} should have received {percentage}% of {damage} damage`
				(name: String, percentage: Double, damage: Int) {
		val character = characters.search(name)
		val totalDamage = (percentage / 100) * damage
		val health = GameCharacter.INITIAL_HEALTH - totalDamage
		character.health.shouldEqual(health.toInt())
	}
}
