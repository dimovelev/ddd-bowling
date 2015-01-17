package de.munich.softwerkskammer.gameplay;

/**
 * An attempt to knock down 10 pins. Attempts are value objects.
 */
interface Attempt {
    /**
     * @return the number of balls thrown during the attempt
     */
    int getNumberOfBalls();

    /**
     * @return the total number of pins knocked down during this attempt
     */
    int getTotalPins();

    /**
     * @return whether the frame is complete (all pins have been knocked down)
     */
    boolean isComplete();

    /**
     * @return the number of bonus balls
     */
    int getBonusBalls();
}
