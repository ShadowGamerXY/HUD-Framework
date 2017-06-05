package sirshadow.hudframework;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by sirshadow on 6/4/17.
 */
public class ConfigurationHandler {
    public static Configuration config;

    //Example hud positions
    public static float example_xPos,example_yPos;

    //Example hud loceked
    public static boolean locked;

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {

        example_xPos = config.getFloat("ExampleHUD xPosition",Configuration.CATEGORY_CLIENT,0,0,100,"");
        example_yPos = config.getFloat("ExampleHUD yPosition",Configuration.CATEGORY_CLIENT,0,0,100,"");

        locked = config.getBoolean("is_example_hud_locked",Configuration.CATEGORY_GENERAL,false,"");

        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(ModLibrary.ModInfo.MOD_ID)) {
            loadConfiguration();
        }
    }
}
