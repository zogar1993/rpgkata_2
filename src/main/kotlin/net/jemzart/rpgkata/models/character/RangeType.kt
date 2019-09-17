package net.jemzart.rpgkata.models.character

enum class RangeType(val value: String, val max: Int) {
    Melee("melee", 2),
    Ranged("ranged", 20);

    companion object{
        fun from(value: String) =
            values().find { value == it.value } ?:
            throw IllegalArgumentException("'$value' is not a valid ranged type")
    }
}
