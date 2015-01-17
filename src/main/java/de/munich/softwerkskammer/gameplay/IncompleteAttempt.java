package de.munich.softwerkskammer.gameplay;

/**
 * An attempt consisting of two rolls trying to knock down the pins but failing to knock down all of them.
 */
public class IncompleteAttempt implements Attempt {
    private final int first;
    private final int second;

    public IncompleteAttempt(int first, int second) {
        assert first + second > 0 && first + second < 10;
        this.first = first;
        this.second = second;
    }

    @Override
    public int getTotalPins() {
        return first + second;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public int getNumberOfBalls() {
        return 2;
    }

    @Override
    public int getBonusBalls() {
        return 0;
    }

    @Override
    public String toString() {
        return first + " + " + second;
    }
}
