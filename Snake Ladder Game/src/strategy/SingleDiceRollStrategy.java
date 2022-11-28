package strategy;

import java.util.Random;

public class SingleDiceRollStrategy implements DiceRollStrategy {

	@Override
	public int getTotalDiceRollValue() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}

}
