package pong.controller.actions;

import static pong.Zmienne.Klawisze;

public class KeyPressedUp extends Action{
    @Override
    public void perform(){

        Klawisze[0]=1;


    }
}
