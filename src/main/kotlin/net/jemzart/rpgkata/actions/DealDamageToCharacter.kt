package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.models.character.Characters
import net.jemzart.rpgkata.models.character.GameCharacter
import net.jemzart.rpgkata.models.character.isAlliedWith
import net.jemzart.rpgkata.models.terrain.Terrain

class DealDamageToCharacter(
	private val characters: Characters,
	private val terrain: Terrain) {
	operator fun invoke(attackerName: String, targetName: String, amount: Int) {
		val attacker = characters.search(attackerName)
		val target = characters.search(targetName)

		if (attacker.mayNotDealDamageTo(target)) return

		val levelMultiplier = levelDamageMultiplier(levelDifference(attacker, target))
		val total = amount * levelMultiplier
		target.receiveDamage(total.toInt())

		characters.put(target)
	}

	private fun GameCharacter.mayNotDealDamageTo(character: GameCharacter) = !this.mayDealDamageTo(character)
	private fun GameCharacter.mayDealDamageTo(character: GameCharacter) : Boolean {
		if (this == character) return false
		if (this.doesNotReach(character)) return false
		if (this.isAlliedWith(character)) return false
		return true
	}

	private fun GameCharacter.doesNotReach(character: GameCharacter) = !this.reaches(character)
	private fun GameCharacter.reaches(target: GameCharacter) : Boolean =
		this.range.max >= terrain.distanceOfCharacters(this, target)

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