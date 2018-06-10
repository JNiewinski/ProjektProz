package pong;

import pong.view.events.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

import static pong.Zmienne.Klawisze;

public class Client {


    /**
     * utworzenie klienta
     */
    public Client(BlockingQueue<pong.view.events.Event> blockingQueue) throws IOException, InterruptedException {

       new Client();
        String wyraz=new String();

        wyraz=run();
       // System.out.println(wyraz);
        if(wyraz=="11")
        {
            blockingQueue.put(new KeyPressedUp());
            blockingQueue.put(new KeyPressedDown());

        }
        if(wyraz=="00")
        {
            blockingQueue.put(new KeyReleasedUp());
            blockingQueue.put(new KeyReleasedDown());

        }
        if(wyraz=="10")
        {
            blockingQueue.put(new KeyPressedUp());
            blockingQueue.put(new KeyReleasedDown());

        }
        if(wyraz=="01")
        {
            blockingQueue.put(new KeyReleasedUp());
            blockingQueue.put(new KeyPressedDown());

        }



    }

    public Client() throws IOException {



    }

    public String run() throws IOException, InterruptedException {


        Socket Sock = new Socket("localhost",4444);



        InputStreamReader IR = new InputStreamReader(Sock.getInputStream());
       BufferedReader BR = new BufferedReader(IR);


        String g = new String();

        if(Klawisze[2]==1 && Klawisze[3]==1)
            g="11\n";
        if(Klawisze[2]!=1 && Klawisze[3]!=1)
            g="00\n";
        if(Klawisze[2]!=1 && Klawisze[3]==1)
            g="01\n";
        if(Klawisze[2]==1 && Klawisze[3]!=1)
            g="10\n";

        PrintStream PS = new PrintStream(Sock.getOutputStream());
        PS.println(g);
        PS.flush();

        String message=null;


        BR.close();
        PS.close();
        Sock.close();


        return message;
    }
}
