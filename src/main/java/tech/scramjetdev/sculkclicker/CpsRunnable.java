package tech.scramjetdev.sculkclicker;

import java.util.ArrayList;
import java.util.TimerTask;

public class CpsRunnable extends TimerTask {
    private final SculkClicker sculkClicker;

    public CpsRunnable(SculkClicker sculkClicker) {
        this.sculkClicker = sculkClicker;
    }

    @Override
    public void run() {
       if (sculkClicker.getResetTime() < System.currentTimeMillis()) {
           sculkClicker.resetClicks();
       }
    }
}
