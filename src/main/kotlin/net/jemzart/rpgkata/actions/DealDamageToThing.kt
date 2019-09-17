package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.character.GameCharacter
import net.jemzart.rpgkata.models.character.isAlliedWith
import net.jemzart.rpgkata.models.terrain.Terrain
import net.jemzart.rpgkata.models.thing.Things

class DealDamageToThing(
	private val characters: Characters,
	private val things: Things) {
	operator fun invoke(attackerName: String, targetName: String, amount: Int) {
		val attacker = characters.search(attackerName)
		val target = things.search(targetName)

		target.receiveDamage(amount)

		things.put(target)
	}
}