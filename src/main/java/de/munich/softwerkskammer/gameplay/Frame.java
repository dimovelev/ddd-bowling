package de.munich.softwerkskammer.gameplay;

import de.munich.softwerkskammer.gameplay.Attempt;

import java.util.List;

/**
 * A completed bowling frame.
 */
public class Frame {
    protected final int number;
    protected final Attempt attempt;

    protected Frame(int number, Attempt attempt) {
        assert number >= 1 && number <= 10;
        this.number = number;
        this.attempt = attempt;
    }

    /**
     * @return whether the frame qualifies for a bonus - this is the case if all 10 pins have been knocked down
     */
    public boolean hasBonus() {
        return attempt.isComplete();
    }

    /**
     * @return the number of balls thrown in this frame
     */
    public int getNumberOfBalls() {
        return attempt.getNumberOfBalls();
    }

    /**
     * @param rolls A list containing the number of pins knocked down for each rolling of a ball
     * @param rollIndex The index of the first roll of this frame
     * @return the score of this frame.
     */
    public int computeScore(List<Integer> rolls, int rollIndex) {
        return computeBaseScore() + computeBonusScore(rolls, rollIndex);
    }

    /**
     * @return the base score of this frame - determined only by the number of pins knocked down without any bonuses
     */
    public int computeBaseScore() {
        return attempt.getTotalPins();
    }

    /**
     * @param rolls A list containing the number of pins knocked down for each rolling of a ball
     * @param rollIndex The index of the first roll of this frame
     * @return the bonus score of this frame excluding the base score
     */
    public int computeBonusScore(List<Integer> rolls, int rollIndex) {
        int result = 0;
        int startRollIndex = rollIndex + attempt.getNumberOfBalls();
        for (int i=startRollIndex; i<startRollIndex + attempt.getBonusBalls() && i<rolls.size(); i++) {
            result += rolls.get(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Frame " + number + "[" + attempt + "]";
    }
}
