package galax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;


class space extends JPanel implements ActionListener {

    private final int B_WIDTH = 1680;
    private final int B_HEIGHT = 1080;
    private final int INITIAL_X = 0;
    private final int INITIAL_Y = 980;
    private final int DELAY = 25;

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
        BigDecimal a = new BigDecimal(0.0015702611760936);
        BigDecimal x_buf = new BigDecimal((x-790)*(x-790));
        x+=10;
        y = a.multiply(x_buf).intValue();

        if (y+100 > B_HEIGHT){
            x = INITIAL_X;
            y = INITIAL_Y;
            url = "./image/rocket_up.png";
            loadImage(url);
        }
        else if(x >= 790) {
            url = "./image/rocket_down.png";
            loadImage(url);
        }

        repaint();
    }
};
