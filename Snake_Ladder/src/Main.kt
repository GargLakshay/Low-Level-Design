import entities.Game
import entities.StandardRules
import entities.setup.StandardSetup

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val game = Game(6,100, StandardSetup())
    val user1 = game.createUser("Mohan")
    val user2 = game.createUser("Rohan")
    val user3 = game.createUser("Sohan")
    game.addUser(user1)
    game.addUser(user2)
    game.addUser(user3)

    game.startGame()

}