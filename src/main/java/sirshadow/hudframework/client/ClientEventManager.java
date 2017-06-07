package sirshadow.hudframework.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;
import sirshadow.hudframework.client.hud.HUDRenderHelper;

/**
 * Created by Shadow on 31.5.2017.
 */
@SideOnly(Side.CLIENT)
public class ClientEventManager {


    private Minecraft mc = FMLClientHandler.instance().getClient();


    @SubscribeEvent
    public void gameRender(TickEvent.RenderTickEvent event) {
        if (event.phase.equals(TickEvent.Phase.START))
        {
            return;
        }else if ((mc.inGameHasFocus || mc.currentScreen == null) && !mc.gameSettings.showDebugInfo)
        {
            if (!HUDRenderHelper.renderHUDElements(mc)) {
                return;
            }
        }
    }
}
