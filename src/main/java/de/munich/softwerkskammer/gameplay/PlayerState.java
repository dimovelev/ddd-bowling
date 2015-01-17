package de.munich.softwerkskammer.gameplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the state of the game for a player
 */
public abstract class PlayerState {
    protected final int currentFrameNumber;
    protected final List<Frame> frames;

    protected PlayerState(int currentFrameNumber, List<Frame> frames) {
        this.currentFrameNumber = currentFrameNumber;
        this.frames = Collections.unmodifiableList(frames);
    }

    /**
     * Signal that the given number of pins have been knocked down.
     * @param pins
     * @return The new state of the player's game
     */
    public abstract PlayerState roll(int pins);

    /**
     * @return The number of the current frame
     */
    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public boolean isLastFrame() {
        return currentFrameNumber == 10;
    }

    protected List<Frame> extendFrames(Frame frame) {
        final List<Frame> result = new ArrayList<>(frames.size() + 1);
        result.addAll(frames);
        result.add(frame);
        return result;
    }

    /**
     * @return whether the player is allowed to throw more balls in this game
     */
    public boolean hasMoreBalls() {
        return true;
    }

    /**
     * @return un unmodifiable list of completed frames
     */
    public List<Frame> getCompletedFrames() {
        return frames;
    }
}
