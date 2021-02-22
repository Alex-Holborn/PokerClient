package Client;

import javax.swing.*;
import java.awt.*;

public class Client {

    private LoginPortal loginPortal;

    public Client(){
        loginPortal = new LoginPortal(this);
    }

    public void CloseLogin(){
        loginPortal.dispose();
    }
}
