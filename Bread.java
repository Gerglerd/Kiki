package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Bread extends Sprite {
    Model model;
    static BufferedImage bread_image = null;
    boolean isTube() {
        return false;
    }
    boolean isMonster() {
        return false;
    }
    boolean isBread() {
        return true;
    }
    boolean isKiki() {
        return false;
    }

    Bread (int x1, int y1, Model m) {
        model = m;
        x = x1;
        y = y1;
        width = 50;
        height = 50;
        if (bread_image == null) {
            bread_image = loadImage("images/bread.png");
        }
    }

    void update() {}

    void draw(Graphics graphics){
        graphics.drawImage(bread_image, x - model.CamPos(), y, width, height, null);
    }

    BufferedImage loadImage(String imFile) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imFile));
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
        return image;
    }
}
