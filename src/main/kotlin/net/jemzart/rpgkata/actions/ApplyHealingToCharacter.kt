package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters

class ApplyHealingToCharacter(private val characters: Characters) {
	operator fun invoke(healerName: String, targetName: String, amount: Int) {
		val target = characters.search(targetName)

		target.receiveHealing(amount)

		characters.put(target)
	}
}