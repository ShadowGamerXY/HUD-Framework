package sirshadow.hudframework.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sirshadow.hudframework.client.hud.HUDElement;

import java.awt.*;

/**
 * Created by Shadow on 31.5.2017.
 */
public class RenderUtil {

    /**
     *
     * @param o an object that can be turned into a String. If the object CAN'T be turned into a string it will crash/cause problems
     * @param x xPos
     * @param y yPos
     * @param c set the color of the string
     */
    public static void addObject(Object o, int x, int y, Color c){
        Minecraft.getMinecraft().fontRendererObj.drawString(o.toString(),x,y, c.hashCode());
    }

    @SideOnly(Side.CLIENT)
    public static void  drawTexturedModalRect(int x, int y, int xPixel, int yPixel, double sizeX, double sizeY)
    {
        int zLevel = HUDElement.zLevel;
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer wr = tessellator.getBuffer();
        wr.begin(7, DefaultVertexFormats.POSITION_TEX);
        wr.pos((double)(x + 0), (double)(y + sizeY), (double)zLevel).tex((double)((float)(xPixel + 0) * f), (double)((float)(yPixel + sizeY) * f1)).endVertex();
        wr.pos((double)(x + sizeX), (double)(y + sizeY), (double)zLevel).tex((double)((float)(xPixel + sizeX) * f), (double)((float)(yPixel + sizeY) * f1)).endVertex();;
        wr.pos((double)(x + sizeX), (double)(y + 0), (double)zLevel).tex((double)((float)(xPixel + sizeX) * f), (double)((float)(yPixel + 0) * f1)).endVertex();;
        wr.pos((double)(x + 0), (double)(y + 0), (double)zLevel).tex((double)((float)(xPixel + 0) * f), (double)((float)(yPixel + 0) * f1)).endVertex();;
        tessellator.draw();
    }
}
