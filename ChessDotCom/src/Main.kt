import entities.GameManager

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val user1 = GameManager.createUser("rohit")
    val user2 = GameManager.createUser("aditya")

    GameManager.addUser(user1)
    GameManager.addUser(user2)

    val match = GameManager.findMatch(user1, ScoreBasedStrategy())
    if (match == null) {
        println("No other opponent available")
    } else {
        DemoMoves.demo(match)
    }

}
