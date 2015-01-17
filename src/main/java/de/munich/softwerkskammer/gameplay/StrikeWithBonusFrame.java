package de.munich.softwerkskammer.gameplay;

/**
 * A strike with two bonus balls.
 */
public class StrikeWithBonusFrame extends Frame {
    private final int first;
    private final int second;

    protected StrikeWithBonusFrame(int first, int second) {
        super(10, new Strike());
        assert first >= 0 && first <= 10;
        assert second >= 0 && second <= 10;
        this.first = first;
        this.second = second;
    }

    @Override
    public int getNumberOfBalls() {
        return super.getNumberOfBalls() + 2;
    }

    @Override
    public String toString() {
        return "Frame " + number + "[" + attempt + first + " + " + second + "]";
    }
}
