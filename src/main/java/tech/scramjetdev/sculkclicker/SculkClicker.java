package tech.scramjetdev.sculkclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SculkClicker {
    private static final Logger LOGGER = LogManager.getLogger(SculkClicker.class);

    private ArrayList<Long> rightClicks = new ArrayList<>();
    private ArrayList<Long> leftClicks = new ArrayList<>();

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
        Thread clock = new Thread(new CpsRunnable(this), "Clock Thread");
        clock.start();
    }

    public ArrayList<Long> getRightClicks() {
        return rightClicks;
    }

    public ArrayList<Long> getLeftClicks() {
        return leftClicks;
    }

    public void setRightClicks(ArrayList<Long> rightClicks) {
        this.rightClicks = rightClicks;
    }

    public void setLeftClicks(ArrayList<Long> leftClicks) {
        this.leftClicks = leftClicks;
    }
}
