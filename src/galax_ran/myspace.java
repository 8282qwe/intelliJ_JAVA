package galax_ran;

import javax.swing.*;

public class myspace extends JFrame {
    public myspace(){

        setTitle("MySpace");
        add(new space());
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        myspace a = new myspace();
        a.setVisible(true);
    }
}

