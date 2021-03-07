package galax_ran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class space extends JPanel implements ActionListener {

    private final int B_WIDTH = 1680;
    private final int B_HEIGHT = 1080;
    private final int INITIAL_X = 840;
    private final int INITIAL_Y = 490;
    private final int DELAY = 300;

    String url = "./image/rocket_right_up.png";
    ImageIcon Background = new ImageIcon("./image/background.jpg");
    private Image star;
    private Timer timer;
    private int x,y,x_buf,y_buf;

    public space(){
        initspace();
    }

    private void loadImage(String url){
        ImageIcon ii = new ImageIcon(url);
        star = ii.getImage();
    }

    private void initspace(){
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
        setDoubleBuffered(true);

        loadImage(url);

        x = INITIAL_X;
        y = INITIAL_Y;

        timer = new Timer(DELAY,this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(Background.getImage(),0,0,null);
        drawStar(g);
    }

    private void drawStar(Graphics g){
        g.drawImage(star,x,y,this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();

        x_buf = x + r.nextInt(500)-250;
        y_buf = y + r.nextInt(500)-250;

        if (y_buf+100 > B_HEIGHT || x_buf < 0 || x_buf+100 > B_WIDTH || y_buf < 0){
            x = INITIAL_X;
            y = INITIAL_Y;
            url = "./image/rocket_right_up.png";
            loadImage(url);
        }
        else if (x<x_buf && y>y_buf){
            x = x_buf;
            y = y_buf;
            url = "./image/rocket_right_up.png";
            loadImage(url);
        }
        else if (x<x_buf && y<y_buf){
            x = x_buf;
            y = y_buf;
            url = "./image/rocket_right_down.png";
            loadImage(url);
        }
        else if (x>x_buf && y<y_buf){
            x = x_buf;
            y = y_buf;
            url = "./image/rocket_left_down.png";
            loadImage(url);
        }
        else if (x>x_buf && y>y_buf){
            x = x_buf;
            y = y_buf;
            url = "./image/rocket_left_up.png";
            loadImage(url);
        }

        repaint();
    }
};
