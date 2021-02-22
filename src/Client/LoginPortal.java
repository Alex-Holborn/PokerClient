package Client;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPortal extends JFrame implements ActionListener {

    private JButton LoginButton;
    private JPanel PasswordPanel;
    private JPanel UsernamePanel;

    private static Client MainClient;

    public LoginPortal(Client main){
        MainClient = main;
        setTitle("Login");
        setSize(320,280);
        JPanel mainPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        mainPanel.setLayout(new GridBagLayout());
        c.gridx = 1;
        c.gridy = 1;
        UsernamePanel = CreatePortalPanel("Username");
        mainPanel.add(UsernamePanel, c);
        c.gridy = 2;
        PasswordPanel = CreatePortalPanel("Password");
        mainPanel.add(PasswordPanel, c);
        c.gridy = 3;
        LoginButton = CreateLoginButton();
        mainPanel.add(LoginButton, c);
        add(mainPanel);
        setVisible(true);
    }

    private JPanel CreatePortalPanel(String panelName){
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        JLabel l = new JLabel(panelName);
        p.add(l, c);
        c.gridx = 1;
        c.weightx = 1;
        JPanel spacer = new JPanel();
        p.add(spacer, c);
        c.gridx = 2;
        c.weightx = 2;
        JTextField f = new JTextField(20);
        f.setToolTipText(panelName);
        p.add(f, c);
        return p;
    }

    private JButton CreateLoginButton(){
        JButton b = new JButton("Login");
        b.addActionListener(this);
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(LoginButton)){
            if(attemptLogin((JTextField) UsernamePanel.getComponent(2), (JTextField) PasswordPanel.getComponent(2))){
                System.out.println("login successful");
                MainClient.CloseLogin();
            }else{
                System.out.println("Login Failed");
            }
        }
    }

    private boolean attemptLogin(JTextField user, JTextField pass){
        LoginHandler l = new LoginHandler(user.getText(), pass.getText());
        return true;
    }
}
