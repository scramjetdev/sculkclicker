package tech.scramjetdev.sculkclicker;

import java.util.ArrayList;

public class CpsRunnable implements Runnable{
    private final SculkClicker sculkClicker;

    public CpsRunnable(SculkClicker sculkClicker) {
        this.sculkClicker = sculkClicker;
    }

    @Override
    public void run() {
        clock();
    }

    private void clock() {
        Long current = System.currentTimeMillis();
        ArrayList<Long> rightClicks = sculkClicker.getRightClicks();
        ArrayList<Long> leftClicks = sculkClicker.getLeftClicks();
        for (Long l : rightClicks) {
            if (current - l > 1000) {
                rightClicks.remove(l);
            }
        }
        for (Long l : leftClicks) {
            if (current - l > 1000) {
                leftClicks.remove(l);
            }
        }
        sculkClicker.setRightClicks(rightClicks);
        sculkClicker.setLeftClicks(leftClicks);

        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clock();
    }
}
