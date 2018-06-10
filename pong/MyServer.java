package pong;

import pong.view.events.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

import static pong.Zmienne.Klawisze;

public class MyServer {


    /**
     * utowrzenie serwera
     */
    public MyServer(BlockingQueue<Event> blockingQueue) throws IOException, InterruptedException {
        MyServer Server=new MyServer();

        String wyraz=new String();
        wyraz=Server.run();

        if(wyraz=="11")
        {
            blockingQueue.put(new KeyPressedW());
            blockingQueue.put(new KeyPressedS());
        }
        if(wyraz=="00")
        {
            blockingQueue.put(new KeyReleasedW());
            blockingQueue.put(new KeyReleasedS());
        }
        if(wyraz=="10")
        {
            blockingQueue.put(new KeyPressedW());
            blockingQueue.put(new KeyReleasedS());
        }
        if(wyraz=="01")
        {
            blockingQueue.put(new KeyReleasedW());
            blockingQueue.put(new KeyPressedS());
        }

    }

  public  MyServer() throws IOException {

  }

  public String run() throws IOException, InterruptedException {


      ServerSocket SRVSocket = new ServerSocket(4444);

      Socket Sock = SRVSocket.accept();
      InputStreamReader IR = new InputStreamReader(Sock.getInputStream());

      BufferedReader BR = new BufferedReader(IR);

      String message = BR.readLine();



      if (message != null) {
          PrintStream PS = new PrintStream(Sock.getOutputStream());
          //System.out.println(message);
        PS.flush();
          String g = new String();


          if (Klawisze[0] == 1 && Klawisze[1] == 1)
              g = "11\n";
          if (Klawisze[0] != 1 && Klawisze[1] != 1)
              g = "00\n";
          if (Klawisze[0] != 1 && Klawisze[1] == 1)
              g = "01\n";
          if (Klawisze[0] == 1 && Klawisze[1] != 1)
              g = "10\n";


          PS.println(g);
          PS.close();

      }

      BR.close();
        Sock.close();
      SRVSocket.close();
      return message;
  }




  }

