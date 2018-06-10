package pong.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pong.Zmienne.z;

public class Buttons implements ActionListener {

    private int przycisk;

    public Buttons(int i) {

        przycisk =i;

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(przycisk==1)
        {
            z=1;

        }
        else
        {

            z=2;

        }


    }

}
