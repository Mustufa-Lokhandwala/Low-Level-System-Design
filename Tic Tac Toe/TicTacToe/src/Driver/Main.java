package Driver;

import model.Player;
import model.PlayingPieceO;
import model.PlayingPieceX;
import service.TicTacToeService;

import java.util.LinkedList;

public class Main {
    public static void main(String args[]) {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player(1, "Mustafa", new PlayingPieceX()));
        players.add(new Player(2, "Murtaza", new PlayingPieceO()));

        TicTacToeService service = new TicTacToeService(3, players);
        service.startGame();

    }
}
