package pong.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import static pong.Zmienne.*;

/**
 * funkcja rysujaca interfejs gry
 */


public class GameView extends JPanel {

    public static class Interfejs implements Runnable{

          @Override

        public void run()
        {
            panel.repaint();
        }


    }


    public GameView() {
        setBackground(Color.black);
        setForeground(Color.WHITE);
        setVisible(true);
        setFocusable(true);

    }

    /**
     *
     * @param g parametr graficzny
     */
    public void paintComponent(Graphics g) {


        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Font myFont = new Font("ArialBlack", Font.CENTER_BASELINE, 100);
        Rectangle2D.Double prost = new Rectangle2D.Double(0, wspolrzednaX, 20, 200);
        Rectangle2D.Double nietaki = new Rectangle2D.Double(980, wspolrzednaY, 20, 200);
        Ellipse2D.Double pilka = new Ellipse2D.Double(pilkaX, pilkaY, 10, 10);
        Rectangle2D.Double eee = new Rectangle2D.Double(0, 0, 1000, 600);
        setFont(myFont);

        g2d.drawString(wynikA + ":" + wynikB, 430, 680);
        g2d.fill(pilka);
        g2d.fill(prost);
        g2d.fill(nietaki);
        g2d.draw(eee);
          for (int i = 0; i < 12; i++) {
               for (int j = 0; j < 6; j++) {
                   if (klocki[i][j] == 1) {
                       RoundRectangle2D.Double generowanyKlocek = new RoundRectangle2D.Double(200 + j * 100, i * 50, 95, 45, 10, 10);
                       g2d.draw(generowanyKlocek);
                    }
                }

            }

    }



}
