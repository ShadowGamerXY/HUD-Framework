package sirshadow.hudframework;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import sirshadow.hudframework.client.GuiHandler;

/**
 * Created by Shadow on 1.6.2017.
 */
public class CommandHUD extends CommandBase {

    @Override
    public String getName()
    {
        return "hud";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.hf.hud";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP targetPlayer = getCommandSenderAsPlayer(sender);

        targetPlayer.openGui(HudFramework.instance, GuiHandler.GUI_HUD, targetPlayer.world, (int)targetPlayer.posX, (int)targetPlayer.posY, (int)targetPlayer.posZ);
    }
}
