package service;

import java.util.LinkedList;
import java.util.List;

import model.Board;
import model.Ladder;
import model.Player;
import model.Snake;
import strategy.DiceRollStrategy;
import strategy.SingleDiceRollStrategy;

public class SnakeLadderService {
	
	private static int DEFAULT_BOARD_SIZE = 100;
	
	private int initialNumberOfPlayers;
	private boolean shouldAllowMultipleDiceRollOnSix = false; // Keeping default value as false. User can use setter method to change this value.
	private boolean shouldGameContinueTillLastPlayer = false; // Keeping default value as false. User can use setter method to change this value.
	
	private Board board;
	private LinkedList<Player> players;
	private DiceRollStrategy diceRollStrategy;
	
	public SnakeLadderService(int size, DiceRollStrategy diceRollStrategy) {
		board = new Board(size);
		players = new LinkedList<>();
		this.diceRollStrategy = diceRollStrategy;
	}

	public SnakeLadderService(int size) {
		this(size, new SingleDiceRollStrategy());
	}
	
	public SnakeLadderService() {
		this(SnakeLadderService.DEFAULT_BOARD_SIZE);
	}

	public void setShouldAllowMultipleDiceRollOnSix(boolean shouldAllowMultipleDiceRollOnSix) {
		this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
	}

	public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
		this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
	}

	public void setPlayers(List<Player> players) {
		initialNumberOfPlayers = players.size();
		
		for(Player player : players) {
			this.players.add(player);
			board.getPlayerPieces().put(player.getId(), 0);
		}
	}

	public void setSnakes(List<Snake> snakes) {
		board.setSnakes(snakes);
	}
	
	public void setLadders(List<Ladder> ladders) {
		board.setLadders(ladders);
	}
	
	private int getPositionAfterGoingThroughSnakeAndLadders(int newPosition) {
		int previousPosition;
		
		do {
			previousPosition = newPosition;
			for(Snake snake : board.getSnakes()) {
				if(snake.getStart() == newPosition)
					newPosition = snake.getEnd();
			}
			for(Ladder ladder : board.getLadders()) {
				if(ladder.getStart() == newPosition) {
					newPosition = ladder.getEnd();
				}
			}
		} while(newPosition != previousPosition);

		return newPosition;
	}
	
	private void movePlayer(Player player) {
		int oldPosition = board.getPlayerPieces().get(player.getId());	
		int diceRollValue = diceRollStrategy.getTotalDiceRollValue();
		int newPosition = oldPosition + diceRollValue;	
		int savedOldPosition = oldPosition;
		
		if(newPosition > board.getSize())
			newPosition = oldPosition;
		else
			newPosition = getPositionAfterGoingThroughSnakeAndLadders(newPosition);
		
		System.out.println(player.getName() + " rolled a " + diceRollValue + " and moved from " + oldPosition + " to " + newPosition);
		
		if(shouldAllowMultipleDiceRollOnSix) {
			int count = 1;
			while(!hasPlayerWon(player) && diceRollValue == 6 && count < 3) { // If you roll a 6, you get another chance to roll.
				diceRollValue = diceRollStrategy.getTotalDiceRollValue();
				
				oldPosition = newPosition;
				newPosition = oldPosition + diceRollValue;
				
				if(newPosition > board.getSize())
					newPosition = oldPosition;
				else
					newPosition = getPositionAfterGoingThroughSnakeAndLadders(newPosition);
				
				System.out.println(player.getName() + " rolled a " + diceRollValue + " and moved from " + oldPosition + " to " + newPosition);
				
				count++;
				
				if(count == 3 && diceRollValue == 6) { // If you roll three consecutive 6's you move back to original position.
					newPosition = savedOldPosition;
					System.out.println(player.getName() + " moved back to " + newPosition + " because he/she rolled 3 consecutives 6's");
				}
			}
		}
		
		board.getPlayerPieces().put(player.getId(), newPosition);	
	}
	
	private boolean hasPlayerWon(Player player) {
		int winningPosition = board.getSize();
		int playerPosition = board.getPlayerPieces().get(player.getId());
		
		return winningPosition == playerPosition; 
	}
	
	private boolean isGameCompleted() {
		int currentNumberOfPlayers = players.size();
		
		if(shouldGameContinueTillLastPlayer)
			return currentNumberOfPlayers ==  0;
		else
			return currentNumberOfPlayers < initialNumberOfPlayers;
	}
	
	public void startGame() {
		while(!isGameCompleted()) {
			Player player = players.poll();
			
			movePlayer(player);
		
			if(hasPlayerWon(player)) {
				System.out.println(player.getName() + " wins the game");
				board.getPlayerPieces().remove(player.getId());
			} else {
				players.add(player);
			}	
		}
	}
}
