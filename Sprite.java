package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

abstract class Sprite {
    int x, y, width, height;

    abstract void update();

    abstract void draw(Graphics graphics);

    boolean isTube() {
        return false;
    }
    boolean isMonster() {
        return false;
    }
    boolean isBread() { return false; }
    boolean isKiki() { return false; }

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

    boolean Space(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        if (x1 + w1 < x2)
            return false;
        if (x2 + w2 < x1)
            return false;
        if (y1 + h1 < y2)
            return false;
        if (y2 + h2 < y1)
            return false;
        return true;
    }
}
