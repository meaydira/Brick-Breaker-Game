package test;

import gui.PauseGamePanel;
import org.junit.jupiter.api.Test;


public class GuiTest {
    @Test
    public void pauseMenuTest(){
        PauseGamePanel panel = PauseGamePanel.getInstance(null);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
