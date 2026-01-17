package entities

import interfaces.Colleague
import interfaces.MatchingStrategy

object GameManager {
    val matchList = hashMapOf<Int, Match>()
    val waitingList = hashMapOf<Int, Colleague>()
    val matchingStrategy: MatchingStrategy? = null

    fun createUser(name: String): Colleague {
        return User(name)
    }

    fun addUser(user: Colleague) {
        waitingList[user.getUserId()] = user
    }

    fun findMatch(user: Colleague, matchingStrategy: MatchingStrategy): Match? {
        waitingList[user.getUserId()] = user

        //if match is created return the match id
        val opponentUser = matchingStrategy.findMatch(user, waitingList) ?: return null

        //means found the other opponent
        waitingList.remove(opponentUser.getUserId())

        return Match(user, opponentUser)
    }


}