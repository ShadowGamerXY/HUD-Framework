package sirshadow.hudframework.client.keybindings;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by sirshadow on 6/4/17.
 */
public enum KeyBindings {

    OPEN_HUD_GUI("open_hud_gui", Keyboard.KEY_H);

    public final KeyBinding keyBinding;

    KeyBindings(String keyName, int defaultKeyCode)
    {
        keyBinding = new KeyBinding(keyName, defaultKeyCode, "key.category.hf");
    }

    public KeyBinding getKeyBid()
    {
        return keyBinding;
    }

    public boolean isPressed()
    {
        return keyBinding.isPressed();
    }
}
