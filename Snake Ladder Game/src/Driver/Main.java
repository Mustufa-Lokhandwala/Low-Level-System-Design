package Driver;

import java.util.ArrayList;
import java.util.List;

import model.Ladder;
import model.Player;
import model.Snake;
import service.SnakeLadderService;

public class Main {

	public static void main(String[] args) {
		
		List<Snake> snakes = new ArrayList<>();
		snakes.add(new Snake(17, 4));
		snakes.add(new Snake(19, 7));
		snakes.add(new Snake(21, 9));
		snakes.add(new Snake(27, 1));
		
		List<Ladder> ladders = new ArrayList<>();
		ladders.add(new Ladder(3, 22));
		ladders.add(new Ladder(5, 8));
		ladders.add(new Ladder(11, 26));
		ladders.add(new Ladder(20, 29));
		
		List<Player> players = new ArrayList<>();
		players.add(new Player("Mustufa"));
		players.add(new Player("Fatema"));
		players.add(new Player("Murtuza"));
		
		SnakeLadderService snakeLadderService = new SnakeLadderService(100);
		snakeLadderService.setSnakes(snakes);
		snakeLadderService.setLadders(ladders);
		snakeLadderService.setPlayers(players);
		snakeLadderService.setShouldAllowMultipleDiceRollOnSix(true);
		snakeLadderService.setShouldGameContinueTillLastPlayer(true);
		
		snakeLadderService.startGame();
	}

}
