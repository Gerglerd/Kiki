package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

class Monster extends Sprite {
    Model model;
    static BufferedImage monster_right_image = null;
    static BufferedImage monster_left_image = null;
    double vert_vel = 0;
    boolean movingRight = true;
    boolean hit = false;
    int count = 0;
    int ground = 420;

    boolean isMonster() {
        return true;
    }

    Monster(int x1, int y1, Model m) {
        model = m;
        x = x1;
        y = y1;
        width = 50;
        height = 70;
        if (monster_left_image == null)
            monster_left_image = super.loadImage("images/monster_left.png");
        if (monster_right_image == null)
            monster_right_image = super.loadImage("images/monster_right.png");
    }

    void move() {
        if (movingRight)
            x += 7;
        else x -= 7;
    }

    void gravity(){
        vert_vel += 6.9;
        y += vert_vel;
    }

    void keep_Above_Ground(){
        if (y > ground - height) {
            vert_vel = 0;
            y = ground - height;
        }
    }

    void check_Space() {
        for (int i = 0; i < model.sprites.size(); i++) {
            Sprite sprite = model.sprites.get(i);
            if (sprite.isTube()){
                if (super.Space(x, y, width, height, sprite.x, sprite.y, sprite.width, sprite.height) && this.movingRight) {
                    this.movingRight = false;
                } else if (super.Space(x, y, width, height, sprite.x, sprite.y, sprite.width, sprite.height) && !this.movingRight) {
                    this.movingRight = true;
                }
            }
        }
    }

    void update() {
        move();
        gravity();
        keep_Above_Ground();
        check_Space();
        if(hit) {
            model.sprites.remove(this);
            count++;
        }
    }

    void draw(Graphics graphics){
        if (!movingRight)
            graphics.drawImage(monster_left_image, x - model.CamPos(), y, null);
        else if(movingRight)
            graphics.drawImage(monster_right_image, x - model.CamPos(), y, null);
    }
}
