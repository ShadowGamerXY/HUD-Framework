package sirshadow.hudframework.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shadow on 31.5.2017.
 */
@SideOnly(Side.CLIENT)
public class HUDRenderHelper
{
    public static Map<String, HUDElement> hudElementsMap = new HashMap<String, HUDElement>();
    public static Minecraft mc = Minecraft.getMinecraft();

    public static boolean renderHUDElements(Minecraft mc)
    {
        for(Map.Entry<String, HUDElement> entry : hudElementsMap.entrySet())
        {
            if (entry.getValue().shouldRenderHUD(mc)) {
                entry.getValue().renderHUD(mc);
            }
        }

        return true;
    }

    public static boolean updateHUDElements()
    {
        for(Map.Entry<String, HUDElement> entry : hudElementsMap.entrySet())
        {
            if (entry.getValue().shouldUpdate()) {
                entry.getValue().update();
            }
        }

        return true;
    }


    /**
     * Used mostly for GuiHUD
     * @param mouseX
     * @param mouseY
     * @return the hud element that you moused over
     */
    public static HUDElement getElementAtCursor(int mouseX, int mouseY)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        for(Map.Entry<String, HUDElement> entry : hudElementsMap.entrySet())
        {
            HUDElement element = entry.getValue();
            if(mouseX >= element.xPos * scaled.getScaledWidth() - 1 &&  mouseX < element.xPos * scaled.getScaledWidth() + element.xSize / 2 && mouseY >= element.yPos * scaled.getScaledHeight() && mouseY < element.yPos* scaled.getScaledHeight() + element.ySize / 2)
            {
                return element;
            }
        }

        return null;
    }

    public static void resetElementsToDefaultPosition()
    {
        for(Map.Entry<String, HUDElement> entry : hudElementsMap.entrySet())
        {
            HUDElement element = entry.getValue();
            element.resetToDefaultPosition();
        }
    }
}
