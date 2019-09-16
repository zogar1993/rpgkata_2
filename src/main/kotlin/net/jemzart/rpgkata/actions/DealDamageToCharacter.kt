package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters

class DealDamageToCharacter(private val characters: Characters) {
	operator fun invoke(attackerName: String, targetName: String, damageAmount: Int) {
		val target = characters.search(targetName)

		target.receiveDamage(damageAmount)

		characters.put(target)
	}
}