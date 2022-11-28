package Driver;

import model.PieceType;
import model.Player;
import service.TicTacToeService;

import java.util.LinkedList;

public class Main {
    public static void main(String args[]) {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player(1, "Mustafa", PieceType.X));
        players.add(new Player(2, "Murtaza", PieceType.O));

        TicTacToeService service = new TicTacToeService(3, players);
        service.startGame();

    }
}
