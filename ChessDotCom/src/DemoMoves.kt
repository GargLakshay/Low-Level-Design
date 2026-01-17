import entities.Match
import enums.STATUS
import model.Position

object DemoMoves {

    fun demo(demoMatch: Match) {
        // Util class for basic demo
        println("\n=== Scholar's Mate Demo (4-move checkmate) ===")

        val aditya = demoMatch.getUser2();
        val rohit = demoMatch.getUser1();
        demoMatch.board.display();

        // Proper Scholar's Mate sequence with correct coordinates
        println("\nMove 1: White e2-e4")
        demoMatch.makeMove(Position(6, 4), Position(4, 4), aditya); // e2-e4

        println("\nMove 1: Black e7-e5")
        demoMatch.makeMove(Position(1, 4), Position(3, 4), rohit); // e7-e5

        println("\nMove 2: White Bf1-c4 (targeting f7)")
        demoMatch.makeMove(Position(7, 5), Position(4, 2), aditya); // Bf1-c4

        println("\nMove 2: Black Nb8-c6 (developing)")
        demoMatch.makeMove(Position(0, 1), Position(2, 2), rohit); // Nb8-c6

        println("\nMove 3: White Qd1-h5 (attacking f7 and h7)")
        demoMatch.makeMove(Position(7, 3), Position(3, 7), aditya); // Qd1-h5 (row 3, col 7 = h5)

        println("\nMove 3: Black Ng8-f6?? (defending h7 but exposing f7)")
        demoMatch.makeMove(Position(0, 6), Position(2, 5), rohit); // Ng8-f6

        println("\nMove 4: White Qh5xf7# (Checkmate!)")
        demoMatch.makeMove(Position(3, 7), Position(1, 5), aditya); // Qh5xf7#

        if (demoMatch.getStatus() != STATUS.COMPLETED) {
            println("Note: Checkmate detection may need refinement for this position.")
        }

        // Demonstrate chat functionality
        println("\n=== Testing Chat Functionality ===")
        aditya.sendMessage("Good game!");
        rohit.sendMessage("Thanks, that was a quick one!")
    }
}