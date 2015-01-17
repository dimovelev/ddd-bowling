package de.munich.softwerkskammer.gameplay;

public class FrameFactory {
    public static Frame newStrike(final int number) {
        return new Frame(number, new Strike());
    }

    protected static Frame newFrame(final int number, final int first, final int second) {
        if (first + second == 10) {
            return new Frame(number, new Spare(first, second));
        } else {
            return new Frame(number, new IncompleteAttempt(first, second));
        }
    }

    protected static SpareWithBonusFrame newSpareWithBonus(final int first, final int second, final int bonus) {
        return new SpareWithBonusFrame(new Spare(first, second), bonus);
    }

    protected static StrikeWithBonusFrame newStrikeWithBonus(final int first, final int second) {
        return new StrikeWithBonusFrame(first, second);
    }
}
