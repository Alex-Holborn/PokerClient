package Client;

import javax.swing.*;
import java.awt.*;

public class LoginPortal extends JFrame {
    public LoginPortal(){
        setTitle("Login");
        setSize(320,280);
        JPanel mainPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        mainPanel.setLayout(new GridBagLayout());
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(CreatePortalPanel("Username"), c);
        c.gridy = 2;
        mainPanel.add(CreatePortalPanel("Password"), c);
        add(mainPanel);
        setVisible(true);
        new LoginHandler("Test", "1234");
    }

    private JPanel CreatePortalPanel(String panelName){
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.3;
        JTextArea t = new JTextArea(panelName);
        t.setEditable(false);
        p.add(t, c);
        c.gridx = 1;
        c.weightx = 1;
        p.add(new JTextArea(), c);
        return p;
    }
}
