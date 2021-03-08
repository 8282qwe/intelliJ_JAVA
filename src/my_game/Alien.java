package my_game;

import java.util.Random;

public class Alien extends Sprite{

    public Alien(int x, int y) {
        super(x,y);
        loadImage("./image/Alien.png");
    }

    public void move(){
        Random r = new Random();
        int buf_x = x;
        int buf_y = y;
        x += r.nextInt(100)-50;
        if (x > 1610 || x < 0){
            x = buf_x;
        }
        y += r.nextInt(50)-25;
        if (y > 470 || y < 0){
            y = buf_y;
        }
    }

    public boolean hit(int a1, int a2){
        if(a2 <= y+70){
            if (a1 + 30 > x && a1 + 30 <= x + 70 || a1 > x && a1 <= x + 70) {
                return true;
            }
        }
        return false;
    }

}
