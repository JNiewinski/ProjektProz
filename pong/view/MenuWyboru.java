package pong.view;

import pong.view.events.Buttons2;

import javax.swing.*;

import static pong.Zmienne.z;

/**
 * menu do wyboru servera i klienta
 */
public class MenuWyboru extends JFrame {

    public MenuWyboru()
    {

        JFrame menu2 = new JFrame();
        menu2.setVisible(true);
        menu2.setSize(500,250);
        JPanel przyciski2 =new JPanel();
        JButton b3= new JButton("Server");
        b3.addActionListener(new Buttons2(3));
        JButton b4= new JButton("Client");
        b4.addActionListener(new Buttons2(4));
        przyciski2.add(b3);
        przyciski2.add(b4);
        menu2.add(przyciski2);


            while(z==2)
            {

                repaint();
            }
        menu2.setVisible(false);
        menu2.dispose();


    }


}
