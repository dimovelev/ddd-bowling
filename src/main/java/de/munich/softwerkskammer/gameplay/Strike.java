package de.munich.softwerkskammer.gameplay;

/**
 * A successful attempt to knock down the pins with one ball.
 */
public class Strike implements Attempt {
    protected Strike() {
    }

    @Override
    public int getNumberOfBalls() {
        return 1;
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
        return 2;
    }

    @Override
    public String toString() {
        return "Strike";
    }
}
