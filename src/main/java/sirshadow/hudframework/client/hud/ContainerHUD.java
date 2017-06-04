package sirshadow.hudframework.client.hud;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by Shadow on 31.5.2017.
 */
public class ContainerHUD extends Container{
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
