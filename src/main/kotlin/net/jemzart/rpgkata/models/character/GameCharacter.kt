package net.jemzart.rpgkata.models.character

class GameCharacter constructor(val name: String) {
	var range: RangeType = RangeType.Melee
    var level = INITIAL_LEVEL
	var health: Int = INITIAL_HEALTH; private set
	val alive get() = health > NO_HEALTH
	private val _factions = mutableSetOf<String>()
	val factions: Set<String> get() = _factions

	fun receiveHealing(amount: Int) {
		if (health == 0) return
		health = (health + amount).coerceAtMost(MAX_HEALTH)
	}

	fun receiveDamage(amount: Int) {
		health = (health - amount).coerceAtLeast(NO_HEALTH)
	}

	fun joinFaction(faction: String) {
		_factions.add(faction)
	}

	fun leaveFaction(faction: String) {
		_factions.remove(faction)
	}

    companion object {
		const val MAX_HEALTH = 1000
		const val NO_HEALTH = 0
		const val INITIAL_HEALTH = MAX_HEALTH
		const val INITIAL_LEVEL = 1
	}
}