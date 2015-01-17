package de.munich.softwerkskammer.gameplay;

/**
 * A spare and a bonus ball.
 */
public class SpareWithBonusFrame extends Frame {
    private final int pins;

    protected SpareWithBonusFrame(Spare spare, int pins) {
        super(10, spare);
        assert pins >= 0 && pins <= 10;
        this.pins = pins;
    }

    @Override
    public int getNumberOfBalls() {
        return super.getNumberOfBalls() + 1;
    }
}
