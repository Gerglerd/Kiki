package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

class Tube extends Sprite{
    Model model;
    static BufferedImage tube_image = null;

    boolean isTube() {
        return true;
    }

    Tube(int x1, int y1, Model m) {
        model = m;
        x = x1;
        y = y1;
        width = 55;
        height = 400;

        //if (tube_image == null)
        //    tube_image = super.loadImage("images/tube.png");
    }

    void update(){
    }

    void draw(Graphics graphics) {
        graphics.drawImage(tube_image, x - model.CamPos(), y, null);
    }
}
