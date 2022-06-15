package tech.scramjetdev.sculkclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import java.util.ArrayList;

public class SculkClicker {
    private ArrayList<Long> rightClicks = new ArrayList<>();
    private ArrayList<Long> leftClicks = new ArrayList<>();
    Thread clock;
    public SculkClicker() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeMouseListener(new MouseListener(this));
        clock = new Thread(new CpsRunnable(this));
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
