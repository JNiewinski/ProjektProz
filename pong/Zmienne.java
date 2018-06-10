package pong;

import javax.swing.*;

public class Zmienne extends JFrame {

        /**  wpolrzedna paletki po lewej stronie


         */

        public static int wspolrzednaX = 200;
        /** wspolrzedna paletki po prawej stronie
         *
         */
        public static int wspolrzednaY = 200;
        /**
         * wynik gracza po lewej
         */
        public static int wynikA = 0;
        /**  wynik gracza po prawej
         *
         */
        public static int wynikB = 0;
        public static int klocki[][];
        /**
         *  wspolrzedna x pilki
         */
        public static int pilkaX = 500;
        /**
         * wspolrzedna y pilki
         */
        public static int pilkaY = 300;
        /**
         * kierunek w ktorym porusza sie pilka po osi y

         */
        public static int directY = 1;
        /**
         * kierunek w ktorym porusza sie pilka po osi X
         */
        public static int directX = -1;
        public static JFrame panel;
        /** tablica przechowujaca informacje o tym czy dany klawisz jest w tym momencie wcisniety
         *
         */
        public static int Klawisze[];
        public static int z=0;


}
