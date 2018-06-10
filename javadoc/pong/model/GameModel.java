package pong.model;

import pong.view.events.UpdateEvent;
import static pong.Zmienne.*;

import java.util.Random;

import static pong.Zmienne.klocki;

public class GameModel {

    /**
     * funkcja odpowiadajaca za losowanie wspolrzednych w ktorych pojawi sie nowy klocek
     *
     */

    public static void losujKlocek() {

     if(z==1) {
         Random losowyX = new Random();

         Random losowyY = new Random();
         int losowyKlocX = losowyX.nextInt(12);
         int losowyKlocY = losowyY.nextInt(6);
         klocki[losowyKlocX][losowyKlocY] = 1;
     }
    }
}
