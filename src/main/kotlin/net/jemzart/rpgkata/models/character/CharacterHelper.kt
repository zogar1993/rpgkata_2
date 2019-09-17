package net.jemzart.rpgkata.models.character

fun GameCharacter.isAlliedWith(character: GameCharacter) = this.factions.any { it in character.factions }