package pong.view;

import pong.view.events.Buttons;
import pong.view.events.Buttons2;

import javax.swing.*;

import static pong.Zmienne.z;

/**
 * utworzenie okna odpowiadajacego za menu poczatkowe
 */

public class MenuStartowe extends JFrame {

    public MenuStartowe()
    {

        JFrame menu = new JFrame();
        menu.setVisible(true);
        menu.setSize(500,250);
        JPanel przyciski =new JPanel();
        JButton b1= new JButton("Gra lokalna");
        b1.addActionListener(new Buttons(1));
        JButton b2= new JButton("Gra sieciowa");
        przyciski.add(b1);
        przyciski.add(b2);
        menu.add(przyciski);

        b2.addActionListener(new Buttons(2));



        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(z==0)
        {
            repaint();
        }

            JButton b3= new JButton("Server");
            b3.addActionListener(new Buttons2(3));
            JButton b4= new JButton("Client");
            b4.addActionListener(new Buttons2(4));
            przyciski.add(b3);
            przyciski.add(b4);
            menu.add(przyciski);
            repaint();





            menu.setVisible(false);
            menu.dispose();


    }


}
