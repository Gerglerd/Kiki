package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

class Cloud extends Sprite{
    Model model;
    static BufferedImage cloud_image = null;
    boolean movingRight = true;
    int count;

    Cloud(int x1, int y1, Model m) {
        model = m;
        x = x1;
        y = y1;
        width = 180;
        height = 163;

        if (cloud_image == null)
            cloud_image = super.loadImage("images/cloud.png");
    }

    void Move() {
        count++;
        if (movingRight && count == 20) {
            x+=5;
            movingRight = false;
            count = 0;
        }else if (!movingRight && count == 20) {
            x-=5;
            movingRight = true;
            count = 0;
        }
    }

    void update(){
        Move();
    }

    void draw(Graphics graphics) {
        graphics.drawImage(cloud_image, x - model.CamPos(), y, null);
    }
}
