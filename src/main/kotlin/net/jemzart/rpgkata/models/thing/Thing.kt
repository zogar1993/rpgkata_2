package net.jemzart.rpgkata.models.thing

class Thing(val name: String, health: Int) {
    var health: Int = health; private set

    fun receiveDamage(amount: Int) {
        health = (health - amount).coerceAtLeast(0)
    }

    val destroyed get() = health == 0
}
