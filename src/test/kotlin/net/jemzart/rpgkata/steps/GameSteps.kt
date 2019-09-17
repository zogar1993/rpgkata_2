package net.jemzart.rpgkata.steps

import cucumber.api.java.en.Given
import net.jemzart.rpgkata.characters
import net.jemzart.rpgkata.terrain

class GameSteps {
	@Given("a new game starts")
	fun `a new game starts`() {
		characters.clear()
		terrain.clear()
	}
}
