package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.When
import net.jemzart.rpgkata.behaviour.dealDamageToCharacter

class DamageSteps {
	@When("character {string} deals {int} damage to character {string}")
	fun `character {attacker} deals {amount} damage to character {target}`
				(attacker: String, amount: Int, target: String) {
		dealDamageToCharacter(attacker, target, amount)
	}
}
