package sirshadow.hudframework;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import sirshadow.hudframework.proxy.IProxy;

/**
 * Created by Shadow on 31.5.2017.
 */
@Mod(modid = ModLibrary.ModInfo.MOD_ID,name = ModLibrary.ModInfo.MOD_NAME,version = ModLibrary.ModInfo.MOD_VERSION,guiFactory = "sirshadow.hudframework.client.gui.GuiFactory"  )
public class HudFramework {


    @Mod.Instance
    public static HudFramework instance;

    @SidedProxy(serverSide = ModLibrary.ModInfo.SERVER_PROXY, clientSide = ModLibrary.ModInfo.CLIENT_PROXY)
    public static IProxy proxy;


    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        proxy.serverStartEvent(event);
        event.registerServerCommand(new CommandHUD());
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
