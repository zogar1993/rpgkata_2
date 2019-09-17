package net.jemzart.rpgkata.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import net.jemzart.rpgkata.createThing
import net.jemzart.rpgkata.dealDamageToThing
import net.jemzart.rpgkata.getThing
import net.jemzart.rpgkata.things
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.amshove.kluent.shouldEqual

class ThingSteps {
    @Given("thing {string} is created with {int} health")
    fun `thing {name} is created with {int} health`(name: String, health: Int){
        createThing(name, health)
    }

    @Given("thing {string} has {int} health")
    fun `{name} has {amount} health`(name: String, amount: Int) {
        val thing = things.search(name)
        thing.receiveDamage(thing.health - amount)
        things.put(thing)
        getThing(name).health.shouldEqual(amount)
    }

    @When("character {string} deals {int} damage to thing {string}")
    fun `character {attacker} deals {amount} damage to thing {target}`
                (attacker: String, amount: Int, target: String) {
        dealDamageToThing(attacker, target, amount)
    }

    @Then("thing {string} should have {int} health")
    fun `thing {name} should have {int} health`(name: String, health: Int){
        val thing = getThing(name)
        thing.health.shouldEqual(health)
    }

    @Then("thing {string} should not be destroyed")
    fun `thing {name} should be alive`(name: String) {
        val thing = getThing(name)
        thing.destroyed.shouldBeFalse()
    }

    @Then("thing {string} should be destroyed")
    fun `thing {name} should be dead`(name: String) {
        val thing = getThing(name)
        thing.destroyed.shouldBeTrue()
    }
}