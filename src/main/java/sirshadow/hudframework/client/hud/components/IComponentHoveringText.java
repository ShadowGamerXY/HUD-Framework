package sirshadow.hudframework.client.hud.components;

import java.util.List;

/**
 * Created by sirshadow on 6/3/17.
 */
public interface IComponentHoveringText {
    /**
     * Add some sort of text to hovText list and it will be displayed on the tooltip when the GuiHUD is opened
     * @param hovText
     */
    void getHoveringText(List<String> hovText);
}
