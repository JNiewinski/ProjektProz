package pong.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pong.Zmienne.z;

public class Buttons2 implements ActionListener {

    private int przycisk;

    public Buttons2(int i) {

        przycisk =i;

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(przycisk==3)
        {
            z=3;

        }
        else
        {

            z=4;

        }


    }

}
