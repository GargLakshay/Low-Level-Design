package interfaces

interface MatchingStrategy {
    fun findMatch(currentUser: Colleague, waitingList: HashMap<Int, Colleague>): Colleague?
}