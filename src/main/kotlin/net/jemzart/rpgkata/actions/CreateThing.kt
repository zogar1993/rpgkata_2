package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.thing.Thing
import net.jemzart.rpgkata.models.thing.Things

class CreateThing(private val things: Things) {
	operator fun invoke(name: String, health: Int) {
		val thing = Thing(name = name, health = health)
		things.put(thing)
	}
}