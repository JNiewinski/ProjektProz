package pong.controller.actions;



import static pong.Zmienne.*;
import static pong.Zmienne.directX;
import static pong.model.GameModel.losujKlocek;


public class UpdateAction extends Action{
    /**
     * uaktualnienie widoku gry
     */
    public void perform() {

        pilkaX -= directY;
        pilkaY -= directX;

      if(  Klawisze[1]==1) {
          wspolrzednaX = wspolrzednaX + 10;
          if (wspolrzednaX > 400) wspolrzednaX = 400;
      }
        if(  Klawisze[0]==1) {
            wspolrzednaX = wspolrzednaX - 10;
            if (wspolrzednaX <0) wspolrzednaX= 0;
        }
        if(    Klawisze[3]==1) {
            wspolrzednaY = wspolrzednaY + 10;
            if (wspolrzednaY > 400) wspolrzednaY = 400;
        }

        if(    Klawisze[2]==1) {
            wspolrzednaY = wspolrzednaY - 10;
            if (wspolrzednaY < 0) wspolrzednaY = 0;
        }





        if (pilkaY < 0 || pilkaY > 590) directX = -directX;

        if (pilkaX == 20 && pilkaY >= wspolrzednaX - 5 && pilkaY <= wspolrzednaX + 205) {
            directY = -directY;
            losujKlocek();
        }
        if (pilkaX == 970 && pilkaY >= wspolrzednaY - 5 && pilkaY <= wspolrzednaY + 205) {
            directY = -directY;
            losujKlocek();
        }
        if (pilkaX < 0) {
            wynikB++;
            if(wynikB==11)
            {
                System.out.println("wygral zawodnik B");
                System.exit(2);
            }
            pilkaX = 500;
            pilkaY = 300;
            for (int i = 0; i < 10; i++) {
                losujKlocek();

            }
        }
        if (pilkaX > 1000) {
            wynikA++;
            if(wynikA==11)
            {
                System.out.println("wygral zawodnik A");
                System.exit(3);
            }
            pilkaX = 500;
            pilkaY = 300;

            for (int i = 0; i < 10; i++) {
                losujKlocek();

            }
        }

        {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (klocki[i][j] == 1) {
                        if((pilkaX==200+(j+1)*100 || pilkaX==200+j*100) && (pilkaY>(i)*50 && pilkaY<(i+1)*50))
                        {
                            directY=-directY;
                            klocki[i][j]=0;
                            return;
                        }
                        else {
                            if ((pilkaY == i * 50 || pilkaY == (i + 1) * 50) && (pilkaX > 200 + (j) * 100 && pilkaX < 200 + (j + 1) * 100)) {
                                directX = -directX;
                                klocki[i][j] = 0;

                            }
                            else{
                                if (pilkaY==i*50 && pilkaX==200+j*100)
                                {
                                    directY=1;
                                    directX=1;
                                    klocki[i][j] = 0;

                                }
                                if (pilkaY==(i+1)*50 && pilkaX==200+j*100)
                                {
                                    directY=1;
                                    directX=-1;
                                    klocki[i][j] = 0;

                                }

                                if (pilkaY==i*50 && pilkaX==200+(j+1)*100)
                                {
                                    directY=-1;
                                    directX=1;
                                    klocki[i][j] = 0;

                                }

                                if (pilkaY==(i+1)*50 && pilkaX==200+(j+1)*100)
                                {
                                    directY=-1;
                                    directX=-1;
                                    klocki[i][j] = 0;

                                }


                            }
                        }
                    }
                }

            }


        }



        panel.repaint();
    }

}
