package strategy;

import java.util.Random;

public class DoubleDiceRollStrategy implements DiceRollStrategy {

	@Override
	public int getTotalDiceRollValue() {
		Random rand = new Random();
		return rand.nextInt(6) + rand.nextInt(6) + 2;
	}

}
