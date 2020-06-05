package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

class Kiki extends Sprite {
    Model model;
    static BufferedImage Kiki_right = null;
    static BufferedImage Kiki_left = null;
    int prev_x, prev_y;
    int lives = 1;
    int Ground = 420;
    int destination = 8130;
    double vert_vel;
    int bread_amount;
    boolean alive = true;
    boolean moveRight = false;
    boolean moveLeft = false;

    Kiki(Model m) {
        model = m;
        x = 200;
        y = 200;
        width = 60;
        height = 60;
        vert_vel = -12.0;
        if (Kiki_left == null)
            Kiki_left = loadImage("images/kiki_left.png");
        if (Kiki_right == null)
            Kiki_right = loadImage("images/kiki_right.png");
    }

    void jump() {
        if(vert_vel == 0) {
            vert_vel = -60;
        }
    }

    void keep_Above_Ground(){
        if(y > Ground - height) {
            vert_vel = 0;
            y = Ground - height;
        }
    }

    void gravity() {
        vert_vel += 6.9;
        y += vert_vel;
    }

    void kikiPastPosition(){
        prev_x = x;
        prev_y = y;
    }

    void draw(Graphics graphics) {
        if (moveRight)
            graphics.drawImage(Kiki_right, 200, y, null);
        if (moveLeft)
            graphics.drawImage(Kiki_left, 200, y, null);
    }

    void faceTube(Sprite sprite) {
        if (x + width >= sprite.x && prev_x + width < sprite.x)
            x = sprite.x - width - 1;
        else if (x <= sprite.x + sprite.width && prev_x > sprite.x + sprite.width)
            x = sprite.x + sprite.width + 1;
        else if( y + height >= sprite.y && prev_y + height < sprite.y)
            y = sprite.y - 1 - height;
        else if( y - height <= sprite.y + sprite.height && prev_y - height > sprite.y + sprite.height)
            y = sprite.y + sprite.height + height + 1;
    }

    void check_Space() {
        for (int i = 0; i < model.sprites.size(); i++) {
            Sprite sprite = model.sprites.get(i);

            if (sprite.isMonster()){
                if (super.Space(x,y,width,height,sprite.x,sprite.y,sprite.width,sprite.height)){
                    if (y+i < sprite.y && vert_vel != 0 && x + width >= sprite.x || x == sprite.x + sprite.width){
                        model.sprites.remove(i);
                        vert_vel = -40;
                    }
                    if (y+height == sprite.y + sprite.height) {
                        lives--;
                        model.sprites.remove(this);
                        died();
                    }
                }
            }
            if (sprite.isBread()){
                if (super.Space(x,y,width,height,sprite.x,sprite.y,sprite.width,sprite.height)){
                    model.sprites.remove(i);
                    bread_amount++;
                }
            }
           /* if (sprite.isTube()){
                if (super.Space(x,y,width,height,sprite.x,sprite.y,sprite.width,sprite.height)){
                    faceTube(sprite);
                    vert_vel = 0;
                }
            }*/
        }
    }

    void died(){
        if (lives == 0){
            alive = false;
        }
    }

    void update() {
        gravity();
        keep_Above_Ground();
        check_Space();
        died();

        if (x<=1)
            x = 1;
        if(x>=destination)
            System.exit(0);
    }
}
