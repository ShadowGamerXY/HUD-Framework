package sirshadow.hudframework;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sirshadow.hudframework.client.hud.HUDRenderHelper;

/**
 * Created by sirshadow on 6/4/17.
 */
public class EventHandler {

    @SubscribeEvent
    public void onUpdate(LivingEvent.LivingUpdateEvent event){
        if (!HUDRenderHelper.updateHUDElements()){
            return;
        }
    }
}
