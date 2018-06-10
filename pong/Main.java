package pong;

import pong.controller.Controller;
import pong.view.GameView;
import pong.view.MenuStartowe;
import pong.view.MenuWyboru;
import pong.view.events.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static pong.Zmienne.*;
import static pong.model.GameModel.losujKlocek;

/**
 * @author Jakub Niewiński
 * @version 1.2.0
 *
 */
public class Main extends JPanel{

    public static BlockingQueue<pong.view.events.Event> queue;

    public static void main(String[] args) throws InterruptedException {
        klocki = new int[12][6];
        Klawisze = new int[4];
        new MenuStartowe();
        if(z==2) {
            new MenuWyboru();

        }


        queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 10; i++) {
            losujKlocek();
        }


            panel = new JFrame();
            panel.setFocusable(true);
            panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setSize(1020, 800);
            panel.setVisible(true);
            panel.add(new GameView());

            panel.addKeyListener(new MyListener());


            panel.toFront();
                Controller controller = new Controller(queue);
                Thread thread = new Thread(controller);
                thread.start();

                while(true) {
                    thread.sleep(3);


                    queue.put(new UpdateEvent());
                }
            //}



    }


    public static class MyListener implements KeyListener {



        @Override

        public void keyTyped(KeyEvent e) {

        }


         @Override

        public void keyPressed(KeyEvent e)  {
            int znak;

            znak = e.getKeyCode();
            if (znak == 87) {
                try {
                    queue.put(new KeyPressedUp());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            if (znak == 83) {
                try {
                    queue.put(new KeyPressedDown());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            if (znak == 38) {
                try {
                    queue.put(new KeyPressedW());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            if (znak == 40) {
                try {
                    queue.put(new KeyPressedS());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            if (znak == 27) {
                System.exit(1);
            }


        }


         @Override

        public void keyReleased(KeyEvent e) {
            int znak;

            znak = e.getKeyCode();
            if (znak == 87) {
                try {
                    queue.put(new KeyReleasedUp());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            if (znak == 83) {
                try {
                    queue.put(new KeyReleasedDown());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            if (znak == 38) {
                try {
                    queue.put(new KeyReleasedW());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            if (znak == 40) {
                try {
                    queue.put(new KeyReleasedS());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }




        }
    }


}






