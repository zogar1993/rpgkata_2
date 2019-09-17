package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.*

class ApplyHealingToCharacter(private val characters: Characters) {
	operator fun invoke(healerName: String, targetName: String, amount: Int) {
		val healer = characters.search(healerName)
		val target = characters.search(targetName)

		if (healer.mayNotHeal(target)) return

		target.receiveHealing(amount)

		characters.put(target)
	}

	private fun GameCharacter.mayNotHeal(character: GameCharacter) = !this.mayHeal(character)
	private fun GameCharacter.mayHeal(character: GameCharacter): Boolean {
		if (this == character) return true
		if (this.isAlliedWith(character)) return true
		return false
	}
}