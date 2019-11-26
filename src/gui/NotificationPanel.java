package gui;

import javax.swing.*;

public class NotificationPanel extends JPanel {
    public NotificationPanel(String message){
        JOptionPane.showMessageDialog(null,message);
    }
}
