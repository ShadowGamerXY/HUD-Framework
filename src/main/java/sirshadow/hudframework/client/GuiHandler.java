package sirshadow.hudframework.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import sirshadow.hudframework.client.hud.ContainerHUD;
import sirshadow.hudframework.client.hud.GuiHUD;

import javax.annotation.Nullable;

/**
 * Created by Shadow on 1.6.2017.
 */
public class GuiHandler implements IGuiHandler{

    public static int GUI_HUD = 1;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_HUD){
            return new ContainerHUD();
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_HUD){
            return new GuiHUD();
        }
        return null;
    }
}
