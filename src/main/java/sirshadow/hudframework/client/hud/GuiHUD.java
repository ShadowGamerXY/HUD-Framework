package sirshadow.hudframework.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.text.TextFormatting;
import sirshadow.hudframework.client.hud.components.IComponentHoveringText;
import sirshadow.hudframework.client.hud.components.IComponentTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shadow on 31.5.2017.
 */
public class GuiHUD extends GuiContainer {
    public GuiHUD() {
        super(new ContainerHUD());
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        HUDElement element = HUDRenderHelper.getElementAtCursor(mouseX, mouseY);
        if (element != null) {
            this.renderToolTip(element, mouseX - x, mouseY - y);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        HUDRenderHelper.renderHUDElements(Minecraft.getMinecraft());
    }

    private int lastMouseX = 0;
    private int lastMouseY = 0;

    private boolean isElementTrapped;
    private HUDElement trappedElement;

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int button) {
        if (button == 0) {
             if (mouseX < 10 && mouseY < 10) {
                this.resetElementsToDefaultPosition();
            }

            HUDElement element = HUDRenderHelper.getElementAtCursor(mouseX, mouseY);

            if (element != null) {
                trappedElement = element;
                isElementTrapped = true;

                lastMouseX = mouseX;
                lastMouseY = mouseY;
            }
        } else {
            trappedElement = null;
            isElementTrapped = false;
        }
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int lastButtonClicked, long timeSinceMouseClicked) {
        if (lastButtonClicked == 0 && isElementTrapped && trappedElement != null) {
            if (!trappedElement.isLocked()) {
                ScaledResolution scaled = new ScaledResolution(mc);
                trappedElement.xPos = ((float) (mouseX - lastMouseX)) / (float) scaled.getScaledWidth() + trappedElement.xPos;
                trappedElement.yPos = ((float) (mouseY - lastMouseY)) / (float) scaled.getScaledHeight() + trappedElement.yPos;
                lastMouseX = mouseX;
                lastMouseY = mouseY;

                trappedElement.onPositionChange();
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int button) {
        super.mouseReleased(mouseX, mouseY, button);

        if (button == 0) {
            trappedElement = null;
            isElementTrapped = false;
        }
    }

    public void resetElementsToDefaultPosition() {
        HUDRenderHelper.resetElementsToDefaultPosition();
    }

    protected void renderToolTip(HUDElement element, int x, int y) {
        List<String> list = new ArrayList<String>();

        if (element instanceof IComponentTitle) {
            if (((IComponentTitle) element).getTitle() != null)
                list.add(((IComponentTitle) element).getTitle());
        }
        if (element instanceof IComponentHoveringText) {
            ((IComponentHoveringText) element).getHoveringText(list);
            for (int k = 0; k < list.size(); ++k) {
                if (k == 0) {
                    list.set(k, list.get(k));
                } else {
                    list.set(k, TextFormatting.GRAY + list.get(k));
                }
            }

            this.drawHoveringText(list, x, y, (fontRendererObj));
        }
    }
}
