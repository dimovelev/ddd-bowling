package de.munich.softwerkskammer.gameplay;

import java.util.Collections;

public class PlayerStateFactory {
    public static PlayerState newInitialPlayerState() {
        return new FirstBallPlayerState(1, Collections.<Frame>emptyList());
    }
}
