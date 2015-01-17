package de.munich.softwerkskammer.gameplay;

import java.util.List;

import static de.munich.softwerkskammer.gameplay.FrameFactory.newSpareWithBonus;

/**
 * The player made a spare in the last frame and received one bonus ball as a result. This state handles this
 * bonus ball.
 */
public class OneBonusBallPlayerState extends PlayerState {
    private final int first;
    private final int second;

    /**
     * @param frames The completed frames so far
     * @param first The pins knocked down by the first roll
     * @param second The pins knocked down by the second roll
     */
    protected OneBonusBallPlayerState(List<Frame> frames, int first, int second) {
        super(10, frames);
        assert first + second == 10;
        this.first = first;
        this.second = second;
    }

    @Override
    public PlayerState roll(int pins) {
        assert pins >= 0 && pins <= 10;
        return new GameOverPlayerState(extendFrames(newSpareWithBonus(first, second, pins)));
    }

    @Override
    public String toString() {
        return "Bonus ball in the last frame";
    }
}
