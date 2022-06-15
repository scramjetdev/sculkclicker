package tech.scramjetdev.sculkclicker;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {

    private final SculkClicker sculkClicker;

    public MouseListener(SculkClicker sculkClicker) {
        this.sculkClicker = sculkClicker;
    }

    public void nativeMouseClicked(NativeMouseEvent event) {
        if (event.getButton() == NativeMouseEvent.BUTTON1) {
            sculkClicker.getLeftClicks().add(System.currentTimeMillis());
        } else if (event.getButton() == NativeMouseEvent.BUTTON2) {
            sculkClicker.getRightClicks().add(System.currentTimeMillis());
        }
        System.out.println("R CPS: " + sculkClicker.getRightClicks().size());
        System.out.println("L CPS: " + sculkClicker.getLeftClicks().size());
    }
}
