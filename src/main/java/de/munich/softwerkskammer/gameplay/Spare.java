package de.munich.softwerkskammer.gameplay;

/**
 * A successful attempt to knock down the 10 pins using two balls
 */
public class Spare implements Attempt {
    private final int first;
    private final int second;

    protected Spare(int first, int second) {
        assert first + second == 10;
        this.first = first;
        this.second = second;
    }

    @Override
    public int getNumberOfBalls() {
        return 2;
    }

    @Override
    public int getTotalPins() {
        return 10;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public int getBonusBalls() {
        return 1;
    }

    @Override
    public String toString() {
        return "Spare [" + first + " + " + second + "]";
    }
}
