package tech.scramjetdev.sculkclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import java.util.ArrayList;

public class SculkClicker {
    private ArrayList<Long> rightClicks = new ArrayList<>();
    private ArrayList<Long> leftClicks = new ArrayList<>();

    public SculkClicker() {
        System.out.println("Initializing SculkClicker...");

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException exception) {
            System.err.println("A problem happened whilst registering native hooks.");
            exception.printStackTrace();
            System.exit(1);
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
