package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.character.GameCharacter

class DealDamageToCharacter(private val characters: Characters) {
	operator fun invoke(attackerName: String, targetName: String, amount: Int) {
		if (attackerName == targetName) return

		val attacker = characters.search(attackerName)
		val target = characters.search(targetName)

		val levelMultiplier = levelDamageMultiplier(levelDifference(attacker, target))
		val total = amount * levelMultiplier
		target.receiveDamage(total.toInt())

		characters.put(target)
	}

	private fun levelDifference(attacker: GameCharacter, target: GameCharacter): Int {
		return attacker.level - target.level
	}

	private fun levelDamageMultiplier(difference: Int): Double {
		return when {
			difference >= 5 -> OVERLEVEL_DAMAGE_MULTIPLIER
			difference <= -5 -> UNDERLEVEL_DAMAGE_MULTIPLIER
			else -> DEFAULT_LEVEL_DAMAGE_MULTIPLIER
		}
	}

	companion object {
		const val OVERLEVEL_DAMAGE_MULTIPLIER = 1.5
		const val UNDERLEVEL_DAMAGE_MULTIPLIER = 0.5
		const val DEFAULT_LEVEL_DAMAGE_MULTIPLIER = 1.0
	}
}