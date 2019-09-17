package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.thing.Things

class GetThing(private val things: Things) {
	operator fun invoke(name: String): Thing {
		val thing = things.search(name)
		return Thing(thing)
	}

	class Thing(thing: net.jemzart.rpgkata.models.thing.Thing){
		val health = thing.health
		val destroyed = thing.destroyed
	}
}