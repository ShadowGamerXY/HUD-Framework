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
    private boolean shouldFade;

    public static int zLevel = 0;
    /**
     * @param name The name of the HUD
     * @param x The starting xPos of the HUD, it will change when you move the HUD(but it resets if you don't save it eg. in the configs)
     * @param y The starting yPos of the HUD, it will change when you move the HUD(but it resets if you don't save it eg. in the configs)
     * @param xWidth width of the HUD, used to calculate the mouse over
     * @param yWidth height of the HUD, used to calculate the mouse over
     */
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
     * If it returns true it element cannot change it's position via GuiHUD
     * @return if the HUD element is locked
     */
    public boolean isLocked() {
        return locked;
    }


    /**
     * Sets if the element is locked
     * @param locked
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Set this to true if you want the element to update
     * @return if the element should update
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
     * @return if the hud should be rendered
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

    public  boolean shouldFade() {
        return shouldFade;
    }

    public  void setShouldFade(boolean fade) {
       shouldFade = fade;
    }

}
