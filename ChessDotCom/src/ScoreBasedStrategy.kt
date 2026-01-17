import interfaces.Colleague
import interfaces.MatchingStrategy
import kotlin.math.abs

class ScoreBasedStrategy : MatchingStrategy {
    override fun findMatch(
        currentUser: Colleague,
        waitingList: HashMap<Int, Colleague>
    ): Colleague? {
        var user: Colleague? = null
        var mn = Integer.MAX_VALUE
        for (pair in waitingList) {
            val opponentUser = pair.value
            if (currentUser.getUserId() != opponentUser.getUserId()) {
                val currDiff = abs(currentUser.getUserScore() - opponentUser.getUserScore())
                if (currDiff < mn) {
                    mn = currDiff
                    user = opponentUser
                }
            }

        }
        return user
    }
}