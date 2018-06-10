package pong.controller;

import pong.Client;
import pong.MyServer;
import pong.controller.actions.*;
import pong.view.events.Event;
import pong.view.events.UpdateEvent;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import static pong.Zmienne.z;

public class Controller implements Runnable {
    public static  MyServer svr;
    public static Client clt;


    BlockingQueue<pong.view.events.Event> blockingQueue;
    HashMap<Class<? extends pong.view.events.Event>,Action> actionMap;

    /**
     * utworzenie kontrolera
     * @param blockingQueue kolejka przechowująca zdarzenia
     */
    public Controller(final BlockingQueue<pong.view.events.Event> blockingQueue) {

        this.blockingQueue = blockingQueue;
        actionMap = new HashMap<>();
        createMap();
    }

    /**
     * utworzenie mapowania zdarzen na akcje
     */


    public void createMap()
    {
        actionMap.put(pong.view.events.KeyPressedUp.class, new KeyPressedUp());
        actionMap.put(pong.view.events.KeyPressedDown.class, new KeyPressedDown());
        actionMap.put(pong.view.events.KeyPressedW.class, new KeyPressedW());
        actionMap.put(pong.view.events.KeyPressedS.class, new KeyPressedS());
        actionMap.put(pong.view.events.KeyReleasedUp.class, new pong.controller.actions.KeyReleasedUp());
        actionMap.put(pong.view.events.KeyReleasedDown.class, new pong.controller.actions.KeyReleasedDown());
        actionMap.put(pong.view.events.KeyReleasedW.class, new pong.controller.actions.KeyReleasedW());
        actionMap.put(pong.view.events.KeyReleasedS.class, new pong.controller.actions.KeyReleasedS());
        actionMap.put(UpdateEvent.class, new UpdateAction());

    }


    @Override

    public void run(){
        while(true) {
            try {
                Event event = blockingQueue.take();
                blockingQueue.remove(event);
                actionMap.get(event.getClass()).perform();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (z == 3) {
                try {
                    new MyServer(blockingQueue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (z == 4) {
                try {
                    new Client(blockingQueue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
