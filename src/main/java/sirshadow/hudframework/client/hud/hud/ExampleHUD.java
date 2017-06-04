package sirshadow.hudframework.client.hud.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import org.lwjgl.opengl.GL11;
import sirshadow.hudframework.ConfigurationHandler;
import sirshadow.hudframework.ModLibrary;
import sirshadow.hudframework.client.hud.HUDElement;
import sirshadow.hudframework.client.hud.components.IComponentHoveringText;
import sirshadow.hudframework.client.hud.components.IComponentTitle;
import sirshadow.hudframework.client.util.RenderUtil;

import java.util.List;

/**
 * Created by sirshadow on 6/4/17.
 */
public class ExampleHUD extends HUDElement implements IComponentHoveringText,IComponentTitle {

    /**
     * Default values for x and y positions
     * Used for resetting the HUD element to its default position
     **/
    private float defaultX,defaultY;

    public ExampleHUD(String name, float x, float y, int xWidth, int yWidth) {
        super(name, x, y, xWidth, yWidth);

        this.defaultX = x;
        this.defaultY = y;
    }

    /**
     * This is the basic implementation of HUD render
     * NOTE: You don't have to do it like this, you can implement the renderHUD any way you want
     * @param mc Minecraft object
     */
    @Override
    public void renderHUD(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);

        GL11.glPushMatrix();

        int x = (int)(xPos * scaled.getScaledWidth()) * 4;
        int y = (int)(yPos * scaled.getScaledHeight()) * 4;

        GL11.glScalef(1f/4f, 1f/4f, 1f/4f);


        ResourceLocation test = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/examplehud.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(test);
        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256, 256);

        GL11.glPopMatrix();
    }

    @Override
    public boolean shouldRenderHUD(Minecraft mc) {
        return true;
    }

    @Override
    public void onPositionChange() {
        ConfigurationHandler.config.get(Configuration.CATEGORY_CLIENT,"ExampleHUD xPosition",ConfigurationHandler.example_xPos).set(this.xPos);
        ConfigurationHandler.config.get(Configuration.CATEGORY_CLIENT,"ExampleHUD yPosition",ConfigurationHandler.example_yPos).set(this.yPos);
        ConfigurationHandler.config.save();
    }

    @Override
    public void resetToDefaultPosition() {
        this.xPos = this.defaultX;
        this.yPos = this.defaultY;
    }

    @Override
    public String getTitle() {
        return this.getUnlocalizedName();
    }

    @Override
    public void getHoveringText(List<String> hovText) {
        hovText.add(I18n.format("hudText.exampleHUD.exampleText"));
    }
}
