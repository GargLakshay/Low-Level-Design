package entities

import interfaces.Dice
import kotlin.random.Random

class XFaceDice(override val faces: Int) : Dice {
    override fun rollDice(): Int {
        return Random.nextInt(1, faces + 1)
    }
}