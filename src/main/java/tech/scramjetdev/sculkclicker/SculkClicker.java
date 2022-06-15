package tech.scramjetdev.sculkclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Timer;

public class SculkClicker {
    private static final Logger LOGGER = LogManager.getLogger(SculkClicker.class);

    private int rightClicks = 0;
    private int leftClicks = 0;
    private long measureStartTime = 0;
    private long resetTime = 3000;

    public SculkClicker() {
        LOGGER.info("Initializing SculkClicker...");

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException exception) {
            LOGGER.error("A problem happened whilst registering native hooks.", exception);
            System.exit(1);
            return;
        }

        GlobalScreen.addNativeMouseListener(new MouseListener(this));
        Timer timer = new Timer("timer thread");
        timer.scheduleAtFixedRate(new CpsRunnable(this), 0, 200);
    }

    public void incrementRightClick() {
        rightClicks++;
        resetTime = System.currentTimeMillis() + 3000;
    }

    public void incrementLeftClick() {
        leftClicks++;
        resetTime = System.currentTimeMillis() + 3000;
    }

    public void resetClicks() {
        rightClicks = 0;
        leftClicks = 0;
        measureStartTime = System.currentTimeMillis();
        resetTime = measureStartTime + 3000;
    }

    public long getResetTime() {
        return resetTime;
    }

    public float getLeftCps() {
        return (float) leftClicks / (System.currentTimeMillis() - measureStartTime) * 1000;
    }

    public float getRightCps() {
        return (float) rightClicks / (System.currentTimeMillis() - measureStartTime) * 1000;
    }
}
