package tech.scramjetdev.sculkclicker;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {

    private final SculkClicker sculkClicker;

    public MouseListener(SculkClicker sculkClicker) {
        this.sculkClicker = sculkClicker;
    }

    public void nativeMouseClicked(NativeMouseEvent event) {
        if (event.getButton() == NativeMouseEvent.BUTTON1) { // left
            sculkClicker.incrementLeftClick();
        } else if (event.getButton() == NativeMouseEvent.BUTTON2) { // right
            sculkClicker.incrementRightClick();
        }
        System.out.println("R CPS: " + sculkClicker.getRightCps());
        System.out.println("L CPS: " + sculkClicker.getLeftCps());
    }
}
