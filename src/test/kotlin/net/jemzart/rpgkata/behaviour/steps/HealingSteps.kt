package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.When
import net.jemzart.rpgkata.behaviour.applyHealingToCharacter

class HealingSteps {
    @When("character {string} heals character {string} for a value of {int}")
    fun `character {healer} heals character {target} for a value of {amount}`
                (healer: String, target: String, amount: Int) {
        applyHealingToCharacter(healer, target, amount)
    }
}