package net.jemzart.rpgkata

import net.jemzart.rpgkata.actions.CreateCharacter
import net.jemzart.rpgkata.actions.DealDamageToCharacter
import net.jemzart.rpgkata.actions.ApplyHealingToCharacter
import net.jemzart.rpgkata.actions.GetCharacter
import net.jemzart.rpgkata.models.character.Characters

val characters = Characters()

val getCharacter = GetCharacter(characters)
val createCharacter = CreateCharacter(characters)
val dealDamageToCharacter = DealDamageToCharacter(characters)
val applyHealingToCharacter = ApplyHealingToCharacter(characters)