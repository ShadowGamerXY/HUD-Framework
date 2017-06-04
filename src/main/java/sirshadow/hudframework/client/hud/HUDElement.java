package sirshadow.hudframework.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

/**
 * Created by Shadow on 31.5.2017.
 */
public class HUDElement {

    public float xPos;
    public float yPos;
    public String name;
    public final int xSize;
    public final int ySize;
    private boolean locked = false;

    public static int zLevel = 0;

    public HUDElement(String name,float x, float y, int xWidth, int yWidth)
    {
        this.name = name;
        this.xPos = x;
        this.yPos = y;
        this.xSize = xWidth;
        this.ySize = yWidth;
    }

    /**
     * This is where you put all the rendering code for the HUD
     * If you leave this empty the HUD will not render
     * @param mc Minecraft object
     **/
    public void renderHUD(Minecraft mc) {}

    /**
     * Not client side
     * Runs every tick
     */
    public void update(){}

    /**
     * If returns true the HUD element will not be able to change pos
     * @return
     */
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Set this to true if you want the element to update
     * @return
     */
    public boolean shouldUpdate(){
        return false;
    }

    /**
     * @return the name of the HUD element
     */
    public String getName() {
        return name;
    }

    /**
     * If you set this to false the HUD will not render
     * @param mc
     * @return
     */
    public boolean shouldRenderHUD(Minecraft mc)
    {
        return true;
    }

    /**
     * Called when the position of the element is changed
     **/
    public void onPositionChange(){}

    /**
     * Resets the element to the default position
     * Note: You have to call it and specify the default position
     **/
    public void resetToDefaultPosition(){}

    public String getUnlocalizedName(){
        return I18n.format("hudElement." + this.getName() + ".name");
    }
}
