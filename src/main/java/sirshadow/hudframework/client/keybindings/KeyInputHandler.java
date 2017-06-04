package sirshadow.hudframework.client.keybindings;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import sirshadow.hudframework.HudFramework;
import sirshadow.hudframework.client.GuiHandler;

/**
 * Created by sirshadow on 6/4/17.
 */
public class KeyInputHandler {
    private KeyBindings getPressedKey(){
        for(KeyBindings key : KeyBindings.values()) {
            if(key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
        KeyBindings key = getPressedKey();
        if(key != null) {
            switch(key){
                case OPEN_HUD_GUI:
                   if (HudFramework.proxy.getClientPlayer() != null){
                       EntityPlayer player = HudFramework.proxy.getClientPlayer();
                       HudFramework.proxy.getClientPlayer().openGui(HudFramework.instance, GuiHandler.GUI_HUD,player.world,(int)player.posX,(int)player.posY,(int)player.posZ);
                   }
            }
        }
    }
}
